package de.mari_023.fabric.marisultimatenetworks.item;

//import com.zundrel.wrenchable.wrench.Wrench;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class WrenchItem extends Item /*implements Wrench*/ {
    public WrenchItem() {
        super(new Settings().group(ItemGroup.MISC));
    }
}