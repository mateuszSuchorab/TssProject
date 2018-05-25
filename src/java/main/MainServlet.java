/*

 */

package main;

import to.Data;
import buisness.BusinessObject;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mateusz Suchorab <suchorab.mateusz@gmail.com>
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {
        
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
        // get current session, or initialise one if none
        HttpSession sess;
        sess = request.getSession(false);
               
        if (sess.getAttribute("bo")==null) {
            sess.setAttribute("bo", new BusinessObject());
        }

        BusinessObject bo = (BusinessObject) sess.getAttribute("bo");
        
        System.out.println("adding BOO");
        //bo.add("mojeImie", "twojeImie");
                
        
        response.setContentType("text/html;charset=UTF-8");

        String command = request.getParameter("command");

        if (command == null) {
            command = "";
        }

        if (command.equals("add")) {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            bo.add(name, surname);
        } else if (command.equals("edit")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            bo.edit(id, name, surname);
        } else if (command.equals("del")) {
            String id = request.getParameter("id");
            bo.del(id);
        }
        ArrayList<Data> userData = bo.getAll();
        request.setAttribute("userData", userData);

        RequestDispatcher rd = request.getRequestDispatcher("data.jsp");
        rd.forward(request, response);
    }

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
    }
}
