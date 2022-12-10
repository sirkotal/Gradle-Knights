package pt.up.fe.ldts.gd.viewer;

import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.menu.Menu;

import java.util.List;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        List<String> lines = getModel().getLines();
        for(int i = 0; i < lines.size(); i++) {
            gui.drawText(lines.get(i), 12, 8+i);
        }
    }
}
