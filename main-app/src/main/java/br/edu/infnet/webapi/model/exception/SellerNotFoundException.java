package br.edu.infnet.webapi.model.exception;

public class SellerNotFoundException extends RuntimeException {
    public SellerNotFoundException(String message) {
        super(message);
    }
}
