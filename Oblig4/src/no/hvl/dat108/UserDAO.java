
package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserDAO {
	
	@PersistenceContext(name = "userPU")
    private EntityManager em;
	
	public List<User> getAllUsers() {
		return em.createQuery("SELECT b FROM User b", User.class).getResultList();
	}
	
	public boolean checkUniquePhone(String phone){
		List<User> list = em.createQuery("SELECT b FROM User b", User.class).getResultList();
		
		for(User s : list) {
			if(s.getPhone().equals(phone)) {
				return false;
			}
		}
		return true;
			
	}
	
	public synchronized User getUser(String name) {
		return em.find(User.class, name);
	}

	public synchronized void createNewUser(User newUser) {
		em.persist(newUser);
	}
}


