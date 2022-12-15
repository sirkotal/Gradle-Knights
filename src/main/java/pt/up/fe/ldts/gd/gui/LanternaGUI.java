package pt.up.fe.ldts.gd.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LanternaGUI implements GUI{
    private final Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException {
        Terminal terminal = createTerminal(width, height);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        return screen;
    }

    private Terminal createTerminal(int width, int height) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);

        return terminalFactory.createTerminal();
    }

    @Override
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.readInput();
        if(keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;

        if(keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if(keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if(keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '1') return ACTION.OPT1;
        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '2') return ACTION.OPT2;
        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '3') return ACTION.OPT3;
        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '4') return ACTION.OPT4;
        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '5') return ACTION.OPT5;
        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '6') return ACTION.OPT6;
        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '7') return ACTION.OPT7;
        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '8') return ACTION.OPT8;
        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '9') return ACTION.OPT9;
        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '0') return ACTION.OPT0;

        return ACTION.NONE;
    }

    @Override
    public void drawText(String str, int col, int row, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(col, row, str);
    }

    @Override
    public void drawPlayerInfo(int hp, int gold) {
        String hpStr = "HP: " + hp;
        String goldStr = "GOLD: " + gold;


        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        tg.putString(55, 40, hpStr);
        tg.putString(55, 41, goldStr);
    }

    @Override
    public void drawDeathScreen() throws IOException {
        List<String> lines = new ArrayList<>();
        URL resource = LanternaGUI.class.getResource("/ascii/death.txt");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        for(String line; (line = br.readLine()) != null;)
            lines.add(line);

        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));

        for(int i = 0; i < lines.size(); i++) {
            drawText(lines.get(i), 35, 15+i, "#FFFFFF");
        }

        drawText("PRESS 0 TO EXIT TO MENU", 50, 35, "#FFFFFF");
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}
