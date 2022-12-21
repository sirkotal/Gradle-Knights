package pt.up.fe.ldts.gd.state.wild;

import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.controller.wild.WildController;
import pt.up.fe.ldts.gd.model.wild.Wild;
import pt.up.fe.ldts.gd.state.State;
import pt.up.fe.ldts.gd.viewer.Viewer;
import pt.up.fe.ldts.gd.viewer.wild.WildViewer;

public class WildState extends State<Wild> {
    public WildState(Wild wild) {
        super(wild);
    }

    protected Controller<Wild> getController() {
        return new WildController(getModel());
    }

    protected Viewer<Wild> getViewer() {
        return new WildViewer(getModel());
    }
}
