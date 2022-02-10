package web.service;

import web.Model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    public  void change(User user, long id);

    List<User> listUsers();

    User findUserById(long id);

    void delete(long id);
}
