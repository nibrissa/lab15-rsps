package com.example.dev;
import com.example.dev.DAO.ConnectionProperty;
import com.example.dev.DAO.DAO_Model_Agreement;
import com.example.dev.DAO.DAO_Model_Bank;
import com.example.dev.DataClass.Agreement;
import com.example.dev.DataClass.Bank;
import com.example.dev.DataClass.Type;
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

@WebServlet("/Bank")
public class BankServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ConnectionProperty prop;
    public BankServlet() throws IOException {super(); prop = new ConnectionProperty();}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Bank> banks;
        DAO_Model_Bank daoModelBank = new DAO_Model_Bank();
        try {banks = daoModelBank.findAll();request.setAttribute("banks", banks);}
        catch (Exception e) {System.out.println(e.getMessage());}

        request.getRequestDispatcher("view/bank.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DAO_Model_Bank dao = new DAO_Model_Bank();
        String namefull = request.getParameter("fullname");
        String nameshort = request.getParameter("shortname");
        long inn = Long.parseLong(request.getParameter("inn"));
        long account = Long.parseLong(request.getParameter("account"));
        String bik = request.getParameter("bik");
        String coraccount = request.getParameter("coraccount");
        String city = request.getParameter("city");

        Bank bank = new Bank(namefull,nameshort,city,inn,bik,coraccount,account);
        try {dao.insert(bank);} catch (Exception e) {System.out.println(e.getMessage());}
        doGet(request, response);
    }
}

