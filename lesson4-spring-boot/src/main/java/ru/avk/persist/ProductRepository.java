package ru.avk.persist;

import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {

    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();

    private final AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init() {

        this.insert(new Product("Монитор 24''",14578, 18000));
        this.insert( new Product("Мышь оптическая", 14579, 750));
        this.insert(new Product( "Клавиатура", 14580,1550));
        this.insert(new Product("Жесткий диск", 14581, 3500));
        this.insert(new Product( "Внешний накопитель", 14582, 4500));
        this.insert(new Product("Принтер", 14583,12000));
        this.insert(new Product("Колонки", 14584, 2145));
        this.insert(new Product("Флеш память", 14585,680));
        this.insert(new Product("Модуль памяти", 14586,1620));
    }

    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    public Product findById(long id) {
        return productMap.get(id);
    }

    public void insert(Product product) {
        long id = identity.incrementAndGet();
        product.setId(id);
        productMap.put(id, product);
    }

    public String save( Product product) {
        if (product.getId() == null) {
            product.setId(identity.incrementAndGet());
        }
        productMap.put(product.getId(), product);
        return "product";
    }

    public void delete(long id) {
        productMap.remove(id);
    }
}