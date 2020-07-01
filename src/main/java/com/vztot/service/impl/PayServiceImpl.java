package com.vztot.service.impl;

import com.vztot.entity.Product;
import com.vztot.entity.User;
import com.vztot.service.PayService;
import com.vztot.service.ProductService;
import com.vztot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {
    private final UserService userService;
    private final ProductService productService;

    public PayServiceImpl(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public boolean buy(Long userId, Long productId) {
        User user = userService.getOne(userId);
        Product product = productService.getOne(productId);
        if (user.getMoney().compareTo(product.getPrice()) >= 0) {
            user.setMoney(user.getMoney().subtract(product.getPrice()));
            userService.save(user);
            return true;
        }
        return false;
    }
}
