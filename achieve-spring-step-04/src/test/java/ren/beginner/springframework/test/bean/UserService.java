package ren.beginner.springframework.test.bean;

public class UserService {

    private String uid;

    private UserDao userDao;

    public UserService() {
    }

    public UserService(String uid) {
        this.uid = uid;
    }

    public UserService(String uid, UserDao userDao) {
        this.uid = uid;
        this.userDao = userDao;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息" + userDao.queryUserName(uid));
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
