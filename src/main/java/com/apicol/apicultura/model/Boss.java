package com.apicol.apicultura.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Data
public class Boss {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fname;
    private String lname;
    private String email;

    private String password;



    @Override
    public String toString() {
        return "Boss{" +            "id=" + id +
            ", name='" + fname + '\'' +
            ", prenume='" + lname + '\'' +  '}'+"\n";}



}
