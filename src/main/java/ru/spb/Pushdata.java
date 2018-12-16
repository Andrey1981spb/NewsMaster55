package ru.spb;

import javax.persistence.*;


@Entity
@Table(name="pushmaster")
public class Pushdata {

    @Id
    @SequenceGenerator(name = "pushmaster_id_seq",
    sequenceName = "pushmaster_id_seq",
    allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE,
    generator = "pushmaster_id_seq")
    @Column(name="id", unique = true)
    public int id;

    private String title;
    private String content;

    public Pushdata (){

    }

    public Pushdata (String title, String content){
        this.title=title;
        this.content=content;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
