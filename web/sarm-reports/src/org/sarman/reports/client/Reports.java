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
package org.sarman.reports.client;

import org.sarman.common.client.ClientActivityMapper;
import org.sarman.common.client.ClientFactory;
import org.sarman.common.client.ClientPlaceHistoryMapper;
import org.sarman.common.client.ClientPlace;
import org.sarman.login.client.LoginService;
import org.sarman.login.client.LoginServiceAsync;
import org.sarman.login.client.LoginView;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class Reports implements EntryPoint {
  
	private SimplePanel appWidget = new SimplePanel();
	private Place defaultPlace = new ClientPlace("Go!");
	private LoginView view;
	private AsyncCallback<Void> callback;
	private LoginServiceAsync service;	
	
	public void onModuleLoad() {
		
		boolean isLogin = true;
		
		service = GWT.create(LoginService.class);
		System.out.println(GWT.getHostPageBaseURL());
//		((ServiceDefTarget) service).setServiceEntryPoint(GWT.getHostPageBaseURL() + "sarm_login/LoginService");
		
		System.out.println(((ServiceDefTarget) service).getServiceEntryPoint());
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setSize("100%", "100%");
		
		callback = new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				view.setMessage(caught.getMessage());
			}

			@Override
			public void onSuccess(Void result) {
				view.setMessage("Success!");		
			}
		};
		
		view = new LoginView(service, callback);
		
		horizontalPanel.add(view);
		RootPanel.get().add(horizontalPanel, 0, 0);
		
		if(!isLogin) {
			// Create ClientFactory using deferred binding so we can replace with 
			// different impls in gwt.xml
			ClientFactory clientFactory = GWT.create(ClientFactory.class);
			EventBus eventBus = clientFactory.getEventBus();
			PlaceController placeController = clientFactory.getController();
			// Start ActivityManager for the main widget with our ActivityMapper
			ActivityMapper activityMapper = new ClientActivityMapper(clientFactory);
			ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
			activityManager.setDisplay(appWidget);
			// Start PlaceHistoryHandler with our PlaceHistoryMapper
			ClientPlaceHistoryMapper historyMapper = GWT .create(ClientPlaceHistoryMapper.class);
			PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
			historyHandler.register(placeController, eventBus, defaultPlace);
			RootPanel.get().add(appWidget);
			// Goes to place represented on URL or default place
			historyHandler.handleCurrentHistory();
		}
	}
}
