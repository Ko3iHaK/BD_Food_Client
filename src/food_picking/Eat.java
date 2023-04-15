package food_picking;

public class Eat {
    public Eat(String foodName, int calories, int proteins, int fats, int carbohydrates, boolean veganFood) {
        this.foodName = foodName;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.veganFood = veganFood;
    }
    private final String foodName;
    private final int calories;
    private final int proteins;
    private final int fats;
    private final int carbohydrates;
    private boolean veganFood;

    public void parameters(){
        System.out.println("| Name: "+ foodName+"| Calories: "+ calories + "| Proteins: "+proteins + "| Fats: "+ fats + "| Carbohydrates: "+ carbohydrates + "| ");
    }

}
