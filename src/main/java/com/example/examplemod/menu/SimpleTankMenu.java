package com.example.examplemod.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class SimpleTankMenu extends AbstractContainerMenu {

    public final BlockEntity entity;
    public SimpleTankMenu(int pContainerId, Inventory inventory, FriendlyByteBuf buf) {
        this(pContainerId, inventory, inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public SimpleTankMenu(int pContainerId, Inventory inventory, BlockEntity entity) {
        super(ModMenuTypes.SIMPLE_TANK.get(), pContainerId);
        this.entity = entity;
    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return true;
    }
}