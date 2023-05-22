package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.*;




public class DAO {
	private String jdbcURL = "jdbc:mysql://localhost:3307/test?useSSL=false&" + 
							 "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Tomate11!";

	private static final String INSERT_USERS_SQL = "INSERT INTO employees" +
            "  (first_name, last_name, username, password, address, email) VALUES " +
            " (?, ?, ?, ?, ?,?);";
	private static final String VALIDATE_LOGIN = "select * from employees where username = ? and password = ?";
	private static final String SELECT_ALL_COUNTRYS = "select * from countries";
	private static final String UPDATE_COUNTRYS_SQL = "update test.countries set $2022 = ?, $2021 =?, $2020 = ? where Name = ?";
	private static final String SELECT_COUNTRY_BY_ID = "select Name, $2020, $2021, $2022 from countries where id = ?";
	
	public DAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public boolean saveDataEdit(String username, String countryName) throws SQLException {
	    boolean rowInserted = false;
	    String query = "INSERT INTO dataedit (username, Name) VALUES (?, ?)";
	    
	    try (Connection connection = getConnection();
	         PreparedStatement statement = connection.prepareStatement(query)) {
	        statement.setString(1, username);
	        statement.setString(2, countryName);
	        
	        rowInserted = statement.executeUpdate() > 0;
	    }
	    
	    return rowInserted;
	}

	public int registerEmployee(RegisterBean employee) throws ClassNotFoundException {
		int result = 0;
        try ( Connection connection = getConnection();
            
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getUsername());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getEmail());
            
            System.out.println(preparedStatement);
            
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }
	
	public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(VALIDATE_LOGIN)) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return status;
    }
	
	public List<CountryBean> selectAllCountrys() {
		List<CountryBean> country = new ArrayList<>();
		// Establishing a Connection
		try (Connection connection = getConnection();
			// Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COUNTRYS);) {
			System.out.println(preparedStatement);
			// Execute the query 
			ResultSet rs = preparedStatement.executeQuery();
			// Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				float $2020 = rs.getFloat("$2020");
				float $2021 = rs.getFloat("$2021");
				float $2022 = rs.getFloat("$2022");
				country.add(new CountryBean(id, name, $2020, $2021, $2022));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return country;
	}
	
	
	public CountryBean selectCountry (int id) {
        CountryBean country = null;
        
        try (Connection connection = getConnection();
        		
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COUNTRY_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                Float $2022 = rs.getFloat("$2022");
                Float $2021 = rs.getFloat("$2021");
                Float $2020 = rs.getFloat("$2020");
                country = new CountryBean(name, $2020, $2021, $2022);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return country;
    }
	
	public boolean updateCountry(CountryBean country) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_COUNTRYS_SQL);) {
			System.out.println("updated Country:"+statement);
			statement.setFloat(1, country.get$2022());
			statement.setFloat(2, country.get$2021());
			statement.setFloat(3, country.get$2020());
			statement.setString(4, country.getName());
			
			rowUpdated = statement.executeUpdate() > 0;			
		}
		
		return rowUpdated;
	}
	
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}