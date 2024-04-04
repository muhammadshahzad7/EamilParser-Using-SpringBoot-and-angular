
package com.example.Backend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Response {
    private String message;

    public List<Email> validEmails;
    public List<String> invalidEmails;

    public Response(List<Email> validEmails, List<String> invalidEmails) {
        this.validEmails = validEmails;
        this.invalidEmails = invalidEmails;
    }

    public Response() {
        validEmails = new ArrayList<>();
        invalidEmails = new ArrayList<>();
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
