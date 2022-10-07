package practice6_new;

public class StringBuilderUndoTest {
    public static void main(String[] args) {
        var queue = new FunctionQueue<>(StringBuilder::new);

        queue.apply(sb -> sb.append('a'));
        queue.apply(sb -> sb.append('b'));

        queue.apply(sb -> sb.append('y'));
        queue.undo();

        queue.apply(sb -> sb.append('c'));

        System.out.println(queue.call().toString());
    }
}
