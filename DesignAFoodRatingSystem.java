class Dish{
    String cuisine;
    String food;
    int rating;
    int expired = 0;
    Dish(String cuisine , String food , int rating){
        this.cuisine = cuisine;
        this.food = food;
        this.rating = rating;
    }
}
class FoodRatings {
    HashMap<String , Dish> foodRating = null;
    HashMap<String, PriorityQueue<Dish> > map = null;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRating = new HashMap<>();
        map = new HashMap<>();
        for(int i = 0 ; i < foods.length ; i++){
            String cuisine = cuisines[i] , food = foods[i];
            Dish dish = new Dish(cuisine , food , ratings[i]);
            foodRating.put(food , dish);
            if(!map.containsKey(cuisine)){
                map.put(cuisine , new PriorityQueue<>((a, b) -> {
                    if(a.rating == b.rating){
                        return a.food.compareTo(b.food);
                    }else{
                        return Integer.compare(b.rating , a.rating);
                    }
                }));
            }
            map.get(cuisine).add(dish);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Dish dish = foodRating.get(food);
        dish.expired = 1;
        String cuisine = dish.cuisine;
        Dish newDish = new Dish(cuisine , food , newRating);
        foodRating.put(food , newDish);
        map.get(cuisine).add(newDish);
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Dish> pq= map.get(cuisine);
        while (pq.peek().expired == 1){
            pq.poll();
        }
        return pq.peek().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
