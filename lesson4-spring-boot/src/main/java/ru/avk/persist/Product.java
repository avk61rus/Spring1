package ru.avk.persist;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class Product {
    private Long id;

    @NotBlank(message = "поле не должно быть пустым")
    private String productName;

    @Min(value = 10000, message = "Цифровое значение должно быть положительным и иметь 5 разрядов")
    @Digits(integer = 5, fraction = 0, message = "должно быть 5 цифр")
    private int vendorCode;

    @Min(value = 1, message = "Цифровое значение должно быть положительным")
    @Digits(integer = 7, fraction = 2, message = "только цифры")
    private int cost;

    public Product(String productName, int vendorCode, int cost) {
        this.productName = productName;
        this.vendorCode = vendorCode;
        this.cost = cost;
    }
}
