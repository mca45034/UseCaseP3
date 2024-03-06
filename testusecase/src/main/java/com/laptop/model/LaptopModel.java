package com.laptop.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.rays.laptopdto.LaptopDTO;

public class LaptopModel {

	public void add(LaptopDTO dto) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(dto);
		tx.commit();
		session.close();
	}
	public void update(LaptopDTO dto) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(dto);
		tx.commit();
		session.close();
	
	}
	
	public void delete(LaptopDTO dto) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(dto);
		tx.commit();
		session.close();
	
	}
	
	public LaptopDTO findByPk(int pk) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
          LaptopDTO dto = (LaptopDTO) session.get(LaptopDTO.class, pk);
		session.close();
		return dto;
		
		
	}
	
	
	public List search(LaptopDTO dto,int pageNo,int pageSize) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Criteria criteria=session.createCriteria(LaptopDTO.class);
		if(dto!=null) {
			if(dto.getName()!=null && dto.getName().length()>0) {
				criteria.add(Restrictions.like("name", dto.getName()+"%"));
			}
//			if(dto.getName()!=null && dto.getName().length()>0) {
//				criteria.add(Restrictions.like("model", dto.getModel()+"%"));
//			}
//			
		}
		if(pageNo>0) {
			pageNo=(pageNo-1)*pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		List list=criteria.list();
		session.close();
		return list;
	}


	
}
