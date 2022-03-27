<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="min-h-screen bg-no-repeat bg-contain bg-left object-contain"
     style="background-image: url('https://cdn.pixabay.com/photo/2017/10/16/09/01/hamburger-2856548__340.jpg')">
    <div class="flex justify-end">
        <div class="bg-white min-h-screen w-1/2 flex justify-center items-center">
            <div>
                <form action="signin" method="post">
                    <div>
                        <span class="text-sm text-gray-900">Welcome back</span>
                        <h1 class="text-2xl font-bold">Login to your account</h1>
                    </div>
                    <div class="my-3">
                        <label class="block text-md mb-2" for="email">Email</label>
                        <input class="px-4 w-full border-2 py-2 rounded-md text-sm outline-none" type="email" name="email" placeholder="email">
                    </div>
                    <div class="mt-5">
                        <label class="block text-md mb-2" for="password">Password</label>
                        <input class="px-4 w-full border-2 py-2 rounded-md text-sm outline-none" type="password" name="password" placeholder="password">
                    </div>                     
                    <div class="flex justify-between mt-2">
                        <div>
                            <input class="cursor-pointer"  type="radio" name="rememberme">
                            <span class="text-sm">Remember Me</span>
                        </div>
                        <span class="text-sm text-blue-700 hover:underline cursor-pointer">Forgot password?</span>
                    </div>
                    <div class="">
                        <button class="mt-4 mb-3 w-full bg-green-500 hover:bg-green-400 text-white py-2 rounded-md transition duration-100">Login now</button>
                    </div>
                </form>
                <p class="mt-8"> Dont have an account? <span class="cursor-pointer text-sm text-blue-600"> <a href="register.jsp">Sign Up</a></span></p>
            </div>
        </div>
    </div>
</div>
</div>
