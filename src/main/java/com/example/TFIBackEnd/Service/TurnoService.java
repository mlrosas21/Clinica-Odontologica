package com.example.TFIBackEnd.Service;

import com.example.TFIBackEnd.Model.Paciente;
import com.example.TFIBackEnd.Model.PacienteDTO;
import com.example.TFIBackEnd.Model.Turno;
import com.example.TFIBackEnd.Model.TurnoDTO;
import com.example.TFIBackEnd.Repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService{
    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }
    // READ ALL
    @Override
    public Set<TurnoDTO> listarTodos() {
        Set<TurnoDTO> turnoDTOS = new HashSet<>();
        List<Turno> turnos = turnoRepository.findAll();
        for(Turno turno : turnos){
            turnoDTOS.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnoDTOS;
    }
    // READ
    @Override
    public TurnoDTO buscarPorId(Long id) throws Exception {
        Optional<Turno> turnoEncontrado =  turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turnoEncontrado.isPresent()) {
            turnoDTO = mapper.convertValue(turnoEncontrado, TurnoDTO.class);
        }
        return turnoDTO;
    }
    // CREATE
    @Override
    public void crearTurno(TurnoDTO turnoDTO) {
        this.guardarTurno(turnoDTO);
    }
    // DELETE
    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }
    // UPDATE
    @Override
    public void actualizarTurno(TurnoDTO turnoDTO) {
        this.guardarTurno(turnoDTO);
    }
}
