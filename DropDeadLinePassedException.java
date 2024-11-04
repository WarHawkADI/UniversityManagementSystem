public class DropDeadLinePassedException extends Exception{
    public DropDeadLinePassedException(String courseDropException) {
        super(courseDropException);
    }
}