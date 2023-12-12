package com.example.dev;

import com.example.dev.DAO.ConnectionProperty;
import com.example.dev.DAO.DAO_Model_Agreement;
import com.example.dev.DAO.DAO_Model_Bank;
import com.example.dev.DataClass.Agreement;
import com.example.dev.DataClass.Bank;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Agreement")
public class AgreementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ConnectionProperty prop;
    public AgreementServlet() throws IOException {super(); prop = new ConnectionProperty();}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Agreement> agreements;
        DAO_Model_Agreement daoModelAgreement = new DAO_Model_Agreement();
        try {agreements = daoModelAgreement.findAll();request.setAttribute("agreements", agreements);}
        catch (Exception e) {System.out.println(e.getMessage());}

        request.getRequestDispatcher("view/agreement.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DAO_Model_Agreement dao = new DAO_Model_Agreement();
        String number = request.getParameter("number");
        String note = request.getParameter("note");
        LocalDate open = LocalDate.parse(request.getParameter("open"));
        LocalDate close = LocalDate.parse(request.getParameter("close"));
        Agreement subject = new Agreement(number,note,open,close) ;
        try {dao.insert(subject);} catch (Exception e) {System.out.println(e.getMessage());}
        doGet(request, response);
    }
}

