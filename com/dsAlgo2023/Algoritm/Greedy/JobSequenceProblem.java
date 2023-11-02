package com.dsAlgo2023.Algoritm.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class JobSequenceProblem {
    public static void main(String[] args) {
        Job[] jobs = new Job[5];
        jobs[0] = new Job(1, 2, 100);
        jobs[1] = new Job(2, 1, 19);
        jobs[2] = new Job(3, 2, 27);
        jobs[3] = new Job(4, 1, 25);
        jobs[4] = new Job(5, 1, 15);

        Arrays.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return Integer.compare(o2.profit, o1.profit);
            }
        });

        Job[] jobArr= new Job[jobs.length+1];
        int count=0,sum=0;

        for(Job job: jobs)
            setJobInSlot(job,job.deadline,jobArr);

        for (Job job: jobArr)
            if(job!=null){
                sum+=job.profit;
                count++;
            }
        System.out.println("count: "+count+" sum: "+sum);
    }

    private static void setJobInSlot(Job job, int slot, Job[] jobArr) {
        if(slot==0)
            return;
        else if(jobArr[slot]==null)
            jobArr[slot]=job;
        else
            setJobInSlot(job,slot-1,jobArr);
    }
}
class Job {
    int id, deadline, profit;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", profit=" + profit +
                ", deadline=" + deadline +
                '}';
    }
}
