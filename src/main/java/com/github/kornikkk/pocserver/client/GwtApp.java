package com.github.kornikkk.pocserver.client;

import com.github.kornikkk.pocserver.client.js.JavaScriptFunctionWrapper;
import com.github.kornikkk.pocserver.client.reactapp.components.App;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class GwtApp implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
//        final Label label = new Label("TEST");
        RootPanel.get("root").add(new App().renderWidget());
//        GwtAppService.App.getInstance().getMessage("TESST", new MyAsyncCallback(label));
        JavaScriptFunctionWrapper<Integer, String> wrapper = new JavaScriptFunctionWrapper<Integer, String>(Integer.class) {

            @Override
            public String apply(Integer test) {
                return "Value is: " + (test + 3);
            }
        };
//        Window.alert(testFunction(wrapper.createJavaScriptObject()));
    }

    public native String testFunction(JavaScriptObject function22) /*-{
        return function22(0);
    }-*/;

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
}
