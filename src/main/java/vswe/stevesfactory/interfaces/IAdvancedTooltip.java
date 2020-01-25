package vswe.stevesfactory.interfaces;


import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public interface IAdvancedTooltip {

    @SideOnly(Side.CLIENT)
    int getMinWidth(GuiBase gui);
    @SideOnly(Side.CLIENT)
    int getExtraHeight(GuiBase gui);
    @SideOnly(Side.CLIENT)
    void drawContent(GuiBase gui, int x, int y, int mX, int mY);
    @SideOnly(Side.CLIENT)
    List<String> getPrefix(GuiBase gui);
    @SideOnly(Side.CLIENT)
    List<String> getSuffix(GuiBase gui);
}
