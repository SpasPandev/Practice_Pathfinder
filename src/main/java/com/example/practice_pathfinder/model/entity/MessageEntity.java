package com.example.practice_pathfinder.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class MessageEntity extends BaseEntity {

    @Column(nullable = false)
    private LocalDateTime data_time;
    @Lob
    private String text_content;
    @ManyToOne
    private UserEntity author;
    @ManyToOne
    private UserEntity recepient;

    public LocalDateTime getData_time() {
        return data_time;
    }

    public void setData_time(LocalDateTime data_time) {
        this.data_time = data_time;
    }

    public String getText_content() {
        return text_content;
    }

    public void setText_content(String text_content) {
        this.text_content = text_content;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public UserEntity getRecepient() {
        return recepient;
    }

    public void setRecepient(UserEntity recepient) {
        this.recepient = recepient;
    }

    public MessageEntity() {
    }
}
