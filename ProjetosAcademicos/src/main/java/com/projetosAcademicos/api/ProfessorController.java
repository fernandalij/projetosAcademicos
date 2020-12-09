package com.projetosAcademicos.api;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetosAcademicos.domain.Professor;
import com.projetosAcademicos.domain.service.ProfessorService;
import com.projetosAcademicos.domain.dto.ProfessorDTO;

@RestController
@RequestMapping("/api/v1/professores")
public class ProfessorController {
	
	@Autowired
	private ProfessorService service;
	
	@GetMapping
	public ResponseEntity<List<ProfessorDTO>> get() {
		return ResponseEntity.ok(service.getProfessor());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Professor> get(@PathVariable("id") Long id) {
		Optional<Professor> professor = service.getProfessorById(id);
		return professor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("/matricula/{matricula}")
	public ResponseEntity<List<ProfessorDTO>> getCarrosByTipo(@PathVariable("matricula") String matricula) {
		List<ProfessorDTO> listaProfessores = service.getProfessorByMatricula(matricula);
		return listaProfessores.isEmpty() ? 
				ResponseEntity.noContent().build() :
				ResponseEntity.ok(listaProfessores);
	}
	
	@PostMapping
	public String cadastrarProfessor(@RequestBody Professor professor) {
		Professor c = service.cadastrar(professor);
		return "professor salvo com sucesso: " + c.getId();
	}
	
	@PutMapping("/{id}")
	public String atualizarProfessor(@PathVariable("id") Long id, @RequestBody Professor professor) {
		Professor c = service.atualizar(professor, id);
		return "Professor atualizado com sucesso: " + c.getId();
	}
	
	@DeleteMapping("/{id}")
	public String removerProfessor(@PathVariable("id") Long id) {
		service.remover(id);
		return "Professor removido com sucesso. ";
	}
	
}
