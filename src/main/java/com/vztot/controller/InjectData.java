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
import org.springframework.http.ResponseEntity;
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

    @RequestMapping
    public ResponseEntity<String> injectData() {
        if (userService.getAll().size() > 0) {
            return ResponseEntity.badRequest()
                    .body("Data was already injected");
        }
        injectUsers();
        injectCategories();
        injectProducts();
        injectDiscounts();
        return ResponseEntity.ok("Successful injection");
    }

    private void injectDiscounts() {
        List<Product> products = productService.getAll();

        Discount aprilDiscount = new Discount();
        aprilDiscount.setName("First april discount");
        aprilDiscount.setDescription("Discount for those who was fooled on first of april");
        aprilDiscount.setPercent(new BigDecimal("0.1"));
        Product iphone = products.stream()
                .filter(product -> product.getName().equals("iPhone"))
                .findFirst()
                .get();
        Product ipad = products.stream()
                .filter(product -> product.getName().equals("iPad"))
                .findFirst()
                .get();
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
        Product tesla = products.stream()
                .filter(product -> product.getName().equals("Tesla"))
                .findFirst()
                .get();
        blackFridayDiscount.setProductList(List.of(tesla));

        discountService.save(aprilDiscount);
        discountService.save(birthdayDiscount);
        discountService.save(blackFridayDiscount);
    }

    private void injectCategories() {
        Category phone = new Category();
        phone.setCategoryName("Phone");
        Category tablet = new Category();
        tablet.setCategoryName("Tablet");
        Category laptop = new Category();
        laptop.setCategoryName("Laptop");
        Category car = new Category();
        car.setCategoryName("Car");
        categoryService.save(phone);
        categoryService.save(tablet);
        categoryService.save(laptop);
        categoryService.save(car);
    }

    private void injectProducts() {
        List<Category> categories = categoryService.getAll();

        Product iphone = new Product();
        iphone.setName("iPhone");
        iphone.setDescription("Mobile phone");
        Category phone = categories.stream()
                .filter(category -> category.getCategoryName().equals("Phone"))
                .findFirst()
                .get();
        iphone.setCategory(phone);
        iphone.setPrice(new BigDecimal(1000));

        Product ipad = new Product();
        ipad.setName("iPad");
        ipad.setDescription("Ergonomic tablet");
        Category tablet = categories.stream()
                .filter(category -> category.getCategoryName().equals("Tablet"))
                .findFirst()
                .get();
        ipad.setCategory(tablet);
        ipad.setPrice(new BigDecimal(1500));

        Product macBook = new Product();
        macBook.setName("MacBook");
        macBook.setDescription("Ergonomic laptop");
        Category laptop = categories.stream()
                .filter(category -> category.getCategoryName().equals("Laptop"))
                .findFirst()
                .get();
        macBook.setCategory(laptop);
        macBook.setPrice(new BigDecimal(2000));

        Product tesla = new Product();
        tesla.setName("Tesla");
        tesla.setDescription("Electric car");
        tesla.setPrice(new BigDecimal(20000));
        Category car = categories.stream()
                .filter(category -> category.getCategoryName().equals("Car"))
                .findFirst()
                .get();
        tesla.setCategory(car);

        productService.save(iphone);
        productService.save(ipad);
        productService.save(macBook);
        productService.save(tesla);
    }

    private void injectUsers() {
        User userSasha = new User();
        User userMasha = new User();
        userSasha.setName("Sasha");
        userMasha.setName("Masha");
        userSasha.setMoney(new BigDecimal(100));
        userMasha.setMoney(new BigDecimal(100));
        userService.save(userSasha);
        userService.save(userMasha);
    }
}
