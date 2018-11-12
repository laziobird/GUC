package com.laziobird.bean;

import java.util.Date;

/**
 * 
 * @author laziobird
 *
 */
public class App {
    private String name;
    private Integer id;
    private String info;
    private String url;
    private Date ctime;
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "App [name=" + name + ", id=" + id + ", info=" + info + ", url=" + url + ", ctime=" + ctime + ", status="
				+ status + "]";
	}


}
