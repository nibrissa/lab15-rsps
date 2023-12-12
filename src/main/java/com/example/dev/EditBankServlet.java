package com.example.dev;
import com.example.dev.DAO.ConnectionProperty;
import com.example.dev.DAO.DAO_Model_Bank;
import com.example.dev.DataClass.Bank;
import com.example.dev.DataClass.Type;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/EditBank")
public class EditBankServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ConnectionProperty prop;
    public EditBankServlet() throws IOException {super(); prop = new ConnectionProperty();}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Bank> banks;
        String strId = request.getParameter("id");
        Long id = null;
        if(strId != null) {id = Long.parseLong(strId);}
        Bank edit = new Bank();
        DAO_Model_Bank daoModelBank = new DAO_Model_Bank();
        try {
            edit = daoModelBank.findById(id);request.setAttribute("edit",edit);
            banks = daoModelBank.findAll();request.setAttribute("banks", banks);}
        catch (Exception e) {System.out.println(e.getMessage());}

        request.getRequestDispatcher("view/edit_bank.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DAO_Model_Bank dao = new DAO_Model_Bank();
        String strId = request.getParameter("id");
        Long id = null;
        if(strId != null) {id = Long.parseLong(strId);}

        String namefull = request.getParameter("fullname");
        String nameshort = request.getParameter("shortname");
        long inn = Long.parseLong(request.getParameter("inn"));
        long account = Long.parseLong(request.getParameter("account"));
        String bik = request.getParameter("bik");
        String coraccount = request.getParameter("coraccount");
        String city = request.getParameter("city");

        Bank bank = new Bank(id,namefull,nameshort,city,bik,coraccount,inn,account);
        try {dao.update(bank);} catch (Exception e) {System.out.println(e.getMessage());}
        response.sendRedirect("Bank");
    }
}

