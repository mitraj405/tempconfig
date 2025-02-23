package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.CharTypes;
import com.google.firebase.sessions.settings.RemoteSettings;

public abstract class JsonStreamContext {
    protected int _index;
    protected int _type;

    public JsonStreamContext() {
    }

    public JsonStreamContext(JsonStreamContext jsonStreamContext) {
        this._type = jsonStreamContext._type;
        this._index = jsonStreamContext._index;
    }

    public final int getCurrentIndex() {
        int i = this._index;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public abstract String getCurrentName();

    public abstract Object getCurrentValue();

    public final int getEntryCount() {
        return this._index + 1;
    }

    public abstract JsonStreamContext getParent();

    public final boolean inArray() {
        if (this._type == 1) {
            return true;
        }
        return false;
    }

    public final boolean inObject() {
        if (this._type == 2) {
            return true;
        }
        return false;
    }

    public final boolean inRoot() {
        if (this._type == 0) {
            return true;
        }
        return false;
    }

    public abstract void setCurrentValue(Object obj);

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        int i = this._type;
        if (i == 0) {
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
        } else if (i != 1) {
            sb.append('{');
            String currentName = getCurrentName();
            if (currentName != null) {
                sb.append('\"');
                CharTypes.appendQuoted(sb, currentName);
                sb.append('\"');
            } else {
                sb.append('?');
            }
            sb.append('}');
        } else {
            sb.append('[');
            sb.append(getCurrentIndex());
            sb.append(']');
        }
        return sb.toString();
    }

    public String typeDesc() {
        int i = this._type;
        if (i == 0) {
            return "root";
        }
        if (i == 1) {
            return "Array";
        }
        if (i != 2) {
            return "?";
        }
        return "Object";
    }

    public JsonStreamContext(int i, int i2) {
        this._type = i;
        this._index = i2;
    }
}
