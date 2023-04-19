package food_picking;

import java.util.ArrayList;

public class Package {
    private int packageNumber;
    public ArrayList<Eat> foodList = new ArrayList<>();
    private boolean isActive;
    private int res;
    private boolean is_male;
    private float bodyIndexHight;
    private float bodyIndexLow;

    public Package(int packageNumber, boolean isActive, int res, boolean is_male) {
        this.packageNumber = packageNumber;
        this.isActive = isActive;
        this.res = res;
        this.is_male = is_male;
    }
    public Package(ArrayList<Eat> foodList){
        this.foodList = foodList;
    }
    public Package(){}
    public void addFood(Eat food_to_add){
        foodList.add(food_to_add);
    }

    public boolean isEval(boolean is_male, double bodyIndex, boolean isActive, int res){
        if((is_male == this.is_male) && (bodyIndex < bodyIndexHight) && (bodyIndex > bodyIndexLow) && (this.isActive == isActive) && (this.res == res)){
            return true;
        }
        return false;
    }
    public void printData(){
        System.out.println("| packageNumber: "+ packageNumber+"| isActive: "+ isActive + "| res: "+res + "| is_male: "+ is_male);

    }

}
