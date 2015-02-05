<%@page contentType="text/html" pageEncoding="ISO-8859-1" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hubbub2 &raquo; Join</title>
        <link rel="stylesheet" type="text/css" href="styles/main.css"/>
    </head>
    <body>
        <div id="hd">
            <img src="images/headerlogo.png" alt="logo"/>
        </div>
        <div id="bd">
            <h1>Sign Up for Hubbub, bub!</h1>
            <h2 class="flash">${flash}</h2>
            <form method="POST" action="index">
                <label>User Name:</label> <input type="text" name="username" required/>
                <label>Password:</label> <input type="password" name="password" required/>
                <input type="hidden" name="action" value="join"/>
                <input type="submit" value="Sign Up"/>
            </form>
            <a class="nav" href="index?action=timeline">Take me back to the Timeline</a>.
            <a class="nav" href="index?action=login">I already have an account, so let me log in</a>.
        </div>
        <div id="ft">
            <div class="footerText">Hubbub -- Social Networking for Widgets, Inc.</div>
        </div>
    </body>
</html>
