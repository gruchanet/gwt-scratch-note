package com.gruchanet.gwt.scratchnote.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.gruchanet.gwt.scratchnote.client.scratchnoteService;
import com.gruchanet.gwt.scratchnote.domain.Note;

public class StickyNote extends Composite {

    private int id = -1;
    private Note bean;

    private NoteTextArea noteTextArea = new NoteTextArea();
    private ControlButton removeBtn = new ControlButton(ControlButton.Type.REMOVE, new ClickHandler() {
        @Override
        public void onClick(ClickEvent event) {
            /* REMOVE */
            scratchnoteService.App.getInstance().removeNote(id, new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    // TODO: error handling
                }

                @Override
                public void onSuccess(Void result) {
                    remove();
                }
            });
        }
    });
    private ControlButton saveBtn = new ControlButton(ControlButton.Type.SAVE, new ClickHandler() {
        @Override
        public void onClick(ClickEvent event) {
            updateBean();

            if (!isInitialized()) {
                /* ADD */
                scratchnoteService.App.getInstance().addNote(bean, new AsyncCallback<Integer>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        // TODO: error handling
                    }

                    @Override
                    public void onSuccess(Integer id) {
                        setID(id);
                        setEditMode(false);
                    }
                });
            } else {
                /* UPDATE */
                scratchnoteService.App.getInstance().updateNote(id, bean, new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        // TODO: error handling
                    }

                    @Override
                    public void onSuccess(Void result) {
                        setEditMode(false);
                    }
                });
            }
        }
    });
    private ControlButton editBtn = new ControlButton(ControlButton.Type.EDIT, new ClickHandler() {
        @Override
        public void onClick(ClickEvent event) {
            setEditMode(true);
            setFocus(true);
        }
    });

    /**
     * Add new note.
     * @param editMode
     */
    public StickyNote(boolean editMode) {
        super();

        setBean(new Note());
        setText("Note something here...");
        initWidget(editMode);
    }

    /**
     * Add existing note.
     * @param id
     * @param note
     */
    public StickyNote(int id, Note note) {
        super();

        initData(id, note);
        updateNoteText();
        initWidget(false);
    }

    private void setID(int id) {
        this.id = id;
    }

    public Note getBean() {
        return bean;
    }

    private void setBean(Note bean) {
        this.bean = bean;
    }

    private void initData(int id, Note bean) {
        setID(id);
        setBean(bean);
    }

    private void initWidget(boolean editMode) {
        FlowPanel panel = new FlowPanel();
        panel.setStyleName("note-wrapper");
        panel.add(noteTextArea);
        panel.add(removeBtn);
        panel.add(saveBtn);
        panel.add(editBtn);
        setEditMode(editMode);

        initWidget(panel);
    }

    private boolean isInitialized() {
        return id != -1;
    }

    public void remove() {
        removeFromParent();
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
        updateNoteText();
    }

    private void updateNoteText() {
        noteTextArea.setText(bean.getText());
    }

    private void updateBean() {
        bean.setText(noteTextArea.getText());
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

        public ControlButton(Type type, ClickHandler clickHandler) {
            super(type.getHTML(), clickHandler);

            setStyleName("note-control");
            addStyleName(type.getName());
        }
    }
}
