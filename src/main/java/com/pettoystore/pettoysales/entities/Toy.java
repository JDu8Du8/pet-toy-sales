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
   @ManyToMany(mappedBy = "toys")
  
  @ManyToMany
  @JoinTable(name = "line_items",
          joinColumns = {
                  @JoinColumn(name = "order_id")},
          inverseJoinColumns = {
                  @JoinColumn(name = "toy_id")})
  private ResultSet<Order> orders;
  */
}
