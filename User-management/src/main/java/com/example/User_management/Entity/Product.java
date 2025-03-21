package com.example.User_management.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_seq")
    @SequenceGenerator(name = "product_seq", sequenceName = "sequence_of_products",allocationSize = 1)
    private Long id;
    @Column(nullable = false, length = 50)
    private String productName;
    @Column(unique = true)
    private double price;

    @Lob
    private Byte[] image;

    @Transient
    private String address;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private Category category;

//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate dateTime;

}
