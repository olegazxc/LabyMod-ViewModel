package com.dezc.viewmodel.events;

import com.dezc.viewmodel.ViewModelMain;
import com.dezc.viewmodel.gui.RenderSliderWidget;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.renderer.RenderWorldLastEvent;
import net.labymod.main.LabyMod;
import net.labymod.utils.Keyboard;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.StringTextComponent;

public class RenderGuiEvent {

    @Subscribe
    public void onRender(RenderWorldLastEvent event) {
        if (Keyboard.isNewKeyDown(72)) {
            if (Minecraft.getInstance().currentScreen == null) {
                updateRender();
            }
        }
    }

    public static void updateRender() {
        Minecraft.getInstance().displayGuiScreen(new RenderSliderWidget(new StringTextComponent("GUI")));
    }
}
