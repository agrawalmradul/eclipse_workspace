package com.ctci.c_stacksQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Animal Shelter: An animal shelter, which holds only dogs and cats, operates
 * on a strictly"first in, first out" basis. People must adopt either the
 * "oldest" (based on arrival time) of all animals at the shelter, or they can
 * select whether they would prefer a dog or a cat (and will receive the oldest
 * animal of that type). They cannot select which specific animal they would
 * like. Create the data structures to maintain this system and implement
 * operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat. You may
 * use the built-in Linked list data structure.
 */

public class F_AnimalShelter {

	public static void main(String[] args) {
		F_AnimalShelter shelter = new F_AnimalShelter();
		shelter.enqueue("cat", 1);
		shelter.enqueue("cat", 2);
		shelter.enqueue("dog", 3);
		shelter.enqueue("cat", 4);
		shelter.enqueue("dog", 5);
		shelter.enqueue("cat", 6);
		System.out.println(shelter.cats.toString());
		System.out.println(shelter.dogs.toString());
		System.out.println(shelter.dequeueAny().kind);
		System.out.println(shelter.cats.toString());
		System.out.println(shelter.dogs.toString());
		System.out.println(shelter.dequeueCat().kind);
		System.out.println(shelter.cats.toString());
		System.out.println(shelter.dequeueCat().kind);
		System.out.println(shelter.cats.toString());
	}

	private class Animal {
		String kind;
		Integer arrival;

		public Animal(String kind, Integer time) {
			this.kind = kind;
			this.arrival = time;
		}
	}

	Queue<Animal> cats;
	Queue<Animal> dogs;

	public F_AnimalShelter() {
		cats = new LinkedList<>();
		dogs = new LinkedList<>();
	}

	public void enqueue(String kind, Integer time) {
		Animal admit = new Animal(kind, time);
		if (kind.equals("cat")) {
			cats.offer(admit);
		} else if (kind.equals("dog"))
			dogs.offer(admit);
	}

	public Animal dequeueAny() {
		if (dogs.isEmpty() && cats.isEmpty())
			return null;
		if (dogs.isEmpty())
			return cats.poll();
		if (cats.isEmpty())
			return dogs.poll();

		Integer oldCat = cats.peek().arrival;
		Integer oldDog = dogs.peek().arrival;

		if (oldCat < oldDog)
			return cats.poll();
		else
			return dogs.poll();
	}

	public Animal dequeueDog() {
		return dogs.isEmpty() ? null : dogs.poll();
	}

	public Animal dequeueCat() {
		return cats.isEmpty() ? null : cats.poll();
	}
}
