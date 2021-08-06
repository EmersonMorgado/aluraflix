package br.com.emersonmorgado.aluraflix.aluraflix.security.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private Boolean contaExpirada;
	private Boolean contaBloqueada;
	private Boolean credencialExpirada;
	private Boolean ativa;
	
	@ManyToMany(fetch = FetchType.EAGER)
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
	public void setName(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String getPassword() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
		
	public Boolean getContaExpirada() {
		return contaExpirada;
	}
	public void setContaExpirada(Boolean contaExpirada) {
		this.contaExpirada = contaExpirada;
	}
	public Boolean getContaBloqueada() {
		return contaBloqueada;
	}
	public void setAccountLocker(Boolean contaBloqueada) {
		this.contaBloqueada = contaBloqueada;
	}
	public Boolean getCredencialExpirada() {
		return credencialExpirada;
	}
	public void setCredencialExpirada(Boolean credencialExpirada) {
		this.credencialExpirada = credencialExpirada;
	}
	public Boolean getAtiva() {
		return ativa;
	}
	public void setAtiva(Boolean ativa) {
		this.ativa = ativa;
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
		return contaExpirada;
	}
	@Override
	public boolean isAccountNonLocked() {
		return contaBloqueada;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return credencialExpirada;
	}
	@Override
	public boolean isEnabled() {
		return ativa;
	}
}
