package com.example.TFIBackEnd.Controller;

import com.example.TFIBackEnd.Model.Odontologo;
import com.example.TFIBackEnd.Model.OdontologoDTO;
import com.example.TFIBackEnd.Service.IOdontologoService;
import com.example.TFIBackEnd.Service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("odontologos")
public class OdontologoController {
    @Autowired
    private IOdontologoService odontologoService;

    // CREATE
    @PostMapping("/new")
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        odontologoService.crearOdontologo(odontologoDTO);
        return ResponseEntity.ok("Odontologo creado exitosamente");
    }

    // GET ALL
    @GetMapping("/list")
    public ResponseEntity<?> buscarTodos(){
        return ResponseEntity.ok(odontologoService.listarTodos());
    }

    // GET
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(odontologoService.buscarPorId(id));
    }

    // UPDATE
    @PutMapping("/update")
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        odontologoService.actualizarOdontologo(odontologoDTO);
        return ResponseEntity.ok("Odontologo actualizado con éxito.");
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarOdontologo(@PathVariable Long id) throws Exception {
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok("Odontologo eliminado!");
    }
}
