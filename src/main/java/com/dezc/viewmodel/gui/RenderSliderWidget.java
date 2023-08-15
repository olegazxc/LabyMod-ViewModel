package com.dezc.viewmodel.gui;

import com.dezc.viewmodel.ViewModelMain;
import com.dezc.viewmodel.events.RenderGuiEvent;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.settings.SliderPercentageOption;
import net.minecraft.util.text.ITextComponent;

import static com.dezc.viewmodel.ConfigClass.*;
import static com.dezc.viewmodel.ViewModelMain.*;
import static com.dezc.viewmodel.mixin.RenderArmMixin.*;

public class RenderSliderWidget extends Screen {

    Button button_editHand;
    Button button_reset;
    SliderPercentageOption slider_posX;
    Widget widget_posX;
    SliderPercentageOption slider_posY;
    Widget widget_posY;
    SliderPercentageOption slider_posZ;
    Widget widget_posZ;
    SliderPercentageOption sliderRotate_posX;
    Widget widgetRotate_posX;
    SliderPercentageOption sliderRotate_posY;
    Widget widgetRotate_posY;
    SliderPercentageOption sliderRotate_posZ;
    Widget widgetRotate_posZ;

    public RenderSliderWidget(ITextComponent titleIn) {
        super(titleIn);
    }

