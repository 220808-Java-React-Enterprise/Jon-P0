package com.revature.Cthulazon.utils.Custom_Exceptions;

public class InvalidUserSelection extends ArrayIndexOutOfBoundsException {
    public InvalidUserSelection(String message) {
        super(message);
    }
}
