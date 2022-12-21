package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_나이순정렬 {
    static class Person{
        int age;
        String name;
        int index;
        public Person(int age, String name, int index){
            this.age = age;
            this.name = name;
            this.index = index;
        }
    }
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Person[] arr = new Person[N];
        for(int i = 0; i< arr.length; i++){
            arr[i] = new Person(sc.nextInt(), sc.next(), i);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1.age == o2.age) {
                return o1.index - o2.index;
            }
            return o1.age - o2.age;
        });

        for(Person p : arr){
            System.out.println(p.age + " " + p.name);
        }

        // 나이순 오름차순, 나이가 같으면 입력이 들어온순서대로. ( 객체에 따로 표시해주자.)
    }
}
