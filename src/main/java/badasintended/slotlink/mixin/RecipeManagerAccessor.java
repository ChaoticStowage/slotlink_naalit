package badasintended.slotlink.mixin;

import java.util.Map;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(RecipeManager.class)
public interface RecipeManagerAccessor {

    @Accessor
    Map<RecipeType<?>, Map<Identifier, Recipe<?>>> getRecipes();

    @Invoker
    <C extends Inventory, T extends Recipe<C>> Map<Identifier, Recipe<C>> callGetAllOfType(RecipeType<T> type);

}
