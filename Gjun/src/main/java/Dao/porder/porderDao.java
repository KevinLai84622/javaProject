package Dao.porder;

import java.util.List;

import Model.porder;

public interface porderDao {
	// Create 新增
	void add(porder p);
	
	// Read 查詢
	List<porder> queryAll();
	List<porder> querySum(int start, int end);
	porder queryPorder(int id);
	
	// Update 修改
	void update(porder p);
	
	// Delete 刪除
	void delete(int id);
	
}
