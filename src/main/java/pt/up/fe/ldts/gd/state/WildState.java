package pt.up.fe.ldts.gd.state;

import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.controller.wild.WildFightController;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.wild.Wild;
import pt.up.fe.ldts.gd.viewer.Viewer;
import pt.up.fe.ldts.gd.viewer.WildViewer;

public class WildState extends State<Wild> {
    public WildState(Wild wild) {
        super(wild);
    }

    protected Controller<Wild> getController() {
        return new WildFightController(getModel());
    }

    protected Viewer<Wild> getViewer() {
        return new WildViewer(getModel());
    }
}
