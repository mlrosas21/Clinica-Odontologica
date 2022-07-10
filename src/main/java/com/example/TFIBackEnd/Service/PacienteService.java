package com.example.TFIBackEnd.Service;

import com.example.TFIBackEnd.Model.Paciente;
import com.example.TFIBackEnd.Model.PacienteDTO;
import com.example.TFIBackEnd.Repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService{
    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarPac(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
    }
    // READ ALL
    @Override
    public Set<PacienteDTO> listarTodos() {
        Set<PacienteDTO> pacientesDTOS = new HashSet<>();
        List<Paciente> pacientes = pacienteRepository.findAll();
        for(Paciente paciente : pacientes){
            pacientesDTOS.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacientesDTOS;
    }
    // READ
    @Override
    public PacienteDTO buscarPorId(Long id) throws Exception {
        Optional<Paciente> pacienteEncontrado =  pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(pacienteEncontrado.isPresent()) {
            pacienteDTO = mapper.convertValue(pacienteEncontrado, PacienteDTO.class);
        }
        return pacienteDTO;
    }
    // CREATE
    @Override
    public void crearPaciente(PacienteDTO pacienteDTO) {
        this.guardarPac(pacienteDTO);
    }
    // DELETE
    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
    // UPDATE
    @Override
    public void actualizarPaciente(PacienteDTO pacienteDTO) {
        this.guardarPac(pacienteDTO);
    }
}
