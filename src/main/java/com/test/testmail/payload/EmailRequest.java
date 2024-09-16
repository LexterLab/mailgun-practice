package com.test.testmail.payload;

import lombok.Builder;

import java.io.File;
import java.util.List;

@Builder
public record EmailRequest(
        String recipient,
        String subject,
        String html,
        List<String> cc,
        List<String> bcc,
        List<File> attachments,
        String sender,
        String from
) {}
