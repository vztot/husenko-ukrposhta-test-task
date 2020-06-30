package com.vztot.service.impl;

import com.vztot.entity.User;
import com.vztot.repository.UserRepository;
import com.vztot.service.UserService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getOne(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public void addMoney(Long userId, BigDecimal amount) {
        User user = userRepository.getOne(userId);
        user.setMoney(user.getMoney().add(amount));
        userRepository.save(user);
    }
}
