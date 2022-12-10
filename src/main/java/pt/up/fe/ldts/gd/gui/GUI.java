package pt.up.fe.ldts.gd.gui;

import java.io.IOException;

public interface GUI {

    ACTION getNextAction() throws IOException;

    void drawText(String str, int col, int row);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;

    enum ACTION { UP, DOWN, SELECT, NONE, QUIT, OPTION1, OPTION2, OPTION3}
}
