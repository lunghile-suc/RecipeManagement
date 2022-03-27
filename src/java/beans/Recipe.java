package beans;

public class Recipe {
    private int recipeID;
    private int userID;
    private int categoryID;
    private int foodID;
    private String recipeName;
    private String recipeIngredients;
    private String recipeInstructions;
    private String recipeDuration;
    private String recipeImage;
    private String recipeServings;

    public Recipe(int recipeID, int userID, int foodID, int categoryID, String recipeName, String recipeIngredients, String recipeInstructions, String recipeDuration, String recipeImage, String recipeServings) {
        this.recipeID = recipeID;
        this.userID = userID;
        this.foodID = foodID;
        this.categoryID = categoryID;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstructions = recipeInstructions;
        this.recipeDuration = recipeDuration;
        this.recipeImage = recipeImage;
        this.recipeServings = recipeServings;
    }

    public Recipe(int userID, int foodID, int categoryID, String recipeName, String recipeIngredients, String recipeInstructions, String recipeDuration, String recipeImage, String recipeServings) {
        this.userID = userID;
        this.foodID = foodID;
        this.categoryID = categoryID;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstructions = recipeInstructions;
        this.recipeDuration = recipeDuration;
        this.recipeImage = recipeImage;
        this.recipeServings = recipeServings;
    }

    public Recipe(int foodID, int categoryID, String recipeName, String recipeIngredients, String recipeInstructions, String recipeDuration, String recipeImage, String recipeServings) {
        this.foodID = foodID;
        this.categoryID = categoryID;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstructions = recipeInstructions;
        this.recipeDuration = recipeDuration;
        this.recipeImage = recipeImage;
        this.recipeServings = recipeServings;
    }

    public Recipe() {
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngedrients(String recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public String getRecipeInstructions() {
        return recipeInstructions;
    }

    public void setRecipeInstructions(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    public String getRecipeDuration() {
        return recipeDuration;
    }

    public void setRecipeDuration(String recipeDuration) {
        this.recipeDuration = recipeDuration;
    }

    public String getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(String recipeImage) {
        this.recipeImage = recipeImage;
    }

    public String getRecipeServings() {
        return recipeServings;
    }

    public void setRecipeServings(String recipeServings) {
        this.recipeServings = recipeServings;
    }
    
    
}
