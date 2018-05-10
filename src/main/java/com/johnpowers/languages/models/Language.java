package com.johnpowers.languages.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;



@Entity
@Table(name="languages")
public class Language {
	
    @Id
    @GeneratedValue
	private Long id;
	private String name;
	private String creator;
	private String currentVersion;
    private Date createdAt;
    private Date updatedAt;
	
	public Language() {
	}
	
	public Language(String name, String creator, String currentVersion) {

		
		this.name = name;
		this.creator = creator;
		this.currentVersion = currentVersion;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@PrePersist
	protected void onCreate() {
		this.setCreatedAt(new Date());
	}
	@PreUpdate
	protected void onUpdate() {
		this.setUpdatedAt(new Date());
	}

}
