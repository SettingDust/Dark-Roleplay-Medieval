package net.dark_roleplay.medieval.common.objects.blocks.tile_entities;

import net.dark_roleplay.core.testing.drawing.ImageHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TE_Banner extends TileEntity{

	private ImageHelper image;

	public TE_Banner() {}

	public TE_Banner(ImageHelper image) {
		this.image = image;
	}

	public void setImage(ImageHelper image) {
		this.image = image;
	}

	public ImageHelper getImage() {
		return this.image;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(compound.hasKey("image")){
        	this.image = ImageHelper.read((NBTTagCompound) compound.getTag("image"));
        }
    }

	@Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
    	compound = super.writeToNBT(compound);
    	if(this.image != null)
    		compound.setTag("image", this.image.write());
    	return compound;
    }

	@Override
	public NBTTagCompound getUpdateTag() {
		return super.getUpdateTag();
	}

	@Override
	public void handleUpdateTag(NBTTagCompound compound) {
		super.handleUpdateTag(compound);
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
	    if(this.image == null) return null;
	    return new SPacketUpdateTileEntity(this.getPos(), 1, this.image.write());
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
	    if(pkt == null) return;
	    this.image = ImageHelper.read(pkt.getNbtCompound());
	}
}
