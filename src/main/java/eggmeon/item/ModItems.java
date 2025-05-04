package eggmeon.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Function;
import java.util.function.Supplier;

import static eggmeon.EggMeOn.id;

public class ModItems {
    public static final Item FRIED_EGG = register(
            "fried_egg",
            Item::new,
            () -> new Item.Settings().food(
                    new FoodComponent.Builder()
                            .nutrition(5)
                            .saturationModifier(0.4f)
                            .build()
            )
    );
    public static final Item BOILED_EGG = register(
            "boiled_egg",
            Item::new,
            () -> new Item.Settings().food(
                    new FoodComponent.Builder()
                            .nutrition(6)
                            .saturationModifier(0.3f)
                            .build()
            )
    );

    public static void init() {

    }

    public static <T extends Item> T register(String name, Function<Item.Settings, T> itemSupplier, Supplier<Item.Settings> settingsSupplier) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id(name));
        return Registry.register(
                Registries.ITEM,
                key,
                itemSupplier.apply(
                        settingsSupplier.get()
                )
        );
    }
}