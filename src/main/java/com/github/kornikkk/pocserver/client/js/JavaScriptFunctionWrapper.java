package com.github.kornikkk.pocserver.client.js;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by kkarolcz on 20.05.2019.
 */
public abstract class JavaScriptFunctionWrapper<T, R> {
    private final Class<T> clazz;

    public JavaScriptFunctionWrapper(Class<T> clazz) {
        this.clazz = clazz;
    }

    public abstract R apply(T test);


    public JavaScriptObject createJavaScriptObject() {
        return createJavaScriptObject(this);
    }

    private static native JavaScriptObject createJavaScriptObject(JavaScriptFunctionWrapper<?, ?> wrapper) /*-{
        return function (value) {
            function castValue(valueToCast) {
                if (wrapper.@JavaScriptFunctionWrapper::isBoolean(*)()) {
                    return @java.lang.Boolean::valueOf(Z)(valueToCast);
                }
                if (wrapper.@JavaScriptFunctionWrapper::isInt(*)()) {
                    return @java.lang.Integer::valueOf(I)(valueToCast);
                }
                if (wrapper.@JavaScriptFunctionWrapper::isDouble(*)()) {
                    return @java.lang.Double::valueOf(D)(valueToCast);
                }
                if (wrapper.@JavaScriptFunctionWrapper::isByte(*)()) {
                    return @java.lang.Byte::valueOf(B)(valueToCast);
                }
                if (wrapper.@JavaScriptFunctionWrapper::isFloat(*)()) {
                    return @java.lang.Float::valueOf(F)(valueToCast);
                }
                return valueToCast;
            }

            return wrapper.@JavaScriptFunctionWrapper::apply(*)(castValue(value));
        }
    }-*/;

    private boolean isBoolean() {
        return Boolean.class.equals(clazz);
    }

    private boolean isInt() {
        return Integer.class.equals(clazz);
    }

    private boolean isDouble() {
        return Double.class.equals(clazz);
    }

    private boolean isByte() {
        return Byte.class.equals(clazz);
    }

    private boolean isFloat() {
        return Float.class.equals(clazz);
    }

}
