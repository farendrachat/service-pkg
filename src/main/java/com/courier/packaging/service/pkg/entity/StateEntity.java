package com.courier.packaging.service.pkg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.commons.codec.binary.StringUtils;
import lombok.Data;

@Entity
@Data
public class StateEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stateId;
	@Column
	private String stateName;
	@Column
	private String stateZone;
	
	 @Override
	    public boolean equals(Object obj) {
		 boolean stateEqual = false;
	        if (obj == null) {
	            return false;
	        }
	        if (obj.getClass() != this.getClass()) {
	            return false;
	        }
	        final StateEntity other = (StateEntity) obj;	        
	        if(StringUtils.equals(this.getStateName(),other.getStateName())){
	        	stateEqual = true; 
	        }	        
	       return stateEqual;
	    }	

	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * (result +				
			(
			 ((this.getStateName() == null) ? 0 : getStateName().hashCode())
			));
		return result;
	}
}
