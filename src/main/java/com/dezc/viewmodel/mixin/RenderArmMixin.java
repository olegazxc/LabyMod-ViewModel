package com.dezc.viewmodel.mixin;


import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.FirstPersonRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.vector.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.dezc.viewmodel.ConfigClass.*;
import static com.dezc.viewmodel.ViewModelMain.*;

@Mixin(FirstPersonRenderer.class)
public class RenderArmMixin {

    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/client/renderer/FirstPersonRenderer;transformSideFirstPerson(Lcom/mojang/blaze3d/matrix/MatrixStack;Lnet/minecraft/util/HandSide;F)V")
    private void onRenderItem(MatrixStack matrixStackIn, HandSide handIn, float equippedProg, CallbackInfo ci) {
        if (handIn == HandSide.RIGHT) {
            matrixStackIn.translate(posX_MainHand, posY_MainHand, posZ_MainHand);
            matrixStackIn.rotate(Vector3f.XP.rotationDegrees((float) rotatePosX_MainHand));
            matrixStackIn.rotate(Vector3f.YP.rotationDegrees((float) rotatePosY_MainHand));
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees((float) rotatePosZ_MainHand));
        } else if (handIn == HandSide.LEFT) {
            matrixStackIn.translate(posX_LeftHand, posY_LeftHand, posZ_LeftHand);
            matrixStackIn.rotate(Vector3f.XP.rotationDegrees((float) rotatePosX_LeftHand));
            matrixStackIn.rotate(Vector3f.YP.rotationDegrees((float) rotatePosY_LeftHand));
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees((float) rotatePosZ_LeftHand));
        }
    }

    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/client/renderer/FirstPersonRenderer;renderArmFirstPerson(Lcom/mojang/blaze3d/matrix/MatrixStack;Lnet/minecraft/client/renderer/IRenderTypeBuffer;IFFLnet/minecraft/util/HandSide;)V")
    private void onRenderArm(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, float equippedProgress, float swingProgress, HandSide side, CallbackInfo ci) {
        if (side == HandSide.RIGHT) {
            matrixStackIn.translate(posX_MainHand, posY_MainHand, posZ_MainHand);
            matrixStackIn.rotate(Vector3f.XP.rotationDegrees((float) rotatePosX_MainHand));
            matrixStackIn.rotate(Vector3f.YP.rotationDegrees((float) rotatePosY_MainHand));
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees((float) rotatePosZ_MainHand));
        } else if (side == HandSide.LEFT) {
            matrixStackIn.translate(posX_LeftHand, posY_LeftHand, posZ_LeftHand);
            matrixStackIn.rotate(Vector3f.XP.rotationDegrees((float) rotatePosX_LeftHand));
            matrixStackIn.rotate(Vector3f.YP.rotationDegrees((float) rotatePosY_LeftHand));
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees((float) rotatePosZ_LeftHand));
        }
    }
}
