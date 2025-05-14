package com.ltpo.DAO;

import com.ltpo.model.Automovel;

import javax.persistence.*;
import java.util.List;

public class AutomovelDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("oficinaPU");
    private EntityManager em = emf.createEntityManager();

    public void salvar(Automovel automovel) {
        try {
            em.getTransaction().begin();

            if (automovel.getModelo().getId() == null || !em.contains(automovel.getModelo())) {
                em.merge(automovel.getModelo());
            }

            em.persist(automovel);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Automovel> buscarTodos() {
        try {
            TypedQuery<Automovel> query = em.createQuery("SELECT a FROM Automovel a", Automovel.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Automovel buscarPorId(Long id) {
        try {
            return em.find(Automovel.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void fechar() {
        em.close();
        emf.close();
    }
}
