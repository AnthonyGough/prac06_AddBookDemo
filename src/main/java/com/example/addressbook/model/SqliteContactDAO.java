package com.example.addressbook.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SqliteContactDAO implements  IContactDAO{

    private static final String CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS contacts ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "firstName VARCHAR NOT NULL,"
            + "lastName VARCHAR NOT NULL,"
            + "phone VARCHAR NOT NULL,"
            + "email VARCHAR NOT NULL"
            + ")";


    private static final String CLEAR_CONTACTS = "DELETE FROM contacts";

    private static final String INSERT_CONTACTS = "INSERT INTO contacts (firstName, lastName, phone, email) VALUES "
            + "('John', 'Doe', '0423423423', 'johndoe@example.com'),"
            + "('Jane', 'Doe', '0423423424', 'janedoe@example.com'),"
            + "('Jay', 'Doe', '0423423425', 'jaydoe@example.com')";

    private Connection connection;

    public SqliteContactDAO() {
        connection = SqliteConnection.getInstance();
        createContactsTable();
        insertDataContactsTable();
    }

    /**
     * Private helper method to create contacts table
     */
    private void createContactsTable() {
        try {
            Statement statement = connection.createStatement();
            statement.execute(CONTACTS_TABLE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Private helper method to insert data into contacts table
     */
    private void insertDataContactsTable() {
        try {
            Statement clearContacts = connection.createStatement();
            clearContacts.execute(CLEAR_CONTACTS);
            Statement insertStatement = connection.createStatement();
            insertStatement.execute(INSERT_CONTACTS);
        } catch (SQLException ex) {
            ex.printStackTrace();
       }
    }




    /**
     * @param contact The contact to add.
     */
    @Override
    public void addContact(Contact contact) {

    }

    /**
     * @param contact The contact to update.
     */
    @Override
    public void updateContact(Contact contact) {

    }

    /**
     * @param contact The contact to delete.
     */
    @Override
    public void deleteContact(Contact contact) {

    }

    /**
     * @param id The id of the contact to retrieve.
     * @return
     */
    @Override
    public Contact getContact(int id) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<Contact> getAllContacts() {
        return List.of();
    }
}
