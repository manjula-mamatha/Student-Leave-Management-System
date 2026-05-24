package dao;

import dto.LeaveDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeaveDAOImpl implements LeaveDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/rnsitdb";
    private static final String USER = "root";
    private static final String PASS = "YOUR_PASSWORD";

    @Override
    public void addLeave(LeaveDTO leave) {

        try {

            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "INSERT INTO leave_requests(student_name, reason, from_date, to_date, status) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, leave.getStudentName());
            pst.setString(2, leave.getReason());
            pst.setString(3, leave.getFromDate());
            pst.setString(4, leave.getToDate());
            pst.setString(5, leave.getStatus());

            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LeaveDTO getLeaveById(int id) {

        LeaveDTO leave = null;

        try {

            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "SELECT * FROM leave_requests WHERE id=?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                leave = new LeaveDTO(
                        rs.getInt("id"),
                        rs.getString("student_name"),
                        rs.getString("reason"),
                        rs.getString("from_date"),
                        rs.getString("to_date"),
                        rs.getString("status")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return leave;
    }

    @Override
    public List<LeaveDTO> getAllLeaves() {

        List<LeaveDTO> list = new ArrayList<>();

        try {

            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "SELECT * FROM leave_requests";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                LeaveDTO leave = new LeaveDTO(
                        rs.getInt("id"),
                        rs.getString("student_name"),
                        rs.getString("reason"),
                        rs.getString("from_date"),
                        rs.getString("to_date"),
                        rs.getString("status")
                );

                list.add(leave);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void updateLeave(LeaveDTO leave) {

        try {

            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "UPDATE leave_requests SET student_name=?, reason=?, from_date=?, to_date=?, status=? WHERE id=?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, leave.getStudentName());
            pst.setString(2, leave.getReason());
            pst.setString(3, leave.getFromDate());
            pst.setString(4, leave.getToDate());
            pst.setString(5, leave.getStatus());
            pst.setInt(6, leave.getId());

            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLeave(int id) {

        try {

            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "DELETE FROM leave_requests WHERE id=?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, id);

            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
