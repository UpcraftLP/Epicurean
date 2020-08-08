package io.github.cottonmc.epicurean.mixins;

import com.google.common.collect.Lists;
import io.github.cottonmc.epicurean.container.CookingTableContainer;
import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.client.recipebook.RecipeBookGroup;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientRecipeBook.class)
public class MixinRecipeBookGroups {

    @Inject(method = "getGroupsForContainer", at = @At("HEAD"), cancellable = true)
    private static void getCookingTableGroups(AbstractRecipeScreenHandler<?> container, CallbackInfoReturnable cir) {
        if (container instanceof CookingTableContainer) {
            cir.setReturnValue(Lists.newArrayList(RecipeBookGroup.CRAFTING_SEARCH, RecipeBookGroup.CRAFTING_MISC));
        }
    }
}
