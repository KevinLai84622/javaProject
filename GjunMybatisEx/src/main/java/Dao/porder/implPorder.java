package Dao.porder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import Dao.DbConnection;
import Model.porder;

public class implPorder implements porderDao{

	public static void main(String[] args) {
//		porder p = new porder("A桌", 2, 2, 2);
//		new implPorder().add(p);
		
//		System.out.println(new implPorder().selectAll());
//		System.out.println(new implPorder().selectId(10));
		
//		porder p = new implPorder().selectId(12);
//		p.setSum(810);
//		new implPorder().update(p);
		
		List<porder> l = new implPorder().selectSum(600, 1500);
		for(porder p:l) {
			System.out.println(p.getId() + "\t" + p.getDesk() + "\t" + p.getSum());
		}
		
//		new implPorder().delete(11);
		
	}	
	
	// Create
	@Override
	public void add(porder p) {
		SqlSession session = DbConnection.getDb();
		session.insert("porderMapper.add", p);
		session.commit();
	}
	
	// Read
	@Override
	public List<porder> selectAll() {
		SqlSession session = DbConnection.getDb();
		List<porder> l = session.selectList("porderMapper.selectAll");
		return l;
	}

	@Override
	public porder selectId(int id) {
		SqlSession session = DbConnection.getDb();
		List<porder> l = session.selectList("porderMapper.selectId", id);
		porder[] p = l.toArray(new porder[l.size()]);
		if(l.size()!=0) {
			return p[0];
		}else {
			return null;
		}		
	}

	@Override
	public List<porder> selectSum(int start, int end) {
		SqlSession session = DbConnection.getDb();
		Map<String, Integer> map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<porder> l = session.selectList("porderMapper.selectSum", map);
		return l;		
	}
	
	// Update
	@Override
	public void update(porder p) {
		SqlSession session = DbConnection.getDb();
		session.update("porderMapper.update", p);
		session.commit();
	}
	
	// Delete
	@Override
	public void delete(int id) {
		SqlSession session = DbConnection.getDb();
		session.delete("porderMapper.delete", id);
		session.commit();
	}
}
