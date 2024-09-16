package com.test.testmail.processor;

import com.mailgun.api.v3.MailgunMessagesApi;
import com.mailgun.model.message.Message;
import com.test.testmail.payload.EmailRequest;
import com.test.testmail.payload.EmailResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class SendEmailProcessor {
    private final MailgunMessagesApi mailgun;

    @Value("${mailgun.domain}")
    private String domain;

    public EmailResponse sendEmail(EmailRequest emailRequest) {
        log.info("Sending email request: {}", emailRequest);

        Message message = Message
                .builder()
                .cc(emailRequest.cc())
                .bcc(emailRequest.bcc())
                .html(emailRequest.html())
                .to(emailRequest.recipient())
                .from(emailRequest.from())
                .subject(emailRequest.subject())
                .attachment(emailRequest.attachments())
                .build();


        mailgun.sendMessage(domain, message);


        return EmailResponse.builder().build();
    }
}
