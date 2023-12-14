package backend;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GroupFigureMap<K> extends HashMap<Integer, Set<K>>
{
    public Set<K> findGroup(K elem)
    {
        for (Set<K> set:values()) {
            if(set.contains(elem))
            {
                return set;
            }
        }
        return new HashSet<>();
    }
    public int numGroup(K fig){

        for (Entry<Integer, Set<K>> map: entrySet()) {
            for (Set<K> set:values()) {
                if(set.contains(fig))
                {
                    return map.getKey();
                }
            }
        }
        return 0;
    }
}
