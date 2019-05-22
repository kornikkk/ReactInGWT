package com.github.kornikkk.pocserver.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("gwtappService")
public interface GwtAppService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use GwtAppService.App.getInstance() to access static instance of gwtappServiceAsync
     */
    class App {
        private static GwtAppServiceAsync ourInstance = GWT.create(GwtAppService.class);

        public static synchronized GwtAppServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
