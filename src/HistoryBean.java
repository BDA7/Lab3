import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "History", eager = true)
@ApplicationScoped
public class HistoryBean {

    private EntityManager em = DbEntity.em;

    public List<Result> getResults() {
        DbEntity.em.getTransaction().begin();
        List<Result> list = DbEntity.em.createQuery("SELECT c FROM Result c", Result.class).getResultList();
        DbEntity.em.getTransaction().commit();
        return list;
    }

    private List<Result> results;

    public HistoryBean() {
        results = new ArrayList<Result>();
    }

}
