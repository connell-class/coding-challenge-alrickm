package GroceryController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.GroceryItem;


import GroceryServices.ItemService;



@Controller
@RequestMapping(value="/item")
@CrossOrigin(origins="*")
public class Item {
	
private ItemService item;
	

	
	@Autowired
	public void setItemService(ItemService item) {
		this.item = item;
	}
	
	@PostMapping(value="/putIn.app")
	public @ResponseBody GroceryItem insert(@RequestBody GroceryItem i) {
		item.insert(i);
		return i;
	}
	
	@GetMapping(value="/getAll.app")
	public ResponseEntity<List<GroceryItem>> getAll(){
		
		return new ResponseEntity<List<GroceryItem>>(item.getAllItems(), HttpStatus.OK);
	
	}
	
	
	public ItemService getGroceryItem() {
		return item;
		}

}
