package practice13.exercise5;

import java.security.InvalidParameterException;
import java.util.regex.Pattern;

public class PhoneNumberConverter {
    private final static Pattern[] formatPatterns = new Pattern[] {
        Pattern.compile("^\\+(?<country>\\d+?)(?<digits>\\d{10})$"),
        Pattern.compile("^(?<country>8)(?<digits>\\d{10})$")
    };

    public static String normalize(String phoneNumberStr) {
        for (var pattern : formatPatterns) {
            var matcher = pattern.matcher(phoneNumberStr);
            if (!matcher.find()) {
                continue;
            }

            var builder = new StringBuilder();
            builder.append('+');
            builder.append(matcher.group("country"));

            var digits = matcher.group("digits");
            builder.append('(');
            builder.append(digits, 0, 3);
            builder.append(')');
            builder.append(digits, 3, 6);
            builder.append('-');
            builder.append(digits, 6, 10);

            return builder.toString();
        }

        throw new InvalidParameterException("unknown phone number format");
    }

    public static void main(String[] args) {
        System.out.println(normalize("+104289652211"));
        System.out.println(normalize("89175655655"));
    }
}
