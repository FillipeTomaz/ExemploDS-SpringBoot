package com.exemploDS.exemploDS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemploDS.exemploDS.dto.TipoDTO;
import com.exemploDS.exemploDS.entities.Tipo;
import com.exemploDS.exemploDS.repositories.TipoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TipoService {
    @Autowired
    private TipoRepository tipoRepository;


    public List<TipoDTO> findAll(){

        List<Tipo> listaTipo = tipoRepository.findAll();
        return listaTipo.stream().map(TipoDTO::new).toList();

    }

    // Buscar por ID
    public TipoDTO findById(Long id) {
    Tipo tipo = tipoRepository.findById(id)
    .orElseThrow(() -> new EntityNotFoundException("Tipo não encontrado com ID: " + id));
    return new TipoDTO(tipo);
    }
    
    // Inserir Tipo
    public TipoDTO insert(TipoDTO tipoDTO) {
    Tipo tipo = new Tipo();
    tipo.setDescricao(tipoDTO.getDescricao());
    Tipo tipoSalvo = tipoRepository.save(tipo);
    return new TipoDTO(tipoSalvo);
    }

    // Atualizar Tipo
    public TipoDTO update(Long id, TipoDTO tipoDTO) {
        Tipo tipo = tipoRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Tipo não encontrado com ID: " + id));
        tipo.setDescricao(tipoDTO.getDescricao());
        Tipo tipoAtualizado = tipoRepository.save(tipo);
        return new TipoDTO(tipoAtualizado);
        }

    // Remover por ID
    public void delete(Long id) {
        if (!tipoRepository.existsById(id)) {
        throw new EntityNotFoundException("Tipo não encontrado com ID: " + id);
        }
        tipoRepository.deleteById(id);
        }
    


}
