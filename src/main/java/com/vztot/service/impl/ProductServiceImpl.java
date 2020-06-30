package com.vztot.service.impl;

import com.vztot.entity.Product;
import com.vztot.repository.ProductRepository;
import com.vztot.service.ProductService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getOne(Long id) {
        return productRepository.getOne(id);
    }
}
