package pt.up.fe.ldts.gd.controller;

import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.wild.Wild;

import java.io.IOException;

public class PlayerController extends WildController {
    private Player player;
    public PlayerController(Wild wild) {
        super(wild);
        this.player = getModel().getPlayer();
    }

    @Override
    public void step(Game game, GUI.ACTION action) throws IOException {
        if (player.isTurn()) {
            attackEnemy(player);
            player.setTurn(false);
        }
    }

    private void attackEnemy(Player player) {
        /* to implement */
    }
}
