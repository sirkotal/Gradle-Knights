package pt.up.fe.ldts.gd.controller.wild;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.player.Inventory;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.wild.Wild;
import pt.up.fe.ldts.gd.state.menu.MenuState;
import pt.up.fe.ldts.gd.state.player.InventoryState;
import pt.up.fe.ldts.gd.state.town.TownState;
import pt.up.fe.ldts.gd.state.wild.FightState;

import java.io.IOException;
import java.util.List;

public class WildControllerTest {
    private WildController controller;
    private Game game;

    @BeforeEach
    public void setup() throws IOException {
        game = Mockito.mock(Game.class);
        Wild wild = Mockito.mock(Wild.class);
        controller = Mockito.spy(new WildController(wild));
    }

    @Test
    public void goToMenu() throws IOException {
        controller.step(game, GUI.ACTION.OPT0);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(MenuState.class));
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any());
        Mockito.verify(controller, Mockito.times(0)).getModel();
    }

    @Test
    public void goToInventoryAlive() throws IOException {
        Mockito.when(controller.getModel().getPlayer()).thenReturn(Mockito.mock(Player.class));
        Mockito.when(controller.getModel().getPlayer().getInventory()).thenReturn(Mockito.mock(Inventory.class));
        Mockito.when(controller.getModel().getPlayer().isAlive()).thenReturn(true);

        controller.step(game, GUI.ACTION.OPT2);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(InventoryState.class));
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any());
        Mockito.verify(controller.getModel().getPlayer(), Mockito.times(1)).isAlive();
        Mockito.verify(controller.getModel().getPlayer(), Mockito.times(1)).getInventory();
    }

    @Test
    public void goToInventoryDead() throws IOException {
        Mockito.when(controller.getModel().getPlayer()).thenReturn(Mockito.mock(Player.class));
        Mockito.when(controller.getModel().getPlayer().getInventory()).thenReturn(Mockito.mock(Inventory.class));
        Mockito.when(controller.getModel().getPlayer().isAlive()).thenReturn(false);

        controller.step(game, GUI.ACTION.OPT2);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any());
        Mockito.verify(controller.getModel().getPlayer(), Mockito.times(1)).isAlive();
        Mockito.verify(controller.getModel().getPlayer(), Mockito.times(0)).getInventory();
    }

    @Test
    public void noEnemiesLeft() throws IOException {
        Mockito.when(controller.getModel().getEnemies()).thenReturn(Mockito.mock(List.class));
        Mockito.when(controller.getModel().getEnemies().size()).thenReturn(0);
        Mockito.when(controller.getModel().getPlayer()).thenReturn(Mockito.mock(Player.class));

        controller.step(game, GUI.ACTION.OPT1);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(TownState.class));
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any());

        Mockito.verify(controller.getModel().getPlayer(), Mockito.times(0)).isAlive();
        Mockito.verify(controller.getModel().getEnemies(), Mockito.times(0)).remove(Mockito.anyInt());
    }

    @Test
    public void enemiesExists() throws IOException {
        Mockito.when(controller.getModel().getEnemies()).thenReturn(Mockito.mock(List.class));
        Mockito.when(controller.getModel().getEnemies().size()).thenReturn(2);
        Mockito.when(controller.getModel().getPlayer()).thenReturn(Mockito.mock(Player.class));
        Mockito.when(controller.getModel().getPlayer().isAlive()).thenReturn(true);

        controller.step(game, GUI.ACTION.OPT1);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(FightState.class));
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any());

        Mockito.verify(controller.getModel().getPlayer(), Mockito.times(2)).isAlive();
        Mockito.verify(controller.getModel().getEnemies(), Mockito.times(1)).remove(Mockito.anyInt());
    }

    @Test
    public void oneEnemy() throws IOException {
        Mockito.when(controller.getModel().getEnemies()).thenReturn(Mockito.mock(List.class));
        Mockito.when(controller.getModel().getEnemies().size()).thenReturn(1);
        Mockito.when(controller.getModel().getPlayer()).thenReturn(Mockito.mock(Player.class));
        Mockito.when(controller.getModel().getPlayer().isAlive()).thenReturn(true);

        controller.step(game, GUI.ACTION.OPT1);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(FightState.class));
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any());

        Mockito.verify(controller.getModel().getPlayer(), Mockito.times(2)).isAlive();
        Mockito.verify(controller.getModel().getEnemies(), Mockito.times(1)).remove(0);
    }
}
