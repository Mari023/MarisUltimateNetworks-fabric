package de.mari_023.fabric.marisultimatenetworks.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class WrenchItem extends Item {
    public WrenchItem() {
        super(new Settings().group(ItemGroup.MISC));
    }
}