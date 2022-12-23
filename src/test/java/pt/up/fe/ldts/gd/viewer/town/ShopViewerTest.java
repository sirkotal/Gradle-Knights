package pt.up.fe.ldts.gd.viewer.town;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.town.Shop;

import java.io.IOException;
import java.util.ArrayList;

public class ShopViewerTest {
    private GUI gui;
    private ShopViewer viewer;
    private Shop shop;

    @BeforeEach
    public void setup() throws IOException {
        shop = new Shop(new ArrayList<>(), new Player("Pinkman"));
        gui = Mockito.mock(GUI.class);
        viewer = new ShopViewer(shop);
    }

    @Test
    public void drawPlayerInfo() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPlayerInfo(shop.getPlayer().getHP(), shop.getPlayer().getGold());
    }

    @Test
    public void drawMessage() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawText(shop.getMessage(), 125/2 - shop.getMessage().length()/2, 46, "#FFFFFF");
    }

    @Test
    public void drawAscii() throws IOException {
        viewer.draw(gui);

        for(int i = 0; i < shop.getLines().size(); i++) {
            Mockito.verify(gui, Mockito.times(1)).drawText(shop.getLines().get(i), 30, 8+i,"#FFFFFF");
        }
    }

    @Test
    public void drawItemInfo() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawText("Item(value/price)", 50,38, "#FFFFFF");
    }

    @Test
    public void drawOptions() throws IOException {
        viewer.draw(gui);

        int opt_col = 25;
        for(String str: shop.getOptions()) {
            Mockito.verify(gui, Mockito.times(1)).drawText(str, opt_col, 35,"#FFFFFF");
            opt_col += str.length() + 5;
        }
    }

    @Test
    public void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
