package com.pettoystore.pettoysales.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@Entity
@Table(name = "toys")
@NoArgsConstructor
@AllArgsConstructor
public class Toy {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int toyID;
  
  @Column(name = "description")
  private String description;
  
  @Column(name = "price")
  private BigDecimal price;
}
