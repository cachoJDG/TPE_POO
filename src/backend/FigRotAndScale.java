package backend;

import backend.model.Figure;

@FunctionalInterface
public interface FigRotAndScale {
    void apply(SelectionFigureSet set);
}

