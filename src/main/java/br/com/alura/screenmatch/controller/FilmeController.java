package br.com.alura.screenmatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.screenmatch.dto.CadastroFilme;
import br.com.alura.screenmatch.entiites.Filme;
import br.com.alura.screenmatch.repositories.FilmeRepository;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

	@Autowired
	private FilmeRepository repository;

	@GetMapping("/formulario")
	public String CarregaFormulario() {
		return "filmes/formulario";
	}

	@GetMapping
	public String ListaFilmes(Model model) {
		model.addAttribute("lista", repository.findAll());
		return "filmes/listagem";
	}

	@PostMapping
	public String CadastroFilme(CadastroFilme dados) {
		Filme filme = new Filme(dados);
		repository.save(filme);
		return "redirect:/filmes";

	}

}