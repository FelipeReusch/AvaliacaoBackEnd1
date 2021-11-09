package com.backend.aula16;

import com.backend.aula16.dao.ServidorH2;
import com.backend.aula16.model.Dentista;
import org.apache.log4j.PropertyConfigurator;

public class Main {


    public static void main(String[] args) {

        PropertyConfigurator.configure("log4j.properties");

        Dentista dent = new Dentista(1,"Helmut", "Reusch", 101);
        Dentista dent2 = new Dentista(2,"Rodrigo", "Rocha", 102);
        Dentista dent3 = new Dentista(3,"Lauriani", "Muller", 103);

        ServidorH2 servidor = new ServidorH2();

        servidor.insert(dent);
        servidor.select(dent.getId());

        servidor.insert(dent2);
        servidor.select(dent2.getId());

        servidor.insert(dent3);
        servidor.select(dent3.getId());
        servidor.selectAll();
	// write your code here
    }
}
