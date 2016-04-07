package net.drpmedieval.common.blocks.tileentitys;

import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDungeonChest extends TileEntity {

	public InventoryBasic inventory;

	int InvSize = 27;

	public TileEntityDungeonChest() {
		inventory = new InventoryBasic("DungeonChestInventory", false, InvSize);
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {

		super.writeToNBT(compound);

		NBTTagList list = new NBTTagList();

		for(int i = 0; i < InvSize; i++){
			if(inventory.getStackInSlot(i) != null){
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				inventory.getStackInSlot(i).writeToNBT(tag);
				list.appendTag(tag);
			}
		}

		compound.setTag("ItemStacks", list);

	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {

		super.readFromNBT(compound);

		NBTTagList list = compound.getTagList("ItemStacks", 10);
		this.inventory = new InventoryBasic("DungeonChestInventory", false, InvSize);
		for(int i = 0; i < list.tagCount(); i++){
			NBTTagCompound tag = list.getCompoundTagAt(i);
			byte b = tag.getByte("Slot");

			if(b >= 0 && b < inventory.getSizeInventory()){
				inventory.setInventorySlotContents(b, ItemStack.loadItemStackFromNBT(tag));
			}
		}
	}
}
