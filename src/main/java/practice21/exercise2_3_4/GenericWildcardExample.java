package practice21.exercise2_3_4;

import java.util.ArrayList;
import java.util.Collection;

public class GenericWildcardExample {
    private final ArrayList<?> array;

    public GenericWildcardExample(Collection<?> elements) {
        array = new ArrayList<>(elements);
    }

    public Object get(int index) {
        return array.get(index);
    }
}
