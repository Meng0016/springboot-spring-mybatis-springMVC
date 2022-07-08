package com.ydlclass;

public class UserService {
   /* private UserDao userDao=(UserDao) YdlContainer.MAP.get("userDao");*/
    private static final UserService userService = new UserService();
    private UserDao userDao;
    private AdressDao adressDao;

    public UserService(UserDao userDao, AdressDao adressDao) {
        this.userDao = userDao;
        this.adressDao = adressDao;
    }

    public UserService() {
    }

    public static UserService create(){
        return userService;
       /* return new UserDao();*/
    }
    public UserDao create2(){
        return new UserDao();
    }
    public void hello(){
        userDao.hello();
    }

    public UserService(AdressDao adressDao) {
        this.adressDao = adressDao;
    }

    public void setAdressDao(AdressDao adressDao) {
        this.adressDao = adressDao;
    }

    public void setUserDao(UserDao userDao){
        this.userDao =userDao;
   }
}
