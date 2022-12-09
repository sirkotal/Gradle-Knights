package pt.up.fe.ldts.gd.state;

import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.viewer.Viewer;

public abstract class State<T> {
    private final T template;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T template) {
        this.template = template;
        this.viewer = getViewer();
        this.controller = getController();
    }

    public T getTemplate() {
        return this.template;
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

}
