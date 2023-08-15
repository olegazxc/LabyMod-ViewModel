package com.dezc.viewmodel;

import net.labymod.addon.AddonTransformer;
import net.labymod.api.TransformerType;

public class MixinTransformer extends AddonTransformer {

  @Override
  public void registerTransformers() {
    this.registerTransformer(TransformerType.VANILLA, "viewmodel.mixin.json");
  }
}
