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

import java.io.IOException;

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
        KeyStroke keyStroke = screen.pollInput();
        if(keyStroke == null) return ACTION.NONE;

        if(keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if(keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if(keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '1') return ACTION.OPTION1;
        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '2') return ACTION.OPTION2;
        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '3') return ACTION.OPTION3;

        return ACTION.NONE;
    }

    @Override
    public void drawText(String str, int col, int row) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        tg.putString(col, row, str);
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
