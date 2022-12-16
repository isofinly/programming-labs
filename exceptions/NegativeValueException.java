package exceptions;

public class NegativeValueException extends IllegalArgumentException {
    public NegativeValueException(String message) {
        super(message);
    }

    /**
     * Use this method to print the error message
     *
     * @return string representation of this exception
     */
    public String getError() {
        return "Error: " + getMessage();
    }
}