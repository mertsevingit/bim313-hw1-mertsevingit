package edu.bim313;
import org.paukov.combinatorics3.Generator;

import java.util.Arrays;
import java.util.List;

import static edu.bim313.TurkishNetwork.cities;
import static edu.bim313.TurkishNetwork.distance;


public class App 
{
    private static List<String> listCities = Arrays.asList(cities);

    public static void main(String[] args) {
        Generator.combination(cities)
                .simple(3)
                .stream()
                .filter(App::isViolating)
                .forEach(App::printTrioCities);
    }

    private static boolean isViolating(List<String> trioCity) {
        int indexCity1 = listCities.indexOf(trioCity.get(0));
        int indexCity2 = listCities.indexOf(trioCity.get(1));
        int indexCity3 = listCities.indexOf(trioCity.get(2));

        int a = distance[indexCity1][indexCity2];
        int b = distance[indexCity1][indexCity3];
        int c = distance[indexCity2][indexCity3];

        return !((a + b > c) && (a + c > b) && (b + c > a));
    }

    private static void printTrioCities(List<String> trioCity) {
        System.out.println(trioCity.get(0) + " " + trioCity.get(1) + " " + trioCity.get(2));
    }
}
