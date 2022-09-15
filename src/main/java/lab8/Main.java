package lab8;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        var scanner = new Scanner(System.in);

        System.out.print("Enter path to file: ");
        var filePath = scanner.nextLine();

        System.out.println("Enter text lines (empty to stop):");

        try (FileWriter writer = new FileWriter(filePath)) {
            boolean firstLine = true;
            String line;
            while ((line = scanner.nextLine()).length() != 0) {
                if (!firstLine) {
                    writer.append('\n');
                }

                writer.append(line);

                firstLine = false;
            }
        }
    }
}
