package org.sarman.login.client;

import org.sarman.login.shared.ClientInfo;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The asynchronous counterpart of {@link LoginService}
 */
public interface LoginServiceAsync {
	
	void signup(ClientInfo info, String username, String email, String password, AsyncCallback<Void> callback);
	
	void login(ClientInfo info, String username, String password, AsyncCallback<Void> callback);

	void logout(ClientInfo info, AsyncCallback<Void> callback);

	void disable(ClientInfo info, String username, AsyncCallback<Void> callback);

	void activate(ClientInfo info, String username, AsyncCallback<Void> callback);

	void delete(ClientInfo info, String username, AsyncCallback<Void> callback);

	void reset(ClientInfo info, String email, AsyncCallback<Void> callback);
}
