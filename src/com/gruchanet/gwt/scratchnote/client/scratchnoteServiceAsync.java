package com.gruchanet.gwt.scratchnote.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gruchanet.gwt.scratchnote.domain.Note;

import java.util.Map;

public interface scratchnoteServiceAsync {
    void getNotes(AsyncCallback<Map<Integer, Note>> async);
    void getNote(int id, AsyncCallback<Note> async);
    void addNote(Note note, AsyncCallback<Integer> async);
    void updateNote(int id, Note note, AsyncCallback<Void> async);
    void removeNote(int id, AsyncCallback<Void> async);
}
