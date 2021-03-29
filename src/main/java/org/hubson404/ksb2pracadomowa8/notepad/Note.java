package org.hubson404.ksb2pracadomowa8.notepad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Lob
    @Column(name = "content", columnDefinition = "CLOB")
    private String content;

}
