package nghiant.interview.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import nghiant.interview.entity.Student;

public class StudentDAO extends HibernateDaoSupport {
    public void addStudent(Student student) {
	getHibernateTemplate().save(student);
    }
}
