package com.example.dev.DAO;

import com.example.dev.DataClass.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAO_Model_Account implements RepositoryDAO<Account> {
    public DAO_Model_Account() {}
    private static final String select_all_account = "SELECT * FROM account ORDER BY id";
    private static final String select_account_ById = "SELECT * FROM account WHERE id = ?";
    private static final String insert_account = "INSERT INTO account(bank_id, aggrement_id, type_id, account) VALUES(?,?,?,?)";
    private static final String edit_account = "UPDATE account SET bank_id = ?, aggrement_id =?, type_id =?, account=? WHERE id = ?";
    private static final String delete_account = "DELETE FROM account WHERE id = ?";
    private ConnectionBuilder builder = new DbConnectionBuilder();
    private Connection getConnection() throws SQLException {return builder.getConnection();}
    @Override
    public void insert(Account account){
        try (Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(insert_account, new String[] { "id" })) {
            Long Id = -1L;
            pst.setLong(1, account.getBank_id());
            pst.setLong(2, account.getAggrement_id());
            pst.setLong(3, account.getType_id());
            pst.setString(4, account.getAccount());
            pst.executeUpdate();
        } catch (Exception e) {System.out.println(e.getMessage());}
    }
    @Override
    public void update(Account account){
        try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(edit_account)) {
            pst.setLong(1, account.getBank_id());
            pst.setLong(2, account.getAggrement_id());
            pst.setLong(3, account.getType_id());
            pst.setString(4, account.getAccount());
            pst.setLong(5, account.getId());
            pst.executeUpdate();
        } catch (Exception e) {System.out.println(e.getMessage());}
    }
    @Override
    public void delete(Long Id){
        try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(delete_account)) {
            pst.setLong(1, Id);
            pst.executeUpdate();
        } catch (Exception e) {System.out.println(e.getMessage());}
    }
    @Override
    public Account findById(Long Id) {
        Account account = null;
        try (Connection con = getConnection()) {
            PreparedStatement pst = con.prepareStatement(select_account_ById);
            pst.setLong(1, Id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {account = fill(rs);}
            rs.close(); pst.close();
        } catch (Exception e) {System.out.println(e.getMessage());}
        return account;
    }
    @Override
    public List<Account> findAll() {
        List<Account> list = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(select_all_account);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {list.add(fill(rs));}
        } catch (Exception e) {System.out.println(e.getMessage());}
        return list;
    }

    private Account fill(ResultSet rs) throws SQLException {
        Account status = new Account();
        status.setId(rs.getLong("id"));
        status.setBank_id(rs.getLong("bank_id"));
        status.setType_id(rs.getLong("type_id"));
        status.setAggrement_id(rs.getLong("aggrement_id"));
        status.setAccount(rs.getString("account"));
        return status;
    }
    public Account FindById(Long id, List<Account> accounts) {
        if (accounts != null) {for (Account c: accounts) {if (c.getId()==id) {return c;}}}
        else {return null;}
        return null;
    }
}

