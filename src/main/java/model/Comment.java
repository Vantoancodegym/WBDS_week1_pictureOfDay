package model;

import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String evaluate;
    private String author;
    private String feedback;
    private int likesAmount;
    public  Comment(){}

    public Comment(int id, String evaluate, String author, String feedback, int likesAmount) {
        this.id = id;
        this.evaluate = evaluate;
        this.author = author;
        this.feedback = feedback;
        this.likesAmount = likesAmount;
    }

    public Comment(String evaluate, String author, String feedback, int likesAmount) {
        this.evaluate = evaluate;
        this.author = author;
        this.feedback = feedback;
        this.likesAmount = likesAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getLikesAmount() {
        return likesAmount;
    }

    public void setLikesAmount(int likesAmount) {
        this.likesAmount = likesAmount;
    }
}
