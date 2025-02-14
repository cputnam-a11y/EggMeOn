package eggmeon.item.group;

import eggmeon.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class ModItemGroups {
    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((entries) ->
                entries.addAfter(Items.PUMPKIN_PIE, ModItems.FRIED_EGG, ModItems.BOILED_EGG)
        );
    }
}
