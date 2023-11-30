package com.miintegrador.miintegrador.services;


import com.miintegrador.miintegrador.model.Turno;
import com.miintegrador.miintegrador.repository.TurnoRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    private final TurnoRepositoryImp turnoRepository;

    public TurnoService(TurnoRepositoryImp turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Turno registrarTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    public List<Turno> listar() {
        return turnoRepository.findAll();
    }

    public void eliminar(Integer id) {
        turnoRepository.deleteById(id);
    }

    public Turno actualizar(Turno turno) {
        return turnoRepository.save(turno);
    }

    public Optional<Turno> buscar(Integer id) {
        return turnoRepository.findById(id);
    }

}
