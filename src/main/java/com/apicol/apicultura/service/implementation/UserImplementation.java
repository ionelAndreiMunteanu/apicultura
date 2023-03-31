package com.apicol.apicultura.service.implementation;

import com.apicol.apicultura.model.Product;
import com.apicol.apicultura.model.User;
import com.apicol.apicultura.repository.ProductRepository;
import com.apicol.apicultura.repository.UserRepository;
import com.apicol.apicultura.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImplementation implements UserService
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    public UserImplementation( UserRepository userRepository, ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Product> findProductbyUser() {
        return (List<Product>) productRepository.findAll();
    }
    @Override
    public Optional<Product> findOneProductByUser(Long id) {
        return productRepository.findById(id);
    }


    @Override
    public void updateUser(User user, String lname, String password, String phoneNumber, String adress) {

        User updateUser = userRepository.findById(user.getId()).get();
        updateUser.setLname(lname);
        updateUser.setPassword(password);
        updateUser.setPhoneNumber(phoneNumber);
        updateUser.setAdress(adress);
        userRepository.save(updateUser);

    }
    @Override
    public void updateUser(User user, String password, String phoneNumber, String adress) {

        User updateUser = userRepository.findById(user.getId()).get();
        updateUser.setPassword(password);
        updateUser.setPhoneNumber(phoneNumber);
        updateUser.setAdress(adress);
        userRepository.save(updateUser);

    }
    @Override
    public void updateUser(User user, String phoneNumber, String adress) {

        User updateUser = userRepository.findById(user.getId()).get();
        updateUser.setPhoneNumber(phoneNumber);
        updateUser.setAdress(adress);
        userRepository.save(updateUser);

    }
    @Override
    public void updateUserAdress(User user, String adress) {

        User updateUser = userRepository.findById(user.getId()).get();
        updateUser.setAdress(adress);
        userRepository.save(updateUser);

    }

    @Override
    public void updateUserPhone(User user, String phoneNumber) {

        User updateUser = userRepository.findById(user.getId()).get();
        updateUser.setPhoneNumber(phoneNumber);
        userRepository.save(updateUser);

    }
    @Override
    public void updateUserPassword(User user, String password) {

        User updateUser = userRepository.findById(user.getId()).get();
        updateUser.setPassword(password);
        userRepository.save(updateUser);

    }

    @Override
    public boolean login(User boss, String email, String password){
        User verify = userRepository.findById(boss.getId()).get();
        if(email.equals(verify.getEmail())){
            if(password.equals(verify.getPassword())){
                return true;
            }else {
                System.out.println("Incorrect password");
                return false;
            }
        }else{
            System.out.println("Incorrect email or password!");
            return false;
        }


    }


}
