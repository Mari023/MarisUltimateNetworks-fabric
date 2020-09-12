package de.mari_023.fabric.marisultimatenetworks.item;

import de.mari_023.fabric.mariswrenchapi.IWrench;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class WrenchItem extends Item implements IWrench {
    public WrenchItem() {
        super(new Settings().group(ItemGroup.MISC));
    }
}