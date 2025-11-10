package br.com.alura.screenmatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.screenmatch.dto.AtualizadorDados;
import br.com.alura.screenmatch.dto.CadastroFilme;
import br.com.alura.screenmatch.entiites.Filme;
import br.com.alura.screenmatch.repositories.FilmeRepository;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

	@Autowired
	private FilmeRepository repository;

	@GetMapping("/formulario")
	public String CarregaFormulario(Model model, Long id) {
		if (id !=null) {
			var filme = repository.getReferenceById(id);
			model.addAttribute("filme",filme);
		}
		return "filmes/formulario";
	}

	@GetMapping
	public String ListaFilmes(Model model) {
		model.addAttribute("lista", repository.findAll());
		return "filmes/listagem";
	}

	@PostMapping
	@Transactional
	public String CadastroFilme(CadastroFilme dados) {
		Filme filme = new Filme(dados);
		repository.save(filme);
		return "redirect:/filmes";

	}
	
	@PutMapping
	@Transactional
	public String AtualizarFilmes(AtualizadorDados dados) {
		Filme filme = repository.getReferenceById(dados.id());
		filme.atualizaDados(dados);
		return "redirect:/filmes";
	}

	@DeleteMapping
	@Transactional
	public String ExcluirFilme(Long id) {
		
		repository.deleteById(id);		
        return "redirect:/filmes";

	}
	
}