package app.model.sql;

import app.model.RouteToTrainTimeTableDao;
import app.model.entities.RouteToTrainTimeTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SqlRouteToTrainTimeTableDao implements RouteToTrainTimeTableDao {
    public static final String SQL_FIND_ALL_ROUTE_TO_TRAIN = "SELECT * FROM route_to_train_time_table";
    public static final String SQL_INSERT_ROUTE_TO_TRAIN_TIMETABLE =
            "INSERT INTO route_to_train_time_table (id_route, id_train, arrive_time, depart_time) " +
            "VALUES (?, ?, ?, ?)";
    public static final String SQL_DELETE_ROUTE_TO_TRAIN_TIMETABLE_BY_ID = "DELETE FROM route_to_train_time_table WHERE id_route_to_train = ?";
    public static final String SQL_UPDATE_ROUTE_TO_TRAIN_TIMETABLE_DEPARTURE =
            "UPDATE route_to_train_time_table SET depart_time = ? WHERE id_route_to_train = ?";
    public static final String SQL_UPDATE_ROUTE_TO_TRAIN_TIMETABLE_ARRIVAL =
            "UPDATE route_to_train_time_table SET arrive_time = ? WHERE id_route_to_train = ?";


    @Override
    public List<RouteToTrainTimeTable> findAllRouteToTrainTimeTable() {
        List<RouteToTrainTimeTable> result = new ArrayList<RouteToTrainTimeTable>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_FIND_ALL_ROUTE_TO_TRAIN);
            while (rs.next()) {
                result.add(new RouteToTrainTimeTable(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getTimestamp(4), rs.getTimestamp(5)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public void insertRouteToTrainTimeTable(RouteToTrainTimeTable routeToTrainTimeTable) {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT_ROUTE_TO_TRAIN_TIMETABLE);
            ps.setInt(1, routeToTrainTimeTable.getRoute());
            ps.setString(2, routeToTrainTimeTable.getTrain());
            ps.setTimestamp(3, (Timestamp) routeToTrainTimeTable.getArriveTime());
            ps.setTimestamp(4, (Timestamp) routeToTrainTimeTable.getDepartTime());
            ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteRouteToTrainTimeTable(Integer id) {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE_ROUTE_TO_TRAIN_TIMETABLE_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateRouteToTrainTimeTableOfDeparture(Integer id, Date departure) {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_ROUTE_TO_TRAIN_TIMETABLE_DEPARTURE);
            ps.setTimestamp(1, (Timestamp) departure);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateRouteToTrainTimeTableOfArrival(Integer id, Date arrival) {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_ROUTE_TO_TRAIN_TIMETABLE_ARRIVAL);
            ps.setTimestamp(1, (Timestamp) arrival);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
