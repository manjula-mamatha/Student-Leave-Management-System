package service;

import dao.*;
import dto.LeaveDTO;

import java.util.List;

public class LeaveService {

    private LeaveDAO dao = new LeaveDAOImpl();

    public void addLeave(LeaveDTO leave) {

        if (leave.getStudentName() == null || leave.getStudentName().isEmpty()) {
            System.out.println("Student name cannot be empty");
            return;
        }

        if (leave.getReason() == null || leave.getReason().isEmpty()) {
            System.out.println("Reason cannot be empty");
            return;
        }

        dao.addLeave(leave);
    }

    public LeaveDTO getLeave(int id) {
        return dao.getLeaveById(id);
    }

    public List<LeaveDTO> getAllLeaves() {
        return dao.getAllLeaves();
    }

    public void updateLeave(LeaveDTO leave) {
        dao.updateLeave(leave);
    }

    public void deleteLeave(int id) {
        dao.deleteLeave(id);
    }
}
