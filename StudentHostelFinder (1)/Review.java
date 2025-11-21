// Review.java
public class Review {
    private Student author;
    private String comment;
    private int rating;

    public Review(Student author, String comment, int rating) {
        this.author = author;
        this.comment = comment;
        this.rating = rating;
    }

    public String getComment() { return comment; }
    public int getRating() { return rating; }
    public Student getAuthor() { return author; }
}
