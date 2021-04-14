package fr.drouianm;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Todo extends PanacheEntity {
    public String task;
    public Boolean complete;

    public Todo() {}

    public Todo(String task, Boolean complete) {
        this.task = task;
        this.complete = complete;
    }
}
