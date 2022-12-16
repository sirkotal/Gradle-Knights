package pt.up.fe.ldts.gd.state;

import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.controller.town.TownController;
import pt.up.fe.ldts.gd.model.town.Shop;
import pt.up.fe.ldts.gd.model.town.Town;
import pt.up.fe.ldts.gd.viewer.TownViewer;
import pt.up.fe.ldts.gd.viewer.Viewer;

public class TownState extends State<Town> {
    public TownState(Town town) {
        super(town);
    }
    protected Controller<Town> getController() {
        return new TownController(getModel());
    }

    protected Viewer<Town> getViewer() {
        return new TownViewer(getModel());
    }
}