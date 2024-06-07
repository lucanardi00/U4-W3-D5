package luca_nardi.repository;

import luca_nardi.model.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PrestitoRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaPU");

    public void save(Prestito prestito) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(prestito);
        em.getTransaction().commit();
        em.close();
    }

    public List<Prestito> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Prestito> prestiti = em.createQuery("from Prestito", Prestito.class).getResultList();
        em.close();
        return prestiti;
    }

}

