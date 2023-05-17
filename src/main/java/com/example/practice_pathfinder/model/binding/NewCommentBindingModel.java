package com.example.practice_pathfinder.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewCommentBindingModel {

    private String message;

    public NewCommentBindingModel() {
    }

    @NotBlank
    @Size(min = 10)
    public String getMessage() {
        return message;
    }

    public NewCommentBindingModel setMessage(String message) {
        this.message = message;
        return this;
    }
}
