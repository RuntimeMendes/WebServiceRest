package br.com.ustore.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.ustore.EntityManager.JpaEntityManager;
import br.com.ustore.model.UsuarioModel;

@Path("/usuario")
public class UsuarioService {
	private JpaEntityManager JPAEM = new JpaEntityManager();
	private EntityManager objEM = JPAEM.getEntityManager();

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<UsuarioModel> listar() {

		try {
			String query = "select c from UsuarioModel c";
			List<UsuarioModel> usuarios = objEM.createQuery(query, UsuarioModel.class).getResultList();
			objEM.close();
			return usuarios;
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@GET
	@Path("/buscar/{codigo}")
	@Produces("application/json")
	public UsuarioModel buscar(@PathParam("codigo") int codigo) {
		try {
			UsuarioModel usuario = objEM.find(UsuarioModel.class, codigo);
			objEM.close();
			return usuario;
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}

	}

	@POST
	@Path("/cadastrar")
	@Consumes("application/json")
	public Response cadastrar(UsuarioModel objUsuario) {
		try {
			objEM.getTransaction().begin();
			objEM.persist(objUsuario);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200).entity("cadastro realizado.").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
	
	 @PUT
	 @Path("/alterar")
	 @Consumes("application/json")
	 public Response alterar(UsuarioModel objUsuario){
	 try {
	 objEM.getTransaction().begin();
	 objEM.merge(objUsuario);
	 objEM.getTransaction().commit();
	 objEM.close();
	 return Response.status(200).entity("cadastro alterado.").build();
	 } catch (Exception e) {
	 throw new WebApplicationException(500);
	 }
		  		  
	 }
	  @DELETE
	  @Path("/excluir/{codigo}")
	  public Response excluir(@PathParam("codigo") int codigo){
	  try {
	  UsuarioModel objUsuario = objEM.find(UsuarioModel.class, codigo);
	 
	  objEM.getTransaction().begin();
	  objEM.remove(objUsuario);
	  objEM.getTransaction().commit();
	  objEM.close();
	 
	  return Response.status(200).entity("cadastro excluído.").build();
	  } catch (Exception e) {
	  throw new WebApplicationException(500);

	  }
	  }
	
}	

