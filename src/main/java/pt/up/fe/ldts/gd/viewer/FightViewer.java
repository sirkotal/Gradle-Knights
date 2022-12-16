package pt.up.fe.ldts.gd.viewer;

import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.player.Fight;

import java.io.IOException;
import java.util.List;

public class FightViewer extends Viewer<Fight> {
    public FightViewer(Fight fight){super(fight);}

    protected void drawElements(GUI gui) throws IOException{
        gui.drawText("Working", 20,20);
        List<String> options = getModel().getOptions();
        int opt_col = 40;
        for(String str: options) {
            gui.drawText(str, opt_col, 35);
            opt_col += str.length() + 5;
        }

    }
}
