package br.unipar.programacaoweb.repository;

import br.unipar.programacaoweb.model.Endereco;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.Optional;

public class EnderecoRepository {
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public EnderecoRepository() {
        this.emf = Persistence.createEntityManagerFactory("consomeCepPU");
        this.em = emf.createEntityManager();
    }

    public Optional<Endereco> findByCep(String cep) {
        TypedQuery<Endereco> query = em.createQuery(
                "SELECT e FROM Endereco e WHERE e.cep = :cep", Endereco.class);
        query.setParameter("cep", cep);
        return query.getResultList().stream().findFirst();
    }

    public void save(Endereco endereco) {
        try {
            em.getTransaction().begin();
            em.merge(endereco);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao salvar endereço: " + e.getMessage(), e);
        }
    }

    public void close() {
        em.close();
        emf.close();
    }
}