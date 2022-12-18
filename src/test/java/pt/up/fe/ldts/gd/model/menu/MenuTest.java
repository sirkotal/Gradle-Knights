package pt.up.fe.ldts.gd.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.up.fe.ldts.gd.model.player.CombatItem;
import pt.up.fe.ldts.gd.model.player.Inventory;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.player.PotionItem;

import java.io.IOException;

public class MenuTest {
    @Test
    public void menuTest() throws IOException {
        Menu my_menu = new Menu();
        Assertions.assertFalse(my_menu.selectedExit());
        my_menu.nextEntry();
        Assertions.assertTrue(my_menu.selectedExit());
        my_menu.previousEntry();
        Assertions.assertFalse(my_menu.selectedExit());
    }
}
