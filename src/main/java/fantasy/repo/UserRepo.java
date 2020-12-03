package fantasy.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fantasy.model.User;

@Component
@Repository
public class UserRepo {
	@PersistenceContext
    private EntityManager entityManager;
	
	@Transactional
	public void insertWithQuery(User user) {
	    entityManager.createNativeQuery("INSERT INTO user (user_name,user_id,user_mailId) VALUES (?,?,?)")
	      .setParameter(1, user.getUser_name() )
	      .setParameter(2,user.getUser_id())
		  .setParameter(3, user.getUser_mail())
	      .executeUpdate();    
	}
	public User fetchUser(String User_id) {
	User user = (User)entityManager.createNativeQuery("SELECT * FROM user where user_id = ?", User.class)
			.setParameter(1, User_id)
			.getSingleResult();
		return user;
	}
	public int fetchID(String user_mail) {
		Integer user_id = (Integer)entityManager.createNativeQuery("Select user_id from user where user_mail = ?",Integer.class)
				.setParameter(1, user_mail)
				.getSingleResult();
		return (user_id);
	}
	
}
