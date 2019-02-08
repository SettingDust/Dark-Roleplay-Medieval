package net.dark_roleplay.medieval.objects.blocks.building.roofs;

import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.FACING_HORIZONTAL;
import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.HAS_TE;
import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.SNOWED;
import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.STAIR_TYPE;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.holders.MedievalBlockProperties;
import net.dark_roleplay.medieval.holders.MedievalBlockProperties.StairType;
import net.dark_roleplay.medieval.objects.blocks.general.FacedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Roof extends FacedBlock {

	protected static final AxisAlignedBB AABB_QTR_TOP_WEST = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 0.5D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_QTR_TOP_EAST = new AxisAlignedBB(0.5D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_QTR_TOP_NORTH = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 0.5D);
	protected static final AxisAlignedBB AABB_QTR_TOP_SOUTH = new AxisAlignedBB(0.0D, 0.5D, 0.5D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_OCT_TOP_NW = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 0.5D, 1.0D, 0.5D);
	protected static final AxisAlignedBB AABB_OCT_TOP_NE = new AxisAlignedBB(0.5D, 0.5D, 0.0D, 1.0D, 1.0D, 0.5D);
	protected static final AxisAlignedBB AABB_OCT_TOP_SW = new AxisAlignedBB(0.0D, 0.5D, 0.5D, 0.5D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_OCT_TOP_SE = new AxisAlignedBB(0.5D, 0.5D, 0.5D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_SLAB_BOTTOM = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	protected static final AxisAlignedBB AABB_QTR_BOT_WEST = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.5D, 0.5D, 1.0D);
	protected static final AxisAlignedBB AABB_QTR_BOT_EAST = new AxisAlignedBB(0.5D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	protected static final AxisAlignedBB AABB_QTR_BOT_NORTH = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 0.5D);
	protected static final AxisAlignedBB AABB_QTR_BOT_SOUTH = new AxisAlignedBB(0.0D, 0.0D, 0.5D, 1.0D, 0.5D, 1.0D);
	protected static final AxisAlignedBB AABB_OCT_BOT_NW = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.5D, 0.5D, 0.5D);
	protected static final AxisAlignedBB AABB_OCT_BOT_NE = new AxisAlignedBB(0.5D, 0.0D, 0.0D, 1.0D, 0.5D, 0.5D);
	protected static final AxisAlignedBB AABB_OCT_BOT_SW = new AxisAlignedBB(0.0D, 0.0D, 0.5D, 0.5D, 0.5D, 1.0D);
	protected static final AxisAlignedBB AABB_OCT_BOT_SE = new AxisAlignedBB(0.5D, 0.0D, 0.5D, 1.0D, 0.5D, 1.0D);

	public Roof(String name, BlockSettings settings) {
		super(name, settings);
		this.setDefaultState(this.getDefaultState().withProperty(STAIR_TYPE, StairType.STRAIGHT).withProperty(SNOWED, false).withProperty(HAS_TE, false));
//		this.setTickRandomly(true);
		this.useNeighborBrightness = true;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING_HORIZONTAL, STAIR_TYPE, HAS_TE, SNOWED});
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.byHorizontalIndex(meta & 0x3))
				.withProperty(HAS_TE, (meta & 0x8) == 0x8).withProperty(SNOWED, (meta & 0x4) == 0x4);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING_HORIZONTAL).getHorizontalIndex() | (state.getValue(SNOWED) ? 0x4 : 0) | (state.getValue(HAS_TE) ? 0x8 : 0);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
		EnumFacing facing = state.getValue(FACING_HORIZONTAL);
		IBlockState otherBlock = world.getBlockState(pos.offset(facing));
		IBlockState otherBlock2 = world.getBlockState(pos.offset(facing.getOpposite()));
		IBlockState otherBlock3 = world.getBlockState(pos.offset(facing.rotateY()));
		IBlockState otherBlock4 = world.getBlockState(pos.offset(facing.rotateYCCW()));
		if (otherBlock.getBlock() instanceof Roof && otherBlock.getValue(FACING_HORIZONTAL) == facing.rotateY()) {
			return state.withProperty(STAIR_TYPE, StairType.INNER_LEFT);
		} else if (otherBlock.getBlock() instanceof Roof
				&& otherBlock.getValue(FACING_HORIZONTAL) == facing.rotateYCCW()) {
			return state.withProperty(STAIR_TYPE, StairType.INNER_RIGHT);
		} else if (otherBlock2.getBlock() instanceof Roof
				&& otherBlock2.getValue(FACING_HORIZONTAL) == facing.rotateY() && !(otherBlock3.getBlock() instanceof Roof && otherBlock3.getValue(FACING_HORIZONTAL) == facing)) {
			return state.withProperty(STAIR_TYPE, StairType.OUTER_LEFT);
		} else if (otherBlock2.getBlock() instanceof Roof
				&& otherBlock2.getValue(FACING_HORIZONTAL) == facing.rotateYCCW() && !(otherBlock4.getBlock() instanceof Roof && otherBlock4.getValue(FACING_HORIZONTAL) == facing)) {
			return state.withProperty(STAIR_TYPE, StairType.OUTER_RIGHT);
		}

		return state;
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING_HORIZONTAL, placer.getHorizontalFacing().getOpposite())
				.withProperty(HAS_TE, worldIn.getBlockState(pos.down()).isFullCube());
	}

	@Override
	@Deprecated
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
		world.setBlockState(pos, state.withProperty(HAS_TE, world.getBlockState(pos.down()).isFullCube()));
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return state.getValue(HAS_TE);
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityRoof();
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
		if (!isActualState) {
			state = this.getActualState(state, worldIn, pos);
		}

		for (AxisAlignedBB axisalignedbb : getCollisionBoxList(state.withProperty(FACING_HORIZONTAL, state.getValue(FACING_HORIZONTAL).getOpposite()))) {
			addCollisionBoxToList(pos, entityBox, collidingBoxes, axisalignedbb);
		}
	}

	@Override
	public void randomTick(World world, BlockPos pos, IBlockState state, Random random){
//
//		if (state.getValue(SNOWED)) return;
//
//		if(!world.isRaining()) return;
//
//		if (!world.canSeeSky(pos.up())) return;
//
//		Biome biome = world.getBiome(pos);
//
//		if (!biome.getEnableSnow() && biome.getTemperature(pos) >= 15) return;
//
//		world.setBlockState(pos, state.withProperty(SNOWED, true), 2);
	}

	@Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
        return false;
    }

