<%@page contentType="text/html" pageEncoding="ISO-8859-1" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hubbub2 &raquo; Profile</title>
        <link rel="stylesheet" type="text/css" href="styles/main.css"/>
    </head>
    <body>
        <div id="hd">
            <img src="images/headerlogo.png" alt="logo"/>
        </div>
        <div id="bd">
            <h1>Profile for
                <a href="mailto:${profile.email}">${user.username}</a>
            </h1>
            <h2 class="flash">${flash}</h2>
            <div class="biography">${profile.biography}</div>
            <c:if test="${user.profileId == profile.id}">
                <a class="nav" href="index?action=pedit">Edit my profile</a>
            </c:if>
            <a class="nav" href="index?action=timeline">Take me back to the Timeline.</a>
        </div>
        <div id="ft">
            <div class="footerText">Hubbub -- Social Networking for Widgets, Inc.</div>
        </div>
    </body>
</html>
