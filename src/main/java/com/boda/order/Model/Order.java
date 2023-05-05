package com.boda.order.Model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class Order {
    private Long id;
    private String productName;
    private String productId;
    private String productSpecification;
    private Integer productQuantity;
    private String branchName;
    private String schoolName;
    private LocalDate orderDate;
    private LocalDateTime createTime;
}
