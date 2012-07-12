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

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author kennethg
 *
 */
public class LoginView extends Composite {

	private static final Binder BINDER = GWT.create(Binder.class);
	
	@UiField TextBox tbUsername;	
	
	static{
		GWT.<Resources>create(Resources.class).style().ensureInjected();
	}
	
	interface Binder extends UiBinder<Widget, LoginView> {
	}

	public LoginView() {
		initWidget(BINDER.createAndBindUi(this));
		//Set focus
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {			
			@Override
			public void execute() {
				tbUsername.setFocus(true);
			}
		});		
	}
}
