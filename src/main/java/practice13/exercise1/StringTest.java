package practice13.exercise1;

public class StringTest {
    public static void main(String[] args) {
        testString("I like Java!!!");
    }

    private static void testString(String str) {
        System.out.println(str);
        System.out.println("last char: " + str.charAt(str.length() - 1));
        System.out.println("ends with \"!!!\": " + str.endsWith("!!!"));
        System.out.println("starts with \"I like\": " + str.startsWith("I like"));
        System.out.println("contains \"Java\": " + str.contains("Java"));
        System.out.println("index of \"Java\": " + str.indexOf("Java"));
        System.out.println("replace 'a' with 'o': " + str.replaceAll("a", "o"));
        System.out.println("uppercase: " + str.toUpperCase());
        System.out.println("lowercase: " + str.toLowerCase());
        System.out.println("substring 3..: " + str.substring(3));
    }
}
