package com.example.BookApplication.Service;

import com.example.BookApplication.DTO.BookResponse;
import com.example.BookApplication.Model.Book;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoogleBooksService {
    private final WebClient webClient;

    public GoogleBooksService(WebClient.Builder webClientBuilder){
        this.webClient =  webClientBuilder.baseUrl("https://www.googleapis.com/books/v1").build();
    }

    public Mono<BookResponse> searchBooks(String query){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/volumes").queryParam("q", query).build())
                .retrieve()
                .bodyToMono(BookResponse.class);
    }

    private List<Book> parseBooks(JsonNode jsonNode){
        List<Book> books = new ArrayList<>();
        if(jsonNode.has("items")){
            for(JsonNode item: jsonNode.get("items")){
                JsonNode volumeInfo = item.get("volumeInfo");
                if(volumeInfo != null){
                    String title = volumeInfo.has("title") ? volumeInfo.get("title").asText(): "No Title";
                }
            }
        }
        return books;
    }

}
