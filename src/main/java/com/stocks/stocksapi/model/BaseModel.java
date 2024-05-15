package com.stocks.stocksapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class BaseModel {
	@CreationTimestamp
	@Column(nullable=false, updatable=false)
	private Date created_on;
		
	@UpdateTimestamp
		private Date modified_on;

}
