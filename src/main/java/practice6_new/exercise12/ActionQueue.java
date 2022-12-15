package practice6_new.exercise12;

import java.util.ArrayList;

public final class ActionQueue {
    private final ArrayList<Runnable> actions;

    public ActionQueue() {
        actions = new ArrayList<>();
    }

    public void add(Runnable action) {
        actions.add(action);
    }

    public void undo() {
        if (!actions.isEmpty()) {
            actions.remove(actions.size() - 1);
        }
    }

    public void perform() {
        for (var action : actions) {
            action.run();
        }
    }
}
