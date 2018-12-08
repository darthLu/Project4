package lwade;

import org.springframework.stereotype.Repository;
import javax.persistence.*;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class QuoteDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Quotes q){
        try {
            entityManager.persist(q);
        }catch(Exception e){

        }
    }
    public Quotes getById(int id) {
        return entityManager.find(Quotes.class, id);
    }

    public void updateQuote(Quotes q) {
        if(entityManager.contains(q))
            entityManager.merge(q);
        else
            create(q);
    }

    public void deleteQuote(int id) {
        Quotes x = entityManager.find(Quotes.class, id);
        if(x != null)
            entityManager.remove(x);
    }
}
