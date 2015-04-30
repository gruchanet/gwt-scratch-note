package com.gruchanet.gwt.scratchnote.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gruchanet.gwt.scratchnote.client.scratchnoteService;
import com.gruchanet.gwt.scratchnote.domain.Note;

import java.util.*;

public class scratchnoteServiceImpl extends RemoteServiceServlet implements scratchnoteService {

    private int nextID = 1;
    private Map<Integer, Note> notes = new HashMap<Integer, Note>(); // TODO: in-memory OR local-storage

    public Map<Integer, Note> getNotes() {
        return notes;
    }

    public Note getNote(int id) {
        return notes.get(id);
    }

    public int addNote(Note note) {
        int id = nextID++;
        notes.put(id, note);

        return id;
    }

    public void updateNote(int id, Note note) {
        notes.remove(id);
        notes.put(id, note);
    }

    public void removeNote(int id) {
        notes.remove(id);
    }
}