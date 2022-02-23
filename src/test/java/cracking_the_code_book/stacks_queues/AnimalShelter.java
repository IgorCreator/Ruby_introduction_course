package cracking_the_code_book.stacks_queues;

import java.util.Date;
import java.util.LinkedList;

public class AnimalShelter {
    LinkedList<Animal> cats = new LinkedList<>();
    LinkedList<Animal> dogs = new LinkedList<>();

    private void enqueue(String animalType){
        Animal newAnimalInShelter = new Animal(animalType, new Date());
        if(animalType.equals("Dog")) dogs.addLast(newAnimalInShelter);
        else cats.addLast(newAnimalInShelter);
    }

    private Animal dequeueAny() {
        if (dogs.size() == 0) {
            return dequeueCats();
        } else if (cats.size() == 0) {
            return dequeueDogs();
        }

        Animal oldestCat = cats.peek();
        Animal oldestDog = dogs.peek();

        if (oldestCat.arrivedInShelter().after(oldestDog.arrivedInShelter()))
            return dequeueCats();
        else
            return dequeueDogs();
    }

        private Animal dequeueCats() {
            return dogs.pop();
    }

    private Animal dequeueDogs() {
        return cats.pop();
    }

    // My solution
//    LinkedList<Animal> all = new LinkedList<>();
//    LinkedList<Animal> cats = new LinkedList<>();
//    LinkedList<Animal> dogs = new LinkedList<>();
//
//    private void enqueue(String animalType){
//        Animal newAnimalInShelter = new Animal(animalType, new Date());
//        if(animalType.equals("Dog")) dogs.add(newAnimalInShelter);
//        else cats.add(newAnimalInShelter);
//
//        all.add(newAnimalInShelter);
//    }
//
//    private Animal dequeueAny(){
//        Animal oldestAnimal = all.pop();
//        if(oldestAnimal.getType().equals("Dog")) dogs.pop();
//        else cats.pop();
//
//        return oldestAnimal;
//    }
//
//    private Animal dequeueDog(){
//        Animal oldestDog = dogs.pop();
//        if(all.getLast().getType().equals("Cat")){
//            Animal oldestCat = all.pop();
//            all.pop();
//            all.add(oldestCat);
//        } else {
//            all.pop();
//        }
//        return oldestDog;
//    }
//
//    private Animal dequeueCat(){
//        Animal oldestCat = cats.pop();
//        if(all.getLast().getType().equals("Dog")){
//            Animal oldestDog = all.pop();
//            all.pop();
//            all.add(oldestDog);
//        } else {
//            all.pop();
//        }
//        return oldestCat;
//    }
//
    class Animal {
        private String type;
        private Date arrivingInShelter;

        public String getType() {
            return type;
        }

        public Animal(String type, Date arrivingInShelter) {
            this.type = type;
            this.arrivingInShelter = arrivingInShelter;
        }

        public Date arrivedInShelter() {
            return arrivingInShelter;
        }
    }
}
