package com.ltpo.DAO;

import com.ltpo.model.Usuarios;

import javax.persistence.*;
import java.util.List;

public class UsuariosDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("oficinaPU");
    private EntityManager em = emf.createEntityManager();

    public void salvar(Usuarios usuario) {
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Usuarios> buscarTodos() {
        try {
            TypedQuery<Usuarios> query = em.createQuery("SELECT u FROM Usuarios u", Usuarios.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Usuarios buscarPorId(Long id) {
        try {
            return em.find(Usuarios.class, id);
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
