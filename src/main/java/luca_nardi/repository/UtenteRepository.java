package luca_nardi.repository;

import luca_nardi.model.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UtenteRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaPU");

    public void save(Utente utente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(utente);
        em.getTransaction().commit();
        em.close();
    }

    public List<Utente> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Utente> utenti = em.createQuery("from Utente", Utente.class).getResultList();
        em.close();
        return utenti;
    }

}

