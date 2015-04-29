package com.gruchanet.gwt.scratchnote.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.gruchanet.gwt.scratchnote.domain.Note;

@RemoteServiceRelativePath("scratchnoteService")
public interface scratchnoteService extends RemoteService {
    void addNote(Note note);
    void removeNote(int seqID);
    void updateNote(int seqID, Note note);

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
