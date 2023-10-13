<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Registration</title>
    <link rel="stylesheet" href="login.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>
    <div class="wrapper">
        <div class="form-wrapper sign-up">
            <form action="fs1" method="post" enctype="multipart/form-data">
                <h2>Sign Up</h2>
                <div class="input-group">
                    <input type="text" name="name" id="name" required>
                    <label for="">Enter Name</label>
                    <span class="error-message" id="name-error"></span> 
                </div>
                <div class="input-group">
                    <input type="text" name="addr" required>
                    <label for="">Your Address</label>
                    <span class="error-message" id="addr-error"></span> 
                </div>
                <div class="input-group">
                    <input type="email" name="email" id="email" required>
                    <label for="">Your Email</label>
                    <span class="error-message" id="email-error"></span> 
                </div>
                <div class="input-group">
                    <input type="text" name="contact" id="contact" required>
                    <label for="">Contact</label>
                    <span class="error-message" id="contact-error"></span> 
                </div>
                Image<input type="file" name="photo" id="photo" required>                    
                <span class="error-message" id="Img-error"></span> 
                <button type="submit" class="btn" name="signup" id="signup" value="Register">Register</button>
                <div class="sign-link">
                    <p>Already have an account? <a href="#" class="signIn-link">Sign In</a></p>
                </div>
            </form>
        </div>

        <div class="form-wrapper sign-in">
            <form action="fs2" method="post">
                <h2>Login</h2>
               <div class="input-group">
                    <input type="email" name="username" id="username" required>
                    <label for="">Username</label>
                </div>
                <div class="input-group">
                    <input type="password" name="password" id="password" required>
                    <label for="">Password</label>
                </div>
                <div class="forgot-pass">
                    <a href="#">Forgot Password?</a>
                </div>
                <button type="submit" class="btn">Login</button>
                <div class="sign-link">
                   <p>Don't have an account? <a href="#" class="signUp-link">Sign Up</a></p>
                </div>
            </form>
        </div>
    </div> 

    <script src="login.js"></script>
</body>
</html>