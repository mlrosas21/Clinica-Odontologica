package com.example.TFIBackEnd.Service;

import com.example.TFIBackEnd.Model.Odontologo;
import com.example.TFIBackEnd.Model.OdontologoDTO;
import com.example.TFIBackEnd.Model.PacienteDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IOdontologoService {

    Set<OdontologoDTO> listarTodos();

    OdontologoDTO buscarPorId(Long id) throws Exception;

    void crearOdontologo(OdontologoDTO odontologoDTO);

    void eliminarOdontologo(Long id);

    void actualizarOdontologo(OdontologoDTO odontologoDTO);
}
