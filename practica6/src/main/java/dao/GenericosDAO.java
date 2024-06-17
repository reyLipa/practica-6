package dao;


import java.util.ArrayList;

public interface GenericosDAO<T> {
    void crear(T t);

    ArrayList<T> listar();
}