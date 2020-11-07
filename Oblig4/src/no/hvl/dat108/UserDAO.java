
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
		return em.createQuery("SELECT b FROM oblig4.user1 b", User.class).getResultList();
	}
	
	public boolean checkUniquePhone(String phone){
		List<User> list = em.createNamedQuery("SELECT phone FROM oblig4.user1 b", User.class).getResultList();
		
		for(User s : list) {
			if(s.getPhone().equals(phone)) {
				return true;
			}
		}
		return false;
			
	}
	
	public User getUser(String name) {
		return em.find(User.class, name);
	}

	public void createNewUser(User newUser) {
		em.persist(newUser);
	}
}


