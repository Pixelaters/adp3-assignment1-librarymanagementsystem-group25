package za.ac.cput.repository;
/*
    Breyton Ernstzen (217203027)
    ADP3 - Assignment 1: Group 25
    Date: 31 March 2022
 */
public interface IRepository <T,ID> {
    //Repository with CRUD operations
    //Don't do anything in this class and don't modify any code here
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
