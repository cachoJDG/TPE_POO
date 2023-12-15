package backend;

import backend.model.Figure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GroupFigureMap extends HashMap<Integer, Set<Figure>>
{
    public Set<Figure> findGroup(Figure elem)
    {
        for (Set<Figure> set:values()) {
            if(set.contains(elem))
            {

                return set;
            }
        }
        return new HashSet<>();
    }
    public int numGroup(Figure fig){

        for (Entry<Integer, Set<Figure>> map: entrySet()) {
            for (Set<Figure> set:values()) {
                if(set.contains(fig))
                {
                    return map.getKey();
                }
            }
        }
        return 0;
    }
}
