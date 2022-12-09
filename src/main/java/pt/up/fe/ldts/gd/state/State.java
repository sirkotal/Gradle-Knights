package pt.up.fe.ldts.gd.state;

import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.viewer.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    public T getModel() {
        return this.model;
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public void step(Game game, GUI gui) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action);
        viewer.draw(gui);
    }
}
