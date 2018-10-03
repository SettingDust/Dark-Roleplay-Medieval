package net.dark_roleplay.medieval.client.objects.blocks.tesrs.old;

import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityCauldron;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class SpecialRenderCauldron extends TileEntitySpecialRenderer<TileEntityCauldron> {

	private static final ResourceLocation textureEmpty = new ResourceLocation(References.MODID, "textures/old_blocks/block_cauldron_empty.png");
	private static final ResourceLocation textureFilled = new ResourceLocation(References.MODID, "textures/old_blocks/block_cauldron_filled.png");

	private ModelCauldronEmpty modelEmpty;
	private ModelCauldronFilled modelFilled;

	public SpecialRenderCauldron() {
		this.modelEmpty = new ModelCauldronEmpty();
		this.modelFilled = new ModelCauldronFilled();
	}

	@Override
	public void render(TileEntityCauldron tileentity, double x, double y, double z, float partialTicks, int destroyStage, float alpha){
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);

		PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
		PropertyBool FILLED = PropertyBool.create("filled");
		IBlockState state = tileentity.getWorld().getBlockState(tileentity.getPos());
		int facing = 0;
		if(state.getValue(FACING).equals(EnumFacing.NORTH))
			facing = 1;
		else if(state.getValue(FACING).equals(EnumFacing.EAST))
			facing = 2;
		else if(state.getValue(FACING).equals(EnumFacing.SOUTH))
			facing = 3;
		else if(state.getValue(FACING).equals(EnumFacing.WEST)) facing = 4;

		GL11.glRotatef(facing * 90, 0.0F, 1.0F, 0.0F);

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

//		if((Boolean) state.getValue(FILLED)){
			this.bindTexture(textureFilled);
			this.modelFilled.renderModel(0.0625F);
//		}
//		else{
//			this.bindTexture(textureEmpty);
//			this.modelEmpty.renderModel(0.0625F);
//		}

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}
}

class ModelCauldronEmpty extends ModelBase {

	// fields
	ModelRenderer Cauldron1;
	ModelRenderer Cauldron2;
	ModelRenderer Cauldron3;
	ModelRenderer Cauldron4;
	ModelRenderer tripod1;
	ModelRenderer Cauldron6;
	ModelRenderer Cauldron7;
	ModelRenderer Cauldron8;
	ModelRenderer Cauldron9;
	ModelRenderer Ingerdient1;
	ModelRenderer Cauldron11;
	ModelRenderer Cauldron13;
	ModelRenderer Cauldron15;
	ModelRenderer Cauldron21;
	ModelRenderer Cauldron27;
	ModelRenderer Cauldron29;
	ModelRenderer Cauldron30;
	ModelRenderer Cauldron31;
	ModelRenderer Cauldron32;
	ModelRenderer Cauldron33;
	ModelRenderer Cauldron34;
	ModelRenderer Cauldron35;
	ModelRenderer Cauldron36;
	ModelRenderer Cauldron37;
	ModelRenderer Cauldron38;
	ModelRenderer Cauldron39;
	ModelRenderer Cauldron5;
	ModelRenderer tripod11;
	ModelRenderer tripod6;
	ModelRenderer tripod2;
	ModelRenderer tripod3;
	ModelRenderer tripod4;
	ModelRenderer tripod5;
	ModelRenderer tripod12;
	ModelRenderer tripod7;
	ModelRenderer tripod8;
	ModelRenderer tripod9;
	ModelRenderer tripod10;
	ModelRenderer Wood2;
	ModelRenderer Wood3;
	ModelRenderer Wood4;
	ModelRenderer Wood5;
	ModelRenderer Wood1;
	ModelRenderer Cauldron10;
	ModelRenderer Water;
	ModelRenderer Ingerdient2;
	ModelRenderer Ingerdient3;
	ModelRenderer Ingerdient4;
	ModelRenderer Ingerdient5;

