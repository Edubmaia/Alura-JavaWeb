package br.com.alura.screenmatch.entiites;

import java.util.Objects;

import br.com.alura.screenmatch.dto.CadastroFilme;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme {



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer duracaoEmMinutos;
	private Integer anoLancamento;
	private String genero;
	
	public Filme( ) {
		
	}

	
	public Filme(CadastroFilme dados) {
		this.nome = dados.nome();
		this.duracaoEmMinutos = dados.duracao();
		this.anoLancamento = dados.ano();
		this.genero = dados.genero();
	
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getDuracaoEmMinutos() {
		return duracaoEmMinutos;
	}

	public Integer getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Integer anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public void setDuracaoEmMinutos(Integer duracaoEmMinutos) {
		this.duracaoEmMinutos = duracaoEmMinutos;
	}
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Filme [id=" + id + ", nome=" + nome + ", duracaoEmMinutos=" + duracaoEmMinutos + ", anoLancamento="
				+ anoLancamento + ", genero=" + genero + "]";
	}
}
