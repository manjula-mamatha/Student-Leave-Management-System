import dto.LeaveDTO;
import service.LeaveService;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        LeaveService service = new LeaveService();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Apply Leave");
            System.out.println("2. Get Leave By ID");
            System.out.println("3. Get All Leaves");
            System.out.println("4. Update Leave");
            System.out.println("5. Delete Leave");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student Name: ");
                    String name = sc.next();

                    System.out.print("Enter Reason: ");
                    String reason = sc.next();

                    System.out.print("Enter From Date: ");
                    String from = sc.next();

                    System.out.print("Enter To Date: ");
                    String to = sc.next();

                    service.addLeave(
                            new LeaveDTO(0, name, reason, from, to, "Pending")
                    );

                    break;

                case 2:

                    System.out.print("Enter Leave ID: ");
                    int id = sc.nextInt();

                    LeaveDTO leave = service.getLeave(id);

                    if (leave != null) {

                        System.out.println(
                                leave.getId() + " " +
                                leave.getStudentName() + " " +
                                leave.getReason() + " " +
                                leave.getFromDate() + " " +
                                leave.getToDate() + " " +
                                leave.getStatus()
                        );
                    }

                    break;

                case 3:

                    List<LeaveDTO> list = service.getAllLeaves();

                    list.forEach(l ->
                            System.out.println(
                                    l.getId() + " " +
                                    l.getStudentName() + " " +
                                    l.getReason() + " " +
                                    l.getFromDate() + " " +
                                    l.getToDate() + " " +
                                    l.getStatus()
                            )
                    );

                    break;

                case 4:

                    System.out.print("Enter Leave ID: ");
                    int uid = sc.nextInt();

                    System.out.print("Enter Student Name: ");
                    String newName = sc.next();

                    System.out.print("Enter Reason: ");
                    String newReason = sc.next();

                    System.out.print("Enter From Date: ");
                    String newFrom = sc.next();

                    System.out.print("Enter To Date: ");
                    String newTo = sc.next();

                    System.out.print("Enter Status: ");
                    String status = sc.next();

                    service.updateLeave(
                            new LeaveDTO(uid, newName, newReason, newFrom, newTo, status)
                    );

                    break;

                case 5:

                    System.out.print("Enter Leave ID: ");
                    int did = sc.nextInt();

                    service.deleteLeave(did);

                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}
