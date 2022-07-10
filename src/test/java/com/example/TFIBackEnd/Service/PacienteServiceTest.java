package com.example.TFIBackEnd;

import com.example.TFIBackEnd.Model.PacienteDTO;
import com.example.TFIBackEnd.Service.PacienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    @Test
    public void crearEstudiante() throws Exception {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setApellido("Rosas");
        pacienteDTO.setNombre("Martin");
        pacienteDTO.setDni(12345678);
        pacienteService.crearPaciente(pacienteDTO);


        assertTrue(pacienteService.buscarPorId(1L) != null);
    }
}