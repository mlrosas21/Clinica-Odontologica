package com.example.TFIBackEnd.Service;

import com.example.TFIBackEnd.Model.TurnoDTO;

import java.util.Set;

public interface ITurnoService {
    Set<TurnoDTO> listarTodos();

    TurnoDTO buscarPorId(Long id) throws Exception;

    void crearTurno(TurnoDTO turnoDTO);

    void eliminarTurno(Long id);

    void actualizarTurno(TurnoDTO turnoDTO);
}
