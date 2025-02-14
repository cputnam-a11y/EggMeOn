package eggmeon;

import eggmeon.item.ModItems;
import eggmeon.item.group.ModItemGroups;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class EggMeOn implements ModInitializer {
    public static final String MOD_ID = "eggmeon";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.init();
        ModItemGroups.init();
    }

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}