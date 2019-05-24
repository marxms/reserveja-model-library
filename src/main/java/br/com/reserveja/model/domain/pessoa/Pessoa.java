package br.com.reserveja.model.domain.pessoa;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import br.com.reserveja.model.domain.endereco.Endereco;
import br.com.reserveja.model.domain.telefone.Telefone;
import br.com.reserveja.model.domain.user.User;

@Entity
public class Pessoa implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -469902889166847938L;

	@Id
	@GenericGenerator(name="pessoaIncrement" , strategy="increment")
	@GeneratedValue(generator="pessoaIncrement")
	private Long id;
	
	private String nome;
	
	private String sobrenome;
	
	private Date dtnascimento;
	
	@Transient
	@ManyToOne(cascade=CascadeType.DETACH, fetch=FetchType.LAZY, optional= true)
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="pessoa")
	private List<Telefone> telefone;
	
	private String email;
	
	@Enumerated(EnumType.STRING)
	private EnumSexo sexo;
	
	@Transient
	@OneToOne(fetch=FetchType.LAZY, optional=true, cascade = CascadeType.DETACH, mappedBy="pessoa")
	private User user;
	

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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDtnascimento() {
		return dtnascimento;
	}

	public void setDtnascimento(Date dtnascimento) {
		this.dtnascimento = dtnascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EnumSexo getSexo() {
		return sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
