package practice7_new.task7_8;

public record Magazine(String name) implements Printable {
    @Override
    public void print() {
        System.out.println(name);
    }

    public static void printMagazines(Printable[] printables) {
        for (var printable : printables) {
            if (printable instanceof Magazine magazine) {
                magazine.print();
            }
        }
    }
}
