package Class_Animal_and_interface_Edible;

public class Main {
    public static void main(String[] args) {
        Animal[] arr = new Animal[2];
        arr[0] = new Tiger();
        arr[1] = new Chicken();
        for (Animal animal : arr) {
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken) {
                System.out.println(((Chicken) animal).howToEat());
            }
        }
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
