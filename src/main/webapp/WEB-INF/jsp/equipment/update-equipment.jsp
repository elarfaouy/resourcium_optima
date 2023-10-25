<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String PageTitle = "Update Equipment";
    String PageName = "Equipments";
%>

<%@ include file="../header.jsp" %>

<div>
    <div class="max-w-md mx-auto bg-white p-6 rounded shadow">
        <h1 class="text-2xl font-semibold mb-4">Update Equipment</h1>
        <form action="equipments" method="post">
            <input type="hidden" name="_method" value="update">
            <input type="hidden" name="id" value="${equipment.id}">
            <div class="mb-4">
                <label for="name" class="block text-gray-600">Name:</label>
                <input type="text" id="name" name="name" class="w-full px-4 py-2 border rounded" value="${equipment.name}">
            </div>
            <div class="mb-4">
                <label for="type" class="block text-gray-600">Type:</label>
                <input type="text" id="type" name="type" class="w-full px-4 py-2 border rounded" value="${equipment.type}">
            </div>
            <div class="mb-4">
                <label for="status" class="block text-gray-600">Status:</label>
                <select id="status" name="status" class="w-full px-4 py-2 border rounded">
                    <option ${equipment.equipmentStatus == "AVAILABLE" ? "selected" : ""} value="AVAILABLE">Available</option>
                    <option ${equipment.equipmentStatus == "IN_USE" ? "selected" : ""} value="IN_USE">In Use</option>
                    <option ${equipment.equipmentStatus == "MAINTENANCE" ? "selected" : ""} value="MAINTENANCE">Maintenance</option>
                    <option ${equipment.equipmentStatus == "OUT_SERVICE" ? "selected" : ""} value="OUT_SERVICE">Out of Service</option>
                </select>
            </div>
            <div class="mb-4">
                <label for="department" class="block text-gray-600">Department:</label>
                <select id="department" name="department" class="w-full px-4 py-2 border rounded">
                    <option ${equipment.department.id == 1 ? "selected" : ""} value="1">IT</option>
                </select>
            </div>
            <div class="mt-6">
                <button type="submit" class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600">Update Equipment</button>
            </div>
        </form>
    </div>
</div>

<%@ include file="../footer.jsp" %>
