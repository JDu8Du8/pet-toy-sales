package com.pettoystore.pettoysales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.jdbc.JdbcTestUtils;
import lombok.Getter;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class CsnBeProjectApplicationTests {

  @LocalServerPort
  protected int serverPort;
  
  @Autowired
  @Getter
  public TestRestTemplate restTemplate;
  
  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  @Test
  void testDb() {
    int numrows = JdbcTestUtils.countRowsInTable(jdbcTemplate, "breeds");
    System.out.println("num=" + numrows);
  }

}
