package practice30;

public final class Customer {
    private static final int MATURE_AGE = 18;
    public static final Customer MATURE_UNKNOWN_CUSTOMER = new Customer("", "", MATURE_AGE, Address.EMPTY_ADDRESS);
    public static final Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer("", "", MATURE_AGE - 1, Address.EMPTY_ADDRESS);

    private final String firstName;
    private final String secondName;
    private final int age;
    private final Address address;

    public Customer(int age) {
        this("", "", age, Address.EMPTY_ADDRESS);
    }

    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address.getCityName() + ", code: " + address.getZipCode() + ", " + address.getStreetName() + " " + address.getBuildNum()
            + ", " + address.getApartmentNum();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}