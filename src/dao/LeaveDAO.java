package dao;

import dto.LeaveDTO;
import java.util.List;

public interface LeaveDAO {

    void addLeave(LeaveDTO leave);

    LeaveDTO getLeaveById(int id);

    List<LeaveDTO> getAllLeaves();

    void updateLeave(LeaveDTO leave);

    void deleteLeave(int id);
}
