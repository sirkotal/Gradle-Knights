package pt.up.fe.ldts.gd.viewer;

import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.town.Shop;

import java.util.List;

public class ShopViewer extends Viewer<Shop> {
    public ShopViewer(Shop shop) {
        super(shop);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawPlayerInfo(getModel().getPlayer().getHP(), getModel().getPlayer().getGold());
        gui.drawText("Item(value/price)", 50,38);

        List<String> lines = getModel().getLines();
        for(int i = 0; i < lines.size(); i++) {
            gui.drawText(lines.get(i), 30, 8+i);
        }

        List<String> options = getModel().getOptions();
        int opt_col = 25;
        for(String str: options) {
            gui.drawText(str, opt_col, 35);
            opt_col += str.length() + 5;
        }
    }
}
