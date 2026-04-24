package connect4.response;

public class Connect4Error extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private ErrorResponse error;

    public Connect4Error(String message) {
        super(message);
    }

    public Connect4Error(ErrorResponse error) {
        super(error.toString());
        this.error = error;
    }

    public ErrorResponse getError() {
        return error;
    }
}
