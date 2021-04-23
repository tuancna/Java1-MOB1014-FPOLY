package com.poly;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Toolkit;

public class Function {   
    public static int iInput(Scanner sc){       
        while(!sc.hasNextInt()){
            String except = sc.next();
            
            System.out.println(except + " không hợp lệ!");
            System.out.print("> Nhập lại: ");
        }
        
        return sc.nextInt();
    }
    
    public static double dInput(Scanner sc){       
        while(!sc.hasNextDouble()){
            String except = sc.next();
            
            System.out.println(except + " không hợp lệ!");
            System.out.print("> Nhập lại: ");
        }
        
        return sc.nextDouble();
    }
    
    public static Employee inputEmpLeader(ArrayList<Employee> list){
        Employee tmp = new Leader(1);
        
        boolean check = false;
        
        do{
            tmp.input();
            
            if(list.isEmpty())
                return tmp;
            
            for(Employee x : list){
                if(tmp.getEmpId().compareToIgnoreCase(x.getEmpId()) == 0){
                    System.out.println("> Mã số nhân viên đã tồn tại!");
                    check = false;
                    break;
                }
                else
                    check = true;
            }
        } while(!check);
        
        return tmp;
    }
    
    public static Employee inputEmpOfficer(ArrayList<Employee> list){
        Employee tmp = new Officer(2);
        
        boolean check = false;
        
        do{
            tmp.input();
            
            if(list.isEmpty())
                return tmp;
            
            for(Employee x : list){
                if(tmp.getEmpId().compareToIgnoreCase(x.getEmpId()) == 0){
                    System.out.println("> Mã số nhân viên đã tồn tại!");
                    check = false;
                    break;
                }
                else
                    check = true;
            }
        } while(!check);
        
        return tmp;
    }
    
    public static Employee inputEmpSaleman(ArrayList<Employee> list){
        Employee tmp = new Saleman(3);
        
        boolean check = false;
        
        do{
            tmp.input();
            
            if(list.isEmpty())
                return tmp;
            
            for(Employee x : list){
                if(tmp.getEmpId().compareToIgnoreCase(x.getEmpId()) == 0){
                    System.out.println("> Mã số nhân viên đã tồn tại!");
                    check = false;
                    break;
                }
                else
                    check = true;
            }
        } while(!check);
        
        return tmp;
    }
    
    /**
     *
     * @param list
     * @param sc
     */
    public static void inputList(ArrayList<Employee> list, Scanner sc){
        int Type;        
        boolean next;
        
        do{
            do{
            System.out.print("> Nhập loại nhân viên (\u001B[34m1 - TP | 2 - VP | 3 - KD\u001B[0m): ");
            Type = iInput(sc);
            } while(Type < 1 || Type > 3);
            
            switch(Type){
                case 1:{
                    list.add(inputEmpLeader(list));
                    break;
                }

                case 2:{
                    list.add(inputEmpOfficer(list));
                    break;
                }

                default:{
                    list.add(inputEmpSaleman(list));
                    break;
                }
            }
            
            sc.nextLine();
            
            System.out.print("> Tiếp tục nhập? [Y]: ");
            
            next = sc.nextLine().compareToIgnoreCase("Y") == 0;
        } while(next);
    }
    
    public static void outputList(ArrayList<Employee> list){
        System.out.printf("\u001B[34m%-15s%-25s%-25s%-20s%-17s%-15s\u001B[0m\n", "[Mã nhân viên]", "[Họ và tên]", "[Chức vụ]", "[Lương cơ bản]", "[Thuế]", "[Tổng thu nhập]");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        
        if(!list.isEmpty()){
            for(Employee x : list){
                System.out.printf("%-15s%-25s%-25s%-20s%-17s%-15s\n", x.getEmpId(), x.getEmpName(), x.getEmpTitle(), String.format("%,.1f", x.getEmpSalary()), String.format("%,.1f", x.getEmpTax()), String.format("%,.1f", x.getEmpNet()));
            }

            System.out.println("-------------------------------------------------------------------------------------------------------------------");
        }
        else
            System.out.println("> Danh sách rỗng!");
    }
    
    public static Employee searchById(ArrayList<Employee> list, Scanner sc){
        System.out.print("> Nhập mã số nhân viên cần tìm: ");
        String keyword = sc.nextLine();
        
        for(Employee x : list){
            if(x.getEmpId().compareToIgnoreCase(keyword) == 0)
                return x;
        }
        
        return null;
    }
    
    public static void outputById(ArrayList<Employee> list, Scanner sc){
        Employee tmp = searchById(list, sc);
        
        if(tmp != null)
            tmp.output(0);
        else
            System.out.println("> Mã nhân viên không tồn tại!");
    }
    
