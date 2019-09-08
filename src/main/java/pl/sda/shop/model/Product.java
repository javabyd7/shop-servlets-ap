package pl.sda.shop.model;

import lombok.*;

@Data
@AllArgsConstructor
public class Product {

    private String name;
    private int price;
    private int quantity;

}