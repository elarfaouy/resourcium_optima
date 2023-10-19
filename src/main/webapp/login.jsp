<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="min-h-screen flex items-center justify-center bg-gray-100">
    <div class="bg-white p-8 rounded shadow-md max-w-md w-full">
        <h2 class="text-2xl text-center font-semibold mb-6">Login</h2>
        <form action="login" method="post">
            <div class="mb-4">
                <label for="username" class="block text-gray-600 text-sm font-medium">Username</label>
                <input type="text" id="username" name="username" placeholder="Enter your username" required
                       class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500">
            </div>
            <div class="mb-4">
                <label for="password" class="block text-gray-600 text-sm font-medium">Password</label>
                <input type="password" id="password" name="password" placeholder="Enter your password" required
                       class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500">
            </div>
            <button type="submit"
                    class="w-full py-2 px-4 bg-blue-500 text-white rounded hover:bg-blue-600 focus:outline-none">Login</button>
        </form>
    </div>
</div>
</body>
</html>

