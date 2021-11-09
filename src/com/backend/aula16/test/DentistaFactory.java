package com.backend.aula16.test;

import com.backend.aula16.model.Dentista;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DentistaFactory {
    private static Map<String, Dentista> flyweight = new HashMap<>();
    private static Integer contador = 0;

    public Dentista getDentista(int id, String nome, String sobrenome, int matricula) {
        String dentista = String.format("id:%snome:%ssobrenome:%smatricula:%s", id,nome,sobrenome,matricula);

        if(!flyweight.containsKey(id)){
            flyweight.put(dentista, new Dentista(id,nome,sobrenome,matricula));
            contador++;
        }
        return flyweight.get(id);
    }

    public Integer getContador() {
        return contador;
    }
}
