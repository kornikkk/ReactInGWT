package com.github.kornikkk.pocserver.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GwtAppServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
