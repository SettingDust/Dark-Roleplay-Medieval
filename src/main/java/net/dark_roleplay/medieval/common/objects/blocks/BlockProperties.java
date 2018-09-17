package net.dark_roleplay.medieval.common.objects.blocks;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;

public class BlockProperties {

	public static final PropertyEnum<EnumFacing.Axis> AXIS_HORIZONTAL = PropertyEnum.<EnumFacing.Axis>create("axis", EnumFacing.Axis.class, EnumFacing.Axis.X, EnumFacing.Axis.Z);
	public static final PropertyEnum<EnumFacing.Axis> AXIS = PropertyEnum.<EnumFacing.Axis>create("axis", EnumFacing.Axis.class);
	public static final PropertyDirection FACING_HORIZONTAL = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);


	public static final PropertyBool ADDON_LIGHTER = PropertyBool.create("addon_lighter");
	public static final PropertyBool ADDON_TRAP = PropertyBool.create("addon_trap");
	public static final PropertyBool POWERED = PropertyBool.create("powered");

	//Wood Bench
	public static final PropertyBool SINGLE = PropertyBool.create("single");

	//Dirt Stairs
	public static final PropertyEnum<StairType> STAIR_TYPE = PropertyEnum.<StairType>create("type", StairType.class);

	//Target
	public static final PropertyBool IS_TOP = PropertyBool.create("top");

	//Dungeon Chest
	public static final PropertyBool LIT = PropertyBool.create("lit");


	public static enum StairType implements IStringSerializable{
		STRAIGHT,
		INNER_LEFT,
		INNER_RIGHT,
		OUTER_LEFT,
		OUTER_RIGHT;

		@Override
		public String getName() {
			return this.name().toLowerCase();
		}
	}

	public static class Settings {

		public static final BlockSettings WOOD_SOLID = new BlockSettings(Material.WOOD, SoundType.WOOD, 2.0F, 5.0F);
		public static final BlockSettings WOOD_DECO = new BlockSettings(Material.WOOD, SoundType.WOOD, 2.0F, 5.0F).setBlockFaceShape(BlockFaceShape.UNDEFINED).setFullAndOpaque(false, false);
		public static final BlockSettings WOOD_DECO_TESR =new BlockSettings(Material.WOOD, SoundType.WOOD, 2.0F, 5.0F).setBlockFaceShape(BlockFaceShape.UNDEFINED).setFullAndOpaque(false, false).setBlockRenderLayer(BlockRenderLayer.TRANSLUCENT);


		public static final BlockSettings METAL_SOLID = new BlockSettings(Material.IRON, SoundType.METAL, 2.0F, 5.0F);
		public static final BlockSettings METAL_DECO = new BlockSettings(Material.IRON, SoundType.METAL, 2.0F, 5.0F).setBlockFaceShape(BlockFaceShape.UNDEFINED).setFullAndOpaque(false, false);
		public static final BlockSettings METAL_DECO_TESR = new BlockSettings(Material.IRON, SoundType.METAL, 2.0F, 5.0F).setBlockFaceShape(BlockFaceShape.UNDEFINED).setFullAndOpaque(false, false).setBlockRenderLayer(BlockRenderLayer.TRANSLUCENT);

		public static final BlockSettings STONE_SOLID = new BlockSettings(Material.ROCK, SoundType.STONE, 1.5F, 10.0F);
		public static final BlockSettings SNOW_SOLID = new BlockSettings(Material.CRAFTED_SNOW, SoundType.SNOW, 0.2F, 0.0F);
		//		Block
		public static final BlockSettings PACKED_ICE = new BlockSettings(Material.PACKED_ICE, SoundType.GLASS, 0.5F, 0.0F);

		public static final BlockSettings OBSIDIAN_GLASS = new BlockSettings(Material.GLASS, SoundType.STONE, 4F, 4000.0F).setBlockFaceShape(BlockFaceShape.UNDEFINED).setFullAndOpaque(false, false).setLightOpacity(6);


	}
}
