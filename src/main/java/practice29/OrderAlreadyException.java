package practice29;

public class OrderAlreadyException extends Exception {
    public OrderAlreadyException(String address) {
        super("The order for " + address + " is already added");
    }
}
