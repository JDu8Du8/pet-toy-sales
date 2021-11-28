package com.pettoystore.pettoysales.entities;

import java.math.BigDecimal;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "orderID")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_ID")
  private int orderID;
  
  @Column(name = "cust_ID")
  private int custID;
  
  @Column(name = "toy_ID")
  private int toyID;
   
  @Column(name = "quantity")
  private int quantity;
  
  @Column(name = "total")
  private BigDecimal total;
 
   @ManyToMany(targetEntity = Toy.class,
       cascade = CascadeType.ALL)
   @JoinTable(name = "line_items",
   joinColumns = @JoinColumn(name = "order_ID"),
   inverseJoinColumns = @JoinColumn(name = "toy_ID"))
   @JsonIgnore
  private Set<Toy> toys = new HashSet<>();
  
   public void addToy(Toy toy) {
     toys.add(toy);
     toy.getOrders().add(this);
   }
   
   public void removeToy(Toy toy) {
     toys.remove(toy);
     toy.getOrders().remove(this);
   }
}
