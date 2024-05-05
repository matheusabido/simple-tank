package com.example.examplemod.block.simpletank;

import com.example.examplemod.block.ModBlockEntities;
import com.example.examplemod.menu.SimpleTankMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class SimpleTankBlockEntity extends BlockEntity implements MenuProvider {
    public SimpleTankBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(ModBlockEntities.SIMPLE_TANK.get(), p_155229_, p_155230_);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Simple Tank");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new SimpleTankMenu(pContainerId, pPlayerInventory, this);
    }
}