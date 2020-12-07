package com.projetosAcademicos.domain.service;

import com.projetosAcademicos.domain.Endereco;
import com.projetosAcademicos.domain.dto.EnderecoDTO;
import com.projetosAcademicos.domain.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<EnderecoDTO> getEndereco(){
        return enderecoRepository.findAll().stream().map(EnderecoDTO::new).collect(Collectors.toList());
    }

    public Optional<Endereco> getEnderecoById(Long id){
        return enderecoRepository.findById(id);
    }

    public Endereco cadastrarEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public Endereco atualizarEndereco(Endereco endereco, long id){

        Optional<Endereco> optional = getEnderecoById(id);
        if(optional.isPresent()){
            Endereco enderecobd = optional.get();
            enderecobd.setCep(endereco.getCep());
            enderecobd.setCidade(endereco.getCidade());
            enderecobd.setEstado(endereco.getEstado());
            enderecobd.setNumero(endereco.getNumero());
            enderecobd.setPais(endereco.getPais());
            enderecobd.setRua(endereco.getRua());

            enderecoRepository.save(enderecobd);
            return enderecobd;
        }
        else{
            throw new RuntimeException("Não foi possivel atualizar o endereco informado");
        }
    }
}
