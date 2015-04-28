package com.gruchanet.gwt.scratchnote.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gruchanet.gwt.scratchnote.client.scratchnoteService;

public class scratchnoteServiceImpl extends RemoteServiceServlet implements scratchnoteService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}