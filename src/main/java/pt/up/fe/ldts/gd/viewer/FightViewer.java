package pt.up.fe.ldts.gd.viewer;

import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.wild.Fight;

import java.io.IOException;
import java.util.List;

public class FightViewer extends Viewer<Fight> {
    public FightViewer(Fight fight){super(fight);}

    protected void drawElements(GUI gui) throws IOException{
        gui.drawEnemy();
        gui.drawPlayerInfo(getModel().getPlayer().getHP(), getModel().getPlayer().getGold());
        List<String> options = getModel().getOptions();
        int opt_col = 40;
        for(String str: options) {
            gui.drawText(str, opt_col, 35, "#FFFFFF");
            opt_col += str.length() + 5;
        }
    }
}
