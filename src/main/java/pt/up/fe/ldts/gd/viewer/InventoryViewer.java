package pt.up.fe.ldts.gd.viewer;

import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.player.Inventory;

import java.util.List;

public class InventoryViewer extends Viewer<Inventory> {
    public InventoryViewer(Inventory inv) {
        super(inv);
    }

    protected void drawElements(GUI gui) {
        gui.drawPlayerInfo(getModel().getPlayer().getHP(), getModel().getPlayer().getGold());

        List<String> lines = getModel().getLines();
        for(int i = 0; i < lines.size(); i++) {
            gui.drawText(lines.get(i), 45, 5+i);
        }

        List<String> options = getModel().getOptions();
        int opt_col = 10;
        for(String str: options) {
            gui.drawText(str, opt_col, 37);
            opt_col += str.length() + 5;
        }
    }
}
