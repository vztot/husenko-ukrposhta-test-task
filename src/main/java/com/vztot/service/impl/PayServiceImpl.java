package com.vztot.service.impl;

import com.vztot.entity.Discount;
import com.vztot.entity.Product;
import com.vztot.entity.User;
import com.vztot.service.DiscountService;
import com.vztot.service.PayService;
import com.vztot.service.ProductService;
import com.vztot.service.UserService;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PayServiceImpl implements PayService {
    private final UserService userService;
    private final ProductService productService;
    private final DiscountService discountService;

    public PayServiceImpl(UserService userService, ProductService productService,
                          DiscountService discountService) {
        this.userService = userService;
        this.productService = productService;
        this.discountService = discountService;
    }

    @Transactional
    @Override
    public boolean buy(Long userId, Long productId) {
        User user = userService.getOne(userId);
        Product product = productService.getOne(productId);
        List<Discount> discountList = discountService.findDiscountByProduct(product);
        BigDecimal productPrice = product.getPrice();
        if (discountList.size() > 0) {
            BigDecimal bestDiscount = discountList
                    .stream()
                    .map(Discount::getPercent)
                    .max(Comparator.naturalOrder())
                    .get();
            BigDecimal discountValue = productPrice.multiply(bestDiscount);
            productPrice = productPrice.subtract(discountValue);
        }
        if (user.getMoney().compareTo(productPrice) >= 0) {
            user.setMoney(user.getMoney().subtract(productPrice));
            userService.save(user);
            return true;
        }
        return false;
    }
}
