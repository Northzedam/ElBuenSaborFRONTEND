package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RubroArticulo;

@Repository
public interface RubroArticuloRepository extends JpaRepository<RubroArticulo, Long> {

	public Page <RubroArticulo> findAll(Pageable pageable);
}
