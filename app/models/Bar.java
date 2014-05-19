package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Bar extends Model{


	public String id;
	
	public String name;
}
