package practice23.exercise3;

import java.util.Dictionary;
import java.util.Hashtable;

public final class ExpressionContext {
    private final Dictionary<String, Integer> variables;

    public ExpressionContext() {
        variables = new Hashtable<>();
    }

    public void defineVariable(String name, int value) {
        variables.put(name, value);
    }

    public int getVariableValue(String name) {
        return variables.get(name);
    }
}
