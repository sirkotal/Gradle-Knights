package pt.up.fe.ldts.gd.viewer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.menu.Menu;

import java.io.IOException;

public class MenuViewerTest {
    private GUI gui;
    private MenuViewer viewer;
    private Menu menu;

    @BeforeEach
    public void setup() throws IOException {
        menu = new Menu();
        gui = Mockito.mock(GUI.class);
        viewer = new MenuViewer(menu);
    }

    @Test
    public void drawStart() throws IOException {
        Assertions.assertFalse(menu.selectedExit());

        viewer.draw(gui);

        for(int i = 0; i < 6; i++) {
            Mockito.verify(gui, Mockito.times(1)).drawText(menu.getLines().get(i), 12, 8+i, "#FFD700");
        }
        for (int i = 7; i < menu.getLines().size(); i++) {
            Mockito.verify(gui, Mockito.times(1)).drawText(menu.getLines().get(i), 12, 8 + i, "#FFFFFF");
        }
    }

    @Test
    public void drawExit() throws IOException {
        menu.nextEntry();

        viewer.draw(gui);

        for (int i = 0; i < menu.getLines().size() - 7; i++) {
            Mockito.verify(gui, Mockito.times(1)).drawText(menu.getLines().get(i), 12, 8 + i, "#FFFFFF");
        }
        for (int i = menu.getLines().size() - 7; i < menu.getLines().size(); i++) {
            Mockito.verify(gui, Mockito.times(1)).drawText(menu.getLines().get(i), 12, 8 + i, "#FFD700");
        }
    }

    @Test
    public void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
