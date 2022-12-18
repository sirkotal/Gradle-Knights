package pt.up.fe.ldts.gd.viewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.player.Inventory;
import pt.up.fe.ldts.gd.model.player.Player;

import java.io.IOException;

public class InventoryViewerTest {
    private GUI gui;
    private InventoryViewer viewer;
    private Inventory inventory;

    @BeforeEach
    public void setup() throws IOException {
        inventory = new Inventory(new Player("Hank"));
        gui = Mockito.mock(GUI.class);
        viewer = new InventoryViewer(inventory);
    }

    @Test
    public void drawPlayerInfo() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPlayerInfo(inventory.getPlayer().getHP(), inventory.getPlayer().getGold());
    }

    @Test
    public void drawAscii() throws IOException {
        viewer.draw(gui);

        for(int i = 0; i < inventory.getLines().size(); i++) {
            Mockito.verify(gui, Mockito.times(1)).drawText(inventory.getLines().get(i), 45, 5+i,"#FFFFFF");
        }
    }

    @Test
    public void drawOptions() throws IOException {
        viewer.draw(gui);

        int opt_col = 10;
        for(String str: inventory.getOptions()) {
            Mockito.verify(gui, Mockito.times(1)).drawText(str, opt_col, 37, "#FFFFFF");
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
