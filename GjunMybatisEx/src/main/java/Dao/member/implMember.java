package Dao.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import Dao.DbConnection;
import Model.member;

public class implMember implements memberDao{

	public static void main(String[] args) {
//		System.out.println(new implMember().selectAll());
		
//		member m = new member("TTT", "ttt", "tttt", "台北", "0000-0000", "0900-000-000");
//		new implMember().add(m);
		
//		System.out.println(new implMember().selectId(1));
		
//		member m = new implMember().selectId(10);
//		m.setName("T10");
//		new implMember().update(m);
		
		System.out.println(new implMember().selectUser("abc", "12345"));
		
//		new implMember().delete(7);
	}	
	
	// Create
	@Override
	public void add(member m) {
		SqlSession session = DbConnection.getDb();
		session.insert("memberMapper.add", m);
		session.commit();		
	}
	
	// Read
	@Override
	public List<member> selectAll() {
		SqlSession session = DbConnection.getDb();
		List<member> l = session.selectList("memberMapper.selectAll");
		return l;
	}

	@Override
	public member selectId(int id) {
		SqlSession session = DbConnection.getDb();
		List<member> l = session.selectList("memberMapper.selectId", id);
		member[] m = l.toArray(new member[l.size()]);
		return m[0];
	}
	
	@Override
	public member selectUser(String username) {
		SqlSession session = DbConnection.getDb();
		List<member> l = session.selectList("memberMapper.selectUser", username);
		member[] m = l.toArray(new member[l.size()]);
		if(l.size()!=0) {
			return m[0];
		}else {
			return null;
		}		
	}
	
	@Override
	public member selectUser(String username, String password) {
		SqlSession session = DbConnection.getDb();
		Map<String, String> map = new HashMap();
		map.put("username", username);
		map.put("password", password);
		
		List<member> l = session.selectList("memberMapper.selectUser2", map);
		member[] m = l.toArray(new member[l.size()]);
		if(l.size()!=0) {
			return m[0];
		}else {
			return null;
		}
	}
	
	// Update
	@Override
	public void update(member m) {
		SqlSession session = DbConnection.getDb();
		session.update("memberMapper.update", m);
		session.commit();
	}
	
	// Delete
	@Override
	public void delete(int id) {
		SqlSession session = DbConnection.getDb();
		session.delete("memberMapper.delete", id);
		session.commit();
	}		
}
