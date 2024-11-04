
import java.util.Random;

public class Complaint {
    private  int complaintId;
    private String description;
    private String status = "Pending"; // status will be "Pending" or "Resolved"

    public  int getComplaintId() {
        return complaintId;
    }


    public  void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Complaint(String description) {
        Random random = new Random();
        this.complaintId = 100000 + random.nextInt(900000);
        this.description = description;
    }

    public void resolve() {
        status = "Resolved";
    }

    @Override
    public String toString() {
        return "Complaint: " + description + " - Status: " + status;
    }
}