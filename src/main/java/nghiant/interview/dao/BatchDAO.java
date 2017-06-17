package nghiant.interview.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import nghiant.interview.entity.Batch;

public class BatchDAO extends HibernateDaoSupport {

    public void addBatch(Batch batch) {
	getHibernateTemplate().save(batch);
    }

    @SuppressWarnings("unchecked")
    public List<Batch> getBatchList() {
	String query = "select b from Batch b";
	return getHibernateTemplate().find(query);
    }
}