package pt.up.fe.ldts.gd.viewer.wild;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.wild.Enemy;
import pt.up.fe.ldts.gd.model.wild.Fight;

import java.io.IOException;

public class FightViewerTest {
    private GUI gui;
    private FightViewer viewer;
    private Fight fight;

    @BeforeEach
    public void setup() throws IOException {
        Enemy enemy = new Enemy(10, 10, 10, 10);

        fight = new Fight(new Player("Tortuga"), enemy);
        gui = Mockito.mock(GUI.class);
        viewer = new FightViewer(fight);
    }

    @Test
    public void drawEnemy() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawEnemy();
    }

    @Test
    public void drawPlayerInfo() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPlayerInfo(fight.getPlayer().getHP(), fight.getPlayer().getGold());
    }

    @Test
    public void drawOptions() throws IOException {
        viewer.draw(gui);

        int opt_col = 40;
        for(String str: fight.getOptions()) {
            Mockito.verify(gui, Mockito.times(1)).drawText(str, opt_col, 35, "#FFFFFF");
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
