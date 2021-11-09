package com.backend.aula16.test;

import com.backend.aula16.dao.ServidorH2;
import com.backend.aula16.model.Dentista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Teste {
    Dentista dentista01;
    Dentista dentista02;
    Dentista dentista03;
    DentistaFactory factory;

    List<Dentista> cadastro;

    @BeforeEach
    void doBefore(){
        factory = new DentistaFactory();
        cadastro = new ArrayList<>();
        dentista01 = factory.getDentista(1, "Felipe", "Reusch", 01);
        dentista02 = factory.getDentista(2, "Jaja", "Baa", 02);
        dentista03 = factory.getDentista(3, "Lele", "Juju", 03);
    }

    @Test
    void getId(){
        assertEquals(new Dentista(1, "Felipe", "Reusch", 01).toString(),dentista01.toString());
    }

    @Test
    void getFactory(){
        cadastro.add(dentista01);
        cadastro.add(dentista02);
        cadastro.add(dentista03);


        assertEquals(java.util.Optional.of(2),factory.getContador());
    }
}
