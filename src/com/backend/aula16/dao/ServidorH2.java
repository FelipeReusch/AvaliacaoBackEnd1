package com.backend.aula16.dao;

import com.backend.aula16.config.ConfigJDBC;
import com.backend.aula16.model.Dentista;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ServidorH2 implements IDao<Dentista> {

    private static final Logger logger = Logger.getLogger(ServidorH2.class);

    private ConfigJDBC config = new ConfigJDBC(); // criando o objeto

    @Override
    public Dentista insert(Dentista dentista){
        String query = String.format("INSERT INTO Dentista VALUES('%s','%s','%s','%s' )",
                dentista.getId(), dentista.getNome(), dentista.getSobrenome(), dentista.getMatricula());

        //buscar a conexao com H2
        try{
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();

            stmt.execute(query);
            stmt.close();

        }catch (Exception e){
            logger.error("|| CANNOT REPEAT AN ID ||" + e.getMessage());
        }

        return dentista;
    }

    @Override
    public void delete(Integer id) {
        String query = String.format("DELETE FROM Dentista WHERE id = %s", id);

        try{
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();

            stmt.execute(query);
            stmt.close();


        }catch (Exception e){
            logger.error("|| CANNOT REPEAT AN ID ||" + e.getMessage());
        }
    }

    @Override
    public void select(Integer id) {
        String query = String.format("SELECT * FROM Dentista WHERE id = %s", id);
        try{
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){ // saber se tenho outro resultado e a hora de parar
                System.out.println("------------------");
                System.out.println(result.getInt(1));
                System.out.println(result.getString(2));
                System.out.println(result.getString(3));
                System.out.println(result.getInt(4));
                System.out.println("------------------");
                logger.debug("O Dentista: " + result.getString(1) + " foi cadastrado!");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void selectAll() {
        String query = String.format("SELECT * FROM Dentista");
        try{
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){ // saber se tenho outro resultado e a hora de parar
                System.out.println("------------------");
                System.out.println(result.getInt(1));
                System.out.println(result.getString(2));
                System.out.println(result.getString(3));
                System.out.println(result.getInt(4));
                System.out.println("------------------");
                logger.debug("O Dentista: " + result.getString(1) + " foi cadastrado!");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
