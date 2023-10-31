<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,p1.Employee" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <title>UPDATE</title>
        <style>
            body {

                background-color: #ffffff;
            }

            .card {

                background:url(bg.jpg);
                background-size: cover;

            }
            * {
                color: beige;
                font-family: Georgia, 'Times New Roman', Times, serif;
                font-style: oblique;

            }
            .p{
                text-align: center;
                text-shadow: 2px 2px 5px rgb(249, 162, 0);
                text-decoration: wavy;
            }
            .card{
                box-shadow: 6px 3px 42px rgb(104, 79, 5);
            }
            .i{
                font: bold;
            }
            .error {
                color: red;
                font-size: 1rem;
                margin-top: 5px;
                display: block;
            }

        </style>
    </head>

    <body>
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-sm-6">
                    <div class="card">
                        <div class="card-header" id="cardHeader">
                            <h3 class="p"> Edit Employee Details</h3>
                        </div>
                        <div class="card-body" id="cardBody">
                            <form action="fs3" method="get" onsubmit="return validateForm()">
                                <div class="form-group">
                                   
                                    <input type="hidden" class="form-control " id="id" name="id" value='<%= request.getParameter("idss")%>' readonly=true />

                                </div>
                                <div class="form-group">
                                    <label for="name" class="i">Enter Name</label>
                                    <input type="text" class="form-control " id="name" name="name" value='<%= request.getParameter("name")%>' />
                                    <span id="nameError" class="error"></span>
                                </div>
                                <div class="form-group">
                                    <label for="address" class="i">Enter Address</label>
                                    <input type="text" class="form-control " id="address" name="addr" value='<%= request.getParameter("addr")%>' />
                                    <span id="addressError" class="error"></span>
                                </div>
                                <div class="form-group">
                                    <label for="email" class="i">Enter Email</label>
                                    <input type="email" class="form-control " id="email" name="email"  value='<%= request.getParameter("email")%>' />
                                    <span id="emailError" class="error"></span>
                                </div>
                                <div class="form-group">
                                    <label for="contact" class="i">Contact</label>
                                    <input type="text" class="form-control " id="contact" name="contact"  value='<%= request.getParameter("contact")%>' />
                                    <span id="contactError" class="error"></span>
                                </div>
                                <button type="submit" class="btn btn-danger">Submit</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
        <script src="update.js"></script>
    </body>

</html>
