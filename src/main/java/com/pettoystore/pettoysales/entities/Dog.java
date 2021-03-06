package com.pettoystore.pettoysales.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Entity
@Table(name = "dogs")
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pet_ID")
  private int petID;
  
  @Column(name = "customer_ID")
  private int customerID;
  
  @Column(name = "breed_ID")
  private int breedID;
  
  @Column(name = "name")
  private String name;
}
