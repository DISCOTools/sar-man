/********************************************************************
 * 
 * LoginService.java is part of SAR-Man.
 * 
 * Copyright (c) 2012, DISCO Foundation. All rights reserved.
 * 
 * SAR-Man is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * SAR-Man is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE.
 * 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * SAR-Man. If not, see http://www.gnu.org/licenses.
 * 
 *********************************************************************/
package org.sarman.login.client;

import org.sarman.login.shared.AuthenticationException;
import org.sarman.login.shared.ClientInfo;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * <b>SAR-Man login service interface</b>
 * 
 * This is the client side stub for the RPC service.
 */
@RemoteServiceRelativePath("LoginService")
public interface LoginService extends RemoteService {
	
	void signup(ClientInfo info, String username, String email, String password) throws AuthenticationException, IllegalArgumentException;
	
	void login(ClientInfo info, String username, String password) throws AuthenticationException;
	
	void logout(ClientInfo info) throws AuthenticationException;

	void disable(ClientInfo info, String username) throws AuthenticationException;
	
	void activate(ClientInfo info, String username) throws AuthenticationException;
	
	void delete(ClientInfo info, String username) throws AuthenticationException;
	
	void reset(ClientInfo info, String email) throws AuthenticationException, IllegalArgumentException;
}
