package food_picking;

public class Human{
    String name;
    private int res;
    private boolean isActive;
    boolean is_male;
    double bodyIndex;
    Package user_package;
    public Human(String name, int res, boolean isActive, boolean is_male, double height, double mass) {
        this.name = name;
        this.res = res;
        this.isActive = isActive;
        this.is_male = is_male;
        if(height>10.){this.bodyIndex = mass/(height*height/10000.);}
        else{this.bodyIndex = mass/height*height;}
    }
    public void YourPackage(Package[] packages){
        for (int i = 0; i < packages.length; i++) {
            if(packages[i].isEval(this.is_male, this.bodyIndex, this.isActive, this.res)){
                this.user_package = packages[i];
            }
        }
    }
    public void printDataToConsole(){
        System.out.println(name + "\t|"+res + "\t|"+isActive + "\t|"+is_male + "\t|"+ String.format("%.2f",bodyIndex) + "\t|");
    }
}
