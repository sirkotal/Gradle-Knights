package pt.up.fe.ldts.gd.viewer;

import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.town.Town;

import java.util.List;

public class TownViewer extends Viewer<Town> {
    public TownViewer(Town town) {
        super(town);
    }

    @Override
    protected void drawElements(GUI gui) {
        List<String> lines = getModel().getLines();
        for(int i = 0; i < lines.size(); i++) {
            gui.drawText(lines.get(i), 23, 8+i);
        }
    }
}
