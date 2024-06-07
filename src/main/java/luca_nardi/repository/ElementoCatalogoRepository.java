package luca_nardi.repository;

import luca_nardi.model.ElementoCatalogo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ElementoCatalogoRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaPU");

    public void save(ElementoCatalogo elemento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(elemento);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteByIsbn(String isbn) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ElementoCatalogo elemento = em.find(ElementoCatalogo.class, isbn);
        if (elemento != null) {
            em.remove(elemento);
        }
        em.getTransaction().commit();
        em.close();
    }

    public ElementoCatalogo findByIsbn(String isbn) {
        EntityManager em = emf.createEntityManager();
        ElementoCatalogo elemento = em.find(ElementoCatalogo.class, isbn);
        em.close();
        return elemento;
    }

    public List<ElementoCatalogo> findAll() {
        EntityManager em = emf.createEntityManager();
        List<ElementoCatalogo> elementi = em.createQuery("from ElementoCatalogo", ElementoCatalogo.class).getResultList();
        em.close();
        return elementi;
    }
}

