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
import java.util.List;

@WebServlet("/EditType")
public class EditTypeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ConnectionProperty prop;
    public EditTypeServlet() throws IOException {super(); prop = new ConnectionProperty();}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Type> types;
        String strId = request.getParameter("id");
        Long id = null;
        if(strId != null) {id = Long.parseLong(strId);}
        Type edit = new Type();
        DAO_Model_Type daoModelType = new DAO_Model_Type();
        try {
            edit = daoModelType.findById(id);request.setAttribute("edit",edit);
            types = daoModelType.findAll();request.setAttribute("types", types);}
        catch (Exception e) {System.out.println(e.getMessage());}

        request.getRequestDispatcher("view/edit_type.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DAO_Model_Type dao = new DAO_Model_Type();
        String strId = request.getParameter("id");
        Long id = null;
        if(strId != null) {id = Long.parseLong(strId);}
        String name = request.getParameter("type");
        Type type = new Type(id,name);
        try {dao.update(type);} catch (Exception e) {System.out.println(e.getMessage());}
        response.sendRedirect("Type");
    }
}

