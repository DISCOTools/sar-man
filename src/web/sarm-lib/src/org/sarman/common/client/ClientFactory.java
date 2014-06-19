/********************************************************************
 * 
 * ClientFactory.java is part of SAR-Man.
 * 
 * Copyright (c) 2012, DISCO Foundation. All rights reserved.
 * 
 * SAR-Man is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version.
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
package org.sarman.common.client;


import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;

/**
 * <b>Client-side MVP factory interface</b>
 * <p>
 * Helpful when using a factory or dependency injection framework like GIN to 
 * obtain references to objects needed throughout your application like 
 * the {@link EventBus}, {@link PlaceController} and {@link ClientView}s.
 */
public interface ClientFactory {

	public ClientView getView();
	
	public EventBus getEventBus();

	public PlaceController getController();
	
	public Activity getActivity(ClientPlace place);
	
}
