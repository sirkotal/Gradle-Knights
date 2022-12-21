package pt.up.fe.ldts.gd.controller.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.menu.Menu;
import pt.up.fe.ldts.gd.state.town.TownState;

import java.io.IOException;

public class MenuControllerTest {
    private MenuController controller;
    private Menu menu;
    private Game game;

    @BeforeEach
    public void setup() throws IOException {
        menu = new Menu();
        controller = new MenuController(menu);
        game = Mockito.mock(Game.class);
    }

    @Test
    public void selectedStartExit() throws IOException {
        Assertions.assertFalse(menu.selectedExit());

        controller.step(game, GUI.ACTION.UP);

        Assertions.assertTrue(menu.selectedExit());

        controller.step(game, GUI.ACTION.DOWN);

        Assertions.assertFalse(menu.selectedExit());

        controller.step(game, GUI.ACTION.DOWN);

        Assertions.assertTrue(menu.selectedExit());
    }

    @Test
    public void verifyExitGame() throws IOException {
        Assertions.assertFalse(menu.selectedExit());

        controller.step(game, GUI.ACTION.SELECT);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.isNull());
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(TownState.class));

        controller.step(game, GUI.ACTION.DOWN);

        Assertions.assertTrue(menu.selectedExit());

        controller.step(game, GUI.ACTION.SELECT);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.isNull());
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(TownState.class));
    }

    @Test
    public void verifyStartGame() throws IOException {
        Assertions.assertFalse(menu.selectedExit());

        controller.step(game, GUI.ACTION.SELECT);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.isNull());
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(TownState.class));
    }
}
