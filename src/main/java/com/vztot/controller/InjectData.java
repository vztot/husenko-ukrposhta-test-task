package com.vztot.controller;

import com.vztot.entity.Category;
import com.vztot.entity.Product;
import com.vztot.entity.User;
import com.vztot.service.CategoryService;
import com.vztot.service.DiscountService;
import com.vztot.service.ProductService;
import com.vztot.service.UserService;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/inject")
@RestController
public class InjectData {
    private final UserService userService;
    private final ProductService productService;
    private final DiscountService discountService;
    private final CategoryService categoryService;

    public InjectData(UserService userService, ProductService productService,
                      DiscountService discountService, CategoryService categoryService) {
        this.userService = userService;
        this.productService = productService;
        this.discountService = discountService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String injectData() {
        User userSasha = new User();
        User userMasha = new User();
        userSasha.setName("Sasha");
        userMasha.setName("Masha");
        userSasha.setMoney(new BigDecimal(100));
        userMasha.setMoney(new BigDecimal(100));
        userService.save(userSasha);
        userService.save(userMasha);

        Category phone = new Category();
        phone.setCategoryName("Phone");
        phone = categoryService.save(phone);
        Category tablet = new Category();
        tablet.setCategoryName("Tablet");
        tablet = categoryService.save(tablet);
        Category laptop = new Category();
        laptop.setCategoryName("Laptop");
        laptop = categoryService.save(laptop);
        Category car = new Category();
        car.setCategoryName("Car");
        car = categoryService.save(car);

        Product iphone = new Product();
        iphone.setPrice(new BigDecimal(1000));
        iphone.setCategory(phone);
        Product ipad = new Product();
        ipad.setCategory(tablet);
        ipad.setPrice(new BigDecimal(1500));
        Product macBook = new Product();
        macBook.setCategory(laptop);
        macBook.setPrice(new BigDecimal(2000));
        Product tesla = new Product();
        tesla.setPrice(new BigDecimal(20000));
        tesla.setCategory(car);

        productService.save(iphone);
        productService.save(ipad);
        productService.save(macBook);
        productService.save(tesla);

        return "Data injected!";
    }
}
