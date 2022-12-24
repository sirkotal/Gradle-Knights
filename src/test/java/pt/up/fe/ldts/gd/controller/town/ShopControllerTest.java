package pt.up.fe.ldts.gd.controller.town;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.player.Item;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.town.Shop;
import pt.up.fe.ldts.gd.state.menu.MenuState;
import pt.up.fe.ldts.gd.state.town.TownState;

import java.io.IOException;
import java.util.ArrayList;

public class ShopControllerTest {
    private ShopController controller;
    private Game game;

    @BeforeEach
    public void setup() throws IOException {
        Shop shop = Mockito.spy(new Shop(new ArrayList<>(), Mockito.mock(Player.class)));
        controller = Mockito.spy(new ShopController(shop));
        game = Mockito.mock(Game.class);

        Mockito.when(game.getPreviousState()).thenReturn(Mockito.mock(TownState.class));
    }

    @Test
    public void goToMenu() throws IOException {
        controller.step(game, GUI.ACTION.OPT0);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(MenuState.class));
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any());
        Mockito.verify(game, Mockito.times(0)).getPreviousState();
        Mockito.verify(controller, Mockito.times(0)).getModel();
    }

    @Test
    public void goToTown() throws IOException {
        controller.step(game, GUI.ACTION.OPT9);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(TownState.class));
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any());
        Mockito.verify(game, Mockito.times(1)).getPreviousState();
        Mockito.verify(controller, Mockito.times(0)).getModel();
    }

    @Test
    public void canBuyItemOne() throws IOException {
        Mockito.when(controller.getModel().getPlayer().getGold()).thenReturn(Integer.MAX_VALUE);

        controller.getModel().getItems().add(Mockito.mock(Item.class));
        Mockito.when(controller.getModel().getItems().get(0).getName()).thenReturn("ITEM");
        Mockito.when(controller.getModel().getItems().get(0).getPrice()).thenReturn(1);

        controller.step(game, GUI.ACTION.OPT1);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any());
        Mockito.verify(game, Mockito.times(0)).getPreviousState();
        Mockito.verify(controller.getModel(), Mockito.times(1)).buyItem(Mockito.any(Item.class));
        Mockito.verify(controller.getModel(), Mockito.times(1)).setMessage("You bought ITEM successfully!");
    }

    @Test
    public void cannotBuyItemOne() throws IOException {
        Mockito.when(controller.getModel().getPlayer().getGold()).thenReturn(0);

        controller.getModel().getItems().add(Mockito.mock(Item.class));
        Mockito.when(controller.getModel().getItems().get(0).getName()).thenReturn("ITEM");
        Mockito.when(controller.getModel().getItems().get(0).getPrice()).thenReturn(1);

        controller.step(game, GUI.ACTION.OPT1);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any());
        Mockito.verify(game, Mockito.times(0)).getPreviousState();
        Mockito.verify(controller.getModel(), Mockito.times(1)).buyItem(Mockito.any(Item.class));
        Mockito.verify(controller.getModel(), Mockito.times(1)).setMessage("You don't have enough gold!");
    }

    @Test
    public void doNotHaveItemOne() throws IOException {
        controller.step(game, GUI.ACTION.OPT1);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any());
        Mockito.verify(game, Mockito.times(0)).getPreviousState();
        Mockito.verify(controller.getModel(), Mockito.times(0)).buyItem(Mockito.any(Item.class));
        Mockito.verify(controller.getModel(), Mockito.times(0)).setMessage(Mockito.anyString());
    }

    @Test
    public void canBuyItemTwo() throws IOException {
        Mockito.when(controller.getModel().getPlayer().getGold()).thenReturn(Integer.MAX_VALUE);

        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));

        Mockito.when(controller.getModel().getItems().get(0).getName()).thenReturn("ITEM1");
        Mockito.when(controller.getModel().getItems().get(0).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(1).getName()).thenReturn("ITEM2");
        Mockito.when(controller.getModel().getItems().get(1).getPrice()).thenReturn(1);

        controller.step(game, GUI.ACTION.OPT2);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any());
        Mockito.verify(game, Mockito.times(0)).getPreviousState();
        Mockito.verify(controller.getModel(), Mockito.times(1)).buyItem(Mockito.any(Item.class));
        Mockito.verify(controller.getModel(), Mockito.times(1)).setMessage("You bought ITEM2 successfully!");
    }

    @Test
    public void cannotBuyItemTwo() throws IOException {
        Mockito.when(controller.getModel().getPlayer().getGold()).thenReturn(0);

        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));

        Mockito.when(controller.getModel().getItems().get(0).getName()).thenReturn("ITEM1");
        Mockito.when(controller.getModel().getItems().get(0).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(1).getName()).thenReturn("ITEM2");
        Mockito.when(controller.getModel().getItems().get(1).getPrice()).thenReturn(1);

        controller.step(game, GUI.ACTION.OPT2);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any());
        Mockito.verify(game, Mockito.times(0)).getPreviousState();
        Mockito.verify(controller.getModel(), Mockito.times(1)).buyItem(Mockito.any(Item.class));
        Mockito.verify(controller.getModel(), Mockito.times(1)).setMessage("You don't have enough gold!");
    }

    @Test
    public void doNotHaveItemTwo() throws IOException {
        controller.step(game, GUI.ACTION.OPT2);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any());
        Mockito.verify(game, Mockito.times(0)).getPreviousState();
        Mockito.verify(controller.getModel(), Mockito.times(0)).buyItem(Mockito.any(Item.class));
        Mockito.verify(controller.getModel(), Mockito.times(0)).setMessage(Mockito.anyString());
    }

    @Test
    public void canBuyItemThree() throws IOException {
        Mockito.when(controller.getModel().getPlayer().getGold()).thenReturn(Integer.MAX_VALUE);

        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));

        Mockito.when(controller.getModel().getItems().get(0).getName()).thenReturn("ITEM1");
        Mockito.when(controller.getModel().getItems().get(0).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(1).getName()).thenReturn("ITEM2");
        Mockito.when(controller.getModel().getItems().get(1).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(2).getName()).thenReturn("ITEM3");
        Mockito.when(controller.getModel().getItems().get(2).getPrice()).thenReturn(1);

        controller.step(game, GUI.ACTION.OPT3);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any());
        Mockito.verify(game, Mockito.times(0)).getPreviousState();
        Mockito.verify(controller.getModel(), Mockito.times(1)).buyItem(Mockito.any(Item.class));
        Mockito.verify(controller.getModel(), Mockito.times(1)).setMessage("You bought ITEM3 successfully!");
    }

    @Test
    public void cannotBuyItemThree() throws IOException {
        Mockito.when(controller.getModel().getPlayer().getGold()).thenReturn(0);

        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));

        Mockito.when(controller.getModel().getItems().get(0).getName()).thenReturn("ITEM1");
        Mockito.when(controller.getModel().getItems().get(0).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(1).getName()).thenReturn("ITEM2");
        Mockito.when(controller.getModel().getItems().get(1).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(2).getName()).thenReturn("ITEM3");
        Mockito.when(controller.getModel().getItems().get(2).getPrice()).thenReturn(1);

        controller.step(game, GUI.ACTION.OPT3);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any());
        Mockito.verify(game, Mockito.times(0)).getPreviousState();
        Mockito.verify(controller.getModel(), Mockito.times(1)).buyItem(Mockito.any(Item.class));
        Mockito.verify(controller.getModel(), Mockito.times(1)).setMessage("You don't have enough gold!");
    }

    @Test
    public void doNotHaveItemThree() throws IOException {
        controller.step(game, GUI.ACTION.OPT3);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any());
        Mockito.verify(game, Mockito.times(0)).getPreviousState();
        Mockito.verify(controller.getModel(), Mockito.times(0)).buyItem(Mockito.any(Item.class));
        Mockito.verify(controller.getModel(), Mockito.times(0)).setMessage(Mockito.anyString());
    }

    @Test
    public void canBuyItemFour() throws IOException {
        Mockito.when(controller.getModel().getPlayer().getGold()).thenReturn(Integer.MAX_VALUE);

        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));

        Mockito.when(controller.getModel().getItems().get(0).getName()).thenReturn("ITEM1");
        Mockito.when(controller.getModel().getItems().get(0).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(1).getName()).thenReturn("ITEM2");
        Mockito.when(controller.getModel().getItems().get(1).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(2).getName()).thenReturn("ITEM3");
        Mockito.when(controller.getModel().getItems().get(2).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(3).getName()).thenReturn("ITEM4");
        Mockito.when(controller.getModel().getItems().get(3).getPrice()).thenReturn(1);

        controller.step(game, GUI.ACTION.OPT4);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any());
        Mockito.verify(game, Mockito.times(0)).getPreviousState();
        Mockito.verify(controller.getModel(), Mockito.times(1)).buyItem(Mockito.any(Item.class));
        Mockito.verify(controller.getModel(), Mockito.times(1)).setMessage("You bought ITEM4 successfully!");
    }

    @Test
    public void cannotBuyItemFour() throws IOException {
        Mockito.when(controller.getModel().getPlayer().getGold()).thenReturn(0);

        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));

        Mockito.when(controller.getModel().getItems().get(0).getName()).thenReturn("ITEM1");
        Mockito.when(controller.getModel().getItems().get(0).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(1).getName()).thenReturn("ITEM2");
        Mockito.when(controller.getModel().getItems().get(1).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(2).getName()).thenReturn("ITEM3");
        Mockito.when(controller.getModel().getItems().get(2).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(3).getName()).thenReturn("ITEM4");
        Mockito.when(controller.getModel().getItems().get(3).getPrice()).thenReturn(1);

        controller.step(game, GUI.ACTION.OPT4);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any());
        Mockito.verify(game, Mockito.times(0)).getPreviousState();
        Mockito.verify(controller.getModel(), Mockito.times(1)).buyItem(Mockito.any(Item.class));
        Mockito.verify(controller.getModel(), Mockito.times(1)).setMessage("You don't have enough gold!");
    }

    @Test
    public void doNotHaveItemFour() throws IOException {
        controller.step(game, GUI.ACTION.OPT4);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any());
        Mockito.verify(game, Mockito.times(0)).getPreviousState();
        Mockito.verify(controller.getModel(), Mockito.times(0)).buyItem(Mockito.any(Item.class));
        Mockito.verify(controller.getModel(), Mockito.times(0)).setMessage(Mockito.anyString());
    }

    @Test
    public void canBuyItemFive() throws IOException {
        Mockito.when(controller.getModel().getPlayer().getGold()).thenReturn(Integer.MAX_VALUE);

        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));

        Mockito.when(controller.getModel().getItems().get(0).getName()).thenReturn("ITEM1");
        Mockito.when(controller.getModel().getItems().get(0).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(1).getName()).thenReturn("ITEM2");
        Mockito.when(controller.getModel().getItems().get(1).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(2).getName()).thenReturn("ITEM3");
        Mockito.when(controller.getModel().getItems().get(2).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(3).getName()).thenReturn("ITEM4");
        Mockito.when(controller.getModel().getItems().get(3).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(4).getName()).thenReturn("ITEM5");
        Mockito.when(controller.getModel().getItems().get(4).getPrice()).thenReturn(1);

        controller.step(game, GUI.ACTION.OPT5);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any());
        Mockito.verify(game, Mockito.times(0)).getPreviousState();
        Mockito.verify(controller.getModel(), Mockito.times(1)).buyItem(Mockito.any(Item.class));
        Mockito.verify(controller.getModel(), Mockito.times(1)).setMessage("You bought ITEM5 successfully!");
    }

    @Test
    public void cannotBuyItemFive() throws IOException {
        Mockito.when(controller.getModel().getPlayer().getGold()).thenReturn(0);

        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));
        controller.getModel().getItems().add(Mockito.mock(Item.class));

        Mockito.when(controller.getModel().getItems().get(0).getName()).thenReturn("ITEM1");
        Mockito.when(controller.getModel().getItems().get(0).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(1).getName()).thenReturn("ITEM2");
        Mockito.when(controller.getModel().getItems().get(1).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(2).getName()).thenReturn("ITEM3");
        Mockito.when(controller.getModel().getItems().get(2).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(3).getName()).thenReturn("ITEM4");
        Mockito.when(controller.getModel().getItems().get(3).getPrice()).thenReturn(1);

        Mockito.when(controller.getModel().getItems().get(4).getName()).thenReturn("ITEM5");
        Mockito.when(controller.getModel().getItems().get(4).getPrice()).thenReturn(1);

        controller.step(game, GUI.ACTION.OPT5);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any());
        Mockito.verify(game, Mockito.times(0)).getPreviousState();
        Mockito.verify(controller.getModel(), Mockito.times(1)).buyItem(Mockito.any(Item.class));
        Mockito.verify(controller.getModel(), Mockito.times(1)).setMessage("You don't have enough gold!");
    }

    @Test
    public void doNotHaveItemFive() throws IOException {
        controller.step(game, GUI.ACTION.OPT5);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any());
        Mockito.verify(game, Mockito.times(0)).getPreviousState();
        Mockito.verify(controller.getModel(), Mockito.times(0)).buyItem(Mockito.any(Item.class));
        Mockito.verify(controller.getModel(), Mockito.times(0)).setMessage(Mockito.anyString());
    }
}
