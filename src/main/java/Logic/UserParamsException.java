package Logic;

public class UserParamsException extends Exception {
    public UserParamsException(String notValidPhoneNumber) {
        super(notValidPhoneNumber);
    }
}
