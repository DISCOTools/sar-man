/********************************************************************
 * 
 * LoginView.java is part of SAR-Man. 
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
package org.sarman.login.client;

import org.sarman.common.resources.Resources;
import org.sarman.login.shared.ClientInfo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window.Navigator;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PasswordTextBox;

/**
 * @author kennethg
 *
 */
public class LoginView extends Composite {

	private static final Binder BINDER = GWT.create(Binder.class);

	private final LoginServiceAsync service;	
	private final AsyncCallback<Void> callback;
	
	@UiField TextBox username;	
	@UiField Label message;
	@UiField Button submit;
	@UiField PasswordTextBox password;
	
	static{
		GWT.<Resources>create(Resources.class).style().ensureInjected();
	}
	
	interface Binder extends UiBinder<Widget, LoginView> {
	}

	public LoginView(LoginServiceAsync service, AsyncCallback<Void> callback) {
		
		// Prepare
		this.service = service;
		this.callback = callback;
		
		// Initialize widget
		initWidget(BINDER.createAndBindUi(this));
		
		// Register login handler
		LoginRequestHandler handler = new LoginRequestHandler();
		this.username.addKeyDownHandler(handler);
		this.password.addKeyDownHandler(handler);
		this.submit.addClickHandler(handler);
		
		//Set focus
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {			
			@Override
			public void execute() {
				username.setFocus(true);
			}
		});		
	}
	
	public void setMessage(String message) {
		this.message.setText(message);
		this.message.setVisible(!(message == null || message.isEmpty()));
		this.submit.setEnabled(true);
	}
	
	/**
	 * Login request handler
	 * 
	 * @author kennethg
	 *
	 */
	private class LoginRequestHandler implements ClickHandler, KeyDownHandler {
		
		/**
		 * Fired when the user clicks on element.
		 */
		public void onClick(ClickEvent event) {
			login();
		}

		/**
		 * Fired when the user types in element.
		 */
		public void onKeyDown(KeyDownEvent event) {
			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				login();
			}
		}

		/**
		 * Request
		 */
		private void login() {
			
			// Reset current notification
			setMessage("");

			// Disable submit button
			submit.setEnabled(false);

			// Send login request
			service.login(newInstance(), username.getText(), password.getText(),callback);
			
		}
		
		public final ClientInfo newInstance() {
			ClientInfo info = new ClientInfo();
			info.setLocale(LocaleInfo.getCurrentLocale().getLocaleName());
			info.setUserAgent(Navigator.getUserAgent());
			return info;
		}
		
		
	}
	
	
}
