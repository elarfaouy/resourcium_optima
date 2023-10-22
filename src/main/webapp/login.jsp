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
        <div class="py-6 bg-transparent border-b-0 rounded-t-2xl">
            <h3 class="text-xl font-bold text-transparent bg-gradient-to-tl from-blue-600 to-cyan-400 bg-clip-text">Welcome back</h3>
            <p class="mb-0">Enter your username and password to sign in</p>
        </div>
        <form action="login" method="post">
            <div class="mb-4">
                <label for="username" class="block text-gray-600 text-sm font-medium pb-2">Username</label>
                <input type="text" id="username" name="username" placeholder="username" required
                       class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500">
            </div>
            <div class="mb-4">
                <label for="password" class="block text-gray-600 text-sm font-medium pb-2">Password</label>
                <input type="password" id="password" name="password" placeholder="password" required
                       class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500">
            </div>
            <button type="submit"
                    class="inline-block w-full px-6 py-3 mt-6 mb-0 font-bold text-center text-white uppercase align-middle transition-all bg-transparent border-0 rounded-lg cursor-pointer shadow-soft-md bg-x-25 bg-150 leading-pro text-xs ease-soft-in tracking-tight-soft bg-gradient-to-tl from-blue-600 to-cyan-400 hover:scale-102 hover:shadow-soft-xs active:opacity-85">Login</button>
            <div class="mt-4 p-6 px-1 pt-0 bg-transparent border-t-0 border-t-solid rounded-b-2xl lg:px-2">
                <p class="mx-auto mb-6 leading-normal text-sm">
                    Don't have an account?
                    <a href="register" class="relative z-10 font-semibold text-transparent bg-gradient-to-tl from-blue-600 to-cyan-400 bg-clip-text">Register</a>
                </p>
            </div>
        </form>
    </div>
</div>
</body>
</html>

