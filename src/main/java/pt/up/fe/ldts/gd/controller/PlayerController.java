package pt.up.fe.ldts.gd.controller;

import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.wild.Wild;

import java.io.IOException;

public class PlayerController extends WildController {
    public PlayerController(Wild wild) {
        super(wild);
    }

    public void step(Game game, GUI.ACTION action) throws IOException {
        if (getModel().getPlayer().isTurn()) {
            attackEnemy(getModel().getPlayer());
            getModel().getPlayer().setTurn(false);
        }
    }

    private void attackEnemy(Player player) {
        /* to implement */
    }
}
