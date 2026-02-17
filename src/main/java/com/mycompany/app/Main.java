package com.mycompany.app;

import java.util.Random;

import com.mycompany.app.entities.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_persistence_unit");

    EntityManager em = emf.createEntityManager(); // Represent the persistence context
    Random rnd = new Random();
    try {
      em.getTransaction().begin();
      for(int i=0;i<11;i++){
        Book book = new Book();
        int rndNum = rnd.nextInt(100);
        book.setName("My Book "+i+" Num " + rndNum);
        book.setIsbn("123-" + i + "-" + rndNum);
        em.persist(book);
      }
      em.getTransaction().commit();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    finally{
      em.close();
    }
  }
}