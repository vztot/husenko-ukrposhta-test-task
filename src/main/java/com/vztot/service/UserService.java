package com.vztot.service;

import com.vztot.entity.User;
import java.math.BigDecimal;

public interface UserService extends GenericService<User> {
    void addMoney(Long userId, BigDecimal amount);
}
