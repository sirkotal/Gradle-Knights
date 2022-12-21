package pt.up.fe.ldts.gd.viewer.wild;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.wild.Wild;

import java.io.IOException;

public class WildViewerTest {
    private GUI gui;
    private WildViewer viewer;
    private Wild wild;

    @BeforeEach
    public void setup() throws IOException {
        wild = new Wild(new Player("Tortuga"));
        gui = Mockito.mock(GUI.class);
        viewer = new WildViewer(wild);
    }

    @Test
    public void drawPlayerInfo() throws IOException {
        Assertions.assertTrue(wild.getPlayer().isAlive());

        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPlayerInfo(wild.getPlayer().getHP(), wild.getPlayer().getGold());
    }

    @Test
    public void drawMessage() throws IOException {
        Assertions.assertTrue(wild.getPlayer().isAlive());

        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawText(wild.getMessage(), 125/2 - wild.getMessage().length()/2, 46, "#FFFFFF");
    }

    @Test
    public void drawAscii() throws IOException {
        Assertions.assertTrue(wild.getPlayer().isAlive());

        viewer.draw(gui);

        for(int i = 0; i < wild.getLines().size(); i++) {
            Mockito.verify(gui, Mockito.times(1)).drawText(wild.getLines().get(i), 30, 8+i,"#FFFFFF");
        }
    }

    @Test
    public void drawOptions() throws IOException {
        Assertions.assertTrue(wild.getPlayer().isAlive());

        viewer.draw(gui);

        int opt_col = 40;
        for(String str: wild.getOptions()) {
            Mockito.verify(gui, Mockito.times(1)).drawText(str, opt_col, 35,"#FFFFFF");
            opt_col += str.length() + 5;
        }
    }

    @Test
    public void drawDeathScreen() throws IOException {
        wild.getPlayer().setHP(0);

        Assertions.assertFalse(wild.getPlayer().isAlive());

        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawDeathScreen();
    }

    @Test
    public void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
