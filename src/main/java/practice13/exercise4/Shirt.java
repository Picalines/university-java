package practice13.exercise4;

import java.util.StringTokenizer;

enum ShirtSize {
    S, M, L, XL, XXL,
}

public record Shirt(String id, String name, String color, ShirtSize size) {
    public static Shirt fromString(String str) {
        var tokenizer = new StringTokenizer(str, ",", false);

        return new Shirt(
            tokenizer.nextToken(),
            tokenizer.nextToken(),
            tokenizer.nextToken(),
            ShirtSize.valueOf(tokenizer.nextToken())
        );
    }

    public static void main(String[] args) {
        var shirtStrings = new String[]{
            "S001,Black Polo Shirt,Black,XL",
            "S002,Black Polo Shirt,Black,L",
            "S003,Blue Polo Shirt,Blue,XL",
            "S004,Blue Polo Shirt,Blue,M",
            "S005,Tan Polo Shirt,Tan,XL",
            "S006,Black TShirt,Black,XL",
            "S007,White T-Shirt,White,XL",
            "S008,White T-Shirt,White,L",
            "S009,Green T-Shirt,Green,S",
            "S010,Orange T-Shirt,Orange,S",
            "S011,Maroon Polo Shirt,Maroon,S",
        };

        for (var shirtString : shirtStrings) {
            System.out.println(Shirt.fromString(shirtString));
        }
    }
}
