package service;
import dao.UserDao;
import model.User;
import util.PasswordUtil;

public class AuthService {
    
    private UserDao userDao = new UserDao();

    public boolean register(String username, String email, String password,String role){
        String hashedPassword = PasswordUtil.hashPassword(password);
        User user = new User(username, email, hashedPassword, role);
        return userDao.register(user);
    }

    public String login(String username, String password){
        String hashedPassword = PasswordUtil.hashPassword(password);
        return userDao.login(username, hashedPassword);

    }
}
