package com.miintegrador.miintegrador.repository;

import com.miintegrador.miintegrador.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepositoryImp extends JpaRepository<Domicilio, Long> {

}
