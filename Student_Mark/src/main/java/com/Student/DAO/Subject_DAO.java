package com.Student.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.Student.Entity.Subject;

@Component("subjectDao")
@Transactional
public class Subject_DAO {

	@Autowired
	public HibernateTemplate hibernateTemplate;

	public int insertSubject(Subject subject) {
		int i = (Integer) hibernateTemplate.save(subject);

		return i;
	}

	public List<Subject> getAllSubject() {

		return hibernateTemplate.loadAll(Subject.class);

	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
