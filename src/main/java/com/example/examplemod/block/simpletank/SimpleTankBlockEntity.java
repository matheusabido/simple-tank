package com.example.examplemod.block.simpletank;

import com.example.examplemod.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SimpleTankBlockEntity extends BlockEntity {
    public SimpleTankBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(ModBlockEntities.SIMPLE_TANK.get(), p_155229_, p_155230_);
    }
}