package design;

public class FoodRatingsExec {


    public static void main(String[] args) {
        String[] foods = new String[]   { "kimchi", "miso",     "sushi",    "moussaka", "ramen",   "bulgogi" };
        String[] cusines = new String[] { "korean", "japanese", "japanese",  "greek",    "japanese",  "korean" };
        int[] ratings = new int[] {        9,        12,           8,          15,           14,           7};

        FoodRatings foodRatings = new FoodRatings(foods, cusines, ratings);
        System.out.println(foodRatings.highestRated("korean")); // Kimchi
        System.out.println(foodRatings.highestRated("japanese")); // ramem

        foodRatings.changeRating("sushi", 16);

        System.out.println(foodRatings.highestRated("japanese")); // Sushi

        foodRatings.changeRating("ramen", 16);

        System.out.println(foodRatings.highestRated("japanese")); // Sushi

    }


}
