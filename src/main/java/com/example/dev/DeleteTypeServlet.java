package com.example.dev;

import com.example.dev.DAO.ConnectionProperty;
import com.example.dev.DAO.DAO_Model_Type;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet( "/DeleteType")
public class DeleteTypeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ConnectionProperty prop;
    public DeleteTypeServlet() throws IOException {
        super();
        prop = new ConnectionProperty();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO_Model_Type dao = new DAO_Model_Type();
        String strId = request.getParameter("id");
        Long deleteid = null;
        if(strId != null) {deleteid = Long.parseLong(strId);}
        try {dao.delete(deleteid);}
        catch (Exception e) {System.out.println(e.getMessage());}
        response.sendRedirect("Type");
    }
}