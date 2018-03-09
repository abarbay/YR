package collectionspriorityqueue;

import job.Job;
import job.NoJobException;

import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {
    public Queue<Job> addJob(Job... jobs) {
        Queue<Job> queuedJobs = new PriorityQueue<>();
        for (Job job : jobs) {
            queuedJobs.add(job);
        }
        return queuedJobs;
    }

    public Job dispatchNextJob(Queue<Job> jobs) throws NoJobException {
        if (jobs.peek() == null) {
            throw new NoJobException("No job available");
        }
        return jobs.poll();
    }
}
