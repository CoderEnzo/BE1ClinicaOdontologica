package com.miintegrador.miintegrador.repository;

import com.miintegrador.miintegrador.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepositoryImp extends JpaRepository<Paciente, Integer> {
}
