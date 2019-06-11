package com.github.kornikkk.pocserver.client.js.react;


import com.github.kornikkk.pocserver.client.js.JavaScriptFunctionWrapper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

import java.util.ArrayList;
import java.util.List;

/**
 * Usable with react-interop library: <a href=https://www.npmjs.com/package/react-interop>https://www.npmjs.com/package/react-interop</a>
 */
public class ReactComponent {

    private final String exportedContainerPath;
    private final String componentName;
    private final JavaScriptObject properties = JavaScriptObject.createObject();


    /**
     *  @param exportedContainerPath name of the container for exported ReactUtils Components
     *  @param componentName name of the ReactUtils Component in the container
     */
    public ReactComponent(String exportedContainerPath, String componentName) {
        this.exportedContainerPath = exportedContainerPath;
        this.componentName = componentName;
    }

    public final Widget renderWidget() {
        return renderWidgets().iterator().next();
    }

    public final List<Widget> renderWidgets() {
        Element containerElement = new HTMLPanel("").getElement();
        ReactUtils.createComponent(exportedContainerPath, componentName, properties, containerElement);

        List<Widget> widgets = new ArrayList<>();
        Element childElement = containerElement.getFirstChildElement();
        while (childElement != null) {
            widgets.add(new ReactWidget(childElement));
            childElement = childElement.getNextSiblingElement();
        }
        return widgets;
    }

    protected final void setProperty(String name, JavaScriptFunctionWrapper jsFunction) {
        setProperty(name, jsFunction.createJavaScriptObject());
    }

    protected final void setProperty(String name, Object object) {
        setProperty(properties, name, object);
    }

    private native void setProperty(JavaScriptObject properties, String name, Object object)/*-{
        properties[name] = object;
    }-*/;

    private class ReactWidget extends Widget {
        private ReactWidget(Element element) {
            setElement(element);
        }
    }
}
