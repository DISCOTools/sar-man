/********************************************************************
 * 
 * ClientFactoryImpl.java is part of SAR-Man.
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
package org.sarman.common.client;

import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

/**
 * Abstract {@link ClientFactory} implementation.
 */
public abstract class AbstractClientFactory implements ClientFactory {
  
	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);
	private final ClientView view;
	
	public AbstractClientFactory(ClientView view) {
		this.view = view;
	}

	@Override
	public final EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public final PlaceController getController() {
		return placeController;
	}

	@Override
	public final ClientView getView() {
		return view;
	}

	@Override
	public abstract ClientActivity getActivity(ClientPlace place);

}
