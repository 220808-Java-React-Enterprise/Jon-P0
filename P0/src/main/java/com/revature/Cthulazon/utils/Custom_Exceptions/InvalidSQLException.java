package com.revature.Cthulazon.utils.Custom_Exceptions;

public class InvalidSQLException extends RuntimeException {
    public InvalidSQLException() {
    }

    public InvalidSQLException(String message) {
        super(message);
    }
}