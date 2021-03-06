package io.github.cottonmc.epicurean.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeFinder;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.collection.DefaultedList;

import javax.annotation.Nullable;

public class CookingInventory extends CraftingInventory {
    public static final int SECTION_SIZE = 6;
    @Nullable
    public final PlayerEntity accessor;
    private final DefaultedList<ItemStack> stacks;

    public CookingInventory(ScreenHandler container) {
        this(container, null);
    }

    public CookingInventory(ScreenHandler container, @Nullable PlayerEntity player) {
        super(container, SECTION_SIZE, 2);
        this.accessor = player;
        this.stacks = DefaultedList.ofSize(SECTION_SIZE * 2, ItemStack.EMPTY);
    }

    public void provideRecipeInputs(RecipeFinder finder) {
        //only get the items from the first section, since that's all we care about for matching
        for (int i = 0; i < SECTION_SIZE; i++) {
            ItemStack stack = stacks.get(i);
            finder.addNormalItem(stack);
        }

    }
}
