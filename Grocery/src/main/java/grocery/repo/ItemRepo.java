package grocery.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.GroceryItem;




@Transactional
@Repository()
public class ItemRepo {

	static {try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	}
	
	private SessionFactory sesFact;
	
	@Autowired
	public ItemRepo(SessionFactory sesFact) {
		this.sesFact = sesFact;
	}
	
	public void insert(GroceryItem i) {
		sesFact.getCurrentSession().save(i);
	}
	
	public void update(GroceryItem i) {
		sesFact.getCurrentSession().update(i);
	}
	
	public GroceryItem selectById(int id) {
		GroceryItem  i = sesFact.getCurrentSession().get(GroceryItem .class, id);
		return i;
	}
	
	
	
	public List<GroceryItem> selectAll(){
		List <GroceryItem> list = sesFact.getCurrentSession().createQuery("from GroceryItem", GroceryItem.class).list();
		return list; 
		}
	
	
	
	
}
