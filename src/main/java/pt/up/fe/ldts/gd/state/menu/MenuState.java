package pt.up.fe.ldts.gd.state.menu;

import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.controller.menu.MenuController;
import pt.up.fe.ldts.gd.model.menu.Menu;
import pt.up.fe.ldts.gd.state.State;
import pt.up.fe.ldts.gd.viewer.Viewer;
import pt.up.fe.ldts.gd.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu menu) {
        super(menu);
    }

    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }

    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }
}
