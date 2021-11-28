package com.pettoystore.pettoysales.entities;

import java.math.BigDecimal;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Entity
@Table(name = "breeds")
@NoArgsConstructor
@AllArgsConstructor
public class Breed{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "breedID")
  private int breedID;
  
  @Column(name = "description")
  private String description;
}
