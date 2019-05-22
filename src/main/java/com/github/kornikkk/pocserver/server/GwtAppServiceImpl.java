package com.github.kornikkk.pocserver.server;

import com.github.kornikkk.pocserver.client.GwtAppService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GwtAppServiceImpl extends RemoteServiceServlet implements GwtAppService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}