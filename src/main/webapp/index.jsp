<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resourcium Optima II</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="min-h-screen flex flex-col font-sans">

<!-- Header -->
<header class="bg-white py-4 flex justify-between items-center px-8">
    <h1 class="text-3xl font-semibold"><a href="<%= request.getContextPath() %>">Resourcium Optima II</a></h1>
    <div>
        <a href="login" class="btn-login bg-blue-500 hover:bg-blue-600 text-white font-semibold px-6 py-3 rounded-md transition duration-300 ease-in-out transform hover:scale-105 mr-4">Login</a>
        <a href="register" class="btn-register bg-indigo-500 hover:bg-indigo-600 text-white font-semibold px-6 py-3 rounded-md transition duration-300 ease-in-out transform hover:scale-105">Register</a>
    </div>
</header>

<!-- Main Content -->
<section class="bg-white border-b py-8">
    <div class="container mx-auto flex flex-wrap pt-4 pb-12">
        <div class="w-full mb-4">
            <div class="h-1 mx-auto gradient w-64 opacity-25 my-0 py-0 rounded-t"></div>
        </div>
        <div class="w-full md:w-1/3 p-6 flex flex-col flex-grow flex-shrink">
            <div class="flex-1 bg-white rounded-t rounded-b-none overflow-hidden shadow">
                <a href="#" class="flex flex-wrap no-underline hover:no-underline">
                    <img src="https://images.unsplash.com/photo-1556761175-5973dc0f32e7?auto=format&fit=crop&q=80&w=1932&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Image 1" class="rounded-lg shadow-md mx-auto">
                    <div class="w-full font-bold text-xl text-gray-800 px-6 mt-6">
                        User Management
                    </div>
                    <p class="text-gray-800 text-base px-6 mb-5">
                        Effortlessly set up user authentication, account creation, role management, and more.
                    </p>
                </a>
            </div>
        </div>
        <div class="w-full md:w-1/3 p-6 flex flex-col flex-grow flex-shrink">
            <div class="flex-1 bg-white rounded-t rounded-b-none overflow-hidden shadow">
                <a href="#" class="flex flex-wrap no-underline hover:no-underline">
                    <img src="https://images.unsplash.com/photo-1542626991-cbc4e32524cc?auto=format&fit=crop&q=80&w=2069&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Image 2" class="rounded-lg shadow-md mx-auto">
                    <div class="w-full font-bold text-xl text-gray-800 px-6 mt-6">
                        Resource Allocation
                    </div>
                    <p class="text-gray-800 text-base px-6 mb-5">
                        Empower your staff to efficiently reserve equipment and allow HR to assign tasks based on resource availability.
                    </p>
                </a>
            </div>
        </div>
        <div class="w-full md:w-1/3 p-6 flex flex-col flex-grow flex-shrink">
            <div class="flex-1 bg-white rounded-t rounded-b-none overflow-hidden shadow">
                <a href="#" class="flex flex-wrap no-underline hover:no-underline">
                    <img src="https://images.unsplash.com/photo-1531403009284-440f080d1e12?auto=format&fit=crop&q=80&w=2070&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Image 3" class="rounded-lg shadow-md mx-auto">
                    <div class="w-full font-bold text-xl text-gray-800 px-6 mt-6">
                        Issue Management
                    </div>
                    <p class="text-gray-800 text-base px-6 mb-5">
                        Enable your staff to report equipment issues with automatic notifications to administrators.
                    </p>
                </a>
            </div>
        </div>
    </div>
</section>

<!-- Footer -->
<footer class="bg-white py-4">
    <div class="container mx-auto text-center text-gray-600">
        &copy; 2023 Resourcium Optima II. All rights reserved.
    </div>
</footer>

</body>
</html>
