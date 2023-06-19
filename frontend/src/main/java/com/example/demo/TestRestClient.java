package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class TestRestClient {

    @GetMapping("/testRestList")
    public String testRestList(){

        return WebClient.create("https://8080-loasit00-paralleleverte-664y5bfzfq2.ws-eu100.gitpod.io/todos/")
        .get()
        .retrieve()
        .bodyToMono(Todo[].class)
        .block()
        .toString();

    }

    @GetMapping("/testGetRestObject")
    public String testRestObject(){

        return WebClient.create("https://8080-loasit00-paralleleverte-664y5bfzfq2.ws-eu100.gitpod.io/todos/one")
        .get()
        .retrieve()
        .bodyToMono(Todo.class)
        .block()
        .toString();

    }

    @GetMapping("/testPostRestObject")
    public Todo testPostRestObject(){

        return WebClient
            .create("https://8080-loasit00-paralleleverte-664y5bfzfq2.ws-eu100.gitpod.io/todos/one")
            .post()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(Mono.just(new Todo("one")), Todo.class)
            .retrieve()
            .bodyToMono(Todo.class)
            .block();

    }
    
}
