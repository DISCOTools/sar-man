package org.sarman.login.server;

import org.sarman.login.client.LoginService;
import org.sarman.login.shared.AuthenticationException;
import org.sarman.login.shared.ClientInfo;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements
		LoginService {

	@Override
	public void signup(ClientInfo info, String username, String email,
			String password) throws AuthenticationException,
			IllegalArgumentException {
		
		assertUser();
		
	}

	@Override
	public void login(ClientInfo info, String username, String password)
			throws AuthenticationException {

		assertUser();
		
	}

	@Override
	public void logout(ClientInfo info) throws AuthenticationException {

		assertUser();
		
	}

	@Override
	public void disable(ClientInfo info, String username)
			throws AuthenticationException {

		assertUser();
		
	}

	@Override
	public void activate(ClientInfo info, String username)
			throws AuthenticationException {

		assertUser();
		
	}

	@Override
	public void delete(ClientInfo info, String username)
			throws AuthenticationException {

		assertUser();
		
	}

	@Override
	public void reset(ClientInfo info, String email)
			throws AuthenticationException, IllegalArgumentException {

		assertUser();
		
	}

	public static final void assertUser() throws AuthenticationException {
		throw new AuthenticationException(Constants.getMessages().AuthFailed());
	}
	
}
