package pt.up.fe.ldts.gd.state;

import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.controller.MenuController;
import pt.up.fe.ldts.gd.model.menu.Menu;
import pt.up.fe.ldts.gd.viewer.Viewer;
import pt.up.fe.ldts.gd.viewer.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu menu) {
        super(menu);
    }

    protected Controller<Menu> getController() {
        return new MenuController(getTemplate());
    }

    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getTemplate());
    }
}
