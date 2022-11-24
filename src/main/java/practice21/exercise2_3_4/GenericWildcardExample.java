package practice21.exercise2_3_4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

record Animal(String name, int age) {}

public class GenericWildcardExample {
    private final List<?> array;

    public GenericWildcardExample(Object[] elements) {
        array = Arrays.asList(elements);
    }

    public Object get(int index) {
        return array.get(index);
    }

    public void save5ElementsTo(String filepath) throws IOException {
        var lines = array.stream().limit(5).map(Object::toString).toList();

        for (var line : lines) {
            System.out.println(line);
        }

        Files.write(Paths.get(filepath), lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
    }

    public static void main(String[] args) throws IOException {
        var example = new GenericWildcardExample(new Object[]{1, "test", new Animal("Max", 14), 4, 5, 6, 7});

        System.out.println(example.get(2));

        example.save5ElementsTo("D:\\test.txt");
    }
}
