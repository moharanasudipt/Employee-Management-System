<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="java.util.*,p1.Employee" %>
        <% if("name"==null)
        { session.getAttribute("name");
         response.sendRedirect("login.jsp"); 
        } 
        %>
   
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>
        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        
        <style>
            .bg{
                background-color: #ffcc00;
            }
            .bod{
                background-color: #9999ff;
                box-shadow: 4px 4px 22px purple;
            }
            .t{
                background-color: #ffcc00;
            }
            h1{
                text-rendering: auto;
                text-shadow: 3px 3px 6px violet;
            }
            img.ims{
                height: 70px;
                width: 70px;
                margin-left:20px;
                border-top-left-radius: 15%;
                border-bottom-right-radius: 15%;
                box-shadow: 4px 4px 8px #070402;
            }
        </style>
    </head>
    <body >
        <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        %>
       
        <!-- Navigation -->

        <nav class="navbar navbar-expand-lg navbar-light bg">
            <div class="container">
                <a class="navbar-brand" href="#"><h2>Home</h2></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                                             
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded bg-danger"
                                                                href="logout">Logout</a></li>                                      
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded bg-success"
                                                             href="#"><%=session.getAttribute("name")%></a></li>
                        <li class="nav-item mx-0 mx-lg-1"><img class="ims" src='<%=session.getAttribute("iname")%>' alt="image" /></li>
                                                             
                    </ul>
                </div> 
            </div>
        </nav>


        <!-- Employee Information Section -->
        <section id="employee-info" class="py-5">
            <div class="container bod">
                <center><h1>EMPLOYEE INFORMATION</h1></center>
                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-bordered table-striped">
                            <thead >
                                <tr>
                                    <th>Employee Id</th>
                                    <th>Employee Name</th>
                                    <th>Employee Address</th>
                                    <th>Employee Mail</th>
                                    <th>Employee Contact</th>
                                    <th>ACTION</th>
                                </tr>
                            </thead>
                            <c:forEach var="E" items="${allEmp}">
                        <tr>
                            <td>
                                <c:out value="${E.eid}" />
                            </td>
                            <td>
                                <c:out value="${E.ename}" />
                            </td>
                            <td>
                                <c:out value="${E.eaddr}" />
                            </td>
                            <td>
                                <c:out value="${E.email}" />
                            </td>
                            <td>
                                <c:out value="${E.phone_no}" />
                            </td>
                             
                            <c:set var="message" value='${requestScope["cmail"]}' />
                            <c:set var="reqEmail" value="${E.email}" scope="request" />

                            <c:choose>
                                <c:when test="${reqEmail == message}">
                            <td>
<a href=update.jsp?idss=<c:out value="${E.eid}"/>&name=<c:out value="${E.ename}"/>&addr=<c:out value="${E.eaddr}" />&email=<c:out value="${E.email}" />&contact=<c:out value="${E.phone_no}" />><button type="button" class="btn btn-success">Edit</button></a>
<a href=fs4?del=<c:out value="${E.eid}"/>><button type="button" class="btn btn-danger">Delete</button></a>
                            </td>
                        </c:when>

                        <c:otherwise>
                            <td>
                                <button class="btn btn-outline-danger" type="button">Access Denied</button>
                            </td>
                        </c:otherwise>

                        </c:choose>
                        </tr>
                    </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </section>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>