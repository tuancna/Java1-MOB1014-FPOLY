package com.poly;

import java.util.Scanner;

public class Employee {
    private String empName, empId, empTitle;
    private double empNet = 0, empSalary = 0, empTax = 0;
    //--------------------------------------
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setEmpTitle(int Type) {
        switch(Type){
            case 1: {
                this.empTitle = "Trưởng phòng";
                break;
            }
            
            case 2: {
                this.empTitle = "Nhân viên hành chính";
                break;
            }
            
            case 3: {
                this.empTitle = "Nhân viên kinh doanh";
                break;
            }
        }
    }
    
    public void setEmpNet(double empNet) {
        this.empNet = empNet;
    }
    
    public void setEmpSalary(double empSalary){
        this.empSalary = empSalary;
    }

    public void setEmpTax(double empTax) {
        this.empTax = empTax;
    }
    //--------------------------------------
    public String getEmpName() {
        return empName;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpTitle() {
        return empTitle;
    }
    
    public double getEmpSalary(){
        return empSalary;
    }
    
    public double getEmpNet(){
        return empNet;
    }

    public double getEmpTax() {
        return empTax;
    }
    
    public String getFirstName(){
        String firstName;
        
        int position = getEmpName().lastIndexOf(" ");
        firstName = getEmpName().substring(position + 1);
        
        return firstName;
    }
    //--------------------------------------
    protected double dInput(){
        Scanner sc = new Scanner(System.in);
        double result;
        
        do{
            while(!sc.hasNextDouble()){
                String except = sc.next();

                System.out.println(except + " không hợp lệ!");
                System.out.print("> Nhập lại: ");
            }
            
            result = sc.nextDouble();
            
            if(result < 0)
                System.out.println("> Không hợp lệ!");
            
        } while(result < 0);
        
        return result;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        String patternId = "^RV-[0-9]{5}";
        //RV-<5 CHỮ SỐ>
        
        do{
            System.out.print("> Nhập mã số nhân viên (RV-12345): ");
            setEmpId(sc.nextLine());
        } while(!this.getEmpId().matches(patternId));
        
        System.out.print("> Nhập họ và tên nhân viên: ");
        setEmpName(sc.nextLine().trim().replaceAll(" +", " "));
    }
    
    public void editName(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("> Nhập lại họ và tên nhân viên: ");
        setEmpName(sc.nextLine().trim());
    }
    
    public void editSalary(){
        System.out.println(">>");
    }
    
    public void output(int Type){
        if(Type == 161297){
            System.out.printf("%-15s%-25s%-25s%-20s%-17s%-15s\n", getEmpId(), getEmpName(), getEmpTitle(), String.format("%,.1f", getEmpSalary()), String.format("%,.1f", getEmpTax()), String.format("%,.1f", getEmpNet()));
            return;
        }
        
        System.out.printf("\n%-15s%-25s%-25s%-20s%-17s%-15s\n", "[Mã nhân viên]", "[Họ và tên]", "[Chức vụ]", "[Lương cơ bản]", "[Thuế]", "[Tổng thu nhập]");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-25s%-25s%-20s%-17s%-15s\n", getEmpId(), getEmpName(), getEmpTitle(), String.format("%,.1f", getEmpSalary()), String.format("%,.1f", getEmpTax()), String.format("%,.1f", getEmpNet()));
    }
}
