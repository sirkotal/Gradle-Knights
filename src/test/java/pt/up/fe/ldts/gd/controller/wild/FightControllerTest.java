package pt.up.fe.ldts.gd.controller.wild;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.wild.Enemy;
import pt.up.fe.ldts.gd.model.wild.Fight;
import pt.up.fe.ldts.gd.model.wild.Wild;
import pt.up.fe.ldts.gd.state.menu.MenuState;
import pt.up.fe.ldts.gd.state.wild.WildState;

import java.io.IOException;

public class FightControllerTest {
    private Fight fight;
    private FightController controller;
    private Game game;

    @BeforeEach
    public void setup() {
        game = Mockito.mock(Game.class);
        Player player = Mockito.mock(Player.class);
        Enemy enemy = Mockito.mock(Enemy.class);
        fight = Mockito.spy(new Fight(player, enemy));
        controller = new FightController(fight);

        Mockito.when(game.getPreviousState()).thenReturn(Mockito.mock(WildState.class));
        Mockito.when(game.getPreviousState().getModel()).thenReturn(Mockito.mock(Wild.class));

        // Fight is always ending with the victory of the player and loot of 10 gold
        Mockito.when(player.isAlive()).thenReturn(true);
        Mockito.when(enemy.isAlive()).thenReturn(false);
        Mockito.when(enemy.getGold()).thenReturn(10);
    }

    @Test
    public void goToMenu() throws IOException {
        controller.step(game, GUI.ACTION.OPT0);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(MenuState.class));
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any());
        Mockito.verify(fight, Mockito.times(0)).resultFight();
        Mockito.verify(((Wild) game.getPreviousState().getModel()), Mockito.times(0)).setMessage(Mockito.any());
    }

    @Test
    public void fleeTest() throws IOException {
        controller.step(game, GUI.ACTION.OPT1);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.isA(WildState.class));
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any());
        Mockito.verify(fight, Mockito.times(0)).resultFight();
        Mockito.verify(((Wild) game.getPreviousState().getModel()), Mockito.times(1)).setMessage(
                "You fled from the fight"
        );
        Mockito.verify(((Wild) game.getPreviousState().getModel()), Mockito.times(1)).setMessage(Mockito.any());
    }

    @Test
    public void fightTest() throws IOException {
        controller.step(game, GUI.ACTION.OPT2);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.isA(WildState.class));
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any());
        Mockito.verify(fight, Mockito.times(1)).resultFight();
        Mockito.verify(((Wild) game.getPreviousState().getModel()), Mockito.times(1)).setMessage(
                "You fought an enemy and you won! You earned 10 gold!"
        );
        Mockito.verify(((Wild) game.getPreviousState().getModel()), Mockito.times(1)).setMessage(Mockito.any());
    }
}
