package pt.up.fe.ldts.gd.viewer;

import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.player.Inventory;
import pt.up.fe.ldts.gd.model.town.Shop;

public class InventoryViewer extends Viewer<Inventory> {
    public InventoryViewer(Inventory inv) {
        super(inv);
    }

    protected void drawElements(GUI gui) {}
}
