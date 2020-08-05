package com.observer.response;

public class ErrorObject {

    private String errorMessage;

    public ErrorObject(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        StringBuilder errorBuilder = new StringBuilder();
        errorBuilder.append("ErrorMessage: ");
        errorBuilder.append(errorMessage);
        return errorBuilder.toString();
    }
}
