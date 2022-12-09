package pt.up.fe.ldts.gd.state;

import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.viewer.Viewer;
import pt.up.fe.ldts.gd.model.wild.Wild;
import pt.up.fe.ldts.gd.controller.WildController;
import pt.up.fe.ldts.gd.viewer.WildViewer;

public class WildState extends State<Wild> {
    public WildState(Wild wild) {
        super(wild);
    }

    protected Controller<Wild> getController() {
        return new WildController(getTemplate());
    }

    protected Viewer<Wild> getViewer() {
        return new WildViewer(getTemplate());
    }
}
