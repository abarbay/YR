package job;

public class Job implements Comparable<Job> {
    private int priority;
    private String jobDescription;

    public Job(int priority, String jobDescription) {
        this.priority = priority;
        this.jobDescription = jobDescription;
    }

    public int getPriority() {
        return priority;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public int compareTo(Job job) {
        if (job.getPriority() > this.getPriority()) {
            return -1;
        } else if (job.getPriority() < this.getPriority()) {
            return 1;
        } else {
            return 0;
        }

    }

    public boolean isUrgent() {
        return getPriority() < 5;
    }


}
