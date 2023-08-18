package com.Student.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.Student.Entity.Student;
import com.Student.Entity.StudentResult;

@Component("result_dao")
@Transactional
public class Result_DAO {

	@Autowired
	public HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void addResult(ArrayList<StudentResult> studentmarks) {

		studentmarks.forEach(v -> {
			int i = (Integer) hibernateTemplate.save(v);
		});

	}

	public List<StudentResult> getresultByStudent(int student_id) {

		List<StudentResult> students = (List<StudentResult>) hibernateTemplate
				.findByNamedParam("from StudentResult where student_id = :student_id", "student_id", student_id);

		return students;
	}

	public List<StudentResult> getAll() {

		return hibernateTemplate.loadAll(StudentResult.class);
	}

}
