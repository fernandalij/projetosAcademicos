package com.projetosAcademicos.api;

import com.projetosAcademicos.domain.Endereco;
import com.projetosAcademicos.domain.dto.EnderecoDTO;
import com.projetosAcademicos.domain.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> getEndereco(){
        return ResponseEntity.ok(enderecoService.getEndereco());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getEnderecoId(@PathVariable ("id") Long id){
        Optional<Endereco> endereco = enderecoService.getEnderecoById(id);
        return endereco.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public String cadastrarEndereco(@RequestBody Endereco endereco){
        Endereco endereco1 = enderecoService.cadastrarEndereco(endereco);
        return "Endereco Salvo com sucesso" + endereco1.getId();
    }
}
