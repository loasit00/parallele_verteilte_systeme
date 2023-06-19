package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Controller
public class Frontend {

    @Value("${backend.endpoint}")
    private String todoApiEndpoint;

    @GetMapping("/")
    public String displayPage(Model model) {

        Todo[] items = WebClient
                .create(todoApiEndpoint)
                .get()
                .retrieve()
                .bodyToMono(Todo[].class)
                .block();

        model.addAttribute("items", items);

        return "page";
    }

    @PostMapping("/create")
	public String addItem(@RequestParam String content, @RequestParam Boolean completed , Model model){

        Todo item = new Todo();
        item.content = content;
        item.completed  = completed ;

        WebClient
            .create(todoApiEndpoint)
            .post()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(Mono.just(item), Todo.class)
            .retrieve()
            .bodyToMono(Todo.class)
            .block();

        return "redirect:/";
	}

    @DeleteMapping("/delete")
    public String deleteItem(@RequestParam String todo){

        WebClient
            .create(todoApiEndpoint+todo)
            .delete()
            .retrieve()
            .bodyToMono(Void.class)
            .block();

        return "redirect:/";

    }
    
}