	public ModelCauldronEmpty() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.Cauldron1 = new ModelRenderer(this, 80, 56);
		this.Cauldron1.addBox(0F, 0F, 0F, 8, 1, 1);
		this.Cauldron1.setRotationPoint(-4F, 7F, -6F);
		this.Cauldron1.setTextureSize(128, 64);
		this.Cauldron1.mirror = true;
		this.setRotation(this.Cauldron1, 0F, 0F, 0F);
		this.Cauldron2 = new ModelRenderer(this, 0, 30);
		this.Cauldron2.addBox(0F, 0F, 0F, 6, 6, 1);
		this.Cauldron2.setRotationPoint(-3F, 10F, -7F);
		this.Cauldron2.setTextureSize(128, 64);
		this.Cauldron2.mirror = true;
		this.setRotation(this.Cauldron2, 0F, 0F, 0F);
		this.Cauldron3 = new ModelRenderer(this, 40, 16);
		this.Cauldron3.addBox(0F, 0F, 0F, 1, 8, 10);
		this.Cauldron3.setRotationPoint(-6F, 9F, -5F);
		this.Cauldron3.setTextureSize(128, 64);
		this.Cauldron3.mirror = true;
		this.setRotation(this.Cauldron3, 0F, 0F, 0F);
		this.Cauldron4 = new ModelRenderer(this, 40, 4);
		this.Cauldron4.addBox(0F, 0F, 0F, 1, 6, 6);
		this.Cauldron4.setRotationPoint(-7F, 10F, -3F);
		this.Cauldron4.setTextureSize(128, 64);
		this.Cauldron4.mirror = true;
		this.setRotation(this.Cauldron4, 0F, 0F, 0F);
		this.tripod1 = new ModelRenderer(this, 62, 6);
		this.tripod1.addBox(0F, 0F, 0F, 1, 1, 10);
		this.tripod1.setRotationPoint(-6F, 17F, -5F);
		this.tripod1.setTextureSize(128, 64);
		this.tripod1.mirror = true;
		this.setRotation(this.tripod1, 0F, 0F, 0F);
		this.Cauldron6 = new ModelRenderer(this, 40, 34);
		this.Cauldron6.addBox(0F, 0F, 0F, 1, 6, 6);
		this.Cauldron6.setRotationPoint(6F, 10F, -3F);
		this.Cauldron6.setTextureSize(128, 64);
		this.Cauldron6.mirror = true;
		this.setRotation(this.Cauldron6, 0F, 0F, 0F);
		this.Cauldron7 = new ModelRenderer(this, 0, 14);
		this.Cauldron7.addBox(0F, 0F, 0F, 6, 6, 1);
		this.Cauldron7.setRotationPoint(-3F, 10F, 6F);
		this.Cauldron7.setTextureSize(128, 64);
		this.Cauldron7.mirror = true;
		this.setRotation(this.Cauldron7, 0F, 0F, 0F);
		this.Cauldron8 = new ModelRenderer(this, 40, 46);
		this.Cauldron8.addBox(0F, 0F, 0F, 1, 8, 10);
		this.Cauldron8.setRotationPoint(5F, 9F, -5F);
		this.Cauldron8.setTextureSize(128, 64);
		this.Cauldron8.mirror = true;
		this.setRotation(this.Cauldron8, 0F, 0F, 0F);
		this.Cauldron9 = new ModelRenderer(this, 32, 8);
		this.Cauldron9.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Cauldron9.setRotationPoint(4F, 7F, -5F);
		this.Cauldron9.setTextureSize(128, 64);
		this.Cauldron9.mirror = true;
		this.setRotation(this.Cauldron9, 0F, 0F, 0F);
		this.Ingerdient1 = new ModelRenderer(this, 88, 40);
		this.Ingerdient1.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Ingerdient1.setRotationPoint(-3F, 9.5F, 2F);
		this.Ingerdient1.setTextureSize(128, 64);
		this.Ingerdient1.mirror = true;
		this.setRotation(this.Ingerdient1, -1.394198F, -1.189716F, 0F);
		this.Cauldron11 = new ModelRenderer(this, 36, 8);
		this.Cauldron11.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Cauldron11.setRotationPoint(-5F, 7F, -5F);
		this.Cauldron11.setTextureSize(128, 64);
		this.Cauldron11.mirror = true;
		this.setRotation(this.Cauldron11, 0F, 0F, 0F);
		this.Cauldron13 = new ModelRenderer(this, 0, 37);
		this.Cauldron13.addBox(0F, 0F, 0F, 10, 8, 1);
		this.Cauldron13.setRotationPoint(-5F, 9F, -6F);
		this.Cauldron13.setTextureSize(128, 64);
		this.Cauldron13.mirror = true;
		this.setRotation(this.Cauldron13, 0F, 0F, 0F);
		this.Cauldron15 = new ModelRenderer(this, 0, 21);
		this.Cauldron15.addBox(0F, 0F, 0F, 10, 8, 1);
		this.Cauldron15.setRotationPoint(-5F, 9F, 5F);
		this.Cauldron15.setTextureSize(128, 64);
		this.Cauldron15.mirror = true;
		this.setRotation(this.Cauldron15, 0F, 0F, 0F);
		this.Cauldron21 = new ModelRenderer(this, 62, 46);
		this.Cauldron21.addBox(0F, 0F, 0F, 1, 1, 8);
		this.Cauldron21.setRotationPoint(-6F, 7F, -4F);
		this.Cauldron21.setTextureSize(128, 64);
		this.Cauldron21.mirror = true;
		this.setRotation(this.Cauldron21, 0F, 0F, 0F);
		this.Cauldron27 = new ModelRenderer(this, 80, 58);
		this.Cauldron27.addBox(0F, 0F, 0F, 8, 1, 1);
		this.Cauldron27.setRotationPoint(-4F, 8F, -5F);
		this.Cauldron27.setTextureSize(128, 64);
		this.Cauldron27.mirror = true;
		this.setRotation(this.Cauldron27, 0F, 0F, 0F);
		this.Cauldron29 = new ModelRenderer(this, 0, 46);
		this.Cauldron29.addBox(0F, 0F, 0F, 10, 1, 10);
		this.Cauldron29.setRotationPoint(-5F, 17F, -5F);
		this.Cauldron29.setTextureSize(128, 64);
		this.Cauldron29.mirror = true;
		this.setRotation(this.Cauldron29, 0F, 0F, 0F);
		this.Cauldron30 = new ModelRenderer(this, 28, 10);
		this.Cauldron30.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Cauldron30.setRotationPoint(4F, 9F, 4F);
		this.Cauldron30.setTextureSize(128, 64);
		this.Cauldron30.mirror = true;
		this.setRotation(this.Cauldron30, 0F, 0F, 0F);
		this.Cauldron31 = new ModelRenderer(this, 24, 8);
		this.Cauldron31.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Cauldron31.setRotationPoint(-5F, 7F, 4F);
		this.Cauldron31.setTextureSize(128, 64);
		this.Cauldron31.mirror = true;
		this.setRotation(this.Cauldron31, 0F, 0F, 0F);
		this.Cauldron32 = new ModelRenderer(this, 32, 10);
		this.Cauldron32.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Cauldron32.setRotationPoint(4F, 9F, -5F);
		this.Cauldron32.setTextureSize(128, 64);
		this.Cauldron32.mirror = true;
		this.setRotation(this.Cauldron32, 0F, 0F, 0F);
		this.Cauldron33 = new ModelRenderer(this, 28, 8);
		this.Cauldron33.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Cauldron33.setRotationPoint(4F, 7F, 4F);
		this.Cauldron33.setTextureSize(128, 64);
		this.Cauldron33.mirror = true;
		this.setRotation(this.Cauldron33, 0F, 0F, 0F);
		this.Cauldron34 = new ModelRenderer(this, 36, 10);
		this.Cauldron34.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Cauldron34.setRotationPoint(-5F, 9F, -5F);
		this.Cauldron34.setTextureSize(128, 64);
		this.Cauldron34.mirror = true;
		this.setRotation(this.Cauldron34, 0F, 0F, 0F);
		this.Cauldron35 = new ModelRenderer(this, 62, 37);
		this.Cauldron35.addBox(0F, 0F, 0F, 1, 1, 8);
		this.Cauldron35.setRotationPoint(4F, 8F, -4F);
		this.Cauldron35.setTextureSize(128, 64);
		this.Cauldron35.mirror = true;
		this.setRotation(this.Cauldron35, 0F, 0F, 0F);
		this.Cauldron36 = new ModelRenderer(this, 24, 10);
		this.Cauldron36.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Cauldron36.setRotationPoint(-5F, 9F, 4F);
		this.Cauldron36.setTextureSize(128, 64);
		this.Cauldron36.mirror = true;
		this.setRotation(this.Cauldron36, 0F, 0F, 0F);
		this.Cauldron37 = new ModelRenderer(this, 62, 28);
		this.Cauldron37.addBox(0F, 0F, 0F, 1, 1, 8);
		this.Cauldron37.setRotationPoint(5F, 7F, -4F);
		this.Cauldron37.setTextureSize(128, 64);
		this.Cauldron37.mirror = true;
		this.setRotation(this.Cauldron37, 0F, 0F, 0F);
		this.Cauldron38 = new ModelRenderer(this, 80, 60);
		this.Cauldron38.addBox(0F, 0F, 0F, 8, 1, 1);
		this.Cauldron38.setRotationPoint(-4F, 7F, 5F);
		this.Cauldron38.setTextureSize(128, 64);
		this.Cauldron38.mirror = true;
		this.setRotation(this.Cauldron38, 0F, 0F, 0F);
		this.Cauldron39 = new ModelRenderer(this, 80, 62);
		this.Cauldron39.addBox(0F, 0F, 0F, 8, 1, 1);
		this.Cauldron39.setRotationPoint(-4F, 8F, 4F);
		this.Cauldron39.setTextureSize(128, 64);
		this.Cauldron39.mirror = true;
		this.setRotation(this.Cauldron39, 0F, 0F, 0F);
		this.Cauldron5 = new ModelRenderer(this, 0, 57);
		this.Cauldron5.addBox(0F, 0F, 0F, 6, 1, 6);
		this.Cauldron5.setRotationPoint(-3F, 18F, -3F);
		this.Cauldron5.setTextureSize(128, 64);
		this.Cauldron5.mirror = true;
		this.setRotation(this.Cauldron5, 0F, 0F, 0F);
		this.tripod11 = new ModelRenderer(this, 54, 40);
		this.tripod11.addBox(0F, 0F, 0F, 1, 5, 1);
		this.tripod11.setRotationPoint(-7F, 19.2F, -6.3F);
		this.tripod11.setTextureSize(128, 64);
		this.tripod11.mirror = true;
		this.setRotation(this.tripod11, 0F, 0.7853982F, 0F);
		this.tripod6 = new ModelRenderer(this, 54, 0);
		this.tripod6.addBox(0F, 0F, 0F, 1, 1, 3);
		this.tripod6.setRotationPoint(5F, 17.7F, 4.3F);
		this.tripod6.setTextureSize(128, 64);
		this.tripod6.mirror = true;
		this.setRotation(this.tripod6, -2.356194F, -2.356194F, 0F);
		this.tripod2 = new ModelRenderer(this, 62, 4);
		this.tripod2.addBox(0F, 0F, 0F, 10, 1, 1);
		this.tripod2.setRotationPoint(-5F, 17F, 5F);
		this.tripod2.setTextureSize(128, 64);
		this.tripod2.mirror = true;
		this.setRotation(this.tripod2, 0F, 0F, 0F);
		this.tripod3 = new ModelRenderer(this, 54, 4);
		this.tripod3.addBox(0F, 0F, 0F, 1, 1, 3);
		this.tripod3.setRotationPoint(-4.3F, 17.7F, 5F);
		this.tripod3.setTextureSize(128, 64);
		this.tripod3.mirror = true;
		this.setRotation(this.tripod3, -2.356194F, 2.356194F, 0F);
		this.tripod4 = new ModelRenderer(this, 62, 2);
		this.tripod4.addBox(0F, 0F, 0F, 10, 1, 1);
		this.tripod4.setRotationPoint(-5F, 17F, -6F);
		this.tripod4.setTextureSize(128, 64);
		this.tripod4.mirror = true;
		this.setRotation(this.tripod4, 0F, 0F, 0F);
		this.tripod5 = new ModelRenderer(this, 62, 17);
		this.tripod5.addBox(0F, 0F, 0F, 1, 1, 10);
		this.tripod5.setRotationPoint(5F, 17F, -5F);
		this.tripod5.setTextureSize(128, 64);
		this.tripod5.mirror = true;
		this.setRotation(this.tripod5, 0F, 0F, 0F);
		this.tripod12 = new ModelRenderer(this, 54, 34);
		this.tripod12.addBox(0F, 0F, 0F, 1, 5, 1);
		this.tripod12.setRotationPoint(-7F, 19.2F, 6.3F);
		this.tripod12.setTextureSize(128, 64);
		this.tripod12.mirror = true;
		this.setRotation(this.tripod12, 0F, 0.7853982F, 0F);
		this.tripod7 = new ModelRenderer(this, 54, 8);
		this.tripod7.addBox(0F, 0F, 0F, 1, 1, 3);
		this.tripod7.setRotationPoint(-5F, 17.7F, -4.3F);
		this.tripod7.setTextureSize(128, 64);
		this.tripod7.mirror = true;
		this.setRotation(this.tripod7, -2.356194F, 0.7853982F, 0F);
		this.tripod8 = new ModelRenderer(this, 54, 12);
		this.tripod8.addBox(0F, 0F, 0F, 1, 1, 3);
		this.tripod8.setRotationPoint(4.3F, 17.7F, -5F);
		this.tripod8.setTextureSize(128, 64);
		this.tripod8.mirror = true;
		this.setRotation(this.tripod8, -2.356194F, -0.7853982F, 0F);
		this.tripod9 = new ModelRenderer(this, 58, 34);
		this.tripod9.addBox(0F, 0F, 0F, 1, 5, 1);
		this.tripod9.setRotationPoint(5.6F, 19.2F, 6.3F);
		this.tripod9.setTextureSize(128, 64);
		this.tripod9.mirror = true;
		this.setRotation(this.tripod9, 0F, 0.7853982F, 0F);
		this.tripod10 = new ModelRenderer(this, 58, 40);
		this.tripod10.addBox(0F, 0F, 0F, 1, 5, 1);
		this.tripod10.setRotationPoint(5.6F, 19.2F, -6.3F);
		this.tripod10.setTextureSize(128, 64);
		this.tripod10.mirror = true;
		this.setRotation(this.tripod10, 0F, 0.7853982F, 0F);
		this.Wood2 = new ModelRenderer(this, 32, 38);
		this.Wood2.addBox(0F, 0F, 0F, 2, 6, 2);
		this.Wood2.setRotationPoint(0F, 20F, -1F);
		this.Wood2.setTextureSize(128, 64);
		this.Wood2.mirror = true;
		this.setRotation(this.Wood2, -1.22173F, -0.5205006F, 0F);
		this.Wood3 = new ModelRenderer(this, 24, 38);
		this.Wood3.addBox(0F, 0F, 0F, 2, 6, 2);
		this.Wood3.setRotationPoint(0F, 20F, -1F);
		this.Wood3.setTextureSize(128, 64);
		this.Wood3.mirror = true;
		this.setRotation(this.Wood3, -1.22173F, -1.747395F, 0F);
		this.Wood4 = new ModelRenderer(this, 24, 30);
		this.Wood4.addBox(0F, 0F, 0F, 2, 6, 2);
		this.Wood4.setRotationPoint(0F, 20F, -1F);
		this.Wood4.setTextureSize(128, 64);
		this.Wood4.mirror = true;
		this.setRotation(this.Wood4, -1.22173F, 1.951877F, 0F);
		this.Wood5 = new ModelRenderer(this, 24, 30);
		this.Wood5.addBox(0F, 0F, 0F, 2, 6, 2);
		this.Wood5.setRotationPoint(0F, 20F, -1F);
		this.Wood5.setTextureSize(128, 64);
		this.Wood5.mirror = true;
		this.setRotation(this.Wood5, -1.22173F, -3.141593F, 0F);
		this.Wood1 = new ModelRenderer(this, 32, 30);
		this.Wood1.addBox(0F, 0F, 0F, 2, 6, 2);
		this.Wood1.setRotationPoint(0F, 20F, -1F);
		this.Wood1.setTextureSize(128, 64);
		this.Wood1.mirror = true;
		this.setRotation(this.Wood1, -1.22173F, 1.208305F, 0F);
		this.Cauldron10 = new ModelRenderer(this, 62, 55);
		this.Cauldron10.addBox(0F, 0F, 0F, 1, 1, 8);
		this.Cauldron10.setRotationPoint(-5F, 8F, -4F);
		this.Cauldron10.setTextureSize(128, 64);
		this.Cauldron10.mirror = true;
		this.setRotation(this.Cauldron10, 0F, 0F, 0F);
		this.Water = new ModelRenderer(this, 88, 40);
		this.Water.addBox(0F, 0F, 0F, 10, 0, 10);
		this.Water.setRotationPoint(-5F, 10F, -5F);
		this.Water.setTextureSize(128, 64);
		this.Water.mirror = true;
		this.setRotation(this.Water, 0F, 0F, 0F);
		this.Ingerdient2 = new ModelRenderer(this, 88, 42);
		this.Ingerdient2.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Ingerdient2.setRotationPoint(3F, 9.5F, -3F);
		this.Ingerdient2.setTextureSize(128, 64);
		this.Ingerdient2.mirror = true;
		this.setRotation(this.Ingerdient2, -0.3717861F, -2.453788F, 0F);
		this.Ingerdient3 = new ModelRenderer(this, 88, 40);
		this.Ingerdient3.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Ingerdient3.setRotationPoint(0F, 9.5F, -1F);
		this.Ingerdient3.setTextureSize(128, 64);
		this.Ingerdient3.mirror = true;
		this.setRotation(this.Ingerdient3, -0.1858931F, -0.0371786F, 0F);
		this.Ingerdient4 = new ModelRenderer(this, 88, 42);
		this.Ingerdient4.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Ingerdient4.setRotationPoint(-2F, 9.5F, -3F);
		this.Ingerdient4.setTextureSize(128, 64);
		this.Ingerdient4.mirror = true;
		this.setRotation(this.Ingerdient4, -0.7435722F, -1.189716F, 0F);
		this.Ingerdient5 = new ModelRenderer(this, 88, 42);
		this.Ingerdient5.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Ingerdient5.setRotationPoint(2F, 9.5F, 3F);
		this.Ingerdient5.setTextureSize(128, 64);
		this.Ingerdient5.mirror = true;
		this.setRotation(this.Ingerdient5, -0.3717861F, -3.085825F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Cauldron1.render(f5);
		this.Cauldron2.render(f5);
		this.Cauldron3.render(f5);
		this.Cauldron4.render(f5);
		this.tripod1.render(f5);
		this.Cauldron6.render(f5);
		this.Cauldron7.render(f5);
		this.Cauldron8.render(f5);
		this.Cauldron9.render(f5);
		this.Ingerdient1.render(f5);
		this.Cauldron11.render(f5);
		this.Cauldron13.render(f5);
		this.Cauldron15.render(f5);
		this.Cauldron21.render(f5);
		this.Cauldron27.render(f5);
		this.Cauldron29.render(f5);
		this.Cauldron30.render(f5);
		this.Cauldron31.render(f5);
		this.Cauldron32.render(f5);
		this.Cauldron33.render(f5);
		this.Cauldron34.render(f5);
		this.Cauldron35.render(f5);
		this.Cauldron36.render(f5);
		this.Cauldron37.render(f5);
		this.Cauldron38.render(f5);
		this.Cauldron39.render(f5);
		this.Cauldron5.render(f5);
		this.tripod11.render(f5);
		this.tripod6.render(f5);
		this.tripod2.render(f5);
		this.tripod3.render(f5);
		this.tripod4.render(f5);
		this.tripod5.render(f5);
		this.tripod12.render(f5);
		this.tripod7.render(f5);
		this.tripod8.render(f5);
		this.tripod9.render(f5);
		this.tripod10.render(f5);
		this.Wood2.render(f5);
		this.Wood3.render(f5);
		this.Wood4.render(f5);
		this.Wood5.render(f5);
		this.Wood1.render(f5);
		this.Cauldron10.render(f5);
		this.Water.render(f5);
		this.Ingerdient2.render(f5);
		this.Ingerdient3.render(f5);
		this.Ingerdient4.render(f5);
		this.Ingerdient5.render(f5);
	}

