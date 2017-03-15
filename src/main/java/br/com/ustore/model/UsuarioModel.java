package br.com.ustore.model;
import java.util.Date;
 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
 import javax.persistence.Table;
 import javax.persistence.Temporal;
 import javax.persistence.TemporalType;

@Entity
@Table(name="usuario")
public class UsuarioModel {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	 Long codigo;

	 @Column(name="nome")
	 String nome;
	 @Column(name="email")
	 String email;
	 
	 @Column(name="senha")
	 String senha;
	 
	 @Column(name="telefone")
	 String telefone;
	 
	 @Column(name="data_cadastro")
	 @Temporal(TemporalType.TIMESTAMP)
	 Date  data_cadastro;

	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	 
	 

	
	
	

}
