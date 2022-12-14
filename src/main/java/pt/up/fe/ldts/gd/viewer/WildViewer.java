package pt.up.fe.ldts.gd.viewer;

import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.wild.Wild;

import java.util.List;

public class WildViewer extends Viewer<Wild> {
    public WildViewer(Wild wild) {
        super(wild);
    }

    @Override
    protected void drawElements(GUI gui) {
        List<String> lines = getModel().getLines();
        for(int i = 0; i < lines.size(); i++) {
            gui.drawText(lines.get(i), 30, 8+i);
        }

        List<String> options = getModel().getOptions();
        int opt_col = 47;
        for(String str: options) {
            gui.drawText(str, opt_col, 40);
            opt_col += str.length() + 5;
        }
    }
}
