package eggmeon.datagen;

import eggmeon.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                offerSmelting(
                        List.of(Items.EGG),
                        RecipeCategory.FOOD,
                        ModItems.FRIED_EGG,
                        0.35f,
                        200,
                        "eggmeon:fried_egg"
                );
                CookingRecipeJsonBuilder.createSmoking(
                                Ingredient.ofItem(Items.EGG),
                                RecipeCategory.FOOD,
                                ModItems.BOILED_EGG,
                                0.35f,
                                100
                        )
                        .criterion(hasItem(Items.EGG), conditionsFromItem(Items.EGG))
                        .group("eggmeon:boiled_egg")
                        .offerTo(
                                exporter,
                                RegistryKey.of(
                                        RegistryKeys.RECIPE,
                                        Registries.ITEM.getId(ModItems.BOILED_EGG)
                                )
                        );
            }
        };
    }

    @Override
    public String getName() {
        return "Recipe Provider";
    }
}
