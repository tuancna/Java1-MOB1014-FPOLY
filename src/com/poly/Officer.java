package com.poly;

public class Officer extends Employee {
    public Officer(){
        super();
    }
    
    public Officer(int Type){
        super.setEmpTitle(Type);
    }   
    
    public Officer(String empId, String empName, double empSalary){
        super.setEmpId(empId);
        super.setEmpName(empName);
        super.setEmpTitle(2);
        super.setEmpSalary(empSalary);
        
        if(super.getEmpSalary() < 9000000)
            super.setEmpTax(0);
        else if(super.getEmpSalary() < 15000000)
            super.setEmpTax((super.getEmpSalary()) * 0.1);
        else
            super.setEmpTax((super.getEmpSalary()) * 0.12);
        
        super.setEmpNet(super.getEmpSalary() - super.getEmpTax());
    }
    //--------------------------------------    
    @Override
    public void input(){
        super.input();
        
        System.out.print("> Nhập lương cơ bản: ");
        super.setEmpSalary(super.dInput());
        
        if(super.getEmpSalary() < 9000000)
            super.setEmpTax(0);
        else if(super.getEmpSalary() < 15000000)
            super.setEmpTax((super.getEmpSalary()) * 0.1);
        else
            super.setEmpTax((super.getEmpSalary()) * 0.12);
        
        super.setEmpNet(super.getEmpSalary() - super.getEmpTax());
    }
    
    @Override
    public void editSalary(){
        System.out.print("> Nhập lại lương cơ bản: ");
        super.setEmpSalary(super.dInput());
        
        if(super.getEmpSalary() < 9000000)
            super.setEmpTax(0);
        else if(super.getEmpSalary() < 15000000)
            super.setEmpTax((super.getEmpSalary()) * 0.1);
        else
            super.setEmpTax((super.getEmpSalary()) * 0.12);
        
        super.setEmpNet(super.getEmpSalary() - super.getEmpTax());
    }
    
    @Override
    public void output(int Type){
        if(Type == 161297){
            System.out.printf("%-15s%-25s%-25s%-20s%-17s%-15s\n", super.getEmpId(), super.getEmpName(), super.getEmpTitle(), String.format("%,.1f", super.getEmpSalary()), String.format("%,.1f", super.getEmpTax()), String.format("%,.1f", super.getEmpNet()));
            return;
        }
        
        System.out.printf("\u001B[34m%-15s%-25s%-25s%-20s%-17s%-15s\u001B[31m\n", "[Mã nhân viên]", "[Họ và tên]", "[Chức vụ]", "[Lương cơ bản]", "[Thuế]", "[Tổng thu nhập]");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-25s%-25s%-20s%-17s%-15s\n", getEmpId(), getEmpName(), getEmpTitle(), String.format("%,.1f", super.getEmpSalary()), String.format("%,.1f", super.getEmpTax()), String.format("%,.1f", super.getEmpNet()));
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
    }
}
