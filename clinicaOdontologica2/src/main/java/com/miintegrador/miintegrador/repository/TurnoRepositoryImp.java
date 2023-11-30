package com.miintegrador.miintegrador.repository;

import com.miintegrador.miintegrador.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepositoryImp extends JpaRepository<Turno, Integer> {
}
