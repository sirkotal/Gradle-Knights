package pt.up.fe.ldts.gd.gui;

import java.io.IOException;

public interface GUI {

    void clear();
    void refresh() throws IOException;
    void close() throws IOException;
}
