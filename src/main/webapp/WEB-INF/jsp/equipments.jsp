<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%
    String PageTitle = "Equipments";
    String PageName = "Equipments";
%>

<%@ include file="header.jsp" %>

<div>
    <div class="md:ml-auto md:pr-4 w-90 mb-6">
        <form action="equipments" method="get" class="relative flex flex-wrap items-stretch w-full transition-all rounded-lg ease-soft">
            <span class="text-sm ease-soft leading-5.6 absolute z-50 -ml-px flex h-full items-center whitespace-nowrap rounded-lg rounded-tr-none rounded-br-none border border-r-0 border-transparent bg-transparent py-2 px-2.5 text-center font-normal text-slate-500 transition-all">
              <i class="fas fa-search"></i>
            </span>
            <input type="text" name="search" value="${param.search}"
                   class="w-full pl-8.75 text-sm focus:shadow-soft-primary-outline ease-soft w-1/100 leading-5.6 relative -ml-px block min-w-0 flex-auto rounded-lg border border-solid border-gray-300 bg-white bg-clip-padding py-2 pr-3 text-gray-700 transition-all placeholder:text-gray-500 focus:border-fuchsia-300 focus:outline-none focus:transition-shadow"
                   placeholder="Search..."/>
        </form>
    </div>
    <div class="relative flex flex-col min-w-0 mb-6 break-words bg-white border-0 shadow-soft-xl rounded-2xl bg-clip-border">
        <div class="flex-auto p-4">
            <div class="flex flex-wrap -mx-3">
                <c:forEach items="${list}" var="equipment">
                    <div class="w-full max-w-full px-4 pb-2 mb-6 md:w-6/12 md:flex-none xl:mb-0 xl:w-3/12">
                        <div class="relative flex flex-col min-w-0 break-words bg-transparent border-0 shadow-none rounded-2xl bg-clip-border">
                            <div class="relative">
                                <a class="block shadow-xl rounded-xl">
                                    <img src="./assets/img/home-decor-3.jpg" alt="img-blur-shadow"
                                         class="max-w-full shadow-soft-2xl rounded-xl"/>
                                </a>
                            </div>
                            <div class="flex-auto px-1 pt-6">
                                <p class="relative z-10 mb-2 leading-normal text-transparent bg-gradient-to-tl from-gray-900 to-slate-800 text-sm bg-clip-text">
                                    <c:out value="${equipment.equipmentStatus}"/></p>
                                <a href="javascript:;">
                                    <h5><c:out value="${equipment.name}"/></h5>
                                </a>
                                <p class="mb-6 leading-normal text-sm"><c:out
                                        value="${equipment.type} - ${equipment.department.description}"/></p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
