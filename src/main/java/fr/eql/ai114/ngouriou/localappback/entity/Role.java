package fr.eql.ai114.ngouriou.localappback.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role implements GrantedAuthority {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;

    public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getAuthority() {
		return name;
	}
}
