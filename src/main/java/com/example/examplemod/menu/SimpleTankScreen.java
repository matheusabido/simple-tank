package com.example.examplemod.menu;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;

public class SimpleTankScreen extends AbstractContainerScreen<SimpleTankMenu> {
    public SimpleTankScreen(SimpleTankMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float p_97788_, int mouseX, int mouseY) {
        FluidStack stack = new FluidStack(Fluids.WATER, 1000);
        IClientFluidTypeExtensions type = IClientFluidTypeExtensions.of(stack.getFluid());
        ResourceLocation texture = type.getStillTexture(stack);

        TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(texture);

        int tintColor = type.getTintColor(stack.getFluid().defaultFluidState(), menu.entity.getLevel(), menu.entity.getBlockPos());
        float alpha = (tintColor >> 24 & 0xFF) / 255f;
        float red = (tintColor >> 16 & 0xFF) / 255f;
        float green = (tintColor >> 8 & 0xFF) / 255f;
        float blue = (tintColor & 0xFF) / 255f;

        graphics.blit((width - 32) / 2, (height - 32) / 2, 1, 32, 32, sprite, red, green, blue, alpha);
    }

    @Override
    public void render(GuiGraphics gui, int p_283661_, int p_281248_, float p_281886_) {
        renderBackground(gui);
        super.render(gui, p_283661_, p_281248_, p_281886_);
        renderTooltip(gui, p_283661_, p_281248_);
    }
}