package com.example.digitaltaste.Listeners;

import com.example.digitaltaste.Models.RecipeDetailsResponse;

public interface RecipeDetailsListener {
    void didFetch(RecipeDetailsResponse response, String message) ;
    void didError(String message);
}