    @Override
    protected void init() {
        this.minecraft.keyboardListener.enableRepeatEvents(true);

        int space_x = (this.width / 2) / 5;
        int space_y = (this.height / 2) / 5;
        int start_pos_x = (this.width / 2) - (this.width / 26);
        int start_pos_y = this.height / 2;

        this.slider_posX = new SliderPercentageOption("", -3, 3, (float) 0.05, (setting) -> {
            return edit_MainHand ? posX_MainHand : posX_LeftHand;
            },
                (setting, value) -> {
            if (edit_MainHand) {
                posX_MainHand = value;
                updateConfig("posX_MainHand", value);
            } else {
                posX_LeftHand = value;
                updateConfig("posX_LeftHand", value);
            }}, (gameSettings, sliderPercentageOption1) -> ITextComponent.getTextComponentOrEmpty("x: " + Math.round((edit_MainHand ? posX_MainHand : posX_LeftHand ) * 100.0) / 100.0 ));
        this.widget_posX = this.slider_posX.createWidget(Minecraft.getInstance().gameSettings, start_pos_x - space_x, start_pos_y, 70);


        this.slider_posY = new SliderPercentageOption("", -3, 3, (float) 0.05, (setting) -> {
            return edit_MainHand ? posY_MainHand : posY_LeftHand;},
                (setting, value) -> {
            if (edit_MainHand) {
                posY_MainHand = value;
                updateConfig( "posY_MainHand", value);
            } else {
                posY_LeftHand = value;
                updateConfig("posY_LeftHand", value);
            }}, (gameSettings, sliderPercentageOption1) -> ITextComponent.getTextComponentOrEmpty("y: " + Math.round((edit_MainHand ? posY_MainHand : posY_LeftHand) * 100.0) / 100.0));
        this.widget_posY = this.slider_posY.createWidget(Minecraft.getInstance().gameSettings, start_pos_x, start_pos_y, 70);


        this.slider_posZ = new SliderPercentageOption("", -10, 2, (float) 0.05, (setting) -> {
            return edit_MainHand ? posZ_MainHand : posZ_LeftHand;},
                (setting, value) -> {
            if (edit_MainHand) {
                posZ_MainHand = value;
                updateConfig("posZ_MainHand", value);
            } else {
                posZ_LeftHand = value;
                updateConfig("posZ_LeftHand", value);
            }}, (gameSettings, sliderPercentageOption1) -> ITextComponent.getTextComponentOrEmpty("z: " + Math.round((edit_MainHand ? posZ_MainHand : posZ_LeftHand) * 100.0) / 100.0));
        this.widget_posZ = this.slider_posZ.createWidget(Minecraft.getInstance().gameSettings, start_pos_x + space_x, start_pos_y, 70);


        this.sliderRotate_posX = new SliderPercentageOption("", -180, 180, (float) 1, (setting) -> {
            return edit_MainHand ? rotatePosX_MainHand : rotatePosX_LeftHand;},
                (setting, value) -> {
                    if (edit_MainHand) {
                        rotatePosX_MainHand = value;
                        updateConfig("rotatePosX_MainHand", value);
                    } else {
                        rotatePosX_LeftHand = value;
                        updateConfig("rotatePosX_LeftHand", value);
                    }}, (gameSettings, sliderPercentageOption1) -> ITextComponent.getTextComponentOrEmpty("x: " + (edit_MainHand ? rotatePosX_MainHand : rotatePosX_LeftHand)));
        this.widgetRotate_posX = this.sliderRotate_posX.createWidget(Minecraft.getInstance().gameSettings, start_pos_x - space_x, start_pos_y + space_y, 70);

        this.sliderRotate_posY = new SliderPercentageOption("", -180, 180, (float) 1, (setting) -> {
            return edit_MainHand ? rotatePosY_MainHand : rotatePosY_LeftHand;},
                (setting, value) -> {
                    if (edit_MainHand) {
                        rotatePosY_MainHand = value;
                        updateConfig( "rotatePosY_MainHand", value);
                    } else {
                        rotatePosY_LeftHand = value;
                        updateConfig("rotatePosY_LeftHand", value);
                    }}, (gameSettings, sliderPercentageOption1) -> ITextComponent.getTextComponentOrEmpty("y: " + (edit_MainHand ? rotatePosY_MainHand : rotatePosY_LeftHand)));
        this.widgetRotate_posY = this.sliderRotate_posY.createWidget(Minecraft.getInstance().gameSettings, start_pos_x, start_pos_y + space_y, 70);

        this.sliderRotate_posZ = new SliderPercentageOption("", -180, 180, (float) 1, (setting) -> {
            return edit_MainHand ? rotatePosZ_MainHand : rotatePosZ_LeftHand;},
                (setting, value) -> {
                    if (edit_MainHand) {
                        rotatePosZ_MainHand = value;
                        updateConfig("rotatePosZ_MainHand", value);
                    } else {
                        rotatePosZ_LeftHand = value;
                        updateConfig( "rotatePosZ_LeftHand", value);
                    }}, (gameSettings, sliderPercentageOption1) -> ITextComponent.getTextComponentOrEmpty("z: " + (edit_MainHand ? rotatePosZ_MainHand : rotatePosZ_LeftHand) ));
        this.widgetRotate_posZ = this.sliderRotate_posZ.createWidget(Minecraft.getInstance().gameSettings, start_pos_x + space_x, start_pos_y + space_y, 70);



        this.button_editHand = new Button(start_pos_x - space_x, start_pos_y - space_y, 80, 20, ITextComponent.getTextComponentOrEmpty("Редактируется: " + (edit_MainHand ? "Основная рука" : "Вторая рука")), (button) -> {
            edit_MainHand = !edit_MainHand;
            updateConfig("edit_MainHand", edit_MainHand);
            RenderGuiEvent.updateRender();

        });
        this.addButton(button_editHand);

        this.button_reset = new Button(start_pos_x + space_x, start_pos_y - space_y, 80, 20, ITextComponent.getTextComponentOrEmpty("Сбросс настроек"), (button) -> {
            ViewModelMain.resetNums();
            RenderGuiEvent.updateRender();
        });
        this.addButton(button_reset);

        this.children.add(this.widget_posX);
        this.children.add(this.widget_posY);
        this.children.add(this.widget_posZ);
        this.children.add(this.widgetRotate_posX);
        this.children.add(this.widgetRotate_posY);
        this.children.add(this.widgetRotate_posZ);
        super.init();
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTick) {
        this.widget_posX.render(matrixStack, mouseX, mouseY, partialTick);
        this.widget_posY.render(matrixStack, mouseX, mouseY, partialTick);
        this.widget_posZ.render(matrixStack, mouseX, mouseY, partialTick);
        this.widgetRotate_posX.render(matrixStack, mouseX, mouseY, partialTick);
        this.widgetRotate_posY.render(matrixStack, mouseX, mouseY, partialTick);
        this.widgetRotate_posZ.render(matrixStack, mouseX, mouseY, partialTick);
        this.button_editHand.render(matrixStack, mouseX, mouseY, partialTick);
        this.button_reset.render(matrixStack, mouseX, mouseY, partialTick);
        LabyMod.getInstance().getDrawUtils().drawString(matrixStack, "Расположение:", (this.width / 2) - (this.width / 26), this.height / 2 - (this.height / 2) / 9);
        LabyMod.getInstance().getDrawUtils().drawString(matrixStack, "Поворот:", (this.width / 2) - (this.width / 26), this.height / 2 + (this.height / 2) / 9);
        super.render(matrixStack, mouseX, mouseY, partialTick);
    }
}