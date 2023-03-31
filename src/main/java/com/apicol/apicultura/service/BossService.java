package com.apicol.apicultura.service;

import com.apicol.apicultura.model.Boss;
import com.apicol.apicultura.model.Product;
import com.apicol.apicultura.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public interface BossService {

    //aici punem functiile pe care le vrem
    ArrayList<Boss> findBossByLname(String Lname);
    void updateBoss(Boss boss, String fname, String lname, String password);
    List<User> findUsersByBoss();
    void addingBoss(Boss boss);
    boolean login(Boss boss, String email, String password);
    Optional<User> findOneUserByBoss(Long id);
    void updateBoss(Boss boss, String password);
    void deletingBoss(Boss boss1);
    void deleteBoss(Boss boss);



}
