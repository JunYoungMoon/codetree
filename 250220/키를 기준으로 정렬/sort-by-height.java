import java.util.*;

class Person implements Comparable<Person>{
    String name;

    int height, weight;

    public Person(String name, int height, int weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Person person) {
        if(this.height > person.height)
            return 1;
        else if(this.height < person.height)
            return -1;
        else
            return 0;
    }
};

public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        people.add(new Person("lee", 167, 40));
        people.add(new Person("kim", 149, 32));
        people.add(new Person("park", 161, 53));
        people.add(new Person("choi", 183, 70));
        people.add(new Person("jung", 155, 45));

        Collections.sort(people);

        // Comparator를 활용한 정렬 (키 기준 오름차순)
        // Collections.sort(people, new Comparator<Person>() {
        //     @Override
        //     public int compare(Person a, Person b) {
        //         return a.height - b.height;
        //     }
        // });

        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            System.out.println(person.name + " " + person.height + " " + person.weight);
        }
    }
}