package com.miintegrador.miintegrador.services;


import com.miintegrador.miintegrador.exceptions.ResourceNotFoundException;
import com.miintegrador.miintegrador.model.Odontologo;
import com.miintegrador.miintegrador.repository.OdontologoRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    private OdontologoRepositoryImp odontologoRepository;

    public OdontologoService(OdontologoRepositoryImp odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo guardar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    public void eliminar(Integer id) throws ResourceNotFoundException{
        if (buscar(id)== null){
           throw new ResourceNotFoundException("No se pudo eliminar odontologo con id: "+id);
        }
        odontologoRepository.deleteById(id);
    }

    public Optional<Odontologo> buscar(Integer id) {
        return odontologoRepository.findById(id);
    }

    public List<Odontologo> buscarTodos() {
        return odontologoRepository.findAll();
    }

}
