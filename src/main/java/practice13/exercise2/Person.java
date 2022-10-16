package practice13.exercise2;

public record Person(String surname, String firstName, String patronymic) {
    public String getFullName() {
        var builder = new StringBuilder();

        builder.append(surname);

        if (firstName != null) {
            builder.append(' ');
            builder.append(firstName);
        }

        if (patronymic != null) {
            builder.append(' ');
            builder.append(patronymic);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Person("Johnson", "John", "Johnsovich")
            .getFullName());

        System.out.println(new Person("Johnson", "Max", null)
            .getFullName());

        System.out.println(new Person("Johnson", null, null)
            .getFullName());
    }
}
