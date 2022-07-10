package com.example.TFIBackEnd.Service;

import com.example.TFIBackEnd.Model.Odontologo;
import com.example.TFIBackEnd.Model.OdontologoDTO;
import com.example.TFIBackEnd.Repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{
    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarOd(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    // READ ALL
    @Override
    public Set<OdontologoDTO> listarTodos() {
        Set<OdontologoDTO> odontologosDTOS = new HashSet<>();
        List<Odontologo> odontologos = odontologoRepository.findAll();
        for(Odontologo odontologo : odontologos){
            odontologosDTOS.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTOS;
    }

    // READ
    @Override
    public OdontologoDTO buscarPorId(Long id){
        Optional<Odontologo> odontologoEncontrado =  odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologoEncontrado.isPresent()) {
            odontologoDTO = mapper.convertValue(odontologoEncontrado, OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    // CREATE
    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) {
        this.guardarOd(odontologoDTO);
    }

    // DELETE
    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    // UPDATE
    @Override
    public void actualizarOdontologo(OdontologoDTO odontologoDTO) {
        this.guardarOd(odontologoDTO);
    }
}
