package rs.djm.jees.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import rs.djm.jees.model.data.Account;

/**
 * @author djm.rs
 */
public class UserDao {

    private static final UserDao instance = new UserDao();

    private UserDao() {
    }

    public static UserDao getInstance() {
        return instance;
    }

    // TODO; for username get user's hash
    public boolean validate(EntityManager em, String username, String password) {
        String hashPassword = calculateHash(password);

        try {
            final String queryValidateUser = ""
                    + "SELECT ac "
                    + "FROM Account ac "
                    + "WHERE ac.username =:username and ac.password =:password";

            TypedQuery<Account> query = em
                    .createQuery(queryValidateUser, Account.class);
            query.setParameter("username", username);
            query.setParameter("password", hashPassword);

            query.getSingleResult();
            return true;
        } catch (NoResultException nre) {
            return false;
        }

    }

    private String calculateHash(String password) {
        return Integer.toHexString(password.hashCode()).toUpperCase();
    }

}
