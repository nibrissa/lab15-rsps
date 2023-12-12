package com.example.dev.DAO;

import java.util.List;
public interface RepositoryDAO<T> {
    public void insert(T o);
    public void update(T o);
    public void delete(Long Id);
    public T findById(Long Id);
    public List<T> findAll();
}



