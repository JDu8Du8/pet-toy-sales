package com.pettoystore.pettoysales.entities;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "toyID")
public class Toy {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "toy_ID")
  private int toyID;
  
  @Column(name = "description")
  private String description;
  
  @Column(name = "price")
  private int price;


   @ManyToMany(targetEntity = Order.class, 
       cascade = {CascadeType.PERSIST, CascadeType.MERGE}, 
       mappedBy = "toys")
   @JsonIgnore
  private Set<Order> orders = new HashSet<>();
  
}
