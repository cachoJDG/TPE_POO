package backend;

import java.util.ArrayList;
import java.util.Optional;

public class MultiSelectList <K> extends ArrayList<K> {
    public Optional<K> getFirstCustom()
    {
        if(isEmpty())
        {
            return Optional.empty();
        }
        return Optional.of(get(0));
    }
}
