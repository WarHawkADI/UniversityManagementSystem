public class InvalidLoginException extends Exception{
    public InvalidLoginException(String invalidUserCredentials) {
        super(invalidUserCredentials);
    }
}
