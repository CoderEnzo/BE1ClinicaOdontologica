package com.miintegrador.miintegrador.repository;

import com.miintegrador.miintegrador.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepositoryImp extends JpaRepository<Odontologo, Integer> {
}
