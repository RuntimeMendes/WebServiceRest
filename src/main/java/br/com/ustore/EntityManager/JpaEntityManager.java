
package br.com.ustore.EntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaEntityManager {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("app_crud_usuario");
	 private EntityManager em = factory.createEntityManager();
	

	 public EntityManager getEntityManager(){
		  return em;
		  }


}
