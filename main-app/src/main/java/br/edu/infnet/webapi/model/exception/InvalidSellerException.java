package br.edu.infnet.webapi.model.exception;

public class InvalidSellerException extends RuntimeException {
    public InvalidSellerException(String message) {
        super(message);
    }
}