    public static void removeEmp(ArrayList<Employee> list, Scanner sc){
        Employee tmp = searchById(list, sc);
        
        if(tmp != null){
            String oldEmp = "\u001B[34m[" + tmp.getEmpId() + "]" + tmp.getEmpName() + "\u001B[0m";
            list.remove(tmp);
            System.out.println("> Đã xóa nhân viên: " + oldEmp + "!");
            System.out.println("> Xuất danh sách để kiểm tra lại!");
        }
        else
            System.out.println("> Mã nhân viên không tồn tại!");
    }
    
    public static void editEmp(ArrayList<Employee> list, Scanner sc){        
        Employee tmp = searchById(list, sc);
        
        if(tmp != null){
            switch(tmp.getEmpTitle()){
                case "Trưởng phòng":{
                    System.out.println("> Nhập lại thông tin nhân viên \u001B[34m[" + tmp.getEmpName() + "]\u001B[0m");
                    System.out.println("1 - Chỉnh sửa tên nhân viên");
                    System.out.println("2 - Chỉnh sửa lương nhân viên");
                    int choose;
                            
                    do{
                        System.out.print("> ");
                        choose = iInput(sc);
                    } while(choose < 1 || choose > 2);
                    
                    sc.nextLine();
                    
                    switch(choose){
                        case 1:{
                            tmp.editName();
                            break;
                        }
                        
                        default: {
                            tmp.editSalary();
                            break;
                        }
                    }
                    
                    break;
                }
                
                case "Nhân viên hành chính":{
                    System.out.println("> Nhập lại thông tin nhân viên \u001B[34m[" + tmp.getEmpName() + "]\u001B[0m");
                    System.out.println("1 - Chỉnh sửa tên nhân viên");
                    System.out.println("2 - Chỉnh sửa lương nhân viên");
                    int choose;
                            
                    do{
                        System.out.print("> ");
                        choose = iInput(sc);
                    } while(choose < 1 || choose > 2);
                    
                    sc.nextLine();
                    
                    switch(choose){
                        case 1:{
                            tmp.editName();
                            break;
                        }
                        
                        default: {
                            tmp.editSalary();
                            break;
                        }
                    }
                    
                    break;
                }
                
                default:{
                    System.out.println("> Nhập lại thông tin nhân viên \u001B[34m[" + tmp.getEmpName() + "]\u001B[0m");
                    System.out.println("1 - Chỉnh sửa tên nhân viên");
                    System.out.println("2 - Chỉnh sửa lương nhân viên");
                    int choose;
                            
                    do{
                        System.out.print("> ");
                        choose = iInput(sc);
                    } while(choose < 1 || choose > 2);
                    
                    sc.nextLine();
                    
                    switch(choose){
                        case 1:{
                            tmp.editName();
                            break;
                        }
                        
                        default: {
                            tmp.editSalary();
                            break;
                        }
                    }
                    
                    break;
                }
            }
            
            System.out.println("> Chỉnh sửa hoàn tất!");
        }
        else
            System.out.println("> Mã nhân viên không tồn tại!");
    }
    
    public static void searchEmpBySalary(ArrayList<Employee> list, Scanner sc){
        System.out.print("> Nhập mức lương tối thiểu: ");
        double min = dInput(sc);
        
        System.out.print("> Nhập mức lương tối đa: ");
        double max = dInput(sc);
        
        System.out.println("DANH SÁCH NHÂN VIÊN THEO TỔNG THU NHẬP \u001B[34m[" + String.format("%,.1f", min) + " - " + String.format("%,.1f", max) + "]\u001B[0m");
        
        ArrayList<Employee> tmp = new ArrayList();
        
        for(Employee x : list){
            if(x.getEmpNet() >= min && x.getEmpNet() <= max){
                tmp.add(x);
            }
        }
        
        if(!tmp.isEmpty())
            outputList(tmp);
        else
            System.out.println("> Không có nhân viên nào!");
    }
    
    public static void sortByName(ArrayList<Employee> list){
        if(!list.isEmpty()){
            Collections.sort(list, (Employee staff1, Employee staff2) -> staff1.getFirstName().compareTo(staff2.getFirstName()));
            System.out.println("> Sắp xếp hoàn tất!");
        }
        else
            System.out.println("Danh sách rỗng!");
    }
    
