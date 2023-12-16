package backend;

import backend.model.Figure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GroupFigureMap extends HashMap<Integer, SelectionFigureSet>
{
    public SelectionFigureSet findGroup(Figure elem)
    {
        for (SelectionFigureSet set:values()) {
            if(set.contains(elem))
            {

                return set;
            }
        }
        return new SelectionFigureSet();
    }
    public int numGroup(Figure fig){

        for (Entry<Integer, SelectionFigureSet> map: entrySet()) {
            for (SelectionFigureSet set:values()) {
                if(set.contains(fig))
                {
                    return map.getKey();
                }
            }
        }
        return 0;
    }
}