	public void renderModel(float f5) {

		this.Cauldron1.render(f5);
		this.Cauldron2.render(f5);
		this.Cauldron3.render(f5);
		this.Cauldron4.render(f5);
		this.tripod1.render(f5);
		this.Cauldron6.render(f5);
		this.Cauldron7.render(f5);
		this.Cauldron8.render(f5);
		this.Cauldron9.render(f5);
		this.Ingerdient1.render(f5);
		this.Cauldron11.render(f5);
		this.Cauldron13.render(f5);
		this.Cauldron15.render(f5);
		this.Cauldron21.render(f5);
		this.Cauldron27.render(f5);
		this.Cauldron29.render(f5);
		this.Cauldron30.render(f5);
		this.Cauldron31.render(f5);
		this.Cauldron32.render(f5);
		this.Cauldron33.render(f5);
		this.Cauldron34.render(f5);
		this.Cauldron35.render(f5);
		this.Cauldron36.render(f5);
		this.Cauldron37.render(f5);
		this.Cauldron38.render(f5);
		this.Cauldron39.render(f5);
		this.Cauldron5.render(f5);
		this.tripod11.render(f5);
		this.tripod6.render(f5);
		this.tripod2.render(f5);
		this.tripod3.render(f5);
		this.tripod4.render(f5);
		this.tripod5.render(f5);
		this.tripod12.render(f5);
		this.tripod7.render(f5);
		this.tripod8.render(f5);
		this.tripod9.render(f5);
		this.tripod10.render(f5);
		this.Wood2.render(f5);
		this.Wood3.render(f5);
		this.Wood4.render(f5);
		this.Wood5.render(f5);
		this.Wood1.render(f5);
		this.Cauldron10.render(f5);
		this.Water.render(f5);
		this.Ingerdient2.render(f5);
		this.Ingerdient3.render(f5);
		this.Ingerdient4.render(f5);
		this.Ingerdient5.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {

		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {

		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}

class ModelCauldronFilled extends ModelBase {

	// fields
	ModelRenderer Cauldron1;
	ModelRenderer Cauldron2;
	ModelRenderer Cauldron3;
	ModelRenderer Cauldron4;
	ModelRenderer tripod1;
	ModelRenderer Cauldron6;
	ModelRenderer Cauldron7;
	ModelRenderer Cauldron8;
	ModelRenderer Cauldron9;
	ModelRenderer Ingerdient1;
	ModelRenderer Cauldron11;
	ModelRenderer Cauldron13;
	ModelRenderer Cauldron15;
	ModelRenderer Cauldron21;
	ModelRenderer Cauldron27;
	ModelRenderer Cauldron29;
	ModelRenderer Cauldron30;
	ModelRenderer Cauldron31;
	ModelRenderer Cauldron32;
	ModelRenderer Cauldron33;
	ModelRenderer Cauldron34;
	ModelRenderer Cauldron35;
	ModelRenderer Cauldron36;
	ModelRenderer Cauldron37;
	ModelRenderer Cauldron38;
	ModelRenderer Cauldron39;
	ModelRenderer Cauldron5;
	ModelRenderer tripod11;
	ModelRenderer tripod6;
	ModelRenderer tripod2;
	ModelRenderer tripod3;
	ModelRenderer tripod4;
	ModelRenderer tripod5;
	ModelRenderer tripod12;
	ModelRenderer tripod7;
	ModelRenderer tripod8;
	ModelRenderer tripod9;
	ModelRenderer tripod10;
	ModelRenderer Wood2;
	ModelRenderer Wood3;
	ModelRenderer Wood4;
	ModelRenderer Wood5;
	ModelRenderer Wood1;
	ModelRenderer Cauldron10;
	ModelRenderer Water;
	ModelRenderer Ingerdient2;
	ModelRenderer Ingerdient3;
	ModelRenderer Ingerdient4;
	ModelRenderer Ingerdient5;

	public ModelCauldronFilled() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.Cauldron1 = new ModelRenderer(this, 80, 56);
		this.Cauldron1.addBox(0F, 0F, 0F, 8, 1, 1);
		this.Cauldron1.setRotationPoint(-4F, 7F, -6F);
		this.Cauldron1.setTextureSize(128, 64);
		this.Cauldron1.mirror = true;
		this.setRotation(this.Cauldron1, 0F, 0F, 0F);
		this.Cauldron2 = new ModelRenderer(this, 0, 30);
		this.Cauldron2.addBox(0F, 0F, 0F, 6, 6, 1);
		this.Cauldron2.setRotationPoint(-3F, 10F, -7F);
		this.Cauldron2.setTextureSize(128, 64);
		this.Cauldron2.mirror = true;
		this.setRotation(this.Cauldron2, 0F, 0F, 0F);
		this.Cauldron3 = new ModelRenderer(this, 40, 16);
		this.Cauldron3.addBox(0F, 0F, 0F, 1, 8, 10);
		this.Cauldron3.setRotationPoint(-6F, 9F, -5F);
		this.Cauldron3.setTextureSize(128, 64);
		this.Cauldron3.mirror = true;
		this.setRotation(this.Cauldron3, 0F, 0F, 0F);
		this.Cauldron4 = new ModelRenderer(this, 40, 4);
		this.Cauldron4.addBox(0F, 0F, 0F, 1, 6, 6);
		this.Cauldron4.setRotationPoint(-7F, 10F, -3F);
		this.Cauldron4.setTextureSize(128, 64);
		this.Cauldron4.mirror = true;
		this.setRotation(this.Cauldron4, 0F, 0F, 0F);
		this.tripod1 = new ModelRenderer(this, 62, 6);
		this.tripod1.addBox(0F, 0F, 0F, 1, 1, 10);
		this.tripod1.setRotationPoint(-6F, 17F, -5F);
		this.tripod1.setTextureSize(128, 64);
		this.tripod1.mirror = true;
		this.setRotation(this.tripod1, 0F, 0F, 0F);
		this.Cauldron6 = new ModelRenderer(this, 40, 34);
		this.Cauldron6.addBox(0F, 0F, 0F, 1, 6, 6);
		this.Cauldron6.setRotationPoint(6F, 10F, -3F);
		this.Cauldron6.setTextureSize(128, 64);
		this.Cauldron6.mirror = true;
		this.setRotation(this.Cauldron6, 0F, 0F, 0F);
		this.Cauldron7 = new ModelRenderer(this, 0, 14);
		this.Cauldron7.addBox(0F, 0F, 0F, 6, 6, 1);
		this.Cauldron7.setRotationPoint(-3F, 10F, 6F);
		this.Cauldron7.setTextureSize(128, 64);
		this.Cauldron7.mirror = true;
		this.setRotation(this.Cauldron7, 0F, 0F, 0F);
		this.Cauldron8 = new ModelRenderer(this, 40, 46);
		this.Cauldron8.addBox(0F, 0F, 0F, 1, 8, 10);
		this.Cauldron8.setRotationPoint(5F, 9F, -5F);
		this.Cauldron8.setTextureSize(128, 64);
		this.Cauldron8.mirror = true;
		this.setRotation(this.Cauldron8, 0F, 0F, 0F);
		this.Cauldron9 = new ModelRenderer(this, 32, 8);
		this.Cauldron9.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Cauldron9.setRotationPoint(4F, 7F, -5F);
		this.Cauldron9.setTextureSize(128, 64);
		this.Cauldron9.mirror = true;
		this.setRotation(this.Cauldron9, 0F, 0F, 0F);
		this.Ingerdient1 = new ModelRenderer(this, 88, 40);
		this.Ingerdient1.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Ingerdient1.setRotationPoint(-3F, 9.5F, 2F);
		this.Ingerdient1.setTextureSize(128, 64);
		this.Ingerdient1.mirror = true;
		this.setRotation(this.Ingerdient1, -1.394198F, -1.189716F, 0F);
		this.Cauldron11 = new ModelRenderer(this, 36, 8);
		this.Cauldron11.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Cauldron11.setRotationPoint(-5F, 7F, -5F);
		this.Cauldron11.setTextureSize(128, 64);
		this.Cauldron11.mirror = true;
		this.setRotation(this.Cauldron11, 0F, 0F, 0F);
		this.Cauldron13 = new ModelRenderer(this, 0, 37);
		this.Cauldron13.addBox(0F, 0F, 0F, 10, 8, 1);
		this.Cauldron13.setRotationPoint(-5F, 9F, -6F);
		this.Cauldron13.setTextureSize(128, 64);
		this.Cauldron13.mirror = true;
		this.setRotation(this.Cauldron13, 0F, 0F, 0F);
		this.Cauldron15 = new ModelRenderer(this, 0, 21);
		this.Cauldron15.addBox(0F, 0F, 0F, 10, 8, 1);
		this.Cauldron15.setRotationPoint(-5F, 9F, 5F);
		this.Cauldron15.setTextureSize(128, 64);
		this.Cauldron15.mirror = true;
		this.setRotation(this.Cauldron15, 0F, 0F, 0F);
		this.Cauldron21 = new ModelRenderer(this, 62, 46);
		this.Cauldron21.addBox(0F, 0F, 0F, 1, 1, 8);
		this.Cauldron21.setRotationPoint(-6F, 7F, -4F);
		this.Cauldron21.setTextureSize(128, 64);
		this.Cauldron21.mirror = true;
		this.setRotation(this.Cauldron21, 0F, 0F, 0F);
		this.Cauldron27 = new ModelRenderer(this, 80, 58);
		this.Cauldron27.addBox(0F, 0F, 0F, 8, 1, 1);
		this.Cauldron27.setRotationPoint(-4F, 8F, -5F);
		this.Cauldron27.setTextureSize(128, 64);
		this.Cauldron27.mirror = true;
		this.setRotation(this.Cauldron27, 0F, 0F, 0F);
		this.Cauldron29 = new ModelRenderer(this, 0, 46);
		this.Cauldron29.addBox(0F, 0F, 0F, 10, 1, 10);
		this.Cauldron29.setRotationPoint(-5F, 17F, -5F);
		this.Cauldron29.setTextureSize(128, 64);
		this.Cauldron29.mirror = true;
		this.setRotation(this.Cauldron29, 0F, 0F, 0F);
		this.Cauldron30 = new ModelRenderer(this, 28, 10);
		this.Cauldron30.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Cauldron30.setRotationPoint(4F, 9F, 4F);
		this.Cauldron30.setTextureSize(128, 64);
		this.Cauldron30.mirror = true;
		this.setRotation(this.Cauldron30, 0F, 0F, 0F);
		this.Cauldron31 = new ModelRenderer(this, 24, 8);
		this.Cauldron31.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Cauldron31.setRotationPoint(-5F, 7F, 4F);
		this.Cauldron31.setTextureSize(128, 64);
		this.Cauldron31.mirror = true;
		this.setRotation(this.Cauldron31, 0F, 0F, 0F);
		this.Cauldron32 = new ModelRenderer(this, 32, 10);
		this.Cauldron32.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Cauldron32.setRotationPoint(4F, 9F, -5F);
		this.Cauldron32.setTextureSize(128, 64);
		this.Cauldron32.mirror = true;
		this.setRotation(this.Cauldron32, 0F, 0F, 0F);
		this.Cauldron33 = new ModelRenderer(this, 28, 8);
		this.Cauldron33.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Cauldron33.setRotationPoint(4F, 7F, 4F);
		this.Cauldron33.setTextureSize(128, 64);
		this.Cauldron33.mirror = true;
		this.setRotation(this.Cauldron33, 0F, 0F, 0F);
		this.Cauldron34 = new ModelRenderer(this, 36, 10);
		this.Cauldron34.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Cauldron34.setRotationPoint(-5F, 9F, -5F);
		this.Cauldron34.setTextureSize(128, 64);
		this.Cauldron34.mirror = true;
		this.setRotation(this.Cauldron34, 0F, 0F, 0F);
		this.Cauldron35 = new ModelRenderer(this, 62, 37);
		this.Cauldron35.addBox(0F, 0F, 0F, 1, 1, 8);
		this.Cauldron35.setRotationPoint(4F, 8F, -4F);
		this.Cauldron35.setTextureSize(128, 64);
		this.Cauldron35.mirror = true;
		this.setRotation(this.Cauldron35, 0F, 0F, 0F);
		this.Cauldron36 = new ModelRenderer(this, 24, 10);
		this.Cauldron36.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Cauldron36.setRotationPoint(-5F, 9F, 4F);
		this.Cauldron36.setTextureSize(128, 64);
		this.Cauldron36.mirror = true;
		this.setRotation(this.Cauldron36, 0F, 0F, 0F);
		this.Cauldron37 = new ModelRenderer(this, 62, 28);
		this.Cauldron37.addBox(0F, 0F, 0F, 1, 1, 8);
		this.Cauldron37.setRotationPoint(5F, 7F, -4F);
		this.Cauldron37.setTextureSize(128, 64);
		this.Cauldron37.mirror = true;
		this.setRotation(this.Cauldron37, 0F, 0F, 0F);
		this.Cauldron38 = new ModelRenderer(this, 80, 60);
		this.Cauldron38.addBox(0F, 0F, 0F, 8, 1, 1);
		this.Cauldron38.setRotationPoint(-4F, 7F, 5F);
		this.Cauldron38.setTextureSize(128, 64);
		this.Cauldron38.mirror = true;
		this.setRotation(this.Cauldron38, 0F, 0F, 0F);
		this.Cauldron39 = new ModelRenderer(this, 80, 62);
		this.Cauldron39.addBox(0F, 0F, 0F, 8, 1, 1);
		this.Cauldron39.setRotationPoint(-4F, 8F, 4F);
		this.Cauldron39.setTextureSize(128, 64);
		this.Cauldron39.mirror = true;
		this.setRotation(this.Cauldron39, 0F, 0F, 0F);
		this.Cauldron5 = new ModelRenderer(this, 0, 57);
		this.Cauldron5.addBox(0F, 0F, 0F, 6, 1, 6);
		this.Cauldron5.setRotationPoint(-3F, 18F, -3F);
		this.Cauldron5.setTextureSize(128, 64);
		this.Cauldron5.mirror = true;
		this.setRotation(this.Cauldron5, 0F, 0F, 0F);
		this.tripod11 = new ModelRenderer(this, 54, 40);
		this.tripod11.addBox(0F, 0F, 0F, 1, 5, 1);
		this.tripod11.setRotationPoint(-7F, 19.2F, -6.3F);
		this.tripod11.setTextureSize(128, 64);
		this.tripod11.mirror = true;
		this.setRotation(this.tripod11, 0F, 0.7853982F, 0F);
		this.tripod6 = new ModelRenderer(this, 54, 0);
		this.tripod6.addBox(0F, 0F, 0F, 1, 1, 3);
		this.tripod6.setRotationPoint(5F, 17.7F, 4.3F);
		this.tripod6.setTextureSize(128, 64);
		this.tripod6.mirror = true;
		this.setRotation(this.tripod6, -2.356194F, -2.356194F, 0F);
		this.tripod2 = new ModelRenderer(this, 62, 4);
		this.tripod2.addBox(0F, 0F, 0F, 10, 1, 1);
		this.tripod2.setRotationPoint(-5F, 17F, 5F);
		this.tripod2.setTextureSize(128, 64);
		this.tripod2.mirror = true;
		this.setRotation(this.tripod2, 0F, 0F, 0F);
		this.tripod3 = new ModelRenderer(this, 54, 4);
		this.tripod3.addBox(0F, 0F, 0F, 1, 1, 3);
		this.tripod3.setRotationPoint(-4.3F, 17.7F, 5F);
		this.tripod3.setTextureSize(128, 64);
		this.tripod3.mirror = true;
		this.setRotation(this.tripod3, -2.356194F, 2.356194F, 0F);
		this.tripod4 = new ModelRenderer(this, 62, 2);
		this.tripod4.addBox(0F, 0F, 0F, 10, 1, 1);
		this.tripod4.setRotationPoint(-5F, 17F, -6F);
		this.tripod4.setTextureSize(128, 64);
		this.tripod4.mirror = true;
		this.setRotation(this.tripod4, 0F, 0F, 0F);
		this.tripod5 = new ModelRenderer(this, 62, 17);
		this.tripod5.addBox(0F, 0F, 0F, 1, 1, 10);
		this.tripod5.setRotationPoint(5F, 17F, -5F);
		this.tripod5.setTextureSize(128, 64);
		this.tripod5.mirror = true;
		this.setRotation(this.tripod5, 0F, 0F, 0F);
		this.tripod12 = new ModelRenderer(this, 54, 34);
		this.tripod12.addBox(0F, 0F, 0F, 1, 5, 1);
		this.tripod12.setRotationPoint(-7F, 19.2F, 6.3F);
		this.tripod12.setTextureSize(128, 64);
		this.tripod12.mirror = true;
		this.setRotation(this.tripod12, 0F, 0.7853982F, 0F);
		this.tripod7 = new ModelRenderer(this, 54, 8);
		this.tripod7.addBox(0F, 0F, 0F, 1, 1, 3);
		this.tripod7.setRotationPoint(-5F, 17.7F, -4.3F);
		this.tripod7.setTextureSize(128, 64);
		this.tripod7.mirror = true;
		this.setRotation(this.tripod7, -2.356194F, 0.7853982F, 0F);
		this.tripod8 = new ModelRenderer(this, 54, 12);
		this.tripod8.addBox(0F, 0F, 0F, 1, 1, 3);
		this.tripod8.setRotationPoint(4.3F, 17.7F, -5F);
		this.tripod8.setTextureSize(128, 64);
		this.tripod8.mirror = true;
		this.setRotation(this.tripod8, -2.356194F, -0.7853982F, 0F);
		this.tripod9 = new ModelRenderer(this, 58, 34);
		this.tripod9.addBox(0F, 0F, 0F, 1, 5, 1);
		this.tripod9.setRotationPoint(5.6F, 19.2F, 6.3F);
		this.tripod9.setTextureSize(128, 64);
		this.tripod9.mirror = true;
		this.setRotation(this.tripod9, 0F, 0.7853982F, 0F);
		this.tripod10 = new ModelRenderer(this, 58, 40);
		this.tripod10.addBox(0F, 0F, 0F, 1, 5, 1);
		this.tripod10.setRotationPoint(5.6F, 19.2F, -6.3F);
		this.tripod10.setTextureSize(128, 64);
		this.tripod10.mirror = true;
		this.setRotation(this.tripod10, 0F, 0.7853982F, 0F);
		this.Wood2 = new ModelRenderer(this, 32, 38);
		this.Wood2.addBox(0F, 0F, 0F, 2, 6, 2);
		this.Wood2.setRotationPoint(0F, 20F, -1F);
		this.Wood2.setTextureSize(128, 64);
		this.Wood2.mirror = true;
		this.setRotation(this.Wood2, -1.22173F, -0.5205006F, 0F);
		this.Wood3 = new ModelRenderer(this, 24, 38);
		this.Wood3.addBox(0F, 0F, 0F, 2, 6, 2);
		this.Wood3.setRotationPoint(0F, 20F, -1F);
		this.Wood3.setTextureSize(128, 64);
		this.Wood3.mirror = true;
		this.setRotation(this.Wood3, -1.22173F, -1.747395F, 0F);
		this.Wood4 = new ModelRenderer(this, 24, 30);
		this.Wood4.addBox(0F, 0F, 0F, 2, 6, 2);
		this.Wood4.setRotationPoint(0F, 20F, -1F);
		this.Wood4.setTextureSize(128, 64);
		this.Wood4.mirror = true;
		this.setRotation(this.Wood4, -1.22173F, 1.951877F, 0F);
		this.Wood5 = new ModelRenderer(this, 24, 30);
		this.Wood5.addBox(0F, 0F, 0F, 2, 6, 2);
		this.Wood5.setRotationPoint(0F, 20F, -1F);
		this.Wood5.setTextureSize(128, 64);
		this.Wood5.mirror = true;
		this.setRotation(this.Wood5, -1.22173F, -3.141593F, 0F);
		this.Wood1 = new ModelRenderer(this, 32, 30);
		this.Wood1.addBox(0F, 0F, 0F, 2, 6, 2);
		this.Wood1.setRotationPoint(0F, 20F, -1F);
		this.Wood1.setTextureSize(128, 64);
		this.Wood1.mirror = true;
		this.setRotation(this.Wood1, -1.22173F, 1.208305F, 0F);
		this.Cauldron10 = new ModelRenderer(this, 62, 55);
		this.Cauldron10.addBox(0F, 0F, 0F, 1, 1, 8);
		this.Cauldron10.setRotationPoint(-5F, 8F, -4F);
		this.Cauldron10.setTextureSize(128, 64);
		this.Cauldron10.mirror = true;
		this.setRotation(this.Cauldron10, 0F, 0F, 0F);
		this.Water = new ModelRenderer(this, 88, 40);
		this.Water.addBox(0F, 0F, 0F, 10, 0, 10);
		this.Water.setRotationPoint(-5F, 10F, -5F);
		this.Water.setTextureSize(128, 64);
		this.Water.mirror = true;
		this.setRotation(this.Water, 0F, 0F, 0F);
		this.Ingerdient2 = new ModelRenderer(this, 88, 42);
		this.Ingerdient2.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Ingerdient2.setRotationPoint(3F, 9.5F, -3F);
		this.Ingerdient2.setTextureSize(128, 64);
		this.Ingerdient2.mirror = true;
		this.setRotation(this.Ingerdient2, -0.3717861F, -2.453788F, 0F);
		this.Ingerdient3 = new ModelRenderer(this, 88, 40);
		this.Ingerdient3.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Ingerdient3.setRotationPoint(0F, 9.5F, -1F);
		this.Ingerdient3.setTextureSize(128, 64);
		this.Ingerdient3.mirror = true;
		this.setRotation(this.Ingerdient3, -0.1858931F, -0.0371786F, 0F);
		this.Ingerdient4 = new ModelRenderer(this, 88, 42);
		this.Ingerdient4.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Ingerdient4.setRotationPoint(-2F, 9.5F, -3F);
		this.Ingerdient4.setTextureSize(128, 64);
		this.Ingerdient4.mirror = true;
		this.setRotation(this.Ingerdient4, -0.7435722F, -1.189716F, 0F);
		this.Ingerdient5 = new ModelRenderer(this, 88, 42);
		this.Ingerdient5.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Ingerdient5.setRotationPoint(2F, 9.5F, 3F);
		this.Ingerdient5.setTextureSize(128, 64);
		this.Ingerdient5.mirror = true;
		this.setRotation(this.Ingerdient5, -0.3717861F, -3.085825F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Cauldron1.render(f5);
		this.Cauldron2.render(f5);
		this.Cauldron3.render(f5);
		this.Cauldron4.render(f5);
		this.tripod1.render(f5);
		this.Cauldron6.render(f5);
		this.Cauldron7.render(f5);
		this.Cauldron8.render(f5);
		this.Cauldron9.render(f5);
		this.Ingerdient1.render(f5);
		this.Cauldron11.render(f5);
		this.Cauldron13.render(f5);
		this.Cauldron15.render(f5);
		this.Cauldron21.render(f5);
		this.Cauldron27.render(f5);
		this.Cauldron29.render(f5);
		this.Cauldron30.render(f5);
		this.Cauldron31.render(f5);
		this.Cauldron32.render(f5);
		this.Cauldron33.render(f5);
		this.Cauldron34.render(f5);
		this.Cauldron35.render(f5);
		this.Cauldron36.render(f5);
		this.Cauldron37.render(f5);
		this.Cauldron38.render(f5);
		this.Cauldron39.render(f5);
		this.Cauldron5.render(f5);
		this.tripod11.render(f5);
		this.tripod6.render(f5);
		this.tripod2.render(f5);
		this.tripod3.render(f5);
		this.tripod4.render(f5);
		this.tripod5.render(f5);
		this.tripod12.render(f5);
		this.tripod7.render(f5);
		this.tripod8.render(f5);
		this.tripod9.render(f5);
		this.tripod10.render(f5);
		this.Wood2.render(f5);
		this.Wood3.render(f5);
		this.Wood4.render(f5);
		this.Wood5.render(f5);
		this.Wood1.render(f5);
		this.Cauldron10.render(f5);
		this.Water.render(f5);
		this.Ingerdient2.render(f5);
		this.Ingerdient3.render(f5);
		this.Ingerdient4.render(f5);
		this.Ingerdient5.render(f5);
	}

	public void renderModel(float f5) {

		this.Cauldron1.render(f5);
		this.Cauldron2.render(f5);
		this.Cauldron3.render(f5);
		this.Cauldron4.render(f5);
		this.tripod1.render(f5);
		this.Cauldron6.render(f5);
		this.Cauldron7.render(f5);
		this.Cauldron8.render(f5);
		this.Cauldron9.render(f5);
		this.Ingerdient1.render(f5);
		this.Cauldron11.render(f5);
		this.Cauldron13.render(f5);
		this.Cauldron15.render(f5);
		this.Cauldron21.render(f5);
		this.Cauldron27.render(f5);
		this.Cauldron29.render(f5);
		this.Cauldron30.render(f5);
		this.Cauldron31.render(f5);
		this.Cauldron32.render(f5);
		this.Cauldron33.render(f5);
		this.Cauldron34.render(f5);
		this.Cauldron35.render(f5);
		this.Cauldron36.render(f5);
		this.Cauldron37.render(f5);
		this.Cauldron38.render(f5);
		this.Cauldron39.render(f5);
		this.Cauldron5.render(f5);
		this.tripod11.render(f5);
		this.tripod6.render(f5);
		this.tripod2.render(f5);
		this.tripod3.render(f5);
		this.tripod4.render(f5);
		this.tripod5.render(f5);
		this.tripod12.render(f5);
		this.tripod7.render(f5);
		this.tripod8.render(f5);
		this.tripod9.render(f5);
		this.tripod10.render(f5);
		this.Wood2.render(f5);
		this.Wood3.render(f5);
		this.Wood4.render(f5);
		this.Wood5.render(f5);
		this.Wood1.render(f5);
		this.Cauldron10.render(f5);
		this.Water.render(f5);
		this.Ingerdient2.render(f5);
		this.Ingerdient3.render(f5);
		this.Ingerdient4.render(f5);
		this.Ingerdient5.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {

		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {

		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
