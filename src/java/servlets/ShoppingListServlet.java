/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 659159
 */
public class ShoppingListServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if(request.getParameter("action") != null && request.getParameter("action").equals("logout")) {
            (session).invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        
        if(session.getAttribute("userName") != null) {
            request.setAttribute("shopitem", session.getAttribute("items"));
           
           getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
           return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
     
        if(request.getParameter("action").equals("register")) {
            String username = request.getParameter("username");
            
            if((username != null) || !(username.equals(" "))) {
                
                session.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }

        } else if(request.getParameter("action").equals("add")) {
            if(session.getAttribute("shopitem") == null) {
                ArrayList<String> items = new ArrayList<>();
                session.setAttribute("shopitem", items);
                ((ArrayList<String>) session.getAttribute("shopitem")).add(request.getParameter("item"));
            } else if((request.getParameter("item") != null) || !(request.getParameter("item").equals(" "))){
                ((ArrayList<String>) session.getAttribute("shopitem")).add(request.getParameter("item"));
            }
  
        } else if(request.getParameter("action").equals("delete")) {
            String item = (String) request.getParameter("radioButton");
           ((ArrayList<String>) session.getAttribute("shopitem")).remove(item);
           
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

}
