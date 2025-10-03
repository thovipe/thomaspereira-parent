package br.edu.infnet.webapi.model.exception;

public class InvalidItemValueException extends RuntimeException{
    public InvalidItemValueException(String message) {
        super(message);
    }
}
