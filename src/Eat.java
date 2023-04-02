public class Eat implements I_proteins_fats_carbohydrates {
    String foodName;
    int calories;
    int proteins;
    int fats;
    int carbohydrates;
    boolean veganFood = false;
    public Eat(){

    }
    @Override
    public void eat(int calories, int proteins, int fats, int carbohydrates) {
        this.calories += calories;
        this.proteins += proteins;
        this.fats += fats;
        this.carbohydrates += carbohydrates;
    }

    @Override
    public void burn(int calories, int proteins, int fats, int carbohydrates) {
        this.calories -= calories;
        this.proteins -= proteins;
        this.fats -= fats;
        this.carbohydrates -= carbohydrates;
    }
}
