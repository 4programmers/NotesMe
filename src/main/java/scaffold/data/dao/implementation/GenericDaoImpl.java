package scaffold.data.dao.implementation;

import scaffold.data.dao.GenericDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public abstract class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
    private Class<T> type;

    @PersistenceContext
    private EntityManager entityManager;

    public GenericDaoImpl() {
    }

    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

    public PK create(T o) {
        entityManager.persist(o);
        return (PK) entityManager.merge(o);
    }

    public T read(PK id) {
        return (T) entityManager.find(type, id);
    }

    public void update(T o) {
        entityManager.merge(o);
    }

    public void delete(T o) {
        entityManager.remove(o);
    }

    public List<T> getAll(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(type);
        Root<T> rootEntry = cq.from(type);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
}
