package com.xadmin.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.usermanagement.model.Country;




public class CountryDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3307/test?useSSL=false&" + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Tomate11!";

	private static final String INSERT_USERS_SQL = "INSERT INTO countries" + "  (name, $2022, $2021, $2020) VALUES "
			+ " (?, ?, ?, ?);";
	private static final String SELECT_ALL_COUNTRYS = "select * from countries";
	private static final String UPDATE_COUNTRYS_SQL = "update test.countries set $2022 = ?, $2021 =?, $2020 = ? where name = ?;";
	private static final String SELECT_COUNTRY_BY_ID = "select Name, $2020, $2021, $2022 from countries where id =?";
	private static final String UPDATE_USERS_SQL = "update countries set name = ?, $2022 = ?, $2021 =?, $2020 where id = ?;";
	public CountryDAO() {
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

	public List<Country> selectAllCountrys() {
		List<Country> country = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COUNTRYS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				float $2020 = rs.getFloat("$2020");
				float $2021 = rs.getFloat("$2021");
				float $2022 = rs.getFloat("$2022");
				country.add(new Country(id, name, $2020, $2021, $2022));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return country;
	}
	public Country selectCountry (int id) {
        Country country = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COUNTRY_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("Name");
                Float $2022 = rs.getFloat("$2022");
                Float $2021 = rs.getFloat("$2021");
                Float $2020 = rs.getFloat("$2020");
                country = new Country(name, $2020, $2021, $2022);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return country;
    }
	public boolean editCountry(Country country) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, country.getName());
			statement.setFloat(2, country.get$2022());
			statement.setFloat(3, country.get$2021());
			statement.setFloat(4, country.get$2020());
			statement.setInt(5, country.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	public void insertCountry(Country country) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, country.getName());
			preparedStatement.setFloat(2, country.get$2022());
			preparedStatement.setFloat(3, country.get$2021());
			preparedStatement.setFloat(4, country.get$2020());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public boolean updateCountry(Country country) throws SQLException {
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