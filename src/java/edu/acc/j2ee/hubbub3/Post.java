package edu.acc.j2ee.hubbub3;

public class Post implements java.io.Serializable {
    private String content;
    private User   author;
    private java.util.Date postDate;

    public String getContent() {
        return content;
    }

    public java.util.Date getPostDate() {
        return postDate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPostDate(java.util.Date postDate) {
        this.postDate = postDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
