package com.example.digitaltaste.Listeners;

import com.example.digitaltaste.Models.InstructionsResponse;

import java.util.List;

public interface InstructionsListener {
    void didFetch(List<InstructionsResponse> instructions, String message);
    void didError(String message);
}
