package pt.up.fe.ldts.gd.state;
import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.controller.wild.FightController;
import pt.up.fe.ldts.gd.model.wild.Fight;
import pt.up.fe.ldts.gd.viewer.Viewer;
import pt.up.fe.ldts.gd.viewer.FightViewer;
public class FightState extends State<Fight> {
    public FightState(Fight fight) {
        super(fight);
    }

    @Override
    protected Viewer<Fight> getViewer() {
        return new FightViewer(getModel());
    }

    @Override
    protected Controller<Fight> getController() {
        return new FightController(getModel());
    }
}
