<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%
    String PageTitle = "Reservations";
    String PageName = "Reservations";
%>

<%@ include file="header.jsp" %>

<div>
    <div class="relative flex flex-col min-w-0 mb-6 break-words bg-white border-0 border-transparent border-solid shadow-soft-xl rounded-2xl bg-clip-border">
        <div class="flex-auto px-0 pt-0 pb-2">
            <div class="p-0 overflow-x-auto">
                <table class="items-center w-full mb-0 align-top border-gray-200 text-slate-500">
                    <thead class="align-bottom">
                    <tr>
                        <th class="px-6 py-3 font-bold text-left uppercase align-middle bg-transparent border-b border-gray-200 shadow-none text-xxs border-b-solid tracking-none whitespace-nowrap text-slate-400 opacity-70">User</th>
                        <th class="px-6 py-3 pl-2 font-bold text-left uppercase align-middle bg-transparent border-b border-gray-200 shadow-none text-xxs border-b-solid tracking-none whitespace-nowrap text-slate-400 opacity-70">Equipment</th>
                        <th class="px-6 py-3 font-bold text-center uppercase align-middle bg-transparent border-b border-gray-200 shadow-none text-xxs border-b-solid tracking-none whitespace-nowrap text-slate-400 opacity-70">Borrow Date</th>
                        <th class="px-6 py-3 font-bold text-center uppercase align-middle bg-transparent border-b border-gray-200 shadow-none text-xxs border-b-solid tracking-none whitespace-nowrap text-slate-400 opacity-70">Return Date</th>
                        <th class="px-6 py-3 font-semibold capitalize align-middle bg-transparent border-b border-gray-200 border-solid shadow-none tracking-none whitespace-nowrap text-slate-400 opacity-70"></th>
                        <th class="px-6 py-3 font-semibold capitalize align-middle bg-transparent border-b border-gray-200 border-solid shadow-none tracking-none whitespace-nowrap text-slate-400 opacity-70"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${reservations}" var="reservation">
                        <tr>
                            <td class="p-2 align-middle bg-transparent border-b whitespace-nowrap shadow-transparent">
                                <div class="flex px-2 py-1">
                                    <div class="flex flex-col justify-center">
                                        <h6 class="mb-0 text-sm leading-normal">${reservation.user.name}</h6>
                                        <p class="mb-0 text-xs leading-tight text-slate-400">${reservation.user.role.name}</p>
                                    </div>
                                </div>
                            </td>
                            <td class="p-2 align-middle bg-transparent border-b whitespace-nowrap shadow-transparent">
                                <p class="mb-0 text-xs font-semibold leading-tight">${reservation.equipment.name}</p>
                            </td>
                            <td class="p-2 text-center align-middle bg-transparent border-b whitespace-nowrap shadow-transparent">
                                <span class="text-xs font-semibold leading-tight text-slate-400">${reservation.borrowDate}</span>
                            </td>
                            <td class="p-2 text-center align-middle bg-transparent border-b whitespace-nowrap shadow-transparent">
                                <span class="text-xs font-semibold leading-tight text-slate-400">${reservation.returnDate}</span>
                            </td>
                            <c:if test="${reservation.returnDate > now}">
                                <td class="p-2 align-middle bg-transparent border-b whitespace-nowrap shadow-transparent">
                                    <form method="post" action="equipment">
                                        <input type="hidden" name="_method" value="return">
                                        <input type="hidden" name="id" value="${reservation.id}">
                                        <button type="submit" class="text-xs font-semibold leading-tight text-slate-400">Return Now</button>
                                    </form>
                                </td>
                                <td class="p-2 align-middle bg-transparent border-b whitespace-nowrap shadow-transparent">
                                    <form method="post" action="equipment">
                                        <input type="hidden" name="_method" value="report">
                                        <input type="hidden" name="id" value="${reservation.equipment.id}">
                                        <button type="submit" class="text-xs font-semibold leading-tight text-slate-400">Report</button>
                                    </form>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
