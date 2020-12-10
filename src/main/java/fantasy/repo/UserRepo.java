package fantasy.repo;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fantasy.model.UserFantasy;

@Component
@Repository
public class UserRepo {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void insertWithQuery(UserFantasy user) {
		entityManager.createNativeQuery("INSERT INTO user_p (user_name,user_id,user_mailId) VALUES (?,?,?)")
				.setParameter(1, user.getUserName()).setParameter(2, UUID.randomUUID())
				.setParameter(3, user.getUserMail()).executeUpdate();
	}

	public UserFantasy fetchUser(String User_id) {
		UserFantasy user = (UserFantasy) entityManager
				.createNativeQuery("SELECT * FROM user_p where user_id = ?", UserFantasy.class).setParameter(1, User_id)
				.getSingleResult();
		return user;
	}

	public int fetchID(String user_mail) {
		Integer user_id = (Integer) entityManager
				.createNativeQuery("Select user_id from user where user_mail = ?", Integer.class)
				.setParameter(1, user_mail).getSingleResult();
		return (user_id);
	}

	public int ifUser(int user_id) {
		Integer count = (Integer) entityManager
				.createNativeQuery("Select count(*) from user_p where user_id = ?", Integer.class)
				.setParameter(1, user_id).executeUpdate();
		return count;
	}
}
