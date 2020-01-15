package services;

import models.service.UserServiceModel;

public interface UsersService {
    void register(String username, String email, String password, String confirmPassword,String registrationType) throws Exception;

    UserServiceModel login(String username, String password);
}
