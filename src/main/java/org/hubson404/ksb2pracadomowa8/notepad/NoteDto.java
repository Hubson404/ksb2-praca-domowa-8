package org.hubson404.ksb2pracadomowa8.notepad;

public class NoteDto {

    private Long id;
    private String title;
    private String content;

    public NoteDto(Long id, String title, String content) {
        this(title,content);
        this.id = id;
    }

    public NoteDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public NoteDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
