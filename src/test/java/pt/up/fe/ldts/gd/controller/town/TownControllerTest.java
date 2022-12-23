package pt.up.fe.ldts.gd.controller.town;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.town.Shop;
import pt.up.fe.ldts.gd.model.town.Town;
import pt.up.fe.ldts.gd.state.menu.MenuState;
import pt.up.fe.ldts.gd.state.town.ShopState;
import pt.up.fe.ldts.gd.state.wild.WildState;

import java.io.IOException;

public class TownControllerTest {
    private TownController controller;
    private Game game;

    @BeforeEach
    public void setup() throws IOException {
        Town town = Mockito.mock(Town.class);
        controller = Mockito.spy(new TownController(town));
        game = Mockito.mock(Game.class);
    }

    @Test
    public void townToExistingShop() throws IOException {
        Mockito.when(game.getPreviousState()).thenReturn(Mockito.mock(ShopState.class));
        controller.step(game, GUI.ACTION.OPT1);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(ShopState.class));
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any());
    }

    @Test
    public void townToNewShop() throws IOException {
        Mockito.when(game.getPreviousState()).thenReturn(Mockito.mock(WildState.class));
        Mockito.when(controller.getModel()).thenReturn(Mockito.mock(Town.class));
        Mockito.when(controller.getModel().getShop()).thenReturn(Mockito.mock(Shop.class));
        controller.step(game, GUI.ACTION.OPT1);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(ShopState.class));
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any());
    }

    @Test
    public void townToWild() throws IOException {
        controller.step(game, GUI.ACTION.OPT2);
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(WildState.class));
        Mockito.verify(game, Mockito.times(0)).setState(game.getPreviousState());
    }

    @Test
    public void townToMenu() throws IOException {
        controller.step(game, GUI.ACTION.OPT0);
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(MenuState.class));
        Mockito.verify(game, Mockito.times(0)).setState(game.getPreviousState());
    }
}
