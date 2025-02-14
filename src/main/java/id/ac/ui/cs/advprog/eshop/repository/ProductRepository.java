package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public List<Product> findAll() {
        return products;
    }

    public Product save(Product product) {
        product.setId(idGenerator.incrementAndGet());
        products.add(product);
        return product;
    }
}
