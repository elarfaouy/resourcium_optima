<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.optima.resourcium_optima.domain.enums.EquipmentStatus" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="name" value="${equipment.name}"/>
<%
    String PageTitle = (String) pageContext.getAttribute("name");
    String PageName = "Equipment";
%>

<%@ include file="../header.jsp" %>

<div>
    <div class="bg-gray-100">
        <div class="container mx-auto py-8">
            <div class="max-w-xl mx-auto bg-white p-8 rounded-lg shadow">
                <h2 class="text-2xl font-semibold mb-4">Equipment Reservation</h2>
                <div class="mb-6">
                    <img src="./assets/img/home-decor-3.jpg" alt="Equipment Image"
                         class="w-full rounded-xl shadow-soft-2xl">
                </div>
                <p class="text-gray-600 mb-2">
                    Equipment Status: <span class="text-black font-semibold">${equipment.equipmentStatus}</span>
                </p>
                <h2 class="text-xl font-semibold mb-2">${equipment.name}</h2>
                <p class="text-sm text-gray-600 mb-6">${equipment.type} - ${equipment.department.description}</p>

                <c:choose>
                    <c:when test="${equipment.equipmentStatus eq EquipmentStatus.AVAILABLE}">
                        <!-- Reservation Form -->
                        <form action="equipment" method="post">
                            <input type="hidden" name="_method" value="reserve">
                            <input type="hidden" name="id" value="${equipment.id}">
                            <div class="mb-4">
                                <label for="days" class="block text-gray-600 font-medium">How Many Days ?</label>
                                <input type="number" name="days" id="days" max="7" min="1" required
                                       class="w-full border border-gray-300 rounded-md px-3 py-2 focus:outline-none focus:border-blue-400">
                            </div>
                            <button type="submit" class="bg-blue-500 text-white rounded-md py-2 px-4 hover:bg-blue-600">Reserve</button>
                        </form>
                    </c:when>
                    <c:when test="${equipment.equipmentStatus eq EquipmentStatus.IN_USE}">
                        <!-- Notification Form -->
                        <form action="equipment" method="post">
                            <input type="hidden" name="_method" value="notify">
                            <input type="hidden" name="id" value="${equipment.id}">
                            <button type="submit" class="bg-yellow-500 text-white rounded-md py-2 px-4 hover:bg-yellow-600">Notify Me, when available</button>
                        </form>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </div>
</div>

<%@ include file="../footer.jsp" %>
