package ru.spb.push;

import javax.persistence.*;

@Entity
@Table(name = "newsmaster")
public class Newsdata {

    @Id
    @SequenceGenerator(name = "newsmaster_id_seq",
            sequenceName = "newsmaster_id_seq",
            allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE,
            generator = "newsmaster_id_seq")
    @Column(name = "news_id", unique = true)
    public int news_id;

    private String title_news;
    private String content_news;

    public Newsdata() {
    }

    public Newsdata(String title_news, String content_news) {
        this.title_news = title_news;
        this.content_news = content_news;
    }

    @Column(name = "title_news")
    public String getTitle_news() {
        return title_news;
    }

    public void setTitle_news(String title_news) {
        this.title_news = title_news;
    }

    @Column(name = "content_news")
    public String getContent_news() {
        return content_news;
    }

    public void setContent_news(String content_news) {
        this.content_news = content_news;
    }

    public int getId() {
        return news_id;
    }

    public void setId(int news_id) {
        this.news_id = news_id;
    }
}
