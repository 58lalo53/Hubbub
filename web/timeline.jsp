<%@page contentType="text/html" pageEncoding="ISO-8859-1" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hubbub2 &raquo; Posts</title>
        <link rel="stylesheet" type="text/css" href="styles/main.css"/>
    </head>
    <body>
        <div id="hd">
            <img src="images/headerlogo.png" alt="logo"/>
        </div>
        <div id="bd">
            <h1>Welcome to Hubbub2</h1>
            <h2 class="flash">${flash}</h2>
            <p>
                <c:choose>
                    <c:when test="${sessionScope.user.username != null}">
                        <a class="nav" href="index?action=post">Hey, ${sessionScope.user.username}! Post something!</a>
                        <a class="nav" href="index?action=logout">Log out of Hubbub</a>
                    </c:when>
                    <c:otherwise>
                        <a class="nav" href="index?action=join">Sign up for Hubbub</a>
                        <a class="nav" href="index?action=login">Log in to Hubbub</a
                    </c:otherwise>
                </c:choose>
            </p>
            <h2>Time Line</h2>
            <c:forEach var="post" items="${posts}">
                <div class="post">
                    <span class="postAuthor">${post.author}</span>
                    <span class="postDate">(user since ${post.author.joinDate})</span>
                    <div id="postContent">
                        ${post.content}
                    </div>
                    <span class="postDate">Posted ${post.postDate}</span>
                </div>   
            </c:forEach>    
        </div>
        <div id="ft">
            <div id="footerText">Hubbub -- Social Networking for Widgets, Inc.</div>
        </div>
    </body>
</html>
