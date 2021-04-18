package fr.drouianm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Bookmark extends PanacheEntity{
  @NotBlank
  @Column(unique = true)
  public String title;

  public String description;
  
  public String[] tags;

  public Date createdAt;

  public Date updatedAt;
  
  @NotBlank
  @Column(unique = true)
  public String link;

  public Bookmark() {}
}
