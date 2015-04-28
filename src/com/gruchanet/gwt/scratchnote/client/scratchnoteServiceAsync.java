package com.gruchanet.gwt.scratchnote.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface scratchnoteServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
