package Dao.member;

import java.util.List;

import Model.member;

public interface memberDao {
	// Create 新增
	void add(member m);
	
	// Read 查詢
	List<member> queryAll(); //查詢所有
	member queryMember(String username, String password); //帳號密碼驗證
	boolean queryUsername(String username);
	member queryMember(int id);
	
	// Update 修改
	void update(member m);
	
	// Delete 刪除
	void delete(int id);
}
