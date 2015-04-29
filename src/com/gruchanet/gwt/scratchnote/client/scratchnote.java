package com.gruchanet.gwt.scratchnote.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.gruchanet.gwt.scratchnote.widget.StickyNote;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class scratchnote implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        final Button newNoteBtn = new Button("Scratch a note...", new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                StickyNote newNote = new StickyNote();

                RootPanel.get("notes").add(newNote);
                newNote.setFocus(true);
                // TODO: editable note [new/update note == editable note]
                // TODO: note to add [on the left side], like there: https://developer.mozilla.org/pl/demos/detail/sticky-notes/launch
            }
        });

        RootPanel.get("newNoteBtn").add(newNoteBtn);
//        final Button button = new Button("Click me");
//        final Label label = new Label();
//
//        button.addClickHandler(new ClickHandler() {
//            public void onClick(ClickEvent event) {
//                if (label.getText().equals("")) {
//                    scratchnoteService.App.getInstance().getMessage("Hello, World!", new MyAsyncCallback(label));
//                } else {
//                    label.setText("");
//                }
//            }
//        });
//
//        // Assume that the host HTML has elements defined whose
//        // IDs are "slot1", "slot2".  In a real app, you probably would not want
//        // to hard-code IDs.  Instead, you could, for example, search for all
//        // elements with a particular CSS class and replace them with widgets.
//        //
//        RootPanel.get("slot1").add(button);
//        RootPanel.get("slot2").add(label);
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {

        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
}
