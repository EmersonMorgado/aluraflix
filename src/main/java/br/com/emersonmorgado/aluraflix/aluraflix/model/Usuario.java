package br.com.emersonmorgado.aluraflix.aluraflix.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private Boolean contaValida;
	private Boolean desbloqueio;
	private Boolean credencialValida;
	private Boolean ContaAtiva;
	
	@ManyToMany
	private List<Perfil> perfil = new ArrayList<>();

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getContaValida() {
		return contaValida;
	}

	public void setContaValida(Boolean contaValida) {
		this.contaValida = contaValida;
	}

	public Boolean getDesbloqueio() {
		return desbloqueio;
	}

	public void setDesbloqueio(Boolean desbloqueio) {
		this.desbloqueio = desbloqueio;
	}

	public Boolean getCredencialValida() {
		return credencialValida;
	}

	public void setCredencialValida(Boolean credencialValida) {
		this.credencialValida = credencialValida;
	}

	public Boolean getContaAtiva() {
		return ContaAtiva;
	}

	public void setContaAtiva(Boolean contaAtiva) {
		ContaAtiva = contaAtiva;
	}

	public List<Perfil> getPerfil() {
		return perfil;
	}

	public void setPerfil(List<Perfil> perfil) {
		this.perfil = perfil;
	}

	@Override
	public String getPassword() {
		return senha;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfil;
	}
	@Override
	public String getUsername() {
		return email;
	}
	@Override
	public boolean isAccountNonExpired() {
		return contaValida;
	}
	@Override
	public boolean isAccountNonLocked() {
		return desbloqueio;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return credencialValida;
	}
	@Override
	public boolean isEnabled() {
		return ContaAtiva;
	}
}
