package practice32;

import java.io.Serializable;

public record Customer(
    String firstName,
    String secondName,
    int age,
    Address address
) implements Serializable {
    private static final int MATURE_AGE = 18;
    public static final Customer MATURE_UNKNOWN_CUSTOMER = new Customer("", "", MATURE_AGE, Address.EMPTY_ADDRESS);
    public static final Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer("", "", MATURE_AGE - 1, Address.EMPTY_ADDRESS);
}
