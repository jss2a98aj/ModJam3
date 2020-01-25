package vswe.stevesfactory.components;


import java.util.HashMap;
import java.util.Map;

import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.IFluidHandler;
import vswe.stevesfactory.blocks.IRedstoneNode;
import vswe.stevesfactory.blocks.ITriggerNode;
import vswe.stevesfactory.blocks.TileEntityBUD;
import vswe.stevesfactory.blocks.TileEntityCamouflage;
import vswe.stevesfactory.blocks.TileEntityInput;
import vswe.stevesfactory.blocks.TileEntityOutput;
import vswe.stevesfactory.blocks.TileEntitySignUpdater;

public class SlotInventoryHolder {
    private TileEntity inventory;
    private Map<Integer, SlotSideTarget> validSlots;
    private int sharedOption;
    private int id;

    public SlotInventoryHolder(int id, TileEntity inventory, int sharedOption) {
        this.id = id;
        this.inventory = inventory;
        this.sharedOption = sharedOption;
    }

    public int getId() {
        return id;
    }

    public IInventory getInventory() {
        return (IInventory)inventory;
    }

    public IFluidHandler getTank() {
        return (IFluidHandler)inventory;
    }

    public TileEntityOutput getEmitter() {
        return (TileEntityOutput)inventory;
    }

    public IRedstoneNode getNode() {
        return (IRedstoneNode)inventory;
    }

    public TileEntityInput getReceiver() {
        return (TileEntityInput)inventory;
    }

    public TileEntityBUD getBUD() {
        return (TileEntityBUD)inventory;
    }

    public TileEntityCamouflage getCamouflage() {
        return (TileEntityCamouflage)inventory;
    }

    public TileEntitySignUpdater getSign() {
        return (TileEntitySignUpdater)inventory;
    }

    public Map<Integer, SlotSideTarget> getValidSlots() {
        if (validSlots == null) {
            validSlots = new HashMap<Integer, SlotSideTarget>();
        }

        return validSlots;
    }

    public boolean isShared() {
        return sharedOption == 0;
    }

    public int getSharedOption() {
        return sharedOption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SlotInventoryHolder that = (SlotInventoryHolder) o;

        return inventory.xCoord == that.inventory.xCoord && inventory.yCoord == that.inventory.yCoord && inventory.zCoord == that.inventory.yCoord;
    }

    @Override
    public int hashCode() {
        return inventory.hashCode();
    }

    public TileEntity getTile() {
        return inventory;
    }

    public ITriggerNode getTrigger() {
        return (ITriggerNode)inventory;
    }
}
