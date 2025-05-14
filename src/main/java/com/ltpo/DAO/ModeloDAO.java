package com.ltpo.DAO;

import com.ltpo.model.Modelo;

import javax.persistence.*;
import java.util.List;

public class ModeloDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("oficinaPU");
    private EntityManager em = emf.createEntityManager();

    public void salvar(Modelo modelo) {
        try {
            em.getTransaction().begin();
            em.persist(modelo);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Modelo> buscarTodos() {
        try {
            TypedQuery<Modelo> query = em.createQuery("SELECT m FROM Modelo m", Modelo.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Modelo buscarPorId(Long id) {
        try {
            return em.find(Modelo.class, id);
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
