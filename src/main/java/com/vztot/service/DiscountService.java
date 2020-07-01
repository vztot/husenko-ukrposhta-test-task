package com.vztot.service;

import com.vztot.entity.Discount;
import com.vztot.entity.Product;
import java.util.List;

public interface DiscountService extends GenericService<Discount> {
    List<Discount> findDiscountByProduct(Product product);
}
