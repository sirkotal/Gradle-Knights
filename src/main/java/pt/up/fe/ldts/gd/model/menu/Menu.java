package pt.up.fe.ldts.gd.model.menu;

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
        this.lines = readAscii(entries.get(currentEntry));
    }

    public void nextEntry() throws IOException {
        currentEntry++;
        if(currentEntry > this.entries.size() - 1)
            currentEntry = 0;
        this.lines = readAscii(this.entries.get(currentEntry));
    }

    public void previousEntry() throws IOException {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
        this.lines = readAscii(this.entries.get(currentEntry));
    }

    public boolean selectedExit() {
        return currentEntry == 1;
    }

    private List<String> readAscii(String mode) throws IOException {
        if(!mode.equals("start") && !mode.equals("exit")) {
            throw new Error("mode can only be start or exit");
        }
        List<String> lines = new ArrayList<>();
        URL resource = Menu.class.getResource("/ascii/menu/" + mode + "_menu.txt");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        for(String line; (line = br.readLine()) != null;)
            lines.add(line);

        return lines;
    }
}
