/********************************************************************
 * 
 * Style.java is part of SAR-Man. 
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
package org.sarman.common.resources;

import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.Shared;

/**
 * Common style interface for SAR-Man.
 * 
 * @author kennethg
 *
 */
@Shared
public interface Style extends CssResource {

	@ClassName("gwt-Title")
	String gwtTitle();
	
	@ClassName("gwt-Label-Prompt")
	String gwtLabelPrompt();
	
	@ClassName("gwt-Label-Notify")
	String gwtLabelNotify();
	
	@ClassName("gwt-Label-Bold")
	String gwtLabelBold();
	
	@ClassName("gwt-CheckBox-Dimmed")
	String gwtCheckbBoxDimmed();
	
	@ClassName("gwt-Panel-Prompt")
	String gwtPanelPrompt();

	@ClassName("gwt-TextBox-Round")
	String gwtTextBoxRound();

	@ClassName("gwt-Button-Submit")
	String gwtButtonSubmit();
	
}	  