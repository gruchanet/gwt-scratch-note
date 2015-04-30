package com.gruchanet.gwt.scratchnote.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.gruchanet.gwt.scratchnote.domain.Note;

import java.util.Map;

@RemoteServiceRelativePath("scratchnoteService")
public interface scratchnoteService extends RemoteService {
    Map<Integer, Note> getNotes();
    Note getNote(int id);
    int addNote(Note note);
    void updateNote(int id, Note note);
    void removeNote(int id);

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