    public static void sortBySalary(ArrayList<Employee> list, Scanner sc, int type){
        if(type == 161297){
            Collections.sort(list, (Employee staff1, Employee staff2) -> Double.compare(staff1.getEmpNet(), staff2.getEmpNet()));
            return;
        }
        
        if(!list.isEmpty()){
            System.out.println("> Chọn kiểu sắp xếp");
            System.out.println("1 - Từ thấp đến cao");
            System.out.println("2 - Từ cao đến thấp");
            
            int choose;
                    
            do{
                System.out.print("> ");
                choose = iInput(sc);
            } while(choose < 1 || choose > 2);
            
            switch(choose){
                case 1:{
                    Collections.sort(list, (Employee staff1, Employee staff2) -> Double.compare(staff1.getEmpNet(), staff2.getEmpNet()));
                    break;
                }
                
                default:{
                    Collections.sort(list, (Employee staff1, Employee staff2) -> Double.compare(staff1.getEmpNet(), staff2.getEmpNet()));
                    Collections.reverse(list);
                    break;
                }
            }
                       
            System.out.println("> Sắp xếp hoàn tất!");
            sc.nextLine();
        }
        else{
            System.out.println("> Danh sách rỗng!");
            sc.nextLine();
        }
    }
    
    public static void outputTopSalary(ArrayList<Employee> list, Scanner sc){
        if(!list.isEmpty()){
            ArrayList<Employee> tmp = new ArrayList(list);
            sortBySalary(tmp, sc, 161297);
            Collections.reverse(tmp);
            
            System.out.printf("\u001B[34m%-15s%-25s%-25s%-20s%-17s%-15s\u001B[0m\n", "[Mã nhân viên]", "[Họ và tên]", "[Chức vụ]", "[Lương cơ bản]", "[Thuế]", "[Tổng thu nhập]");
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            
            int index = 0;
                       
            for(Employee x : tmp){
                System.out.print("\u001B[31m");
                
                if(index < 5 && index <= tmp.size())
                    x.output(161297);
                
                index++;
            }
            
            System.out.print("\u001B[0m");
            
            System.out.println("-------------------------------------------------------------------------------------------------------------------");

        }
        else
            System.out.println("> Danh sách rỗng!");
    }
    
    public static void Space(int n){
        for(int i = 0; i < n; i++){
            System.out.print(" ");
        }
    }
    
    public static void Separate(int n){
        for(int i = 0; i < n; i++){
            System.out.print(".");
        }
    }
    
    public static void menuText(){       
        String menu = "< CÔNG TY RỒNG VIỆT >";
        Space((50 - menu.length()) / 2);
        System.out.println("\u001B[31m" + menu);
        String app = "PHẦN MỀM QUẢN LÝ NHÂN SỰ";
        Space((50 - app.length()) / 2);
        System.out.println(app + "\u001B[0m\n");
        String menu1 = "BẢNG CHỌN CHỨC NĂNG";
        Space((50 - menu1.length()) / 2);
        System.out.println("\u001B[34m" + menu1 + "\u001B[0m");
        
        Separate(50);
        System.out.print("\n");
        
        String text1 = ".     1 - Nhập danh sách nhân viên";
        String text2 = ".     2 - Xuất danh sách nhân viên";
        String text3 = ".     3 - Tìm kiếm theo mã số";
        String text4 = ".     4 - Xóa nhân viên theo mã số";
        String text5 = ".     5 - Cập nhật thông tin nhân viên";
        String text6 = ".     6 - Tìm kiếm theo khoảng lương";
        String text7 = ".     7 - Sắp xếp nhân viên theo tên";
        String text8 = ".     8 - Sắp xếp nhân theo thu nhập";
        String text9 = ".     9 - Hiển thị 5 nhân viên thu nhập cao";
        String text10 = ".     10 - Kết thúc chương trình";
        
        System.out.print(text1);
            Space(49 - text1.length());
        Separate(1);
        System.out.print("\n");
        
        System.out.print(text2);
        Space(49 - text2.length());
        Separate(1);
        System.out.print("\n");
        
        System.out.print(text3);
        Space(49 - text3.length());
        Separate(1);
        System.out.print("\n");
        
        System.out.print(text4);
        Space(49 - text4.length());
        Separate(1);
        System.out.print("\n");
        
        System.out.print(text5);
        Space(49 - text5.length());
        Separate(1);
        System.out.print("\n");
        
        System.out.print(text6);
        Space(49 - text6.length());
        Separate(1);
        System.out.print("\n");
        
        System.out.print(text7);
        Space(49 - text7.length());
        Separate(1);
        System.out.print("\n");
        
        System.out.print(text8);
        Space(49 - text8.length());
        Separate(1);
        System.out.print("\n");
        
        System.out.print(text9);
        Space(49 - text9.length());
        Separate(1);
        System.out.print("\n");
        
        System.out.print(text10);
        Space(49 - text10.length());
        Separate(1);  
        System.out.print("\n");
        
        Separate(50);
        System.out.print("\n");
    }
    
    public static void playBeep(){
        Toolkit.getDefaultToolkit().beep();
    }
}