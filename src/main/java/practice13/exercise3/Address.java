package practice13.exercise3;

import java.security.InvalidParameterException;
import java.util.StringTokenizer;

public record Address(
    String country, String region, String town, String street,
    String house, String housing, String apartment) {
    public static Address fromStringSplit(String str) {
        var tokens = str.split(",");

        var country = tokens[0];

        if (country.startsWith(" ")) {
            throw new InvalidParameterException("address string cannot start with whitespace");
        }

        var region = tokens[1].strip();
        var town = tokens[2].strip();
        var street = tokens[3].strip();
        var house = tokens[4].strip();
        var housing = tokens[5].strip();
        var apartment = tokens[6].strip();

        if (tokens.length > 7) {
            throw new InvalidParameterException("unexpected token after apartment");
        }

        return new Address(country, region, town, street, house, housing, apartment);
    }

    public static Address fromStringTokenized(String str) {
        var tokenizer = new StringTokenizer(str, ",.;", false);

        var country = tokenizer.nextToken();

        if (country.startsWith(" ")) {
            throw new InvalidParameterException("address string cannot start with whitespace");
        }

        var region = tokenizer.nextToken().strip();
        var town = tokenizer.nextToken().strip();
        var street = tokenizer.nextToken().strip();
        var house = tokenizer.nextToken().strip();
        var housing = tokenizer.nextToken().strip();
        var apartment = tokenizer.nextToken().strip();

        if (tokenizer.hasMoreElements()) {
            throw new InvalidParameterException("unexpected token after apartment");
        }

        return new Address(country, region, town, street, house, housing, apartment);
    }

    public static void main(String[] args) {
        System.out.println(Address.fromStringSplit("a, b, c, d, e, f, g"));
        System.out.println(Address.fromStringTokenized("a, b, c, d, e, f, g"));
    }
}
