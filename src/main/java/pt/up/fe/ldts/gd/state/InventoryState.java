package pt.up.fe.ldts.gd.state;

import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.controller.player.InventoryController;
import pt.up.fe.ldts.gd.model.player.Inventory;
import pt.up.fe.ldts.gd.viewer.InventoryViewer;
import pt.up.fe.ldts.gd.viewer.Viewer;

public class InventoryState extends State<Inventory> {
    public InventoryState(Inventory inv) {
        super(inv);
    }

    @Override
    protected Viewer<Inventory> getViewer() {
        return new InventoryViewer(getModel());
    }

    @Override
    protected Controller<Inventory> getController() {
        return new InventoryController(getModel());
    }
}
