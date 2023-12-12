package com.example.dev.DAO;
import com.example.dev.DataClass.Bank;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;

public class DAO_Model_Bank implements RepositoryDAO<Bank> {
    public DAO_Model_Bank() {}
    private static final String select_all_bank = "SELECT * FROM bank ORDER BY id";
    private static final String select_bank_ById = "SELECT * FROM bank WHERE id = ?";
    private static final String insert_bank = "INSERT INTO bank(fullname, shortname, city, bik, coraccount, inn, account) VALUES(?,?,?,?,?,?,?)";
    private static final String edit_bank = "UPDATE bank set fullname = ?, shortname = ?, city = ?, bik = ?, coraccount = ?, inn = ?, account = ? WHERE id = ?";
    private static final String delete_bank = "DELETE FROM bank WHERE id = ?";
    private ConnectionBuilder builder = new DbConnectionBuilder();
    private Connection getConnection() throws SQLException {return builder.getConnection();}
    @Override
    public void insert(Bank bank){
        try (Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(insert_bank, new String[] { "id" })) {
            Long Id = -1L;
            pst.setString(1, bank.getFullname());
            pst.setString(2, bank.getShortname());
            pst.setString(3, bank.getCity());
            pst.setString(4, bank.getBik());
            pst.setString(5, bank.getCoraccount());
            pst.setLong(6, bank.getInn());
            pst.setLong(7, bank.getAccount());
            pst.executeUpdate();
        } catch (Exception e) {System.out.println(e.getMessage());}
    }
    @Override
    public void update(Bank bank){
        try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(edit_bank)) {
            pst.setString(1, bank.getFullname());
            pst.setString(2, bank.getShortname());
            pst.setString(3, bank.getCity());
            pst.setString(4, bank.getBik());
            pst.setString(5, bank.getCoraccount());
            pst.setLong(6, bank.getInn());
            pst.setLong(7, bank.getAccount());
            pst.setLong(8,bank.getId());
            pst.executeUpdate();
        } catch (Exception e) {System.out.println(e.getMessage());}
    }
    @Override
    public void delete(Long Id){
        try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(delete_bank)) {
            pst.setLong(1, Id);
            pst.executeUpdate();
        } catch (Exception e) {System.out.println(e.getMessage());}
    }
    @Override
    public Bank findById(Long Id) {
        Bank bank = null;
        try (Connection con = getConnection()) {
            PreparedStatement pst = con.prepareStatement(select_bank_ById);
            pst.setLong(1, Id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {bank = fill(rs);}
            rs.close(); pst.close();
        } catch (Exception e) {System.out.println(e.getMessage());}
        return bank;
    }
    @Override
    public List<Bank> findAll() {
        List<Bank> list = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(select_all_bank);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {list.add(fill(rs));}
        } catch (Exception e) {System.out.println(e.getMessage());}
        return list;
    }

    private Bank fill(ResultSet rs) throws SQLException {
        Bank person = new Bank();
        person.setId(rs.getLong("id"));
        person.setBik(rs.getString("bik"));
        person.setFullname(rs.getString("fullname"));
        person.setShortname(rs.getString("shortname"));
        person.setCoraccount(rs.getString("coraccount"));
        person.setCity(rs.getString("city"));
        person.setInn(rs.getLong("inn"));
        person.setAccount(rs.getLong("account"));
        return person;
    }
    public Bank FindById(Long id, List<Bank> banks) {
        if (banks != null) {for (Bank c: banks) {if (c.getId()==id) {return c;}}}
        else {return null;}
        return null;
    }
}

