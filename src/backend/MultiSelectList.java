package backend;

import backend.model.Figure;

import java.util.ArrayList;
import java.util.Optional;

public class MultiSelectList extends ArrayList<Figure> {
    public Optional<Figure> getFirstCustom()
    {
        if(isEmpty())
        {
            return Optional.empty();
        }
        return Optional.of(get(0));
    }

    public boolean onlyOne()
    {
        return size() <= 1;
    }

    public String getSelectedFigLabel()
    {
        if(isEmpty()){return "";}
        StringBuilder sb = new StringBuilder();
        Figure fig = getFirstCustom().get();
        return fig.getLabels();
    }
}
