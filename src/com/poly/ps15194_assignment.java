package com.poly;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ps15194_assignment {
    public static void menu(ArrayList<Employee> list, Scanner sc) {
        while(true){           
            Function.playBeep();
            
            Function.menuText();
            int choose;
                
            System.out.print("> Chọn chức năng: ");
            choose = Function.iInput(sc);

            sc.nextLine();

            switch(choose){
                case 1:{
                    Function.playBeep();
                    System.out.println("-------------------------");
                    System.out.println("NHẬP DANH SÁCH NHÂN VIÊN");
                    Function.inputList(list, sc);
                    break;
                }

                case 2:{
                    Function.playBeep();
                    System.out.println("-------------------------");
                    System.out.println("XUẤT THÔNG TIN CƠ BẢN");
                    Function.outputList(list);
                    break;
                }

                case 3:{
                    Function.playBeep();
                    System.out.println("-------------------------");
                    System.out.println("TÌM KIẾM THEO MÃ SỐ");
                    Function.outputById(list, sc);
                    break;
                }

                case 4:{
                    Function.playBeep();
                    System.out.println("-------------------------");
                    System.out.println("XÓA THEO MÃ SỐ");
                    Function.removeEmp(list, sc);
                    break;
                }

                case 5:{
                    Function.playBeep();
                    System.out.println("-------------------------");
                    System.out.println("CẬP NHẬT THEO MÃ SỐ");
                    Function.editEmp(list, sc);
                    break;
                }

                case 6:{
                    Function.playBeep();
                    System.out.println("-------------------------");
                    System.out.println("TÌM KIẾM THEO KHOẢNG LƯƠNG");
                    Function.searchEmpBySalary(list, sc);
                    break;
                }

                case 7:{
                    Function.playBeep();
                    System.out.println("-------------------------");
                    System.out.println("SẮP XẾP THEO TÊN");
                    Function.sortByName(list);
                    break;
                }

                case 8:{
                    Function.playBeep();
                    System.out.println("-------------------------");
                    System.out.println("SẮP XẾP THEO THU NHẬP");
                    Function.sortBySalary(list, sc, 0);
                    break;
                }

                case 9:{
                    Function.playBeep();
                    System.out.println("-------------------------");
                    System.out.println("TOP 5 NHÂN VIÊN THU NHẬP CAO");
                    Function.outputTopSalary(list, sc);
                    break;
                }

                case 10:{
                    Function.playBeep();
                    System.out.println("-------------------------");
                    System.out.println("> Tạm biệt!");
                    System.exit(0);
                    break;
                }

                default:{
                    Function.playBeep();
                    System.out.println("> Lựa chọn không hợp lệ!");
                    System.out.print("> Nhập lại: ");
                    break;
                }
            }
            
            System.out.print("> Nhập phím bất kỳ để tiếp tục: ");
            String pause = sc.nextLine();
            
            for(int i = 0; i < 50; i++){
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> list = new ArrayList();

        Leader nv1 = new Leader("RV-00001", "Đặng Gia Phát", 25000000, 7500000);
        Leader nv2 = new Leader("RV-00002", "Phạm Hoàng Lâm", 25000000, 7500000);
        Officer nv3 = new Officer("RV-00003", "Lý Đức Thắng", 15000000);
        Officer nv4 = new Officer("RV-00004", "Phan Thái Đạt", 12000000);
        Saleman nv5 = new Saleman("RV-00005", "Đặng Vũ Cao Thiên", 5200000, 15000000);
        Saleman nv6 = new Saleman("RV-00006", "Ngô Lâm Minh Tuấn", 4500000, 7500000);
        Officer nv7 = new Officer("RV-00007", "Cao Phạm Kim Hòa", 14000000);
        Saleman nv8 = new Saleman("RV-00008", "Trịnh Cao Văn", 5200000, 15000000);
        Saleman nv9 = new Saleman("RV-00009", "Ngô Thái Tuấn", 6000000, 7500000);
        Officer nv10 = new Officer("RV-00010", "Mai Xuân Tấn", 17000000);
        list.add(nv1);
        list.add(nv2);
        list.add(nv3);
        list.add(nv4);
        list.add(nv5);
        list.add(nv6);
        list.add(nv7);
        list.add(nv8);
        list.add(nv9);
        list.add(nv10);

        String msg = "Assignment | MOB1014 | PS15194 | CHUNG NGUYỄN ANH TUẤN\n"
               + "----------------------------------------------------------------------------------------\n"
               + "1. Chương trình đã nhập sẵn dữ liệu cho 10 nhân viên, bạn có thể nhập thêm nhân viên bằng chức năng này.\n"
               + ">  Quy tắc: Mã nhân viên theo dạng: RV-[5 chữ số] và không trùng với các nhân viên khác trong danh sách.\n"
               + "2. Chức năng này xuất ra các thông tin cơ bản: [ID] - [Name] - [Title] - [Gross Salary] - [Tax] - [Net Salary].\n"
               + "3. Nhập mã số nhân viên cần tìm, chương trình sẽ xuất thông tin đầy đủ của nhân viên đó.\n"
               + "4. Xóa nhân viên theo mã số.\n"
               + "5. Cập nhật thông tin nhân viên, bạn chỉ có thể sửa tên và lương của nhân viên.\n"
               + "6. Tìm kiếm nhân viên theo khoản lương cho trước.\n"
               + "7. Sắp xếp danh sách theo [First Name] của nhân viên.\n"
               + "8. Sắp xếp danh sách theo lương thực lãnh, bạn có thể sắp xếp tăng dần hoặc giảm dần.\n"
               + "9. Hiển thị top 5 nhân viên có thu nhập cao nhất.\n"
               + "----------------------------------------------------------------------------------------\n"  
               + ">  Lương thực lãnh: Thu nhập trước thuế - Thuế thu nhập\n"
               + ">  Quy tắc tính thuế: <9M: 0% | <=15M: 10% | >15M: 12%, tính trên tổng thu nhập.\n"
               + ">  Thu nhập trước thuế:\n"
               + "-  Trưởng phòng: Lương cơ bản + Thưởng trách nhiệm.\n"
               + "-  Nhân viên hành chính: Lương cơ bản.\n"
               + "-  Nhân viên kinh doanh: Lương cơ bản + Thưởng doanh số (5% trên tổng doanh thu).\n"
               + "----------------------------------------------------------------------------------------\n";
        JOptionPane.showMessageDialog(null, msg, "Hướng dẫn", JOptionPane.INFORMATION_MESSAGE);
        menu(list, sc);
    }
}
