<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String PageTitle = "Settings";
    String PageName = "Settings";
%>

<%@ include file="header.jsp" %>

<div>
    <div class="bg-white p-8 rounded-lg shadow-lg max-w-md w-full mx-auto mt-8 mb-7.5">
        <h1 class="text-2xl font-semibold mb-4">User Settings</h1>

        <!-- User Information Update Form -->
        <form action="settings" method="post">
            <input type="hidden" name="_method" value="user">
            <input type="hidden" name="id" value="${sessionScope.user.id}">
            <div class="mb-4">
                <label for="username" class="block text-gray-600">Username</label>
                <input type="text" id="username" name="username" placeholder="Enter your username" disabled
                       class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500" value="${sessionScope.user.username}">
            </div>

            <div class="mb-4">
                <label for="name" class="block text-gray-600">Name</label>
                <input type="text" id="name" name="name" placeholder="Enter your name" required
                       class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500" value="${sessionScope.user.name}">
            </div>

            <div class="mb-4">
                <label for="surname" class="block text-gray-600">Surname</label>
                <input type="text" id="surname" name="surname" placeholder="Enter your surname" required
                       class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500" value="${sessionScope.user.surname}">
            </div>

            <div class="mb-4">
                <label for="email" class="block text-gray-600">Email</label>
                <input type="email" id="email" name="email" placeholder="Enter your email" required
                       class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500" value="${sessionScope.user.email}">
            </div>

            <button type="submit" class="btn-update bg-blue-500 text-white rounded p-2">Update Information</button>
        </form>

        <hr class="my-6">

        <!-- Password Change Form -->
        <form action="settings" method="post">
            <input type="hidden" name="_method" value="password">
            <input type="hidden" name="id" value="${sessionScope.user.id}">
            <div class="mb-4">
                <label for="currentPassword" class="block text-gray-600">Current Password</label>
                <input type="password" id="currentPassword" name="currentPassword" placeholder="Enter your current password" required
                       class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500">
            </div>

            <div class="mb-4">
                <label for="newPassword" class="block text-gray-600">New Password</label>
                <input type="password" id="newPassword" name="newPassword" placeholder="Enter your new password" required
                class="w-full p-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500">
            </div>

            <button type="submit" class="btn-update-password bg-red-500 text-white rounded p-2">Change Password</button>
        </form>
    </div>
</div>

<%@ include file="footer.jsp" %>
