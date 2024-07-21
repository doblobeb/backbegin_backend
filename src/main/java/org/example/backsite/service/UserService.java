package org.example.backsite.service;

import org.example.backsite.exception.CustomNotFoundException;
import org.example.backsite.model.User;
import org.example.backsite.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new CustomNotFoundException("User not found");
        }
        return user.get();
    }

    public User save(User user) {
        Optional<User> getByEmail = userRepo.findByEmail(user.getEmail());
        if (getByEmail.isEmpty()) {
            return userRepo.save(user);
        } else throw new CustomNotFoundException("Gmail already exists");
    }

    public String delete(Long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return "User deleted";
        } else throw new CustomNotFoundException("User not found");
    }

    public User update(User user) {
        if (userRepo.existsById(user.getId())) {
            return userRepo.save(user);
        } else
            throw new CustomNotFoundException("User not found");
    }
}
