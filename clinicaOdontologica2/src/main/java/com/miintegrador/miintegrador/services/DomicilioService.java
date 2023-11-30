package com.miintegrador.miintegrador.services;

import com.miintegrador.miintegrador.model.Domicilio;
import com.miintegrador.miintegrador.repository.DomicilioRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {
    private final DomicilioRepositoryImp domicilioRepository;

    public DomicilioService(DomicilioRepositoryImp domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    public Domicilio guardar(Domicilio d){
        domicilioRepository.save(d);
        return d;
    }
    public Optional<Domicilio> buscar(Integer id){
        return Optional.of(domicilioRepository.getOne(Long.valueOf(id)));
    }
    public List<Domicilio> buscarTodos(){
        return domicilioRepository.findAll();
    }
    public void eliminar(Integer id){
        domicilioRepository.deleteById(Long.valueOf(id));
    }

}
