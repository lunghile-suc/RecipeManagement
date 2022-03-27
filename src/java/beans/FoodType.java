package beans;

public class FoodType {
    private int foodTypeID;
    private String foodType;

    public FoodType(int foodTypeID, String foodType) {
        this.foodTypeID = foodTypeID;
        this.foodType = foodType;
    }

    public FoodType(String foodType) {
        this.foodType = foodType;
    }
    

    public int getFoodTypeID() {
        return foodTypeID;
    }

    public String getFoodType() {
        return foodType;
    }
    
}
