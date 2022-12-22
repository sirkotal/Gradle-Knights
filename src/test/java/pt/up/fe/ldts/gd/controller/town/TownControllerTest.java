package pt.up.fe.ldts.gd.controller.town;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.controller.menu.MenuController;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.menu.Menu;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.town.Town;
import pt.up.fe.ldts.gd.model.wild.Wild;
import pt.up.fe.ldts.gd.state.menu.MenuState;
import pt.up.fe.ldts.gd.state.town.ShopState;
import pt.up.fe.ldts.gd.state.town.TownState;
import pt.up.fe.ldts.gd.state.wild.WildState;

import java.io.IOException;

public class TownControllerTest {
    private TownController controller;
    private Menu menu;
    private Town town;
    private Wild wild;
    private Game game;
    private Player player;

    @BeforeEach
    public void setup() throws IOException {
        player = new Player("Master Chief");
        town = new Town(player);
        controller = new TownController(town);
        wild = new Wild(player);
        game = Mockito.mock(Game.class);
    }

    @Test
    public void townToShop() throws IOException {
        game.setState(new TownState(town));
        Assertions.assertTrue(game.getPreviousState() instanceof MenuState);

        controller.step(game, GUI.ACTION.OPT1);

        Assertions.assertTrue(game.getPreviousState() instanceof ShopState);
    }
}
