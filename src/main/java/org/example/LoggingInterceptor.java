package org.example;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.ReaderInterceptor;
import jakarta.ws.rs.ext.ReaderInterceptorContext;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LoggingInterceptor implements ReaderInterceptor {
    @Override
    public Object aroundReadFrom(ReaderInterceptorContext readerInterceptorContext) throws IOException, WebApplicationException {
        LocalDateTime logTime = LocalDateTime.now();

        InputStream inputStream = readerInterceptorContext.getInputStream();

        String body = new BufferedReader(new InputStreamReader(inputStream))
                .lines()
                .collect(Collectors.joining("\n"));
        String mediaType = readerInterceptorContext.getMediaType().toString();

        System.out.println("------------------------------" + logTime + "------------------------------");
        System.out.println("Request mediaType: " + mediaType);
        System.out.println("Request body: " + body);

        readerInterceptorContext.setInputStream(new ByteArrayInputStream(body.getBytes()));

        return readerInterceptorContext.proceed();
    }
}
