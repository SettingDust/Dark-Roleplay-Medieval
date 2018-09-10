package net.dark_roleplay.medieval.mess.common.objects.blocks.plants;

import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalItems;
import net.dark_roleplay.medieval.mess.common.objects.blocks.helper.TreePlant;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.item.ItemStack;

public class PearYellow extends TreePlant {

	public PearYellow() {
		super(4, 25F, true, new ItemStack(DRPMedievalItems.PEAR_YELLOW, 1));
		this.setRegistryName("PearYellow");
		this.setUnlocalizedName("PearYellow");
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(0.5F);
		this.setSoundType(SoundType.PLANT);
		this.setTickRandomly(true);
	}

	static { 
		TreePlant.AGE = PropertyInteger.create("age", 0, 5);
	}
}