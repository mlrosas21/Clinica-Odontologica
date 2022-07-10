package com.example.TFIBackEnd.Controller;

import com.example.TFIBackEnd.Model.Paciente;
import com.example.TFIBackEnd.Model.PacienteDTO;
import com.example.TFIBackEnd.Service.IPacienteService;
import com.example.TFIBackEnd.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    IPacienteService pacienteService;

    // CREATE
    @PostMapping("/new")
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok("Paciente creado exitosamente");
    }

    // GET ALL
    @GetMapping("/list")
    public ResponseEntity<?> buscarTodos(){
        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    // GET
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    // UPDATE
    @PutMapping("/update")
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO paciente) {
        pacienteService.actualizarPaciente(paciente);
        return ResponseEntity.ok("Paciente actualizado con éxito.");
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarPaciente(@PathVariable Long id) throws Exception {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok("Paciente eliminado!");
    }
}
