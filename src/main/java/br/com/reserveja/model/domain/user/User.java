package br.com.reserveja.model.domain.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import br.com.reserveja.model.domain.pessoa.Pessoa;

@Entity
@Table(name="tb_user")
public class User {

	@Id
	@GenericGenerator(name="userIncrement" , strategy="increment")
	@GeneratedValue(generator="userIncrement")	
	private Integer id;

	@Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
	@Column(unique = true, nullable = false)
	private String username;

	@Column(unique = true, nullable = false)
	private String email;

	@Size(min = 8, message = "Minimum password length: 8 characters")
	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
	List<Role> roles;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pessoa_id", nullable=true)
	private Pessoa pessoa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
