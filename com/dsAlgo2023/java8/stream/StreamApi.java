package com.dsAlgo2023.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        dataEntry(people);
        System.out.println("1. Find and print the names of all female Software Developers.");
         people.stream()
                 .filter(x->x.gender.equalsIgnoreCase("female")&&x.profession.equals("Software Engineer"))
                 .map(x->x.name).collect(Collectors.toList())
                 .forEach(System.out::println);

        System.out.println("\n\n2.Sort the persons by age in ascending order and print the result.");
        people.stream().sorted((p1,p2)-> p1.age.compareTo(p2.age)).forEach(System.out::println);

        System.out.println("\n\n3.Group the persons by gender and print the count of persons in each group.");
        people.stream().collect(Collectors.groupingBy(x->x.gender)).entrySet().forEach(x-> System.out.println( x.getKey()+": "+x.getValue().stream().count()));

        System.out.println("\n\n4.Calculate and print the total salary of all persons.");
        System.out.println(people.stream().map(x->x.salary).reduce(0.0,(a,b)->a+b));

        System.out.println("\n\n5. Find and print the person with the highest salary.");
        System.out.println(people.stream().max((p1,p2)->Double.compare(p1.salary,p2.salary)).get());

        System.out.println("\n\n6. Find and print the distinct professions in the dataset.");
        people.stream().map(x->x.profession).distinct().forEach(System.out::println);

        System.out.println("\n\n7. Filter the persons aged 25 or younger, map their names to uppercase, and print the result.");
        people.stream().filter(x->x.age<=25).map(x->x.name.toUpperCase()).forEach(System.out::println);

        System.out.println("\n\n8. Check if there is any person with a salary greater than 80000");
        //System.out.println(people.stream().filter(x->x.salary>80000).count() >0?true:false);
        System.out.println(people.stream().anyMatch(x->x.salary>80000));

        System.out.println("\n\n9. Create a map where the key is the profession, and the value is a list of persons with that profession.");
        people.stream().collect(Collectors.groupingBy(x->x.profession)).entrySet().forEach(System.out::println);

        System.out.println("\n\n10. Partition the persons into two groups: those aged 30 or older and those younger than 30. Print the result.");
        people.stream().collect(Collectors.partitioningBy(x->x.age<30)).entrySet().forEach(System.out::println);


    }


    public static void dataEntry(List<Person> people){
        people.add(new Person("Ishwar Singh", 24, "Male", 50000.0, "Software Developer"));
        people.add(new Person("Alice Johnson", 28, "Female", 60000.0, "Data Scientist"));
        people.add(new Person("Bob Williams", 32, "Male", 70000.0, "Product Manager"));
        people.add(new Person("Eva Davis", 25, "Female", 55000.0, "Graphic Designer"));
        people.add(new Person("Charlie Brown", 30, "Male", 65000.0, "System Analyst"));
        people.add(new Person("Olivia Miller", 26, "Female", 58000.0, "Software Engineer"));
        people.add(new Person("Daniel Smith", 29, "Male", 72000.0, "Financial Analyst"));
        people.add(new Person("Sophia Wilson", 27, "Female", 53000.0, "UX Designer"));
        people.add(new Person("Ethan Jones", 31, "Male", 68000.0, "Network Engineer"));
        people.add(new Person("Ava Martinez", 23, "Female", 51000.0, "Marketing Specialist"));
        people.add(new Person("Liam Brown", 33, "Male", 75000.0, "Project Manager"));
        people.add(new Person("Mia Garcia", 22, "Female", 49000.0, "Research Assistant"));
        people.add(new Person("Noah Taylor", 34, "Male", 80000.0, "Business Analyst"));
        people.add(new Person("Chloe Rodriguez", 21, "Female", 48000.0, "Software Engineer"));
        people.add(new Person("Logan Wright", 35, "Male", 85000.0, "Software Architect"));
        people.add(new Person("Emma Harris", 29, "Female", 62000.0, "IT Consultant"));
        people.add(new Person("Mason Lee", 26, "Male", 56000.0, "Database Administrator"));
        people.add(new Person("Grace Turner", 31, "Female", 73000.0, "Software Engineer"));
        people.add(new Person("Carter Clark", 28, "Male", 67000.0, "Quality Assurance Engineer"));
        people.add(new Person("Lily Baker", 24, "Female", 54000.0, "Customer Support Specialist"));

    }
}

class Person{
    String name;
    Integer age;
    String gender;
    Double salary;
    String profession;

    public Person(String name, int age, String gender, double salary, String profession) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", profession='" + profession + '\'' +
                '}';
    }
}