//    /**
//     * @deprecated call via {@link IBlockState#getPackedLightmapCoords(IBlockAccess,BlockPos)} whenever possible.
//     * Implementing/overriding is fine.
//     */
//    @Override
//	@Deprecated
//    @SideOnly(Side.CLIENT)
//    public int getPackedLightmapCoords(IBlockState state, IBlockAccess source, BlockPos pos){
////    	return super.getPackedLightmapCoords(state, source, pos);
//        int i = source.getCombinedLight(pos, state.getLightValue(source, pos));
//        World w;
//        if (i == 0 && state.getBlock() instanceof NormalRoof){
//            pos = pos.up();
//            state = source.getBlockState(pos);
//            return source.getCombinedLight(pos, state.getLightValue(source, pos));
//        }else{
//            return i;
//        }
//    }

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(state.getValue(SNOWED) && player.getHeldItem(hand).getItem() instanceof ItemTool) {
			ItemStack held = player.getHeldItem(hand);
			ItemTool tool = (ItemTool) held.getItem();
			if(tool.getToolClasses(held).contains("shovel")) {
				if(!player.isCreative()) held.damageItem(1, player);
				world.setBlockState(pos, state.withProperty(SNOWED, false));
				for(int i = 0; i < 15; i++)
				world.spawnParticle(EnumParticleTypes.BLOCK_CRACK, pos.getX() + 0.5F, pos.getY() + 0.8F,  pos.getZ() + 0.5F, 0F, 0F, 0F, Block.getStateId(Blocks.SNOW_LAYER.getDefaultState()));
				world.playSound(null, pos, Blocks.SNOW_LAYER.getSoundType().getBreakSound(), SoundCategory.BLOCKS, 2F, 1F);
				return true;
			}
		}else if(!state.getValue(SNOWED) && player.getHeldItem(hand).getItem() == Item.getItemFromBlock(Blocks.SNOW_LAYER)) {
			if(!player.isCreative()) player.getHeldItem(hand).shrink(1);
			world.setBlockState(pos, state.withProperty(SNOWED, true));
			world.playSound(null, pos, Blocks.SNOW_LAYER.getSoundType().getPlaceSound(), SoundCategory.BLOCKS, 2F, 1F);
			return true;
		}
		return false;
	}

	private static List<AxisAlignedBB> getCollisionBoxList(IBlockState bstate) {
		List<AxisAlignedBB> list = Lists.<AxisAlignedBB>newArrayList();
		list.add(AABB_SLAB_BOTTOM);
		MedievalBlockProperties.StairType stairType = bstate.getValue(STAIR_TYPE);

		if (stairType == MedievalBlockProperties.StairType.STRAIGHT
				|| stairType == MedievalBlockProperties.StairType.INNER_LEFT
				|| stairType == MedievalBlockProperties.StairType.INNER_RIGHT) {
			list.add(getCollQuarterBlock(bstate));
		}

		if (stairType != MedievalBlockProperties.StairType.STRAIGHT) {
			list.add(getCollEighthBlock(bstate));
		}

		return list;
	}

	/**
	 * Returns a bounding box representing a quarter of a block (two eight-size
	 * cubes back to back). Used in all stair shapes except OUTER.
	 */
	private static AxisAlignedBB getCollQuarterBlock(IBlockState bstate) {
		switch (bstate.getValue(FACING_HORIZONTAL)) {
		case NORTH:
		default:
			return AABB_QTR_TOP_NORTH;
		case SOUTH:
			return AABB_QTR_TOP_SOUTH;
		case WEST:
			return AABB_QTR_TOP_WEST;
		case EAST:
			return AABB_QTR_TOP_EAST;
		}
	}

	/**
     * Returns a bounding box representing an eighth of a block (a block whose three dimensions are halved).
     * Used in all stair shapes except STRAIGHT (gets added alone in the case of OUTER; alone with a quarter block in
     * case of INSIDE).
     */
    private static AxisAlignedBB getCollEighthBlock(IBlockState bstate){
        EnumFacing enumfacing = bstate.getValue(FACING_HORIZONTAL);
        EnumFacing enumfacing1;

        switch (bstate.getValue(STAIR_TYPE)) {
            case OUTER_LEFT:
            default:
                enumfacing1 = enumfacing.rotateY();
                break;
            case OUTER_RIGHT:
                enumfacing1 = enumfacing;
                break;
            case INNER_RIGHT:
                enumfacing1 = enumfacing;
                break;
            case INNER_LEFT:
                enumfacing1 = enumfacing.rotateY();
        }

        switch (enumfacing1) {
            case NORTH:
            default:
                return AABB_OCT_TOP_NW;
            case SOUTH:
                return AABB_OCT_TOP_SE;
            case WEST:
                return AABB_OCT_TOP_SW;
            case EAST:
                return AABB_OCT_TOP_NE;
        }
    }
}