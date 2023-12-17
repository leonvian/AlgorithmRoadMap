package design;

import java.util.*;

public class FoodRatings {
    private Map<String, Integer> foodToRating;
    private Map<String, String> foodToCuisine;
    private Map<String, TreeMap<Integer, TreeSet<String>>> cuisineToFood;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToRating = new HashMap<>();
        foodToCuisine = new HashMap<>();
        cuisineToFood = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodToRating.put(foods[i], ratings[i]);
            foodToCuisine.put(foods[i], cuisines[i]);

            cuisineToFood.putIfAbsent(cuisines[i], new TreeMap<>(Collections.reverseOrder()));
            cuisineToFood.get(cuisines[i]).putIfAbsent(ratings[i], new TreeSet<>());
            cuisineToFood.get(cuisines[i]).get(ratings[i]).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        int oldRating = foodToRating.get(food);
        String cuisine = foodToCuisine.get(food);

        // Remove the food from the old rating set
        cuisineToFood.get(cuisine).get(oldRating).remove(food);
        if (cuisineToFood.get(cuisine).get(oldRating).isEmpty()) {
            cuisineToFood.get(cuisine).remove(oldRating);
        }

        // Add the food to the new rating set
        cuisineToFood.get(cuisine).putIfAbsent(newRating, new TreeSet<>());
        cuisineToFood.get(cuisine).get(newRating).add(food);

        // Update the food's rating
        foodToRating.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        return cuisineToFood.get(cuisine).firstEntry().getValue().first();
    }
}