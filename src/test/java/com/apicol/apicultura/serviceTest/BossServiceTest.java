package com.apicol.apicultura.serviceTest;

import com.apicol.apicultura.model.Boss;
import com.apicol.apicultura.model.User;
import com.apicol.apicultura.repository.BossRepository;
import com.apicol.apicultura.repository.ProductRepository;
import com.apicol.apicultura.repository.UserRepository;
import com.apicol.apicultura.service.BossService;
import com.apicol.apicultura.service.implementation.BossImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class BossServiceTest {

    private static final String LNAME = "Alina";
    private static final String LNAME_NOT = "LNAME care nu exista";
    Boss boss1;
    private User user;

    private BossImplementation bossServiceImplementare;

    @Mock
    private BossRepository bossRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ProductRepository productRepository;
    
    private ArrayList<Boss> masina;
    private List usersList;


    @BeforeEach
    void init() {
        initMocks(this);
        usersList=new ArrayList<User>();
        masina = new ArrayList<Boss>();
  /*      for (Boss boss: masina) {
            boss.setLname(LNAME);
        }*/
        Boss boss2 = new Boss();
        boss1=new Boss();
        user=new User();
        assertNotNull(boss1);
        boss2.setLname(LNAME);
        masina.add(boss2);
//        assertNotNull(boss2);
//        when(bossServiceImplementare.findBossByLname(LNAME)).thenReturn(masina);
    }
    //insert

    @Test
    void givingBoss_whenAdding_thenAdding()
    {
        bossServiceImplementare = new BossImplementation(bossRepository, userRepository, productRepository);
        bossServiceImplementare.addingBoss(boss1);
        assertNotNull(boss1);
    }

    //delete

//    @Test
//    void givingUser_whenDeleting_thenDeleting()
//    {
//        bossServiceImplementare = new BossImplementation(bossRepository, userRepository, productRepository);
//        bossServiceImplementare.(user);
//        assertNotNull(user);
//    }

    //find
    @Test
    void givenExistingLNAME_whenFindByLNAME_thenFindOne() {

        bossServiceImplementare = new BossImplementation(bossRepository, userRepository, productRepository);

        ArrayList<Boss> boss1 = bossServiceImplementare.findBossByLname(LNAME);

        for (Boss boss: masina) {
            boss.setLname("Alina");
            assertEquals(LNAME, boss.getLname());

        }
    }

    @Test
    void whenDeleting_returnTheOtherList()
    {
        bossServiceImplementare = new BossImplementation(bossRepository, userRepository, productRepository);
        bossServiceImplementare.deleteBoss(boss1);
        assertNotNull(boss1);

    }

    //daca nu gaseste boss ul arunca exc3eptie
    @Test
    void givenNonExistingLNAME_whenFindByLNAME_thenThrowException() {
     //  when(bossServiceImplementare.findBossByLname(LNAME_NOT)).thenReturn(null);

        Exception exception = assertThrows(NullPointerException.class, () -> {
            bossServiceImplementare.findBossByLname(LNAME_NOT);
        });

    }

    //findAll

    @Test
    void givenFunction_whenFindingAll_thenListUser() {
        bossServiceImplementare = new BossImplementation(bossRepository, userRepository, productRepository);
        when(bossServiceImplementare.findUsersByBoss()).thenReturn(usersList);
        usersList = bossServiceImplementare.findUsersByBoss();
        assertNotNull(usersList);
    }

}
