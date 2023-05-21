package com.example.shopping_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;

    @Column(nullable = false)
    private String item_name;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false, columnDefinition = "BIGINT DEFAULT 0")
    private Long quantity;

}
