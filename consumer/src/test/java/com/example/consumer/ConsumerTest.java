package com.example.consumer;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "busProvider", port="8112")
public class ConsumerTest {
    @Pact(provider = "busProvider", consumer = "busConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        return builder.given("test state")
                .uponReceiving("get bus")
                    .path("/bus/HammerSmith/613")
                    .method("GET")
                .willRespondWith()
                    .status(HttpStatus.OK.value())
                    .body("{\n" +
                            "    \"station\": \"HammerSmith\",\n" +
                            "    \"nr\": 613,\n" +
                            "    \"eta\": 614\n" +
                            "}")
                .toPact();
    }

    @Test
    void test(MockServer mockserver) throws IOException {
        HttpResponse httpResponse = Request.Get(mockserver.getUrl() + "/bus/HammerSmith/613")
                .execute()
                .returnResponse();
        assertEquals(HttpStatus.OK.value(), httpResponse.getStatusLine().getStatusCode());

    }
}
