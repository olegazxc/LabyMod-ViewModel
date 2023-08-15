package com.dezc.viewmodel;

import com.dezc.viewmodel.events.RenderGuiEvent;
import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.KeyElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class ViewModelMain extends LabyModAddon {

  private static ViewModelMain instance;
  @Override
  public void onEnable() {
    instance = this;
    getApi().getEventService().registerListener(new RenderGuiEvent());
  }

  @Override
  public void loadConfig() {
    ConfigClass.posX_MainHand = getConfig().has( "posX_MainHand" ) ? getConfig().get( "posX_MainHand" ).getAsDouble() : 0;
    ConfigClass.posY_MainHand = getConfig().has( "posY_MainHand" ) ? getConfig().get( "posY_MainHand" ).getAsDouble() : 0;
    ConfigClass.posZ_MainHand = getConfig().has( "posZ_MainHand" ) ? getConfig().get( "posZ_MainHand" ).getAsDouble() : 0;
    ConfigClass.posX_LeftHand = getConfig().has( "posX_LeftHand" ) ? getConfig().get( "posX_LeftHand" ).getAsDouble() : 0;
    ConfigClass.posY_LeftHand = getConfig().has( "posY_LeftHand" ) ? getConfig().get( "posY_LeftHand" ).getAsDouble() : 0;
    ConfigClass.posZ_LeftHand = getConfig().has( "posZ_LeftHand" ) ? getConfig().get( "posZ_LeftHand" ).getAsDouble() : 0;
    ConfigClass.edit_MainHand = getConfig().has( "edit_MainHand" ) ? getConfig().get( "edit_MainHand" ).getAsBoolean() : true;

    ConfigClass.rotatePosX_MainHand = getConfig().has( "rotatePosX_MainHand" ) ? getConfig().get( "rotatePosX_MainHand" ).getAsDouble() : 0;
    ConfigClass.rotatePosY_MainHand = getConfig().has( "rotatePosY_MainHand" ) ? getConfig().get( "rotatePosY_MainHand" ).getAsDouble() : 0;
    ConfigClass.rotatePosZ_MainHand = getConfig().has( "rotatePosZ_MainHand" ) ? getConfig().get( "rotatePosZ_MainHand" ).getAsDouble() : 0;
    ConfigClass.rotatePosX_LeftHand = getConfig().has( "rotatePosX_LeftHand" ) ? getConfig().get( "rotatePosX_LeftHand" ).getAsDouble() : 0;
    ConfigClass.rotatePosY_LeftHand = getConfig().has( "rotatePosY_LeftHand" ) ? getConfig().get( "rotatePosY_LeftHand" ).getAsDouble() : 0;
    ConfigClass.rotatePosZ_LeftHand = getConfig().has( "rotatePosZ_LeftHand" ) ? getConfig().get( "rotatePosZ_LeftHand" ).getAsDouble() : 0;
  }

  @Override
  protected void fillSettings(List<SettingsElement> list) {
  }
  public static ViewModelMain getInstance() {
    return instance;
  }

  public static void resetNums() {
    List<String> paramsConfig = new ArrayList<>();
    paramsConfig.add("posX_MainHand");
    paramsConfig.add("posX_LeftHand");
    paramsConfig.add("posY_MainHand");
    paramsConfig.add("posY_LeftHand");

    paramsConfig.add("posZ_MainHand");
    paramsConfig.add("posZ_LeftHand");

    paramsConfig.add("rotatePosX_LeftHand");
    paramsConfig.add("rotatePosX_MainHand");
    paramsConfig.add("rotatePosY_MainHand");
    paramsConfig.add("rotatePosY_LeftHand");
    paramsConfig.add("rotatePosZ_LeftHand");
    paramsConfig.add("rotatePosZ_MainHand");

    for (String param : paramsConfig) {
      getInstance().getConfig().addProperty(param, 0);
      getInstance().saveConfig();
    }

    ConfigClass.posX_MainHand = 0;
    ConfigClass.posX_LeftHand = 0;
    ConfigClass.posY_MainHand = 0;
    ConfigClass.posY_LeftHand = 0;
    ConfigClass.posZ_MainHand = 0;
    ConfigClass.posZ_LeftHand = 0;

    ConfigClass.rotatePosX_LeftHand = 0;
    ConfigClass.rotatePosX_MainHand = 0;
    ConfigClass.rotatePosY_MainHand = 0;
    ConfigClass.rotatePosY_LeftHand = 0;
    ConfigClass.rotatePosZ_MainHand = 0;
    ConfigClass.rotatePosZ_LeftHand = 0;
  }
}
