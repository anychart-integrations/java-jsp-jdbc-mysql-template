package com.anychart.servlets;

import com.anychart.models.Fruit;
import com.google.gson.Gson;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MysqlDataSource ds = (MysqlDataSource) req.getServletContext().getAttribute("DBDataSource");

        try (Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name, value FROM fruits ORDER BY value DESC limit 5")) {

            List<Fruit> fruits = new ArrayList<Fruit>();
            // Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String name = rs.getString("name");
                int value = rs.getInt("value");
                // Add item
                fruits.add(new Fruit(name, value));
            }

            req.setAttribute("chartData", new Gson().toJson(fruits));
            req.setAttribute("chartTitle", "Top 5 fruits");
            req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
