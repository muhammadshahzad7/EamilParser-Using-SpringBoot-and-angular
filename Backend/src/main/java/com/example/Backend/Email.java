
package com.example.Backend;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "email_addresses")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public Email(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Email(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Email() {
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Method to split data into list of emails
    public Response splitData(String data) {
        List<Email> validEmails = new ArrayList<>();
        List<String> invalidEmails = new ArrayList<>();

        String[] splitData = data.split("[,;]");
        for (String email : splitData) {
            Email parsedEmail = new Email();
            try {
                parsedEmail.parseData(email.trim());
                validEmails.add(parsedEmail);
            } catch (IllegalArgumentException e) {
                System.err.println("Failed " +
                        "to parse email: " + email);
                invalidEmails.add(email); // Add invalid email to list
            }
        }

        // Print invalid emails if any
        if (!invalidEmails.isEmpty()) {
            System.out.println("Invalid emails:");
            for (String invalidEmail : invalidEmails) {
                System.out.println(invalidEmail);
            }
        }

        return new Response(validEmails, invalidEmails);
    }


    // Method to parse email data
    public void parseData(String data) {

        if (data.contains("<") && data.contains(">")) {

            String[] nameEmail = data.split("<");

            String name = nameEmail[0].trim();
            String email = nameEmail[1].replace(">", "").trim();

            // Check if the name part contains both first name and last name
            if (name.contains(" ")) {
                String[] names = name.split(" ", 2); // Limit the split to 2 parts
                this.firstName = names[0].trim();
                this.lastName = names[1].trim();
            } else {
                this.firstName = name.trim();
                this.lastName = null; // Set last name to null
            }

            // Set email
            this.email = email;
        } else {

            System.out.println("Invalid email: " + data);
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Email{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

