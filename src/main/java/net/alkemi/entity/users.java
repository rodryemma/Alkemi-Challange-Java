package net.alkemi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="users")
public class users {
	
	@Id
	@JsonProperty(value="username")
	private String username;
	
	@JsonProperty(value="password")
	private String password;
	
	@JsonProperty(value="enabled")
	private Integer enabled;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "users [username=" + username + ", password=" + password + ", enabled=" + enabled + ", getUsername()="
				+ getUsername() + ", getPassword()=" + getPassword() + ", getEnabled()=" + getEnabled()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
