package com.gruchanet.gwt.scratchnote.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gruchanet.gwt.scratchnote.domain.Note;

public interface scratchnoteServiceAsync {
    void addNote(Note note, AsyncCallback<Void> async);
    void removeNote(int seqID, AsyncCallback<Void> async);
    void updateNote(int seqID, Note note, AsyncCallback<Void> async);
}
