package com.employ.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.employ.Detalis.Entity.*;

@Component("employdao")
@Transactional
public class EmployDao {
	
	@Autowired
	public HibernateTemplate hibernateTemplate;

	public int insert(Employ employ) {
		int i = (Integer) hibernateTemplate.save(employ);

		return i;
	}
	public int update(Employ employ) {
		try
		{
		hibernateTemplate.update(employ);
			return 1;
		}
		catch(Exception e)
		{
			System.out.println("Employ Don't Exit");
			return 0;
		}
		}
	
	public Employ getId(int id)
	{
		Employ employ = hibernateTemplate.get(Employ.class,id);
		return employ;
	}
	
	public int delete(int id)
	{
		
		Employ employ = hibernateTemplate.get(Employ.class,id);
		hibernateTemplate.delete(employ);
		return 0;
	}
	public List<Employ> getAll() {
        
        return hibernateTemplate.loadAll( Employ.class);
    }

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	

}
