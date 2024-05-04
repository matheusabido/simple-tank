package com.example.examplemod.items;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);

    public static final RegistryObject<Item> SIMPLE_TANK = ITEMS.register("simple_tank", () -> new BlockItem(ModBlocks.SIMPLE_TANK.get(), new Item.Properties()));

}