package pt.up.fe.ldts.gd.controller.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.player.Inventory;
import pt.up.fe.ldts.gd.model.player.Item;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.state.menu.MenuState;

import java.io.IOException;

public class InventoryControllerTest {
    private InventoryController controller;
    private Inventory inventory;
    private Player player;
    private Game game;

    @BeforeEach
    public void setup() throws IOException {
        player = Mockito.mock(Player.class);
        game = Mockito.mock(Game.class);
        inventory = new Inventory(player);
        controller = new InventoryController(inventory);
    }

    @Test
    public void goToMenu() throws IOException {
        controller.step(game, GUI.ACTION.OPT0);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(MenuState.class));
        Mockito.verify(game, Mockito.times(0)).setState(game.getPreviousState());
        Mockito.verify(player, Mockito.times(0)).use(Mockito.any());
    }

    @Test
    public void goToWild() throws IOException {
        controller.step(game, GUI.ACTION.OPT9);

        Mockito.verify(game, Mockito.times(1)).setState(game.getPreviousState());
        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any(MenuState.class));
        Mockito.verify(player, Mockito.times(0)).use(Mockito.any());
    }

    @Test
    public void optionOneSuccessful() throws IOException {
        inventory.addItem(Mockito.mock(Item.class));

        controller.step(game, GUI.ACTION.OPT1);

        Assertions.assertTrue(inventory.size() >= 1);

        Mockito.verify(game, Mockito.times(0)).setState(game.getPreviousState());
        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any(MenuState.class));
        Mockito.verify(player, Mockito.times(1)).use(inventory.getItem(0));

    }

    @Test
    public void optionOneFailed() throws IOException {
        while(inventory.size() < 1) {
            controller.step(game, GUI.ACTION.OPT2);

            Mockito.verify(game, Mockito.times(0)).setState(game.getPreviousState());
            Mockito.verify(game, Mockito.times(0)).setState(Mockito.any(MenuState.class));
            Mockito.verify(player, Mockito.times(0)).use(Mockito.any(Item.class));

            inventory.addItem(Mockito.mock(Item.class));
        }
    }

    @Test
    public void optionTwoSuccessful() throws IOException {
        for(int i = 0; i < 2; i++)
            inventory.addItem(Mockito.mock(Item.class));

        controller.step(game, GUI.ACTION.OPT2);

        Assertions.assertTrue(inventory.size() >= 2);

        Mockito.verify(game, Mockito.times(0)).setState(game.getPreviousState());
        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any(MenuState.class));
        Mockito.verify(player, Mockito.times(1)).use(inventory.getItem(1));
    }

    @Test
    public void optionTwoFailed() throws IOException {
        while(inventory.size() < 2) {
            controller.step(game, GUI.ACTION.OPT2);

            Mockito.verify(game, Mockito.times(0)).setState(game.getPreviousState());
            Mockito.verify(game, Mockito.times(0)).setState(Mockito.any(MenuState.class));
            Mockito.verify(player, Mockito.times(0)).use(Mockito.any(Item.class));

            inventory.addItem(Mockito.mock(Item.class));
        }
    }

    @Test
    public void optionThreeSuccessful() throws IOException {
        for(int i = 0; i < 3; i++)
            inventory.addItem(Mockito.mock(Item.class));

        controller.step(game, GUI.ACTION.OPT3);

        Assertions.assertTrue(inventory.size() >= 3);

        Mockito.verify(game, Mockito.times(0)).setState(game.getPreviousState());
        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any(MenuState.class));
        Mockito.verify(player, Mockito.times(1)).use(inventory.getItem(2));
    }

    @Test
    public void optionThreeFailed() throws IOException {
        while(inventory.size() < 3) {
            controller.step(game, GUI.ACTION.OPT3);

            Mockito.verify(game, Mockito.times(0)).setState(game.getPreviousState());
            Mockito.verify(game, Mockito.times(0)).setState(Mockito.any(MenuState.class));
            Mockito.verify(player, Mockito.times(0)).use(Mockito.any(Item.class));

            inventory.addItem(Mockito.mock(Item.class));
        }
    }

    @Test
    public void optionFourSuccessful() throws IOException {
        for(int i = 0; i < 4; i++)
            inventory.addItem(Mockito.mock(Item.class));

        controller.step(game, GUI.ACTION.OPT4);

        Assertions.assertTrue(inventory.size() >= 4);

        Mockito.verify(game, Mockito.times(0)).setState(game.getPreviousState());
        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any(MenuState.class));
        Mockito.verify(player, Mockito.times(1)).use(inventory.getItem(3));
    }

    @Test
    public void optionFourFailed() throws IOException {
        while(inventory.size() < 4) {
            controller.step(game, GUI.ACTION.OPT4);

            Mockito.verify(game, Mockito.times(0)).setState(game.getPreviousState());
            Mockito.verify(game, Mockito.times(0)).setState(Mockito.any(MenuState.class));
            Mockito.verify(player, Mockito.times(0)).use(Mockito.any(Item.class));

            inventory.addItem(Mockito.mock(Item.class));
        }
    }

    @Test
    public void optionFiveSuccessful() throws IOException {
        for(int i = 0; i < 5; i++)
            inventory.addItem(Mockito.mock(Item.class));

        controller.step(game, GUI.ACTION.OPT5);

        Assertions.assertTrue(inventory.size() >= 5);

        Mockito.verify(game, Mockito.times(0)).setState(game.getPreviousState());
        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any(MenuState.class));
        Mockito.verify(player, Mockito.times(1)).use(inventory.getItem(4));
    }

    @Test
    public void optionFiveFailed() throws IOException {
        while(inventory.size() < 5) {
            controller.step(game, GUI.ACTION.OPT5);

            Mockito.verify(game, Mockito.times(0)).setState(game.getPreviousState());
            Mockito.verify(game, Mockito.times(0)).setState(Mockito.any(MenuState.class));
            Mockito.verify(player, Mockito.times(0)).use(Mockito.any(Item.class));

            inventory.addItem(Mockito.mock(Item.class));
        }
    }
}
