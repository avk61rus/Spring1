package ru.avk.homework;

import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    private final Map<Long, Product> productMap = new HashMap<>();

    @PostConstruct
    public void init() {
        addProduct(1L, new Product(1L, "Монитор 24'' ", 8000L));
        addProduct(2L, new Product(2L, "Мышь оптическая", 750L));
        addProduct(3L, new Product(3L, "Клавиатура", 1550L));
        addProduct(4L, new Product(4L, "Жесткий диск", 3500L));
        addProduct(5L, new Product(5L, "Внешний накопитель", 4500L));
        addProduct(6L, new Product(6L, "Принтер", 12000L));
        addProduct(7L, new Product(7L, "Колонки", 2145L));
        addProduct(8L, new Product(8L, "Флеш память", 680L));
        addProduct(9L, new Product(9L, "Модуль памяти", 1620L));
    }

    @Override
    public Product findProductById(Long id) {
        return productMap.get(id);
    }

    @Override
    public void addProduct(Long id, Product product) {
        productMap.put(id, product);
    }
}
