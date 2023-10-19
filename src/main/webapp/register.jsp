<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="min-h-screen flex items-center justify-center bg-gray-100">
    <div class="bg-white p-8 rounded shadow-md max-w-md w-full">
        <h2 class="text-2xl text-center font-semibold mb-6">Register</h2>
        <form action="register" method="post">
            <div class="mb-4">
                <label for="username" class="block text-gray-600 text-sm font-medium">Username</label>
                <input type="text" id="username" name="username" placeholder="Enter your username" required
                       class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500">
            </div>
            <div class="mb-4">
                <label for="name" class="block text-gray-600 text-sm font-medium">Name</label>
                <input type="text" id="name" name="name" placeholder="Enter your name" required
                       class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500">
            </div>
            <div class="mb-4">
                <label for="surname" class="block text-gray-600 text-sm font-medium">Surname</label>
                <input type="text" id="surname" name="surname" placeholder="Enter your surname" required
                       class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500">
            </div>
            <div class="mb-4">
                <label for="email" class="block text-gray-600 text-sm font-medium">Email</label>
                <input type="text" id="email" name="email" placeholder="Enter your email" required
                       class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500">
            </div>
            <div class="mb-4">
                <label for="password" class="block text-gray-600 text-sm font-medium">Password</label>
                <input type="password" id="password" name="password" placeholder="Enter your password" required
                       class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500">
            </div>
            <div class="mb-4">
                <label for="role" class="block text-gray-600 text-sm font-medium">Role</label>
                <input type="text" id="role" name="role" placeholder="Enter your role" required
                       class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500">
            </div>
            <button type="submit"
                    class="w-full py-2 px-4 bg-blue-500 text-white rounded hover:bg-blue-600 focus:outline-none">Register</button>
        </form>
    </div>
</div>
</body>
</html>
