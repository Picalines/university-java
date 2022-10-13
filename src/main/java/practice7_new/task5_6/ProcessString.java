package practice7_new.task5_6;

public class ProcessString implements StringMethods {
    @Override
    public int count(String string, char ch) {
        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ch) count++;
        }

        return count;
    }

    @Override
    public String getOddChars(String string) {
        var builder = new StringBuilder();

        for (int i = 0; i < string.length(); i += 2) {
            builder.append(string.charAt(i));
        }

        return builder.toString();
    }

    @Override
    public String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public static void main(String[] args) {
        var ps = new ProcessString();

        System.out.println("count(\"1100101\", '1') = " + ps.count("1100101", '1'));

        System.out.println("getOddChars(\"123456789\") = " + ps.getOddChars("123456789"));

        System.out.println("reverse(\"12345\") = " + ps.reverse("12345"));
    }
}
