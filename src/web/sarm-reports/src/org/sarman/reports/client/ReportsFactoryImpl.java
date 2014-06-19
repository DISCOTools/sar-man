package org.sarman.reports.client;

import org.sarman.common.client.AbstractClientFactory;
import org.sarman.common.client.ClientActivity;
import org.sarman.common.client.ClientPlace;
import org.sarman.reports.client.ui.ReportsViewImpl;

public class ReportsFactoryImpl extends AbstractClientFactory {

	public ReportsFactoryImpl() {
		super(new ReportsViewImpl());
	}

	@Override
	public ClientActivity getActivity(ClientPlace place) {
		return new ClientActivity(place, this);
	}

}
