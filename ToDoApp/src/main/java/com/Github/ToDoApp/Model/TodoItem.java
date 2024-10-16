package com.Github.ToDoApp.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@Table(name = "todo_item")
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Description is required")
    private String description;

    private boolean complete;

    private Instant createdDate;

    private Instant modifiedDate;

    public TodoItem(String description)
    {
        this.description = description;
        this.complete = false;
        this.createdDate = Instant.now();
        this.modifiedDate = Instant.now();
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", complete=" + complete +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
