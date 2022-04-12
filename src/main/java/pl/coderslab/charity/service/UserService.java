package pl.coderslab.charity.service;

import pl.coderslab.charity.model.User;

public interface UserService {

    void saveSimpleUser(User user);

    User findByUsername(String username);

}
