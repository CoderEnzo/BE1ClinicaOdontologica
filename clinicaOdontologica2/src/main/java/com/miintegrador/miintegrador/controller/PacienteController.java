package com.miintegrador.miintegrador.controller;

import com.miintegrador.miintegrador.exceptions.ResourceNotFoundException;
import com.miintegrador.miintegrador.model.Paciente;
import com.miintegrador.miintegrador.services.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;





@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping()
    public ResponseEntity<List<Paciente>> buscarpacientes() {
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @PostMapping()
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.guardar(paciente));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Integer id) {
        Paciente paciente = pacienteService.buscar(id).orElse(null);

        return ResponseEntity.ok(paciente);
    }

    @PutMapping()
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) {
        ResponseEntity<Paciente> response = null;

        if (paciente.getId() != null && pacienteService.buscar(paciente.getId()).isPresent())
            response = ResponseEntity.ok(pacienteService.actualizar(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) throws ResourceNotFoundException {
        pacienteService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("El Paciente con el id: "+id+" fue eliminado con exito");
    }
}