package com.gruchanet.gwt.scratchnote.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.gruchanet.gwt.scratchnote.domain.Note;
import com.gruchanet.gwt.scratchnote.widget.StickyNote;

import java.util.Map;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class scratchnote implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        fetchNotes();

        final Button newNoteBtn = new Button("Scratch a note...", new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                StickyNote newNote = new StickyNote(true);

                RootPanel.get("notes").add(newNote);
                newNote.setFocus(true);
                // TODO: note to add [on the left side], like there: https://developer.mozilla.org/pl/demos/detail/sticky-notes/launch
            }
        });

        RootPanel.get("newNoteBtn").add(newNoteBtn);
    }

    private void fetchNotes() {
        scratchnoteService.App.getInstance().getNotes(new AsyncCallback<Map<Integer, Note>>() {
            public void onFailure(Throwable caught) {
                // TODO: error handling
            }

            public void onSuccess(Map<Integer, Note> notes) {
                for (Map.Entry<Integer, Note> entry : notes.entrySet()) {
                    int id = entry.getKey();
                    Note note = entry.getValue();

                    // draw note using existing note data
                    StickyNote stickyNote = new StickyNote(id, note);

                    RootPanel.get("notes").add(stickyNote);
                }
            }
        });
    }
}
