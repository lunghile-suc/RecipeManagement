<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://cdn.tailwindcss.com"></script>
        <script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
        <title>New Recipe</title>
    </head>
    <body class="dark:bg-gray-800">
        <form action="update-recipe" method="post">
            <input type="hidden" name="categoryID" value="${recipe.getCategoryID()}">
            <input type="hidden" name="foodTypeID" value="${recipe.getFoodID()}">
            <input type="hidden" name="recipeID" value="${recipe.getRecipeID()}">

            <section class="w-full max-w-2xl my-8 px-6 py-4 mx-auto bg-white rounded-md shadow-md dark:bg-gray-800">
                <h2 class="text-3xl font-semibold text-center text-gray-800 dark:text-white">Update Recipe</h2>

                <div class="mt-6 ">
                    <div class="items-center -mx-2 md:flex">
                        <div class="w-full mx-2">
                            <label class="block mb-2 text-sm font-medium text-gray-600 dark:text-gray-200">Recipe Name</label>
                            <input class="block w-full px-4 py-2 text-gray-700 bg-white border rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-400 focus:ring-blue-300 dark:focus:border-blue-300 focus:outline-none focus:ring focus:ring-opacity-40" type="text" name="UprecipeName" value="${recipe.getRecipeName()}">
                        </div>
                    </div>

                    <div class="items-center -mx-2 md:flex">
                        <div class="w-full mx-2 mt-4">
                            <label class="block mb-2 text-sm font-medium text-gray-600 dark:text-gray-200">Preparation Time:</label>
                            <select class="block w-full px-4 py-2 text-gray-700 bg-white border rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-400 focus:ring-blue-300 dark:focus:border-blue-300 focus:outline-none focus:ring focus:ring-opacity-40" name="UprecipeDuration">
                                <option><c:out value="${recipe.getRecipeDuration()}" /></option>
                                <option>Less than 30 min</option>
                                <option>1 Hour</option>
                                <option>1 Hour 30 min</option>
                                <option>2 Hours</option>
                                <option>2 Hour 30 min</option>
                                <option>3 Hours+</option>
                                <option>12 Hours</option>
                                <option>24 hours</option>
                            </select>
                        </div>

                        <div class="w-full mx-2 mt-4">
                            <label class="block mb-2 text-sm font-medium text-gray-600 dark:text-gray-200">Servings:</label>
                            <select class="block w-full px-4 py-2 text-gray-700 bg-white border rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-400 focus:ring-blue-300 dark:focus:border-blue-300 focus:outline-none focus:ring focus:ring-opacity-40" name="UprecipeServings">
                                <option><c:out value="${recipe.getRecipeServings()}" /></option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4+</option>
                            </select>
                        </div>
                    </div>

                    <div class="items-center -mx-2 md:flex">
                        <div class="w-full mx-2 mt-4">
                            <label class="block mb-2 text-sm font-medium text-gray-600 dark:text-gray-200">Category:</label>
                            <select class="block w-full px-4 py-2 text-gray-700 bg-white border rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-400 focus:ring-blue-300 dark:focus:border-blue-300 focus:outline-none focus:ring focus:ring-opacity-40" name="UprecipeCategory">
                                <c:forEach var="category" items="${categories}">
                                    <option value="${category.getCategoryID()}"><c:out value="${category.getCategoryName()}" /></option>      
                                </c:forEach>          
                            </select>
                        </div>

                        <div class="w-full mx-2 mt-4">
                            <label class="block mb-2 text-sm font-medium text-gray-600 dark:text-gray-200">Food Type:</label>
                            <select class="block w-full px-4 py-2 text-gray-700 bg-white border rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-400 focus:ring-blue-300 dark:focus:border-blue-300 focus:outline-none focus:ring focus:ring-opacity-40" name="UprecipeFoodType">
                                <c:forEach var="foodType" items="${foodTypes}">
                                    <option value="${foodType.getFoodTypeID()}"><c:out value="${foodType.getFoodType()}" /></option>                  
                                </c:forEach>          
                            </select>
                        </div>
                    </div>

                    <div class="w-full mt-4">
                        <label class="block mb-2 text-sm font-medium text-gray-600 dark:text-gray-200">Ingredients (, separated): </label>
                        <textarea class="block w-full h-40 px-4 py-2 text-gray-700 bg-white border rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-400 dark:focus:border-blue-300 focus:outline-none focus:ring focus:ring-blue-300 focus:ring-opacity-40" name="UprecipeIngredients">
                            <c:out value="${recipe.getRecipeIngredients()}" />
                        </textarea>
                    </div>

                    <div class="w-full mt-4">
                        <label class="block mb-2 text-sm font-medium text-gray-600 dark:text-gray-200">Instructions (, separated):</label>
                        <textarea class="block w-full h-40 px-4 py-2 text-gray-700 bg-white border rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-400 dark:focus:border-blue-300 focus:outline-none focus:ring focus:ring-blue-300 focus:ring-opacity-40" name="UprecipeInstructions">
                            <c:out value="${recipe.getRecipeInstructions()}" />
                        </textarea>
                    </div>

                    <div class="w-full mt-4">
                        <label class="block mb-2 text-sm font-medium text-gray-600 dark:text-gray-200">Image:</label>
                        <input class="block w-full px-4 py-2 text-gray-700 bg-white border rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-400 focus:ring-blue-300 dark:focus:border-blue-300 focus:outline-none focus:ring focus:ring-opacity-40" type="file" name="UprecipeImage">
                    </div>

                    <div class="flex justify-start mt-6">
                        <button class="px-4 py-2 font-medium tracking-wide text-white capitalize transition-colors duration-200 transform bg-blue-600 rounded-md hover:bg-blue-500 focus:outline-none focus:ring focus:ring-blue-300 focus:ring-opacity-80">
                            Update Recipe
                        </button>
                    </div>
                </div>
            </section>
        </form>
    </body>
</html>
