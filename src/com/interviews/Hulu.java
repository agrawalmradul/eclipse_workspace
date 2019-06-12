package com.interviews;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/*  Longest Running Jobs From Log *

A job has a name and one or more instances. Each instance has a globally unique ID number (jobid).

Given this list of input lines and a positive integer K:
Started name=dump_logs jobid=f863
Started name=dump_logs jobid=g301gas
...
Ended jobid=r0eas time=103
Ended jobid=f863 time=1021
Started name=grep_logs jobid=ac3de
Ended jobid=g301gas time=1343
Started name=read_logs jobid=r0eas
 
Started name=write_logs jobid=dg2dz
Ended jobid=ac3de time=52

Print out the names of the K distinct jobs (*not job instance IDs*, so de-dupe on job name) with the longest running individual job instances (no totaling).  Note: they can be out of order.

Example output (with K=2):
Name Time
dump_logs 1343
read_logs 103 
 */

// dump_logs - 1021
// 1343

public class Hulu {

	public static void main(String[] args) {
		ArrayList<String> logs = new ArrayList<>();

		logs.add("Started name=dump_logs jobid=f863");
		logs.add("Started name=dump_logs jobid=g301gas");
		logs.add("Ended jobid=r0eas time=103");
		logs.add("Ended jobid=f863 time=1021");
		logs.add("Started name=grep_logs jobid=ac3de");
		logs.add("Ended jobid=g301gas time=1343");
		logs.add("Started name=read_logs jobid=r0eas");
		logs.add("Started name=write_logs jobid=dg2dz");
		logs.add("Ended jobid=ac3de time=52");
		LongestJobs result = new LongestJobs(logs);
		result.printJobs(2);
	}

}

class LongestJobs {

	PriorityQueue<Job> queue;
	HashMap<String, Job> jobMap;

	public LongestJobs(ArrayList<String> logs) {
		Comparator<Job> comp = Comparator.comparing((Job j) -> j.time).reversed();
		queue = new PriorityQueue<>(comp);
		jobMap = new HashMap<>();
		enqueueJobs(logs);
	}

	public void printJobs(int k) {
		Job currJob = null;
		Job prevJob = null;
		while (!queue.isEmpty() || k > 0) {
			currJob = queue.poll();
			if (prevJob == null || !prevJob.name.equals(currJob.name)) {
				System.out.println(currJob.name + " " + currJob.time);
				prevJob = currJob;
				k--;
			}
		}
	}

	private void enqueueJobs(ArrayList<String> logs) {

		// add jobs to map
		for (String log : logs) {
			String[] logArr = log.split(" ");
			Job jTemp;
			String status = logArr[0];
			if (status.equals("Started")) {
				String name = logArr[1].substring(logArr[1].indexOf("=")+1);
				String id = logArr[2].substring(logArr[2].indexOf("=")+1);
				jTemp = new Job(status, name, id, -1);
				jobMap.put(id, jTemp);
			} else {
				String id = logArr[1].substring(logArr[1].indexOf("=")+1);
				Integer time = Integer.parseInt(logArr[2].substring(logArr[2].indexOf("=")+1));
				jTemp = jobMap.get(id);
				jTemp.time = time;
			}
		}

		// queue all the jobs from the map iff a job is ended
		for (Entry<String, Job> entry : jobMap.entrySet()) {
			Job job = entry.getValue();
			if (job.status.equals("Ended")) {
				queue.offer(job);
			}
		}
	}
}

class Job {
	String name;
	String id;
	String status;
	Integer time;

	public Job(String status, String name, String id, Integer time) {
		this.name = name;
		this.id = id;
		this.status = status;
		this.time = time;
	}
}