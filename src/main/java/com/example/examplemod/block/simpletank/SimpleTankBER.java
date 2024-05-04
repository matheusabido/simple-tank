package com.example.examplemod.block.simpletank;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;

public class SimpleTankBER implements BlockEntityRenderer<SimpleTankBlockEntity> {

    private final BlockEntityRendererProvider.Context context;
    public SimpleTankBER(BlockEntityRendererProvider.Context context) {
        this.context = context;
    }

    private float height = 0;
    @Override
    public void render(SimpleTankBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        height += .0025f;
        if (height >= 1) height = 0;
        if (height <= 0) return;
        FluidStack stack = new FluidStack(Fluids.WATER, 1000);
        if (stack.isEmpty()) return;

        Level level = entity.getLevel();
        if (level == null) return;

        BlockPos pos = entity.getBlockPos();

        IClientFluidTypeExtensions type = IClientFluidTypeExtensions.of(stack.getFluid());
        ResourceLocation texture = type.getStillTexture(stack);
        if (texture == null) return;

        FluidState state = stack.getFluid().defaultFluidState();

        TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(texture);
        int tintColor = type.getTintColor(state, level, pos);

        VertexConsumer builder = buffer.getBuffer(ItemBlockRenderTypes.getRenderLayer(state));

        drawQuad(builder, poseStack, 0, height, 0.01f, 1, height, 1, tintColor, packedLight, sprite); // known issue
        drawQuad(builder, poseStack, 0, 0, 0.01f, 1, height, 0.01f, tintColor, packedLight, sprite);

        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(90));
        poseStack.translate(-1, 0, 0);
        drawQuad(builder, poseStack, 0, 0, 0.01f, 1, height, 0.01f, tintColor, packedLight, sprite);
        poseStack.popPose();

        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(180));
        poseStack.translate(-1, 0, -1);
        drawQuad(builder, poseStack, 0, 0, 0.01f, 1, height, 0.01f, tintColor, packedLight, sprite);
        poseStack.popPose();

        poseStack.pushPose();
        poseStack.mulPose(Axis.YN.rotationDegrees(90));
        poseStack.translate(0, 0, -1);
        drawQuad(builder, poseStack, 0, 0, 0.01f, 1, height, 0.01f, tintColor, packedLight, sprite);
        poseStack.popPose();

        poseStack.pushPose();
        poseStack.mulPose(Axis.XN.rotationDegrees(90));
        poseStack.translate(0, -1, 0);
        drawQuad(builder, poseStack, 0, 0, 0.01f, 1, 1, 0.01f, tintColor, packedLight, sprite);
        poseStack.popPose();
    }

    private void drawQuad(VertexConsumer builder, PoseStack poseStack, float x0, float y0, float z0, float x1, float y1, float z1, int tintColor, int packedLight, TextureAtlasSprite sprite) {
        float diff = sprite.getV1() - sprite.getV0();
        float v1 = sprite.getV0() + diff * y1;

        builder.vertex(poseStack.last().pose(), x0, y0, z0)
                .color(tintColor)
                .uv(sprite.getU0(), sprite.getV0())
                .uv2(packedLight)
                .normal(1, 0, 0)
                .endVertex();

        builder.vertex(poseStack.last().pose(), x0, y1, z1)
                .color(tintColor)
                .uv(sprite.getU0(), v1)
                .uv2(packedLight)
                .normal(1, 0, 0)
                .endVertex();

        builder.vertex(poseStack.last().pose(), x1, y1, z1)
                .color(tintColor)
                .uv(sprite.getU1(), v1)
                .uv2(packedLight)
                .normal(1, 0, 0)
                .endVertex();

        builder.vertex(poseStack.last().pose(), x1, y0, z0)
                .color(tintColor)
                .uv(sprite.getU1(), sprite.getV0())
                .uv2(packedLight)
                .normal(1, 0, 0)
                .endVertex();
    }
}