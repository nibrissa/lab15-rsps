package com.example.dev;

import com.example.dev.DAO.ConnectionProperty;
import com.example.dev.DAO.DAO_Model_Agreement;
import com.example.dev.DataClass.Agreement;
import com.example.dev.DataClass.Type;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/EditAgreement")
public class EditAgreementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ConnectionProperty prop;
    public EditAgreementServlet() throws IOException {super(); prop = new ConnectionProperty();}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Agreement> agreements;
        String strId = request.getParameter("id");
        Long id = null;
        if(strId != null) {id = Long.parseLong(strId);}
        Agreement edit = new Agreement();
        DAO_Model_Agreement daoModelAgreement = new DAO_Model_Agreement();
        try {
            edit = daoModelAgreement.findById(id);request.setAttribute("edit",edit);
            agreements = daoModelAgreement.findAll();request.setAttribute("agreements", agreements);}
        catch (Exception e) {System.out.println(e.getMessage());}

        request.getRequestDispatcher("view/edit_agreement.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DAO_Model_Agreement dao = new DAO_Model_Agreement();
        String strId = request.getParameter("id");
        Long id = null;
        if(strId != null) {id = Long.parseLong(strId);}

        String number = request.getParameter("number");
        String note = request.getParameter("note");
        LocalDate open = LocalDate.parse(request.getParameter("open"));
        LocalDate close = LocalDate.parse(request.getParameter("close"));
        Agreement agreement = new Agreement(id,number,note,open,close) ;
        try {dao.update(agreement);} catch (Exception e) {System.out.println(e.getMessage());}
        response.sendRedirect("Agreement");
    }
}

