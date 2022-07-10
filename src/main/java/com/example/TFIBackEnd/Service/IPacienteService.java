package com.example.TFIBackEnd.Service;

import com.example.TFIBackEnd.Model.Paciente;
import com.example.TFIBackEnd.Model.PacienteDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IPacienteService {
     Set<PacienteDTO> listarTodos();

     PacienteDTO buscarPorId(Long id) throws Exception;

    void crearPaciente(PacienteDTO pacienteDTO);

    void eliminarPaciente(Long id);

    void actualizarPaciente(PacienteDTO pacienteDTO);
}
