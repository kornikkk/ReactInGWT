package com.github.kornikkk.pocserver.client.js.react;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;


/**
 * Created by kkarolcz on 19.05.2019.
 */
public class ReactUtils {
    private ReactUtils() {
    }

    /**
     * Usable with react-interop library: <a href=https://www.npmjs.com/package/react-interop>https://www.npmjs.com/package/react-interop</a>
     *
     * @param exportedContainerPath path to the container in <code>window</code> for exported ReactUtils Components.
     *                              Example: exportedComponents.myComponents
     * @param componentName         name of the ReactUtils Component in the container
     * @param properties            JSON properties of the Component
     * @param containerElement      HTML container which the Component will be rendered in
     */
    public static void createComponent(String exportedContainerPath, String componentName, JavaScriptObject properties,
                                       Element containerElement) {

        createComponent(exportedContainerPath.split("\\."), componentName, properties, containerElement);
    }

    private static native void createComponent(String exportedContainerPath[], String componentName, JavaScriptObject properties,
                                               Element containerElement) /*-{
        var container = $wnd;
        for (var i = 0; i < exportedContainerPath.length; i++) {
            container = container[exportedContainerPath[i]];
        }
        container[componentName].render(properties, containerElement);
    }-*/;

}
