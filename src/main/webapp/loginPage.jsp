<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script
      src="https://kit.fontawesome.com/64d58efce2.js"
      crossorigin="anonymous"
    ></script>
    <link rel="stylesheet" href="./content/css/loginPage.css" />
    <title>Sign in / Sign up Form</title>
  </head>
  <body>
    <div class="container">
      <div class="forms-container">
        <div class="signin-signup">

          <form action="loginController" class="sign-in-form" method="post">
            <h2 class="title">Sign in</h2>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" name="user_name" id="user_name" placeholder="Username" required/>
            </div>
            <div class="input-field">
              <i class="fas fa-lock"></i>
              <input type="password" name="user_password" id="user_password" placeholder="Password" required/>
            </div>
            
            <!-- Error Message Display -->
            <%
              String errorMessage = (String) request.getAttribute("errorMessage");
              if (errorMessage != null) {
            %>
                <div class="error-message" style="color: red; text-align: center; margin-bottom: 10px;">
                  <%= errorMessage %>
                </div>
            <%
              }
            %>

            <input type="submit" value="Login" class="btn solid" />
          </form>
          
          <form id="sign-up-form" action="AddUserController" class="sign-up-form" method="post">
            <h2 class="title">Sign up</h2>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="Username" name="user_name" required/>
            </div>
            <div class="input-field">
              <i class="fas fa-lock"></i>
              <input type="password" placeholder="Password" name="user_password" required/>
            </div>
            <div class="input-field">
              <i class="fas fa-envelope"></i>
              <input type="email" placeholder="Email" name="user_email" required/>
            </div>
            <div class="input-field">
              <i class='fas fa-user-cog'></i>
              <input type="text" placeholder="user_role" name="user_role" value="RENTER/RENTING" readonly/>
            </div>
            <input type="submit" class="btn" value="Sign up" />
          </form>
        </div>
      </div>

      <div class="panels-container">
        <div class="panel left-panel">
          <div class="content">
            <h3>Don't have an account ?</h3>
            <p>
              To become a part of our community, please sign up using your personal information.
            </p>
            <button class="btn transparent" id="sign-up-btn">
              Sign up
            </button>
            <p>
              If you're not User, <a href="loginAdmin.html" style="color: black; text-decoration: underline;">Click here</a> for Admin Login Page
            </p>
          </div>
          <img src="content/loginImage.png" class="image" alt="" />
        </div>
        <div class="panel right-panel">
          <div class="content">
            <h3>One of us ?</h3>
            <p>
              Please log in using your personal information to stay connected with us.
            </p>
            <button class="btn transparent" id="sign-in-btn">
              Sign in
            </button>
          </div>
          <img src="content/registerImage.png" class="image" alt="" />
        </div>
      </div>
    </div>

    <script src="./js/loginPage.js"></script>
    <script>
        document.getElementById("sign-up-form").addEventListener("submit", function(event) {
            alert("You have successfully registered.");
        });
    </script>
    
  </body>
</html>
