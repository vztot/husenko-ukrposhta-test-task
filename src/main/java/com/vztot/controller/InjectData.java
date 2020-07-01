package com.vztot.controller;

import com.vztot.entity.Category;
import com.vztot.entity.Discount;
import com.vztot.entity.Product;
import com.vztot.entity.User;
import com.vztot.service.CategoryService;
import com.vztot.service.DiscountService;
import com.vztot.service.ProductService;
import com.vztot.service.UserService;
import java.math.BigDecimal;
import java.util.List;
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
        Category tablet = new Category();
        tablet.setCategoryName("Tablet");
        Category laptop = new Category();
        laptop.setCategoryName("Laptop");
        Category car = new Category();
        car.setCategoryName("Car");
        phone = categoryService.save(phone);
        tablet = categoryService.save(tablet);
        laptop = categoryService.save(laptop);
        car = categoryService.save(car);

        Product iphone = new Product();
        iphone.setName("iPhone");
        iphone.setDescription("Mobile phone");
        iphone.setCategory(phone);
        iphone.setPrice(new BigDecimal(1000));

        Product ipad = new Product();
        ipad.setName("iPad");
        ipad.setDescription("Ergonomic tablet");
        ipad.setCategory(tablet);
        ipad.setPrice(new BigDecimal(1500));

        Product macBook = new Product();
        macBook.setName("MacBook");
        macBook.setDescription("Ergonomic laptop");
        macBook.setCategory(laptop);
        macBook.setPrice(new BigDecimal(2000));

        Product tesla = new Product();
        tesla.setName("Tesla");
        tesla.setDescription("Electric car");
        tesla.setPrice(new BigDecimal(20000));
        tesla.setCategory(car);

        productService.save(iphone);
        productService.save(ipad);
        productService.save(macBook);
        productService.save(tesla);

        Discount aprilDiscount = new Discount();
        aprilDiscount.setName("First april discount");
        aprilDiscount.setDescription("Discount for those who was fooled on first of april");
        aprilDiscount.setPercent(new BigDecimal("0.1"));
        aprilDiscount.setProductList(List.of(iphone, ipad));

        Discount birthdayDiscount = new Discount();
        birthdayDiscount.setName("Birthday discount");
        birthdayDiscount.setDescription("Discount for those who was born at the day they "
                + "bought a product");
        birthdayDiscount.setPercent(new BigDecimal("0.2"));
        birthdayDiscount.setProductList(List.of(iphone, ipad));

        Discount blackFridayDiscount = new Discount();
        blackFridayDiscount.setName("Black friday discount");
        blackFridayDiscount.setDescription("Discount on the last friday of november");
        blackFridayDiscount.setPercent(new BigDecimal("0.25"));
        blackFridayDiscount.setProductList(List.of(tesla));

        discountService.save(aprilDiscount);
        discountService.save(birthdayDiscount);
        discountService.save(blackFridayDiscount);

        return "{\"result\" : \"data injected\"}";
    }
}
