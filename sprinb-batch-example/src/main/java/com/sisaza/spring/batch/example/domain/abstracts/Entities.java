package com.sisaza.spring.batch.example.domain.abstracts;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class Entities extends Auditable<String> implements Persistable<Long>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Column
	protected boolean enabled = true;
	
	public abstract <T extends Entities> T withId(Long id);
	
	public abstract <T extends Entities> T withEnabled(boolean enabled);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@JsonIgnore
	@Override
	public boolean isNew() {
		return (this.id == null);
	}

}
