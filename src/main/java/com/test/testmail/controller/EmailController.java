package com.test.testmail.controller;

import com.test.testmail.payload.EmailRequest;
import com.test.testmail.payload.EmailResponse;
import com.test.testmail.processor.SendEmailProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmailController {
    private final SendEmailProcessor processor;


    @PostMapping("email")
    public ResponseEntity<EmailResponse> sendMail() {
        EmailRequest request = EmailRequest.builder()
                .sender("Excited User <mailgun@sandbox66baf8cc7d634e1db763cd039308b2f1.mailgun.org>")
                .from("Excited User <mailgun@sandbox66baf8cc7d634e1db763cd039308b2f1.mailgun.org>")
                .cc(List.of("a.parpulanschi@tinqin.com"))
                .bcc(List.of("a.parpulanschi@tinqin.com"))
                .recipient("alexanderparpulansky@gmail.com")
                .html("<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "    <title>Email Template</title>\n" +
                        "    <style>\n" +
                        "        body {\n" +
                        "            font-family: Arial, sans-serif;\n" +
                        "            background-color: #f4f4f4;\n" +
                        "            margin: 0;\n" +
                        "            padding: 0;\n" +
                        "        }\n" +
                        "        .container {\n" +
                        "            max-width: 600px;\n" +
                        "            margin: 20px auto;\n" +
                        "            background-color: #fff;\n" +
                        "            padding: 20px;\n" +
                        "            border-radius: 8px;\n" +
                        "            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);\n" +
                        "        }\n" +
                        "        h1 {\n" +
                        "            color: #333;\n" +
                        "        }\n" +
                        "        p {\n" +
                        "            font-size: 16px;\n" +
                        "            color: #555;\n" +
                        "        }\n" +
                        "        .button {\n" +
                        "            display: inline-block;\n" +
                        "            padding: 10px 20px;\n" +
                        "            background-color: #28a745;\n" +
                        "            color: white;\n" +
                        "            text-decoration: none;\n" +
                        "            border-radius: 5px;\n" +
                        "        }\n" +
                        "        .footer {\n" +
                        "            text-align: center;\n" +
                        "            padding: 10px;\n" +
                        "            font-size: 12px;\n" +
                        "            color: #aaa;\n" +
                        "        }\n" +
                        "    </style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <div class=\"container\">\n" +
                        "        <h1>Hello, [Recipient Name]!</h1>\n" +
                        "        <p>We hope you're doing well. This is just a quick email to let you know about something exciting.</p>\n" +
                        "        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis malesuada dolor in sapien fringilla, eget ultrices felis fermentum.</p>\n" +
                        "        <p>If you'd like to know more, click the button below:</p>\n" +
                        "        <a href=\"https://www.example.com\" class=\"button\">Learn More</a>\n" +
                        "        <p>Thanks for your time!</p>\n" +
                        "        <p>Best regards,</p>\n" +
                        "        <p>The [Your Company] Team</p>\n" +
                        "    </div>\n" +
                        "    <div class=\"footer\">\n" +
                        "        <p>If you no longer wish to receive these emails, <a href=\"#\">unsubscribe here</a>.</p>\n" +
                        "        <p>[Your Company] | 123 Main St, Suite 100, City, Country</p>\n" +
                        "    </div>\n" +
                        "</body>\n" +
                        "</html>\n")
                .attachments(List.of(new File("hello.txt")))
                .subject("yes")
                .build();
        return ResponseEntity.ok(processor.sendEmail(request));
    }

}
