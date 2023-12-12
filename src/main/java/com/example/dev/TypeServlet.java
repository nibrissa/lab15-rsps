package com.example.dev;

import com.example.dev.DAO.ConnectionProperty;
import com.example.dev.DAO.DAO_Model_Type;
import com.example.dev.DataClass.Type;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Type")
public class TypeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ConnectionProperty prop;
    public TypeServlet() throws IOException {super(); prop = new ConnectionProperty();}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Type> types;
        DAO_Model_Type daoModelType = new DAO_Model_Type();
        try {types = daoModelType.findAll();request.setAttribute("types", types);}
        catch (Exception e) {System.out.println(e.getMessage());}

        request.getRequestDispatcher("view/type.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DAO_Model_Type dao = new DAO_Model_Type();
        String name = request.getParameter("type");
        Type type = new Type(name);
        try {dao.insert(type);} catch (Exception e) {System.out.println(e.getMessage());}
        doGet(request, response);
    }
}

