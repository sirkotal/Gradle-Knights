package pt.up.fe.ldts.gd;

import pt.up.fe.ldts.gd.model.menu.Menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AsciiReader {
    static public List<String> readAscii(String path) throws IOException {
        List<String> lines = new ArrayList<>();
        URL resource = AsciiReader.class.getResource(path);
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        for(String line; (line = br.readLine()) != null;)
            lines.add(line);

        return lines;
    }
}
