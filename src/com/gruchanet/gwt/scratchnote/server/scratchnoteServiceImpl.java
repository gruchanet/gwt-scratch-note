package com.gruchanet.gwt.scratchnote.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gruchanet.gwt.scratchnote.client.scratchnoteService;
import com.gruchanet.gwt.scratchnote.domain.Note;

import java.util.*;

public class scratchnoteServiceImpl extends RemoteServiceServlet implements scratchnoteService {

    private int nextID = 1;
    private Map<Integer, Note> notes = new HashMap<Integer, Note>(); // in memory OR local-storage

    public Collection<Note> getNotes() {
        return notes.values();
    }

    public Note getNote(int seqID) {
        return notes.get(seqID);
    }

    public void addNote(Note note) {
        notes.put(nextID++, note);
    }

    public void removeNote(int seqID) {
        notes.remove(seqID);
    }

    public void updateNote(int seqID, Note note) {
        notes.remove(seqID);
        notes.put(seqID, note);
    }
}