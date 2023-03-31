package com.apicol.apicultura.service;

import com.apicol.apicultura.model.Product;
import com.apicol.apicultura.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {
    List<Product> findProductbyUser();
    Optional<Product> findOneProductByUser(Long id);
    void updateUser(User user, String lname, String password, String phoneNumber, String adress);
    void updateUser(User user, String password, String phoneNumber, String adress);
    void updateUser(User user, String phoneNumber, String adress);
    void updateUserAdress(User user, String adress);
    void updateUserPhone(User user, String phoneNumber);
//    void updateUser(User user, String adress);
    void updateUserPassword(User user, String password);
    boolean login(User boss, String email, String password);

}
