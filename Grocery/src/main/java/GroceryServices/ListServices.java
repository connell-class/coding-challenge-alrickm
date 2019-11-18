package GroceryServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.GroceryItem;
import com.model.GroceryList;

import grocery.repo.ListRepo;

@Service
public class ListServices {
	
	private ListRepo lr;
	
	
	@Autowired
	public void setLr(ListRepo lr) {
		this.lr = lr; 
	}
	
	
	public void insert(GroceryList i) {
				lr.insert(i);
	}
	
	
	public List<GroceryList> getAllList() {
		
return lr.selectAll();

}


}
