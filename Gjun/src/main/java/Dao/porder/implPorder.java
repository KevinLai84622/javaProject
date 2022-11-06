package Dao.porder;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Dao.DbConnection;
import Model.porder;

public class implPorder implements porderDao{

	public static void main(String[] args) {
		/*
		porder p = new porder("F桌", 4, 2, 4);
		new implPorder().add(p);
		*/
		
//		System.out.println(new implPorder().queryAll());
		
//		System.out.println(new implPorder().querySum(100,900));
		
//		porder p = new implPorder().queryPorder(5);
//		p.setA(1);
//		p.setB(1);
//		p.getSum();
//		new implPorder().update(p);
		
//		new implPorder().delete(5);
		
		
	}

	// Create 新增
	@Override
	public void add(porder p) {
		EntityManager em = DbConnection.getDb();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}

	// Read 查詢
	@Override
	public List<porder> queryAll() {
		EntityManager em = DbConnection.getDb();
		String JPQL = "select p from porder p";
		Query q = em.createQuery(JPQL);
		List<porder> l = q.getResultList();
		
		return l;
	}

	@Override
	public List<porder> querySum(int start, int end) {
		EntityManager em = DbConnection.getDb();
		String JPQL = "select p from porder p where p.Sum>=?1 and p.Sum<=?2";
		Query q = em.createQuery(JPQL);
		q.setParameter(1, start);
		q.setParameter(2, end);
		List<porder> l = q.getResultList();
		
		return l;
	}
	
	@Override
	public porder queryPorder(int id) {
		EntityManager em = DbConnection.getDb();
		String JPQL = "select p from porder p where p.id=?1";
		Query q = em.createQuery(JPQL);
		q.setParameter(1, id);
		
		List<porder> l = q.getResultList();
		porder[] p = l.toArray(new porder[l.size()]);
		if(l.size()!=0) {
			return p[0];
		}else {
			return null;
		}		
	}

	// Update 修改
	@Override
	public void update(porder p) {
		EntityManager em = DbConnection.getDb();
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();				
	}

	// Delete 刪除
	@Override
	public void delete(int id) {
		EntityManager em = DbConnection.getDb();
		porder p = em.find(porder.class, id);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		em.close();
	}
	
}
