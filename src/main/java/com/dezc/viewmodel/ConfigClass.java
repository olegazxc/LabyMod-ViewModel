package com.dezc.viewmodel;

public class ConfigClass {
    public static double posX_MainHand = 0;
    public static double posY_MainHand = 0;
    public static double posZ_MainHand = 0;
    public static double posX_LeftHand = 0;
    public static double posY_LeftHand = 0;
    public static double posZ_LeftHand = 0;
    public static double rotatePosX_MainHand = 0;
    public static double rotatePosY_MainHand = 0;
    public static double rotatePosZ_MainHand = 0;
    public static double rotatePosX_LeftHand = 0;
    public static double rotatePosY_LeftHand = 0;
    public static double rotatePosZ_LeftHand = 0;
    public static boolean edit_MainHand = true;
    public static void updateConfig(String name_conf, boolean accepted) {
        ViewModelMain.getInstance().getConfig().addProperty(name_conf, accepted);
        ViewModelMain.getInstance().saveConfig();
    }
    public static void updateConfig(String name_conf, double accepted) {
        ViewModelMain.getInstance().getConfig().addProperty(name_conf, accepted);
        ViewModelMain.getInstance().saveConfig();
    }


}
