package com.example.examplemod.block;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.simpletank.SimpleTankBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MOD_ID);

    public static final RegistryObject<Block> SIMPLE_TANK = BLOCKS.register("simple_tank", SimpleTankBlock::new);

}