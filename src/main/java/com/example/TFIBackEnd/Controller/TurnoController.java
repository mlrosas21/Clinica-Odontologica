package com.example.TFIBackEnd.Controller;

import com.example.TFIBackEnd.Model.PacienteDTO;
import com.example.TFIBackEnd.Model.TurnoDTO;
import com.example.TFIBackEnd.Service.IPacienteService;
import com.example.TFIBackEnd.Service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    ITurnoService turnoService;

    // CREATE
    @PostMapping("/new")
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDTO turnoDTO) {
        turnoService.crearTurno(turnoDTO);
        return ResponseEntity.ok("Turno creado exitosamente");
    }

    // GET ALL
    @GetMapping("/list")
    public ResponseEntity<?> buscarTodos(){
        return ResponseEntity.ok(turnoService.listarTodos());
    }

    // GET
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(turnoService.buscarPorId(id));
    }

    // UPDATE
    @PutMapping("/update")
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDTO turnoDTO) {
        turnoService.actualizarTurno(turnoDTO);
        return ResponseEntity.ok("Turno actualizado con éxito.");
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarTurno(@PathVariable Long id) throws Exception {
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok("Turno eliminado!");
    }


}
