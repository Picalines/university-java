package practice29;

public class IllegalAddressException extends Exception {
    public IllegalAddressException(String address) {
        super("There is no such address " + address);
    }
}
