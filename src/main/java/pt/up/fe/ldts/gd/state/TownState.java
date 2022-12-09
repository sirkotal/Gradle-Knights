package pt.up.fe.ldts.gd.state;

import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.controller.TownController;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.town.Town;
import pt.up.fe.ldts.gd.viewer.Viewer;

public class TownState extends State<Town> {
    public TownState(Town town) {
        super(town);
    }

    protected Controller<Town> getController() {
        return new TownController(getTemplate());
    }

    protected Viewer<Town> getViewer() {
        // return new TownViewer(getTemplate());
        return new Viewer<Town>(new Town(new Player("heisenberg"))) {
            @Override
            protected void drawElements(GUI gui) {

            }
        };
    }
}