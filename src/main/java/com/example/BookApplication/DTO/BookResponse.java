package com.example.BookApplication.DTO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookResponse {
    @JsonProperty("items")
    private List<BookItem> items;

}

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
class BookItem{
    @JsonProperty("volumeInfo")
    private VolumeInfo volumeInfo;

}

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
class VolumeInfo{
    @JsonProperty("title")
    private String title;

    @JsonProperty("imageLinks")
    private ImageLinks imageLinks;

    public String getThumbnail(){
        return (imageLinks != null && imageLinks.getThumbnail()!= null && !imageLinks.getThumbnail().isEmpty())
                ? imageLinks.getThumbnail()
                : "/images/book-default.png";
    }
}

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
class ImageLinks{
    @JsonProperty("thumbnail")
    private String thumbnail;
}