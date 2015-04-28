package com.gruchanet.gwt.scratchnote.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("scratchnoteService")
public interface scratchnoteService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use scratchnoteService.App.getInstance() to access static instance of scratchnoteServiceAsync
     */
    public static class App {
        private static scratchnoteServiceAsync ourInstance = GWT.create(scratchnoteService.class);

        public static synchronized scratchnoteServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
