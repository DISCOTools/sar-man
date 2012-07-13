/********************************************************************
 * 
 * UserAbstract.java is part of SAR-Man. 
 * 
 * Copyright (c) 2012, DISCO Foundation. All rights reserved.
 * 
 * SAR-Man is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published 
 * by the Free Software Foundation, either version 3 of the License, 
 * or (at your option) any later version.
 * 
 * SAR-Man is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License 
 * along with SAR-Man. If not, see http://www.gnu.org/licenses.
 * 
 *********************************************************************/
package org.sarman.login.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author kennethg
 *
 */
public class User implements IsSerializable {

	private String username;
	private String fullname;
	private String email;

	/**
	 * Default constructor
	 */
	public User() { /*NOP*/ }

	/**
	 * @param username
	 * @param fullname
	 * @param email
	 */
	public User(String username, String fullname, String email) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.email = email;
	}

	public final String getUserName() {
		return this.username;
	}

	public final void setUserName(String userName) {
		this.username = userName;
	}

	public final String getFullName() {
		return this.fullname;
	}

	public final void setFullName(String fullName) {
		this.fullname = fullName;
	}

	public final String getEmail() {
		return this.email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
