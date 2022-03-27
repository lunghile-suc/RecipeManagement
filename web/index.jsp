<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://cdn.tailwindcss.com"></script>
        <script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
        <title>Recipe Management</title>
        <style>
            .scroll-hidden::-webkit-scrollbar {
                height: 0px;
                background: transparent; /* make scrollbar transparent */
            }
        </style>
    </head>
    <body>
        <c:choose>
            <c:when test="${ user == null}">                
                <jsp:include page="/includes/login.jsp" />
            </c:when>
            <c:otherwise>
    <!--<p>${user.getUserID()}</p>-->
                <jsp:include page="/includes/navbar.jsp" />
                <div class="container px-6 mx-auto">
                    <a href="recipe" class="inline-block my-8 px-4 py-2 font-medium tracking-wide text-white capitalize transition-colors duration-200 transform bg-blue-600 rounded-md hover:bg-blue-500 focus:outline-none focus:ring focus:ring-blue-300 focus:ring-opacity-80">
                        Add Recipe
                    </a>
                    <div class="flex flex-row flex-wrap">
                        <c:forEach var="recipe" items="${recipes}">
                            <div class="flex basis-2/5 m-6 overflow-hidden bg-white rounded-lg shadow-lg dark:bg-gray-800">
                                <div class="w-1/3 bg-cover" style="background-image: url('https://images.unsplash.com/photo-1494726161322-5360d4d0eeae?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80')"></div>
                                <div class="w-2/3 p-4 md:p-4">
                                    <h1 class="text-2xl font-bold text-gray-800 dark:text-white">${recipe.getRecipeName()}</h1>
                                    <div class="flex justify-between mt-3 item-center">
                                        <div class="">
                                            <h1 class="text-base font-bold text-gray-700 dark:text-gray-200 md:text-base">Prep Time</h1>
                                            <p class="text-base text-center font-bold text-gray-700 dark:text-gray-200 md:text-base">30 min</p>
                                        </div>
                                        <div class="">
                                            <h1 class="text-base font-bold text-gray-700 dark:text-gray-200 md:text-base">Serves</h1>
                                            <p class="text-base text-center font-bold text-gray-700 dark:text-gray-200 md:text-base">3+</p>
                                        </div>                           
                                    </div>
                                </div>
                            </div>
                            <p></p>
                        </c:forEach>                                 
                    </div>
                </div>
            </c:otherwise>
        </c:choose> 
    </body>
</html>
