package grocery.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.GroceryItem;
import com.model.GroceryList;


@Transactional
@Repository()
public class ListRepo {
	
	static {try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	}
	
	private SessionFactory sesFact;
	
	@Autowired
	public ListRepo(SessionFactory sesFact) {
		this.sesFact = sesFact;
	}
	
	public void insert(GroceryList l) {
		sesFact.getCurrentSession().save(l);
	}
	
	public void update(GroceryList l) {
		sesFact.getCurrentSession().update(l);
	}
	
	public GroceryList selectById(int id) {
		GroceryList  l = sesFact.getCurrentSession().get(GroceryList .class, id);
		return l;
	}
	
	public List<GroceryList> selectAll(){
		List<GroceryList> list = sesFact.getCurrentSession().createQuery("from GroceryList", GroceryList.class).list();
		return list; 
		}
	
	
	

}
