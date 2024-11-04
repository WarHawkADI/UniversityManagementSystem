



public class Feedback <T>{

    public T feedback;
    public Student student;

    public Feedback(T feedback) {
        this.feedback = feedback;
    }

    public T getFeedback() {
        return feedback;
    }

    public void setFeedback(T feedback) {
        this.feedback = feedback;
    }
}