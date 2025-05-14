import java.util.LinkedList;

/**
 * An animal shelter holds only dogs and cats, and operates on a strictly
 * "first in, first out" basis. People must adopt either the "oldest"
 * (based on arrival time) of all animals at the shelter, or they can
 * select whether they would prefer a dog or a cat (and will receive
 * the oldest animal of that type). They cannot select which specific
 * animal they would like. Create the data structures to maintain this
 * system and implement operations such as enqueue, dequeueAny, dequeueDog
 * and dequeueCat.You may use the built-in LinkedList data structure.
 */
public class AnimalShelter {

    static class Animal {

        String name;
        long timestamp;

        public Animal(String n) {
            name = n;
            timestamp = System.nanoTime();
        }
    }

    static class Dog extends Animal {

        public Dog(String n) {
            super(n);
        }

        public String toString() {
            return "Dog:" + name + ":" + timestamp;
        }
    }

    static class Cat extends Animal {

        public Cat(String n) {
            super(n);
        }

        public String toString() {
            return "Cat:" + name + ":" + timestamp;
        }
    }

    private LinkedList<Dog> dogs = new LinkedList<Dog>();
    private LinkedList<Cat> cats = new LinkedList<Cat>();

    public void enqueue(Animal a) {
        if (a instanceof Dog) {
            dogs.add((Dog) a);
        } else if (a instanceof Cat) {
            cats.add((Cat) a);
        } else {
            throw new IllegalArgumentException("Unknown type of animal!");
        }
    }

    public Dog dequeueDog() {
        if (dogs.isEmpty())
            throw new IllegalStateException("No dogs!");
        return dogs.removeFirst();
    }

    public Cat dequeueCat() {
        if (cats.isEmpty())
            throw new IllegalStateException("No cats!");
        return cats.removeFirst();
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            throw new IllegalStateException("No animals!");
        } else if (dogs.isEmpty()) {
            return dequeueCat();
        } else if (cats.isEmpty()) {
            return dequeueDog();
        } else if (peekDog().timestamp < peekCat().timestamp) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Dog peekDog() {
        if (dogs.isEmpty())
            throw new IllegalStateException("No dogs!");
        return dogs.getFirst();
    }

    public Cat peekCat() {
        if (cats.isEmpty())
            throw new IllegalStateException("No cats!");
        return cats.getFirst();
    }

    public Animal peekAny() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            throw new IllegalStateException("No animals!");
        } else if (dogs.isEmpty()) {
            return peekCat();
        } else if (cats.isEmpty()) {
            return peekDog();
        } else if (peekDog().timestamp < peekCat().timestamp) {
            return peekDog();
        } else {
            return peekCat();
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue(new Cat("lily"));
        shelter.enqueue(new Dog("tom"));
        shelter.enqueue(new Dog("peter"));
        shelter.enqueue(new Cat("john"));
        shelter.enqueue(new Cat("anne"));
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueCat());
        System.out.println(shelter.dequeueAny());
        shelter.enqueue(new Dog("tom"));
        System.out.println(shelter.dequeueDog());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
    }
}