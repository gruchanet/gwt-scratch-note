package com.gruchanet.gwt.scratchnote.widget;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.gruchanet.gwt.scratchnote.domain.Note;

public class StickyNote extends Composite {

    private Note bean;
    private NoteTextArea noteTextArea = new NoteTextArea();

    public StickyNote() {
        super();

        initBean();
        initWidget();
    }

    private void initBean() {
        bean = new Note("Note something here...");
        updateNoteText();
    }

    private void initWidget() {
        FlowPanel panel = new FlowPanel();
        panel.setStyleName("note-wrapper");
        panel.add(noteTextArea);
        panel.add(new ControlButton(ControlButton.Type.CLOSE));
        panel.add(new ControlButton(ControlButton.Type.EDIT));

        initWidget(panel);
    }

    public Note getBean() {
        return bean;
    }

    public void setFocus(boolean focus) {
        noteTextArea.setFocus(focus);
    }

    public void setText(String text) {
        bean.setText(text);
        updateNoteText();
    }

    public void updateNoteText() {
        noteTextArea.setText(bean.getText());
    }

    private static class NoteTextArea extends TextArea {

        public NoteTextArea() {
            super();
            setStyleName("note");
        }

        @Override
        public void setText(String text) {
            super.setText(text);
        }
    }

    private static class ControlButton extends Button {

        public static enum Type {
            CLOSE("close", "<span>&times;</span>"),
            EDIT("edit", "<span class=\"fa fa-pencil\"></span>"),
            SAVE("save", "<span class=\"fa fa-floppy-o\"></span>");

            private final String name;
            private final String html;

            private Type(final String name, final String html) {
                this.name = name;
                this.html = html;
            }

            public String getName() {
                return name;
            }

            public String getHTML() {
                return html;
            }

            @Override
            public String toString() {
                return name;
            }
        }

        public ControlButton(Type type) {
            super();

            setStyleName("note-control");
            addStyleName(type.getName());
            setHTML(type.getHTML());
        }
    }
}
