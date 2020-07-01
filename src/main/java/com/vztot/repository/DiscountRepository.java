package com.vztot.repository;

import com.vztot.entity.Discount;
import com.vztot.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
    @Query("FROM Discount d WHERE :product MEMBER OF d.productList")
    List<Discount> findDiscountByProduct(@Param("product") Product product);
}
