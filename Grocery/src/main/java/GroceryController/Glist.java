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

import com.model.GroceryList;

import GroceryServices.ListServices;


@Controller
@RequestMapping(value="/grocery")
@CrossOrigin(origins="*")
public class Glist {

private ListServices glist;
	

	
	@Autowired
	public void setItemService(ListServices glist) {
		this.glist = glist;
	}
	
	@PostMapping(value="/insert.app")
	public @ResponseBody GroceryList insert(@RequestBody GroceryList l) {
		glist.insert(l);
		return l;
	}
	
	@GetMapping(value="/getAll.app")
	public ResponseEntity<List<GroceryList>> getAll(){
		
		return new ResponseEntity<List<GroceryList>>(glist.getAllList(), HttpStatus.OK);
	
	}
	
	
	public ListServices getGroceryItem() {
		return glist;
		}

	

}
