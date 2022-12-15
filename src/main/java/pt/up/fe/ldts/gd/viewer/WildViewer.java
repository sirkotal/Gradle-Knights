package pt.up.fe.ldts.gd.viewer;

import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.wild.Wild;

import java.io.IOException;
import java.util.List;

public class WildViewer extends Viewer<Wild> {
    public WildViewer(Wild wild) {
        super(wild);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        if(getModel().getPlayer().isAlive()) {
            gui.drawPlayerInfo(getModel().getPlayer().getHP(), getModel().getPlayer().getGold());

            List<String> lines = getModel().getLines();
            for(int i = 0; i < lines.size(); i++) {
                gui.drawText(lines.get(i), 30, 8+i);
            }

            List<String> options = getModel().getOptions();
            int opt_col = 47;
            for(String str: options) {
                gui.drawText(str, opt_col, 35);
                opt_col += str.length() + 5;
            }
        } else {
            gui.drawDeathScreen();
        }
    }
}
