/********************************************************************
 * 
 * Constants.java is part of SAR-Man. 
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
package org.sarman.login.server;

import java.io.IOException;

import org.sarman.common.i18n.Messages;
import org.scb.gwt.web.server.i18n.GWTI18N;

import com.google.gwt.core.client.GWT;

/**
 * Constants only available on server side
 * 
 * @author kennethg
 *
 */
public class Constants {

	private static Messages MESSAGES;
	
	static {
		try {
			MESSAGES = GWTI18N.create(Messages.class);
		} catch (IOException e) { log("Messages", e); }	
	}
	
	private static void log(String name, Throwable e) {
		GWT.log("Failed to create ["+name+"] constant" , e);
	}
	
	public static Messages getMessages() {
		return MESSAGES;
	}	
	
}
