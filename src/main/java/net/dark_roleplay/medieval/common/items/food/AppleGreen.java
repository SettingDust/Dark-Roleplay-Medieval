package net.dark_roleplay.medieval.common.items.food;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.item.ItemFood;

public class AppleGreen extends ItemFood {

	public AppleGreen() {
		super(4, 0.3F, false);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab);
		this.setRegistryName("AppleGreen");
		this.setUnlocalizedName("AppleGreen");
		this.setMaxStackSize(64);
	}
}