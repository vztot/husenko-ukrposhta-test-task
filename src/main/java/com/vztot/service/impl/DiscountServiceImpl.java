package com.vztot.service.impl;

import com.vztot.entity.Discount;
import com.vztot.repository.DiscountRepository;
import com.vztot.service.DiscountService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository discountRepository;

    public DiscountServiceImpl(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

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
