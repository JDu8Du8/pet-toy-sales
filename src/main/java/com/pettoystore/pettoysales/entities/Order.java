package com.pettoystore.pettoysales.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
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
/*  
  @ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY)
  private List<Toy> Toys = new ArrayList<>();
*/  
}
