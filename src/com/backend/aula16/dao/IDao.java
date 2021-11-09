package com.backend.aula16.dao;

public interface IDao <T> {
    public T insert(T t);
    public void delete(Integer id); // entra o void pq nao precisa saber o objeto que sera deletado
    public void select(Integer id);
    public void selectAll();



}