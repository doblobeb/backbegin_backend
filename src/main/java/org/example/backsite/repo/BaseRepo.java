package org.example.backsite.repo;



import org.example.backsite.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepo<E extends BaseModel> extends JpaRepository<E, Long> {
}