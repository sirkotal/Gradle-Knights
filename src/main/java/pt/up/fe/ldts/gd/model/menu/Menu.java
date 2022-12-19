package pt.up.fe.ldts.gd.model.menu;

import pt.up.fe.ldts.gd.AsciiReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private List<String> lines;
    private final List<String> entries;
    private int currentEntry;

    public Menu() throws IOException {
        this.currentEntry = 0;
        this.entries = Arrays.asList("start", "exit");
        this.lines = AsciiReader.readAscii("/ascii/menu/" + entries.get(currentEntry) + "_menu.txt");
    }

    public void nextEntry() throws IOException {
        currentEntry++;
        if(currentEntry > this.entries.size() - 1)
            currentEntry = 0;
        this.lines = AsciiReader.readAscii("/ascii/menu/" + this.entries.get(currentEntry) + "_menu.txt");
    }

    public void previousEntry() throws IOException {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
        this.lines = AsciiReader.readAscii("/ascii/menu/" + this.entries.get(currentEntry) + "_menu.txt");
    }

    public boolean selectedExit() {
        return currentEntry == 1;
    }

    public List<String> getLines() {
        return this.lines;
    }
}
