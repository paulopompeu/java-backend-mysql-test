package com.example.backend_mysql_test.entity.dto;

import java.math.BigDecimal;

public record ClientDTO(String firstName, String lastName, BigDecimal participation) {
}
