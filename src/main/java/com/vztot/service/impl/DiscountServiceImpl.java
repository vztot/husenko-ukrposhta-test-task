package com.vztot.service.impl;

import com.vztot.entity.Discount;
import com.vztot.repository.DiscountRepository;
import com.vztot.service.DiscountService;
import com.vztot.service.ProductService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository discountRepository;
    private final ProductService productService;

    public DiscountServiceImpl(DiscountRepository discountRepository,
                               ProductService productService) {
        this.discountRepository = discountRepository;
        this.productService = productService;
    }

    @Transactional
    @Override
    public Discount save(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    public List<Discount> getAll() {
        return discountRepository.findAll();
    }

    @Override
    public Discount getOne(Long id) {
        return discountRepository.getOne(id);
    }
}
