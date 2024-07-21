package org.example.backsite.repo;


import org.example.backsite.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends BaseRepo<User> {
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);


}
