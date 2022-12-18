package pt.up.fe.ldts.gd.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    public void setup() {
        this.screen = Mockito.mock(Screen.class);
        this.tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(this.tg);

        this.gui = new LanternaGUI(screen);
    }

    @Test
    public void getNextActionTest() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        GUI.ACTION action;

        Mockito.when(screen.readInput()).thenReturn(null);
        action = gui.getNextAction();

        Assertions.assertEquals(GUI.ACTION.NONE, action);

        Mockito.when(screen.readInput()).thenReturn(keyStroke);

        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.EOF);
        action = gui.getNextAction();

        Assertions.assertEquals(GUI.ACTION.QUIT, action);

        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowUp);
        action = gui.getNextAction();

        Assertions.assertEquals(GUI.ACTION.UP, action);

        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowDown);
        action = gui.getNextAction();

        Assertions.assertEquals(GUI.ACTION.DOWN, action);

        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Enter);
        action = gui.getNextAction();

        Assertions.assertEquals(GUI.ACTION.SELECT, action);

        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Character);

        Mockito.when(keyStroke.getCharacter()).thenReturn('1');
        action = gui.getNextAction();

        Assertions.assertEquals(GUI.ACTION.OPT1, action);

        Mockito.when(keyStroke.getCharacter()).thenReturn('2');
        action = gui.getNextAction();

        Assertions.assertEquals(GUI.ACTION.OPT2, action);

        Mockito.when(keyStroke.getCharacter()).thenReturn('3');
        action = gui.getNextAction();

        Assertions.assertEquals(GUI.ACTION.OPT3, action);

        Mockito.when(keyStroke.getCharacter()).thenReturn('4');
        action = gui.getNextAction();

        Assertions.assertEquals(GUI.ACTION.OPT4, action);

        Mockito.when(keyStroke.getCharacter()).thenReturn('5');
        action = gui.getNextAction();

        Assertions.assertEquals(GUI.ACTION.OPT5, action);

        Mockito.when(keyStroke.getCharacter()).thenReturn('6');
        action = gui.getNextAction();

        Assertions.assertEquals(GUI.ACTION.OPT6, action);

        Mockito.when(keyStroke.getCharacter()).thenReturn('7');
        action = gui.getNextAction();

        Assertions.assertEquals(GUI.ACTION.OPT7, action);

        Mockito.when(keyStroke.getCharacter()).thenReturn('8');
        action = gui.getNextAction();

        Assertions.assertEquals(GUI.ACTION.OPT8, action);

        Mockito.when(keyStroke.getCharacter()).thenReturn('9');
        action = gui.getNextAction();

        Assertions.assertEquals(GUI.ACTION.OPT9, action);

        Mockito.when(keyStroke.getCharacter()).thenReturn('0');
        action = gui.getNextAction();

        Assertions.assertEquals(GUI.ACTION.OPT0, action);
    }

    @Test
    public void drawTextTest() {
        gui.drawText("Gus Fring", 1, 1, "#FFFFFF");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Gus Fring");
    }

    @Test
    public void drawPlayerInfoTest() {
        gui.drawPlayerInfo(10, 20);

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(Mockito.any());
        Mockito.verify(tg, Mockito.times(1)).putString(55, 40, "HP: 10");
        Mockito.verify(tg, Mockito.times(1)).putString(55, 41, "GOLD: 20");
    }

    @Test
    public void clearRefreshAndClose() throws IOException {
        gui.clear();
        gui.refresh();
        gui.close();

        Mockito.verify(screen, Mockito.times(1)).clear();
        Mockito.verify(screen, Mockito.times(1)).refresh();
        Mockito.verify(screen, Mockito.times(1)).close();
    }
}
