package com.example.documentmanagment.repository;
import com.example.documentmanagment.entity.Organ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrganRepository extends JpaRepository<Organ, Integer> {

}
