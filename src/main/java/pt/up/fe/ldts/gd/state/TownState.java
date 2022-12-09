package pt.up.fe.ldts.gd.state;

import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.viewer.Viewer;
import pt.up.fe.ldts.gd.model.town.Town;
import pt.up.fe.ldts.gd.controller.TownController;
import pt.up.fe.ldts.gd.viewer.TownViewer;

public class TownState extends State<Town> {
    public TownState(Town town) {
        super(town);
    }

    protected Controller<Town> getController() {
        return new TownController(getTemplate());
    }

    protected Viewer<Town> getViewer() {
        return new TownViewer(getTemplate());
    }
}