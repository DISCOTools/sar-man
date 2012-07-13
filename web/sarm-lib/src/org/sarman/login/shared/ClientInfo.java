/********************************************************************
 * 
 * ClientInfo.java is part of SAR-Man. 
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
 * Information about client passed to server
 * 
 * @author kennethg
 *
 */
public class ClientInfo implements IsSerializable {

	private String locale;
	private String userAgent;
	
	/**
	 * Default constructor
	 */
	public ClientInfo() {  }

	public final String getLocale() {
		return this.locale;
	}

	public final void setLocale(String locale) {
		this.locale = locale;
	}

	public final String getUserAgent() {
		return this.userAgent;
	}

	public final void setUserAgent(String useragent) {
		this.userAgent = useragent;
	}
		
}
