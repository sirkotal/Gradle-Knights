package pt.up.fe.ldts.gd.state;

import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.controller.town.ShopController;
import pt.up.fe.ldts.gd.model.town.Shop;
import pt.up.fe.ldts.gd.viewer.ShopViewer;
import pt.up.fe.ldts.gd.viewer.Viewer;

public class ShopState extends State<Shop> {

    public ShopState(Shop shop) {
        super(shop);
    }

    @Override
    protected Viewer<Shop> getViewer() {
        return new ShopViewer(getModel());
    }

    @Override
    protected Controller<Shop> getController() {
        return new ShopController(getModel());
    }
}
