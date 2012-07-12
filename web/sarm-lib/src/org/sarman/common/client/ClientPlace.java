/********************************************************************
 * 
 * ClientPlace.java is part of SAR-Man.
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

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * <b>A named {@link Place} object representing a particular state of the UI</b>. 
 * <p>
 * A place can be converted to and from a URL history token by defining a 
 * {@link PlaceTokenizer} for each {@link ClientPlace}, and the 
 * {@link PlaceHistoryHandler} automatically updates the browser URL 
 * corresponding to each {@link ClientPlace} in your app.
 */
public class ClientPlace extends Place {
  
	/**
	 * Name property (stores token).
	 */
	private String name;

	public ClientPlace(String token) {
		this.name = token;
	}

	public String getName() {
		return name;
	}
	

	// --------------------------------------------------------
	//  Honor hash and equals contract
	// --------------------------------------------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientPlace other = (ClientPlace) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	/**
	 * PlaceTokenizer knows how to serialize the Place's state to a URL token.
	 */
	public static class Tokenizer implements PlaceTokenizer<ClientPlace> {

		@Override
		public String getToken(ClientPlace place) {
			return place.getName();
		}

		@Override
		public ClientPlace getPlace(String token) {
			return new ClientPlace(token);
		}

	}
}
