package com.example.Backend;

import org.apache.logging.log4j.util.StringMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("api/mail")
    public List<Email> getEmails() {
        return emailService.getEmails();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("api/mail")
    public Response receiveData(@RequestBody Map<String, String> DATA){

        String data = DATA.get("data");
        System.out.println(data);
        if (data == null || data.isEmpty()) {
            // Handle empty or missing data property
            // You may return an error response or handle it based on your requirements
            return new Response(Collections.emptyList(), Collections.singletonList("No email data provided"));
        }
        Email dataObj = new Email();
        Response response = dataObj.splitData(data);
            emailService.addEmails(response.validEmails);
//            if(response.validEmails != null){
//                response.validEmails.add(response.validEmails);
//            } else {
//                response.invalidEmails.add(email.getEmail());
//            }
        return response;
    }

}




