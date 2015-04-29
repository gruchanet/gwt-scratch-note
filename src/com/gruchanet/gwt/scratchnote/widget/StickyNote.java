package com.gruchanet.gwt.scratchnote.widget;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.gruchanet.gwt.scratchnote.domain.Note;

public class StickyNote extends Composite {

    private Note bean;

    private NoteTextArea noteTextArea = new NoteTextArea();
    private ControlButton closeBtn = new ControlButton(ControlButton.Type.REMOVE);
    private ControlButton saveBtn = new ControlButton(ControlButton.Type.SAVE);
    private ControlButton editBtn = new ControlButton(ControlButton.Type.EDIT);

    public StickyNote(boolean editMode) {
        super();

        initBean();
        initWidget(editMode);
    }

    private void initBean() {
        bean = new Note();
        setText("Note something here...");
    }

    private void initWidget(boolean editMode) {
        FlowPanel panel = new FlowPanel();
        panel.setStyleName("note-wrapper");
        panel.add(noteTextArea);
        panel.add(closeBtn);
        panel.add(saveBtn);
        panel.add(editBtn);
        setEditMode(editMode);

        initWidget(panel);
    }

    public Note getBean() {
        return bean;
    }

    public void setEditMode(boolean editMode) {
        if (editMode) {
            saveBtn.setVisible(true);
            editBtn.setVisible(false);
            noteTextArea.setReadOnly(false);
        } else {
            saveBtn.setVisible(false);
            editBtn.setVisible(true);
            noteTextArea.setReadOnly(true);
        }
    }

    public void setFocus(boolean focus) {
        noteTextArea.setFocus(focus);
    }

    public void setText(String text) {
        bean.setText(text);
        refreshNoteText();
    }

    public void refreshNoteText() {
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
            REMOVE("remove", "<span>&times;</span>"),
            EDIT("edit", "<span class=\"fa fa-pencil\"></span>"),
            SAVE("save", "<span class=\"fa fa-check\"></span>");

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
