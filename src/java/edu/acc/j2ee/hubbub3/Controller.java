package edu.acc.j2ee.hubbub3;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "timeline";
        HubbubDB db = getDB(request);
        if (db == null) {
            request.setAttribute("flash", "Cannot connect to database.");
            action = "timeline";
        }
        
        String destination;
        switch (action) {
            default:
            case "timeline": destination = timeline(request); break;
            case "join": destination = join(request); break;
            case "post": destination = post(request); break;
            case "login": destination = login(request); break;
            case "logout": destination = logout(request); break;
            case "profile": destination = profile(request); break;
            case "pedit": destination = editProfile(request); break;
        }
        request.getRequestDispatcher(destination + ".jsp").forward(request, response);
    }
    
    private HubbubDB getDB(HttpServletRequest request) throws ServletException {
        HttpSession session = request.getSession();
        HubbubDB db = (HubbubDB)session.getAttribute("db");
        if (db == null) {
            try {
                db = new HubbubDB();
                session.setAttribute("db", db);
            } catch (SQLException sqle) {}
        }
        return db;
    }

    private String join(HttpServletRequest request) throws ServletException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username == null) return "join";
        if (username.length() < 4 || username.length() > 10 ||
            password.length() < 4 || password.length() > 10 ) {
            request.setAttribute("flash", "Username must be between 4 and 10 characters.");
            return "join";
        }
        try {
            User user = new User(username);
            HubbubDB db = (HubbubDB)session.getAttribute("db");
            db.addUser(username,password);
            session.setAttribute("user", user);
            return timeline(request);
        } catch (SQLException sqle) {
            request.setAttribute("flash", sqle.getMessage());
            return "join";
        }
    }

    private String timeline(HttpServletRequest request) throws ServletException {
        HubbubDB db = (HubbubDB)request.getSession().getAttribute("db");
        try{
            Post[] posts = db.getAllPosts();
            request.setAttribute("posts", posts);
        } catch (SQLException sqle) {
            request.setAttribute("flash",sqle.getMessage());
        }
        return "timeline";
    }
    
    private String post(HttpServletRequest request) throws ServletException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user == null ) {
            request.setAttribute("flash", "You are not logged in!");
            return "join";
        }
        String content = request.getParameter("content");
        if (content == null) return "post";
        if (content.length() < 1 || content.length() > 140) {
            request.setAttribute("flash", "Content must be between 1 and 140 characters.");
            return "post";
        }
        Post post = new Post();
        post.setContent(content);
        post.setAuthor(user);
        post.setPostDate(new java.util.Date());
        
        HubbubDB db = (HubbubDB)request.getSession().getAttribute("db");
        try {
            db.addPost(post);
        } catch (SQLException sqle) {
            request.setAttribute("flash", sqle.getMessage());
            return "post";
        }
        return timeline(request);
    }
    
    private String login(HttpServletRequest request) throws ServletException {
        if ( request.getParameter("username") == null ) return "login";
        LoginBean bean = new LoginBean(request.getParameter("username"), request.getParameter("password"));
        if (! bean.validates()) {
            request.setAttribute("flash", bean.getError());
            return "login";
        }
        HubbubDB db = (HubbubDB)request.getSession().getAttribute("db");
        User user;
        try {
            user = db.authenticateUser(bean.getUsername(), bean.getPassword());
        } catch (SQLException sqle) {
            request.setAttribute("flash", sqle.getMessage());
            return "login";
        }
        if (user == null) {
            request.setAttribute("flash", "Access Denied");
            return "login";
        }
        request.getSession().setAttribute("user", user);
        return timeline(request);
    }
    
    private String logout(HttpServletRequest request) throws ServletException {
        request.getSession().removeAttribute("user");
        return timeline(request);
    }
    
    private String profile(HttpServletRequest request) throws ServletException {
        String username = request.getParameter("username");
        if (username == null || username.length() < 4)  {
            request.setAttribute("flash", "Whose profile are you looking for?");
            return timeline(request);
        }
        HubbubDB db = (HubbubDB)request.getSession().getAttribute("db");
        try {
            User u = db.getUserByUsername(username);
            Profile p = db.getProfile(u.getProfileId());
            request.setAttribute("user", u);
            request.setAttribute("profile", p);
            return "profile";
        } catch (SQLException sqle) {
            request.setAttribute("flash", sqle.getMessage());
            return timeline(request);
        }
    }
    
    private String editProfile(HttpServletRequest request) throws ServletException {
        String username = request.getParameter("username");
        if (username == null )
            return "profile_edit";
        String biography = request.getParameter("biography");
        // get the picture file name and extension
        // read in the file and save the bytes into the db
        return "";
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
