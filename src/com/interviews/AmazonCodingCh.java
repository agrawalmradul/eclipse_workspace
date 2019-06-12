package com.interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//the amazon fullfillment builder will provide an estimate about the time it will take for the tirem to be created based on the size of each of the parts.
//the worker can only combine only two parts at a time. the time required to put two parts together is equal to the sum of the parts.the size of newly constructed part is
// also equal to the sum if the part's sizes. THis process is repeated until all of the parts have been merged together to form the final product

/**
 * Input numOfParts = 4 parts = [8,4,6,12]
 * 
 * output 58 - 4+6 = 10 -> new array -> [8,10,12] - 8+10 = 18 -> new array ->
 * [18,12] - 18+12 = 30 -> new array -> [30] 10+18+30 = 58
 * 
 * @author mradulagrawal
 *
 */

public class AmazonCodingCh {

	static class QItem {
		private int row;
		private int col;
		private int dist;

		QItem(int x, int y, int w) {
			this.row = x;
			this.col = y;
			this.dist = w;
		}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> parts = new ArrayList<>();
		parts.add(8);
		parts.add(4);
		parts.add(6);
		parts.add(12);
		System.out.println(minimumTime(4, parts));
	}

	public static int minimumTime(int numOfParts, List<Integer> parts) {
		Collections.sort(parts);
		int[] job = new int[numOfParts - 1];

		job[0] = parts.get(0) + parts.get(1);

		int sum = 0;
		for (int i = 2; i < parts.size(); i++) {
			job[i - 1] = job[i - 2] + parts.get(i);
		}

		for (int partialSum : job)
			sum += partialSum;

		return sum;
	}

	public static int minimumDistance(int numRows, int numCols, List<List<Integer>> area) {
		// C++ Code implementation for above problem

		// QItem for current location and distance
		// from source location
		QItem source = new QItem(0,0,0);

		// To keep track of isVisited QItems. Marking
		// blocked cells as isVisited.
		boolean[][] isVisited = new boolean[numRows][numCols];

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				if (area.get(i).get(j) == '0')
					isVisited[i][j] = true;
				else
					isVisited[i][j] = false;

				// Finding source
//				if (area.get(i).get(j) == 's') {
//					source.row = i;
//					source.col = j;
//				}
			}
		}

		// applying BFS on matrix cells starting from source
		Queue<QItem> q = new LinkedList<>();
		q.offer(source);
		isVisited[source.row][source.col] = true;
		while (!q.isEmpty()) {
			QItem p = q.poll();

			// Destination found;
			if (area.get(p.row).get(p.col) == 9)
				return p.dist;

			// moving up
			if (p.row - 1 >= 0 && isVisited[p.row - 1][p.col] == false) {
				q.offer(new QItem(p.row - 1, p.col, p.dist + 1));
				isVisited[p.row - 1][p.col] = true;
			}

			// moving down
			if (p.row + 1 < numRows && isVisited[p.row + 1][p.col] == false) {
				q.offer(new QItem(p.row + 1, p.col, p.dist + 1));
				isVisited[p.row + 1][p.col] = true;
			}

			// moving left
			if (p.col - 1 >= 0 && isVisited[p.row][p.col - 1] == false) {
				q.offer(new QItem(p.row, p.col - 1, p.dist + 1));
				isVisited[p.row][p.col - 1] = true;
			}

			// moving right
			if (p.col + 1 < numCols && isVisited[p.row][p.col + 1] == false) {
				q.offer(new QItem(p.row, p.col + 1, p.dist + 1));
				isVisited[p.row][p.col + 1] = true;
			}
		}
		return -1;
	}
}
