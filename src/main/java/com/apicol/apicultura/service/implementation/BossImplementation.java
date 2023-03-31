package com.apicol.apicultura.service.implementation;

import com.apicol.apicultura.model.Boss;
import com.apicol.apicultura.model.User;
import com.apicol.apicultura.repository.BossRepository;
import com.apicol.apicultura.repository.ProductRepository;
import com.apicol.apicultura.repository.UserRepository;
import com.apicol.apicultura.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BossImplementation implements BossService {
    @Autowired
    private BossRepository bossRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;


    public BossImplementation(BossRepository bossRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.bossRepository = bossRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ArrayList<Boss> findBossByLname(String Lname){
        ArrayList<Boss> bosses= (ArrayList<Boss>) bossRepository.findAll();
        ArrayList<Boss> result=null;
        for(Boss boss:bosses){
            if(boss.getLname().equals(Lname)){
                result.add(boss);
            }
        }
        return result;
    }

    @Override
    public void updateBoss(Boss boss, String fname, String lname, String password) {

           Boss updateBoss = bossRepository.findById(boss.getId()).get();
            updateBoss.setFname(fname);
            updateBoss.setLname(lname);
            updateBoss.setPassword(password);

        bossRepository.save(updateBoss);

    }
    @Override
    public List<User> findUsersByBoss() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findOneUserByBoss(Long id) {
        return userRepository.findById(id);
    }
    @Override
    public void updateBoss(Boss boss, String password) {

        Boss updateBoss = bossRepository.findById(boss.getId()).get();
            updateBoss.setPassword(password);
            bossRepository.save(updateBoss);


    }

    @Override
    public void deletingBoss(Boss boss1)
    {
        bossRepository.delete(boss1);
    }


/*    @Override
    public void updateProduct(Product product,String nameProduct,String brand,int quantites,float price){
       Product updateProduct = productRepository.findById(product.getId()).get();
       if(nameProduct!=null){
           updateProduct.setNameProduct(nameProduct);
       }
       if(brand!=null){
           updateProduct.setBrand(brand);
       }
       if(quantites!=null){
           updateProduct.setQuantites(quantites);
       }
       if(price!=null){
           updateProduct.setPrice(price);
       }
    }*/

    @Override
    public void deleteBoss(Boss boss){
        bossRepository.delete(boss);
    }

    @Override
    public void addingBoss(Boss boss)
    {
        bossRepository.save(boss);

    }


    @Override
    public boolean login(Boss boss,String email,String password){
    Boss verify = bossRepository.findById(boss.getId()).get();
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
