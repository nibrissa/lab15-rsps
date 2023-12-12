package com.example.dev;

import com.example.dev.DAO.*;
import com.example.dev.DataClass.Account;
import com.example.dev.DataClass.Agreement;
import com.example.dev.DataClass.Bank;
import com.example.dev.DataClass.Type;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/EditAccount")
public class Edit_AccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ConnectionProperty prop;
    public Edit_AccountServlet() throws IOException {super(); prop = new ConnectionProperty();}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Account> accounts;

        String strId = request.getParameter("id");
        Long id = null;
        if(strId != null) {id = Long.parseLong(strId);}
        Account edit = new Account();

        List<Bank> banks;
        List<Type> types;
        List<Agreement> agreements;
        DAO_Model_Bank daoModelBank = new DAO_Model_Bank();
        DAO_Model_Agreement daoModelAgreement = new DAO_Model_Agreement();
        DAO_Model_Type daoModelType = new DAO_Model_Type();
        DAO_Model_Account dao = new DAO_Model_Account();
        try {
            edit = dao.findById(id);
            edit.setAgreement(daoModelAgreement.findById(edit.getAggrement_id()));
            edit.setBank(daoModelBank.findById(edit.getBank_id()));
            edit.setType(daoModelType.findById(edit.getType_id()));
            request.setAttribute("edit",edit);
            accounts = dao.findAll();
            banks = daoModelBank.findAll();
            agreements = daoModelAgreement.findAll();
            types = daoModelType.findAll();
            for (Account account: accounts) {
                account.setBank(daoModelBank.FindById(account.getBank_id(), banks));
                account.setAgreement(daoModelAgreement.FindById(account.getAggrement_id(), agreements));
                account.setType(daoModelType.FindById(account.getType_id(), types));
            }

            request.setAttribute("agreements", agreements);
            request.setAttribute("banks", banks);
            request.setAttribute("types", types);
            request.setAttribute("accounts",accounts);
        } catch (Exception e) {System.out.println(e.getMessage());}


        request.getRequestDispatcher("view/edit_account.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DAO_Model_Account dao = new DAO_Model_Account();

        String strId = request.getParameter("id");
        Long id = null;
        if(strId != null) {id = Long.parseLong(strId);}

        String accountnumber = request.getParameter("account");
        String agreement = request.getParameter("agreement");
        int index1 = agreement.indexOf('=');
        int index2 = agreement.indexOf(",");
        String a = agreement.substring(index1+1, index2);
        long id_agreement = Long.parseLong(a.trim());
        String type = request.getParameter("type");
        int index_type_1 = type.indexOf('=');
        int index_type_2 = type.indexOf(",");
        String t = type.substring(index_type_1+1, index_type_2);
        long id_type = Long.parseLong(t.trim());
        String bank = request.getParameter("bank");
        int index_bank_1 = bank.indexOf('=');
        int index_bank_2 = bank.indexOf(",");
        String b = bank.substring(index_bank_1+1, index_bank_2);
        long id_bank = Long.parseLong(b.trim());
        Account account = new Account(id,id_bank,id_agreement,id_type,accountnumber);
        try {dao.update(account);} catch (Exception e) {System.out.println(e.getMessage());}
        response.sendRedirect("Account");
    }
}

