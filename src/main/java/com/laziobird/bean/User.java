package com.laziobird.bean;

/**
 * 
 * @author laziobird
 *
 */
public class User {
    private String name;
    private Integer id;
    private String password;
    private String phone;
    private String email;
    private int status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
    }	
	
	public User(String name, String password, int status) {
        this.name = name;
        this.password = password;
        this.status = status;
    }

	public User(String name, String password, int status, String phone, String email) {
        this.name = name;
        this.password = password;
        this.status = status;
        this.phone = phone;
        this.email = email;
	}
}
