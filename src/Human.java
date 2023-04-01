public class Human implements I_proteins_fats_carbohydrates {
    String name;
    short age;
    boolean is_male;
    float height;
    float body_mass;
    int calories;
    int proteins;
    int fats;
    int carbohydrates;

    public Human(String name, short age, boolean is_male, float height, float body_mass) {
        this.name = name;
        this.age = age;
        this.is_male = is_male;
        this.height = height;
        this.body_mass = body_mass;
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
