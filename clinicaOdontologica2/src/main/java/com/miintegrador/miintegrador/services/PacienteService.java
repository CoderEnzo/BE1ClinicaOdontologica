package com.miintegrador.miintegrador.services;

import com.miintegrador.miintegrador.exceptions.ResourceNotFoundException;
import com.miintegrador.miintegrador.model.Paciente;
import com.miintegrador.miintegrador.repository.PacienteRepositoryImp;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;


@Service
public class PacienteService {

    private final PacienteRepositoryImp pacienteRepository;


    public PacienteService(PacienteRepositoryImp pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente guardar(Paciente p) {
        return pacienteRepository.save(p);
    }

    public Optional<Paciente> buscar(Integer id) {
        return pacienteRepository.findById(id);
    }

    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    public void eliminar(Integer id) throws ResourceNotFoundException {
        if(buscar(id)== null){
            throw new ResourceNotFoundException("No se pudo eliminar paciente con id: "+id);
        }
        pacienteRepository.deleteById(id);
    }

    public Paciente actualizar(Paciente p) {
        return pacienteRepository.save(p);
    }
}