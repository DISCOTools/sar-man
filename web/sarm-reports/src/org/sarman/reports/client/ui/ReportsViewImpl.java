/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.sarman.reports.client.ui;

import org.sarman.common.client.ClientPresenter;
import org.sarman.common.client.ClientPlace;
import org.sarman.common.client.ClientView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Sample implementation of {@link ClientView}.
 */
public class ReportsViewImpl extends Composite implements ClientView {

	interface Binder extends UiBinder<Widget, ReportsViewImpl> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);

	private ClientPresenter listener;
	@UiField
	Button button;

	public ReportsViewImpl() {
		initWidget(binder.createAndBindUi(this));
	}

	@Override
	public void setName(String name) {
		button.setHTML(name);
	}

	@Override
	public void setPresenter(ClientPresenter listener) {
		this.listener = listener;
	}

	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
		ClientPlace newPlace = null;
		// TODO
		listener.goTo(newPlace);
	}
}
