package ctci.chapter16._10_livingpeople;

import java.util.Arrays;
import java.util.Random;

public class LivingPeople {

    public static int getMostpopulationYear_Best(Person[] people, int startYear, int endYear) {
        int[] population = new int[endYear - startYear + 1];
        for (Person person : people) {
            population[person.birthYear - startYear]++;
            population[person.deathYear - startYear + 1]--;
        }

        int maxLiveYear = 0;
        int maxPopulation = 0;
        int currentPopulation = 0;
        for (int i=0;i<population.length;i++) {
            currentPopulation += population[i];
              if(currentPopulation > maxPopulation){
                  maxPopulation = currentPopulation;
                  maxLiveYear = i + startYear;
              }
        }
        return maxLiveYear;
    }

    public static int getMostpopulationYear(Person[] people, int startYear, int endYear) {

        int[] birthYears = new int[people.length];
        int[] deathYears = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            birthYears[i] = people[i].birthYear;
            deathYears[i] = people[i].deathYear;
        }
        Arrays.sort(birthYears);
        Arrays.sort(deathYears);

        int i = 0;
        int j = 0;
        int mostYear = startYear;
        int currentPopulation = 0;
        int mostPopulation = 0;
        while (i < people.length && j < people.length) {
            if (birthYears[i] <= deathYears[j]) {
                currentPopulation++;
                if (currentPopulation > mostPopulation) {
                    mostPopulation = currentPopulation;
                    mostYear = birthYears[i];
                }
                i++;
            } else {
                currentPopulation--;
                j++;
            }
        }
        return mostYear;
    }

    public static void main(String[] args) {
        int n = 20;
        int first = 1900;
        int last = 2000;
        Person[] people = new Person[]{
                new Person(1982, 1998),
                new Person(1930, 1994),
                new Person(1928, 1971),
                new Person(1997, 1999),
                new Person(1977, 1979),
                new Person(1950, 1997),
                new Person(1954, 1965),
                new Person(1909, 1924),
                new Person(1955, 1973),
                new Person(1941, 1977),
                new Person(1995, 1998),
                new Person(1959, 1990),
                new Person(1991, 1994),
                new Person(1901, 1997),
                new Person(1992, 1999),
                new Person(1962, 1962),
                new Person(1971, 1982),
                new Person(1974, 1994),
                new Person(1924, 1999),
                new Person(1934, 1990)};
        int year = getMostpopulationYear(people, first, last);
        System.out.printf("max live year = %d \n", year);

        year = getMostpopulationYear_Best(people, first, last);
        System.out.printf("(VEST)max live year = %d \n", year);

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int birth = first + random.nextInt(last - first);
            int death = birth + random.nextInt(last - birth);
            people[i] = new Person(birth, death);
            System.out.println(birth + ", " + death);
        }
        year = getMostpopulationYear(people, first, last);
        System.out.println(year);
    }
}
