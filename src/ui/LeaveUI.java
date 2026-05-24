package ui;

import dto.LeaveDTO;
import service.LeaveService;

import javax.swing.*;
import java.util.List;

public class LeaveUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Leave Management");
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LeaveService service = new LeaveService();

        JButton addBtn = new JButton("Apply Leave");
        addBtn.setBounds(150, 80, 200, 30);

        JButton viewBtn = new JButton("View Leaves");
        viewBtn.setBounds(150, 130, 200, 30);

        JButton deleteBtn = new JButton("Delete Leave");
        deleteBtn.setBounds(150, 180, 200, 30);

        frame.add(addBtn);
        frame.add(viewBtn);
        frame.add(deleteBtn);

        frame.setVisible(true);

        // ADD
        addBtn.addActionListener(e -> {

            String name = JOptionPane.showInputDialog("Enter Student Name:");
            String reason = JOptionPane.showInputDialog("Enter Reason:");
            String from = JOptionPane.showInputDialog("Enter From Date:");
            String to = JOptionPane.showInputDialog("Enter To Date:");

            service.addLeave(
                    new LeaveDTO(0, name, reason, from, to, "Pending")
            );

            JOptionPane.showMessageDialog(null, "Leave Applied!");
        });

        // VIEW
        viewBtn.addActionListener(e -> {

            List<LeaveDTO> list = service.getAllLeaves();

            String[] cols = {"ID", "Student", "Reason", "From", "To", "Status"};

            String[][] data = new String[list.size()][6];

            for (int i = 0; i < list.size(); i++) {

                LeaveDTO leave = list.get(i);

                data[i][0] = String.valueOf(leave.getId());
                data[i][1] = leave.getStudentName();
                data[i][2] = leave.getReason();
                data[i][3] = leave.getFromDate();
                data[i][4] = leave.getToDate();
                data[i][5] = leave.getStatus();
            }

            JTable table = new JTable(data, cols);

            JOptionPane.showMessageDialog(null, new JScrollPane(table));
        });

        // DELETE
        deleteBtn.addActionListener(e -> {

            int id = Integer.parseInt(
                    JOptionPane.showInputDialog("Enter Leave ID:")
            );

            service.deleteLeave(id);

            JOptionPane.showMessageDialog(null, "Leave Deleted!");
        });
    }
}
