package com.pettoystore.pettoysales.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Table(name = "line_items")
@NoArgsConstructor
@AllArgsConstructor
public class LineItem {
  
  @Column(name = "order_id")
  private int orderID;
  
  @Column(name = "toy_id")
  private int toyID;
  
  @Column(name = "quantity")
  private int quantity;
  
}
