package pt.up.fe.ldts.gd.state;

import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.controller.wild.WildFightController;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.wild.Wild;
import pt.up.fe.ldts.gd.viewer.Viewer;

public class WildState extends State<Wild> {
    public WildState(Wild wild) {
        super(wild);
    }

    protected Controller<Wild> getController() {
        return new WildFightController(getModel());
    }

    protected Viewer<Wild> getViewer() {
        // return new WildViewer(getTemplate());
        return new Viewer<Wild>(new Wild(new Player("heisenberg"))) {
            @Override
            protected void drawElements(GUI gui) {

            }
        };
    }
}
