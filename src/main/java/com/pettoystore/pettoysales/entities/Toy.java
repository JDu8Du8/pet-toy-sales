package com.pettoystore.pettoysales.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
  @Column(name = "toy_ID")
  private int toyID;
  
  @Column(name = "description")
  private String description;
  
  @Column(name = "price")
  private int price;

  /*
  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinTable(name = "line_items",
          joinColumns = {
                  @JoinColumn(name = "orderID", referencedColumnName = "orderID",
                          nullable = true, updatable = false)},
          inverseJoinColumns = {
                  @JoinColumn(name = "toyID", referencedColumnName = "toyID",
                          nullable = true, updatable = false)})
  private List<Order> orders = new ArrayList<>();
*/
}
