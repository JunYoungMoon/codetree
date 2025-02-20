import java.util.*;

class Person{
    String name;

    int height, weight;

    public Person(String name, int height, int weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
};

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Person[] people = new Person[n];
        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();

            people[i] = new Person(name, height, weight);
        }

        // custom comparator를 활용한 정렬
        Arrays.sort(people, new Comparator<Person>() {  
            @Override
            public int compare(Person a, Person b) {
                return a.height - b.height;
            }
        });


        for (int i = 0; i < n; i++){
            System.out.print(people[i].name + " ");
            System.out.print(people[i].height + " ");
            System.out.println(people[i].weight);
        }
    }
}