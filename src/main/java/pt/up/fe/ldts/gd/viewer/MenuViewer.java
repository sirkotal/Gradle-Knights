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
        if (!getModel().selectedExit()) {
            for (int i = 0; i < 6; i++) {
                gui.drawText(lines.get(i), 12, 8 + i, "#FFD700");
            }
            for (int i = 7; i < lines.size(); i++) {
                gui.drawText(lines.get(i), 12, 8 + i, "#FFFFFF");
            }
        } else {
            for (int i = 0; i < lines.size() - 7; i++) {
                gui.drawText(lines.get(i), 12, 8 + i, "#FFFFFF");
            }
            for (int i = lines.size() - 7; i < lines.size(); i++) {
                gui.drawText(lines.get(i), 12, 8 + i, "#FFD700");
            }
        }
    }
}

