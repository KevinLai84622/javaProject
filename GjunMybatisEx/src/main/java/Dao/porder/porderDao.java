package Dao.porder;

import java.util.List;

import Model.porder;

public interface porderDao {
	// Create
	void add(porder p);
	
	// Read
	List<porder> selectAll();
	porder selectId(int id);
	List<porder> selectSum(int start, int end);
	
	// Update
	void update(porder p);
	
	// Delete
	void delete(int id);
}
