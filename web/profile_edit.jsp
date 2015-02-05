<%@page contentType="text/html" pageEncoding="ISO-8859-1" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hubbub2 &raquo; Edit Profile</title>
        <link rel="stylesheet" type="text/css" href="styles/main.css"/>
    </head>
    <body>
        <div id="hd">
            <img src="images/headerlogo.png" alt="logo"/>
        </div>
        <div id="bd">
            <h1>Profile for ${user.username}</h1>
            <h2 class="flash">${flash}</h2>
            <form method="POST" action="index" enctype="multipart/form-data"/>
                <label class="formElement">Biography</label>
                <input type="hidden" name="action" value="pedit"/>
                <input type="hidden" name="username" value="${user.username}"/>
                <textarea class="formElement" rows="10" cols="80" name="biography">
                    ${profile.biography}
                </textarea><br/>
                <label class="formElement">Upload a selfie</label>
                <input type="file" name="pic" id="pic"/>
                <input type="submit" valu="Save changes"/>
            </form>
            <a class="nav" href="index?action=timeline">Take me back to the Timeline.</a>
        </div>
        <div id="ft">
            <div class="footerText">Hubbub -- Social Networking for Widgets, Inc.</div>
        </div>
    </body>
</html>
