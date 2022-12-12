package pt.up.fe.ldts.gd.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
    public void drawTextTest() {
        gui.drawText("Gus Fring", 1, 1);

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Gus Fring");
    }
}
