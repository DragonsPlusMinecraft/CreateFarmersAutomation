package plus.dragons.createfarmersautomation.content.contraptions.components.deployer;

import com.simibubi.create.content.contraptions.processing.ProcessingRecipe;
import com.simibubi.create.content.contraptions.processing.ProcessingRecipeBuilder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import plus.dragons.createfarmersautomation.entry.CfaRecipeTypes;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class CuttingBoardDeployingRecipe extends ProcessingRecipe<RecipeWrapper> {
    
    public CuttingBoardDeployingRecipe(ProcessingRecipeBuilder.ProcessingRecipeParams params) {
        super(CfaRecipeTypes.CUTTING_BOARD_DEPLOYING, params);
    }
    
    public static CuttingBoardDeployingRecipe fromCuttingBoard(CuttingBoardRecipe recipe) {
        var builder = new ProcessingRecipeBuilder<>(CuttingBoardDeployingRecipe::new,
            new ResourceLocation(
                recipe.getId().getNamespace(),
                recipe.getId().getPath() + "_using_deployer"
            ))
            .require(recipe.getIngredients().get(0))
            .require(recipe.getTool());
        for (var output : recipe.getRollableResults()) {
            builder.output(output.getChance(), output.getStack());
        }
        return builder.toolNotConsumed().build();
    }
    
    @Override
    protected int getMaxInputCount() {
        return 2;
    }
    
    @Override
    protected int getMaxOutputCount() {
        return 4;
    }
    
    @Override
    public boolean matches(RecipeWrapper inventory, Level level) {
        return ingredients.get(0).test(inventory.getItem(0))
            && ingredients.get(1).test(inventory.getItem(1));
    }
    
}