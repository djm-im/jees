package rs.djm.jees.model.service;

import javax.persistence.EntityManager;
import rs.djm.jees.model.dao.EntityManagerWrapper;
import rs.djm.jees.model.dao.UserDao;
import rs.djm.jees.model.data.UserSessionObject;

/**
 * @author djm.rs
 */
public class UserService {

    private static final UserService instance = new UserService();

    private UserService() {
    }

    public static UserService getInstance() {
        return instance;
    }

    public UserSessionObject getUserDataForSession(String username, String password) {

        EntityManager em = EntityManagerWrapper.createEntityManager();

        try {
            if (UserDao.getInstance().validate(em, username, password)) {
                return new UserSessionObject(username, true);
            }
        } finally {
            em.close();
        }

        return new UserSessionObject(username, false);
    }
}
