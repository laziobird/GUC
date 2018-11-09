package com.laziobird.security;

import org.springframework.security.core.GrantedAuthority;

/**
* @author 蒋志伟
* @version 创建时间：2018年11月9日 下午3:02:58
*/
public class GrantedAuthorityImpl implements GrantedAuthority{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5285204535853131198L;
	private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}