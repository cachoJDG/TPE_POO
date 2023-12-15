package backend;

import backend.model.Figure;

@FunctionalInterface
public interface FigureSetApply {
    void apply(Figure fig);
}
