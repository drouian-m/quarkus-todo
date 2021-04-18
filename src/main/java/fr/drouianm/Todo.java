package fr.drouianm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Todo extends PanacheEntity {
    @NotBlank
    @Column(unique = true)
    public String task;

    public Boolean complete;

    @Column(name = "ordering")
    public int order;

    public Todo() {}

    public Todo(String task, Boolean complete) {
        this.task = task;
        this.complete = complete;
    }
}
