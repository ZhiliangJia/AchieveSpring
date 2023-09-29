package ren.beginner.springframework.test.bean;

import ren.beginner.springframework.beans.BeansException;
import ren.beginner.springframework.beans.factory.BeanClassLoaderAware;
import ren.beginner.springframework.beans.factory.BeanFactory;
import ren.beginner.springframework.beans.factory.BeanFactoryAware;
import ren.beginner.springframework.beans.factory.BeanNameAware;
import ren.beginner.springframework.context.ApplicationContext;
import ren.beginner.springframework.context.ApplicationContextAware;

public class UserService implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ApplicationContextAware {

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    private String uid;
    private String company;
    private String location;
    private UserDao userDao;

    public String queryUserInfo() {
        System.out.println("查询用户信息" + userDao.queryUserName(uid));
        return "查询用户信息" + userDao.queryUserName(uid);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    @Override
    public String toString() {
        return "UserService{" +
                "uid='" + uid + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", userDao=" + userDao +
                '}';
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("Bean Name is：" + beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
