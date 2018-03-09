package collectionsdeque;

import job.Job;
import job.NoJobException;

import java.util.ArrayDeque;
import java.util.Deque;

public class JobQueue {

    public Deque<Job> addJobByUrgency(Job... jobs) {
        Deque<Job> dequeJobs = new ArrayDeque<>();
        for (Job job : jobs) {
            dequeJobs.offer(job);
        }
        return dequeJobs;

    }

    public Job dispatchUrgentJob(Deque<Job> jobs) throws NoJobException {
        Job result = null;
        if (jobs.peek() == null) {
            throw new NoJobException("No job available");
        }
        if (jobs.peek().isUrgent()) {
            result = jobs.peekFirst();
        }
        return result;
    }

    public Job dispatchNotUrgentJob(Deque<Job> jobs) throws NoJobException {
        Job result = null;
        if (jobs.peek() == null) {
            throw new NoJobException("No job available");
        }
        if (!jobs.peekLast().isUrgent()) {
            result = jobs.peekLast();
        }
        return result;
    }
}
