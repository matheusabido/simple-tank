package com.example.examplemod.block;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.simpletank.SimpleTankBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ExampleMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<SimpleTankBlockEntity>> SIMPLE_TANK = BLOCK_ENTITIES.register("simple_tank",
            () -> BlockEntityType.Builder.of(SimpleTankBlockEntity::new, ModBlocks.SIMPLE_TANK.get()).build(null));

}