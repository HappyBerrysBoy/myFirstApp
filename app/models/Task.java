package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Task extends Model{

	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id")
	@Id
	public Long id;
	
	@Required
	public String label;
	
	public static Finder<Long, Task> find = new Finder(Long.class, Task.class);
	
	public static List<Task> all(){
		return find.all();
	}
	
	public static void create(Task task){
		task.save();
	}
	
	public static void delete(Long id){
		find.ref(id).delete();
	}
}
