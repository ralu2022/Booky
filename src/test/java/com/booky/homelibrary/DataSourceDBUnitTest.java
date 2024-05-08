/* https://www.baeldung.com/java-dbunit
* https://www.digitalocean.com/community/tutorials/junit-setup-maven
* https://www.dbunit.org/howto.html
* */

package com.booky.homelibrary;

import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;

import static org.dbunit.Assertion.assertEqualsIgnoreCols;

public class DataSourceDBUnitTest extends DataSourceBasedDBTestCase {
    @Override
    protected DataSource getDataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(
                "jdbc:postgresql://localhost:5432/bookydb");
        dataSource.setUser("postgres");
        dataSource.setPassword("4891");
        return dataSource;
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(getClass().getClassLoader()
                .getResourceAsStream("data.xml"));
    }

    @Override
    protected DatabaseOperation getSetUpOperation() {
        return DatabaseOperation.REFRESH;
    }

    @Override
    protected DatabaseOperation getTearDownOperation() {
        return DatabaseOperation.DELETE_ALL;
    }

   @Test
    public void givenDataSetEmptySchema_whenDataSetCreated_thenTablesAreEqual() throws Exception {
        IDataSet expectedDataSet = getDataSet();
        ITable expectedTable = expectedDataSet.getTable("AUTHOR_TEST");
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("AUTHOR_TEST");
        assertEquals(expectedTable, actualTable);
    }
    @Test
    public void givenDataSet_whenInsert_thenTableHasNewClient() throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("dbunit/expected-user.xml")) {
            IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(is);
            ITable expectedTable = expectedDataSet.getTable("AUTHOR_TEST");
            Connection conn = getDataSource().getConnection();

            conn.createStatement()
                    .executeUpdate(
                            "INSERT INTO AUTHOR_TEST (author_id, author_name,date_of_birth,written_books) VALUES ('6', 'John Jansen', '04-08-1978','Fatima')");
            ITable actualData = getConnection()
                    .createQueryTable(
                            "result_name",
                            "SELECT * FROM AUTHOR_TEST WHERE author_name='John Jansen'");

            assertEqualsIgnoreCols(expectedTable, actualData, new String[] { "author_id" });
        }
    }


}