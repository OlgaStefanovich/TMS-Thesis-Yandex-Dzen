package by.dzen.service;

import by.dzen.dao.UserDaoImpl;
import by.dzen.dto.user.UserAuthDTO;
import by.dzen.dto.user.UserRegDTO;
import by.dzen.entity.User;
import by.dzen.service.exception.DuplicateUserException;
import by.dzen.service.exception.NoSuchUserException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDaoImpl userDao;

    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public void createUser(UserRegDTO userRegDTO) {
        if (userDao.containsByLogin(userRegDTO.getLoginUserDTO()).isPresent()) {
            throw new DuplicateUserException("Such user is already");
        }
        User user = new User(userRegDTO.getNameUserDTO(),userRegDTO.getLoginUserDTO(),userRegDTO.getPasswordUserDTO());
        userDao.createUser(user);
    }

    public boolean authorizeUser(UserAuthDTO userAuthDTO) {
        User user = new User (userAuthDTO.getLoginAuthUser(),userAuthDTO.getPasswordAuthUser());
        if (userDao.containsUser(user).isEmpty()) {
            throw new NoSuchUserException("No such user in DB");
        }
        return true;
    }

    public User getAuthUserIdAndName(UserAuthDTO userAuthDTO) {
        User user = new User(userAuthDTO.getLoginAuthUser(),userAuthDTO.getPasswordAuthUser());
        User userAuth = new User();
        if (userDao.containsUser(user).isPresent()) {
             userAuth =  userDao.containsUser(user).get();
        }
        return userAuth;
    }

}
