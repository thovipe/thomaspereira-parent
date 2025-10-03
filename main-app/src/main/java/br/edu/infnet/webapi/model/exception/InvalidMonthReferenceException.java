package br.edu.infnet.webapi.model.exception;

public class InvalidMonthReferenceException extends RuntimeException {
    public InvalidMonthReferenceException(String message) {
        super(message);
    }
}
