package pt.up.fe.ldts.gd.viewer.town;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.town.Town;

import java.io.IOException;

public class TownViewerTest {
    private GUI gui;
    private TownViewer viewer;
    private Town town;

    @BeforeEach
    public void setup() throws IOException {
        town = new Town(new Player("Tuco"));
        gui = Mockito.mock(GUI.class);
        viewer = new TownViewer(town);
    }

    @Test
    public void drawPlayerInfo() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPlayerInfo(town.getPlayer().getHP(), town.getPlayer().getGold());
    }

    @Test
    public void drawAscii() throws IOException {
        viewer.draw(gui);

        for(int i = 0; i < town.getLines().size(); i++) {
            Mockito.verify(gui, Mockito.times(1)).drawText(town.getLines().get(i), 23, 8+i, "#FFFFFF");
        }
    }

    @Test
    public void drawOptions() throws IOException {
        viewer.draw(gui);

        int opt_col = 45;
        for(String str: town.getOptions()) {
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
