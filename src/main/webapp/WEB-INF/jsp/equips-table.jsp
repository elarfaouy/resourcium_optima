<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%
    String PageTitle = "Equipments Table";
    String PageName = "Equipments";
%>

<%@ include file="header.jsp" %>

<div>
    <a href="add-equipment" class="inline-block px-6 py-3 mt-6 mb-7.5 font-bold text-center text-white uppercase align-middle transition-all bg-transparent border-0 rounded-lg cursor-pointer active:opacity-85 hover:scale-102 hover:shadow-soft-xs leading-pro text-xs ease-soft-in tracking-tight-soft shadow-soft-md bg-150 bg-x-25 bg-gradient-to-tl from-gray-900 to-slate-800 hover:border-slate-700 hover:bg-slate-700 hover:text-white">Add Equipment</a>
    <div class="relative flex flex-col min-w-0 mb-6 break-words bg-white border-0 border-transparent border-solid shadow-soft-xl rounded-2xl bg-clip-border">
        <div class="flex-auto px-0 pt-0 pb-2">
            <div class="p-0 overflow-x-auto">
                <table class="items-center w-full mb-0 align-top border-gray-200 text-slate-500">
                    <thead class="align-bottom">
                    <tr>
                        <th class="px-6 py-3 font-bold text-left uppercase align-middle bg-transparent border-b border-gray-200 shadow-none text-xxs border-b-solid tracking-none whitespace-nowrap text-slate-400 opacity-70">Name</th>
                        <th class="px-6 py-3 pl-2 font-bold text-left uppercase align-middle bg-transparent border-b border-gray-200 shadow-none text-xxs border-b-solid tracking-none whitespace-nowrap text-slate-400 opacity-70">Type</th>
                        <th class="px-6 py-3 font-bold text-center uppercase align-middle bg-transparent border-b border-gray-200 shadow-none text-xxs border-b-solid tracking-none whitespace-nowrap text-slate-400 opacity-70">Status</th>
                        <th class="px-6 py-3 font-bold text-center uppercase align-middle bg-transparent border-b border-gray-200 shadow-none text-xxs border-b-solid tracking-none whitespace-nowrap text-slate-400 opacity-70">Department</th>
                        <th class="px-6 py-3 font-semibold capitalize align-middle bg-transparent border-b border-gray-200 border-solid shadow-none tracking-none whitespace-nowrap text-slate-400 opacity-70"></th>
                        <th class="px-6 py-3 font-semibold capitalize align-middle bg-transparent border-b border-gray-200 border-solid shadow-none tracking-none whitespace-nowrap text-slate-400 opacity-70"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="equipment">
                        <tr>
                            <td class="p-2 align-middle bg-transparent border-b whitespace-nowrap shadow-transparent">
                                <div class="flex px-2 py-1">
                                    <div>
                                        <img src="./assets/img/home-decor-3.jpg" class="inline-flex items-center justify-center mr-4 text-sm text-white transition-all duration-200 ease-soft-in-out h-9 w-9 rounded-xl" alt="user1" />
                                    </div>
                                    <div class="flex flex-col justify-center">
                                        <h6 class="mb-0 text-sm leading-normal"><c:out value="${equipment.name}"/></h6>
                                    </div>
                                </div>
                            </td>
                            <td class="p-2 align-middle bg-transparent border-b whitespace-nowrap shadow-transparent">
                                <p class="mb-0 text-xs font-semibold leading-tight"><c:out value="${equipment.type}"/></p>
                            </td>
                            <td class="p-2 text-sm leading-normal text-center align-middle bg-transparent border-b whitespace-nowrap shadow-transparent">
                                <span class="${equipment.statusCssClass} px-2.5 text-xs rounded-1.8 py-1.4 inline-block whitespace-nowrap text-center align-baseline font-bold uppercase leading-none text-white"><c:out value="${equipment.equipmentStatus}"/></span>
                            </td>
                            <td class="p-2 text-center align-middle bg-transparent border-b whitespace-nowrap shadow-transparent">
                                <span class="text-xs font-semibold leading-tight text-slate-400"><c:out value="${equipment.department.name}"/></span>
                            </td>
                            <td class="p-2 align-middle bg-transparent border-b whitespace-nowrap shadow-transparent">
                                <a href="update-equipment?id=${equipment.id}" class="text-xs font-semibold leading-tight text-slate-400"> Edit </a>
                            </td>
                            <td class="p-2 align-middle bg-transparent border-b whitespace-nowrap shadow-transparent">
                                <form action="delete-equipment?id=${equipment.id}" method="post">
                                    <button type="submit" class="text-xs font-semibold leading-tight text-slate-400"> Delete </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
