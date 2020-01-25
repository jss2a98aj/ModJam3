package vswe.stevesfactory.interfaces;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import vswe.stevesfactory.blocks.TileEntityRelay;
import vswe.stevesfactory.blocks.UserPermission;
import vswe.stevesfactory.network.PacketHandler;


public class ContainerRelay extends ContainerBase {

    private TileEntityRelay relay;

    public ContainerRelay(TileEntityRelay relay, InventoryPlayer player) {
        super(relay, player);
        this.relay = relay;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
        return entityplayer.getDistanceSq(relay.xCoord, relay.yCoord, relay.zCoord) <= 64;
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        if (oldPermissions != null) {
            relay.updateData(this);
        }
    }

    @Override
    public void addCraftingToCrafters(ICrafting player) {
        super.addCraftingToCrafters(player);
        PacketHandler.sendAllData(this, player, relay);
        oldPermissions = new ArrayList<UserPermission>();
        for (UserPermission permission : relay.getPermissions()) {
            oldPermissions.add(permission.copy());
        }
        oldCreativeMode = relay.isCreativeMode();
        oldOpList = relay.doesListRequireOp();
    }

    public List<UserPermission> oldPermissions;
    public boolean oldCreativeMode;
    public boolean oldOpList;

}
