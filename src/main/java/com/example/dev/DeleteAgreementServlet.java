package com.example.dev;

import com.example.dev.DAO.ConnectionProperty;
import com.example.dev.DAO.DAO_Model_Agreement;
import com.example.dev.DAO.DAO_Model_Bank;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet( "/DeleteAgreement")
public class DeleteAgreementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ConnectionProperty prop;
    public DeleteAgreementServlet() throws IOException {
        super();
        prop = new ConnectionProperty();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO_Model_Agreement dao = new DAO_Model_Agreement();
        String strId = request.getParameter("id");
        Long deleteid = null;
        if(strId != null) {deleteid = Long.parseLong(strId);}
        try {dao.delete(deleteid);}
        catch (Exception e) {System.out.println(e.getMessage());}
        response.sendRedirect("Agreement");
    }
}