package GroceryServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.GroceryItem;


import grocery.repo.ItemRepo;



@Service
public class ItemService {
	private ItemRepo ir;
	
	
	@Autowired
	public void setIr(ItemRepo ir) {
		this.ir = ir; 
	}
	
	
	public void insert(GroceryItem i) {
				ir.insert(i);
	}
	
	public GroceryItem getById(int id) {
		GroceryItem i = ir.selectById(id);
	
return i;
}
	
	
	public List<GroceryItem> getAllItems() {
		
return ir.selectAll();
}
	
	
}	
