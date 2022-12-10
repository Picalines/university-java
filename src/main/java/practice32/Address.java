package practice32;

import java.io.Serializable;

public record Address(
    String cityName,
    int zipCode,
    String streetName,
    int buildNumber,
    char buildLetter,
    int apartmentNumber
) implements Serializable {
    public static final Address EMPTY_ADDRESS = new Address("", 0, "", 0, ' ', 0);

    @Override
    public String toString() {
        return cityName + ", code: " + zipCode + ", " + streetName + " " + buildNumber + ", " + apartmentNumber;
    }
}
