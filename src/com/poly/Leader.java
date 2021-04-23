package com.poly;

public class Leader extends Employee{
    private double empWageBonus;
    //--------------------------------------
    public Leader() {
        super();
    }
    
    public Leader(int Type){
        super.setEmpTitle(Type);
    }
    
    public Leader(String empId, String empName, double empSalary, double empWageBonus){
        super.setEmpId(empId);
        super.setEmpName(empName);
        super.setEmpTitle(1);
        super.setEmpSalary(empSalary);
        this.empWageBonus = empWageBonus;
        
        if(super.getEmpSalary() + this.empWageBonus < 9000000)
            super.setEmpTax(0);
        else if(super.getEmpSalary() + this.empWageBonus < 15000000)
            super.setEmpTax((super.getEmpSalary() + this.empWageBonus) * 0.1);
        else
            super.setEmpTax((super.getEmpSalary() + this.empWageBonus) * 0.12);
        
        super.setEmpNet(super.getEmpSalary() + this.empWageBonus - super.getEmpTax());
    }
    //--------------------------------------
    public void setEmpWageBonus(double empWageBonus) {
        this.empWageBonus = empWageBonus;
    }
    
    public void setEmpTotal(){       
        if(super.getEmpSalary() + this.empWageBonus < 9000000)
            super.setEmpTax(0);
        else if(super.getEmpSalary() + this.empWageBonus < 15000000)
            super.setEmpTax((super.getEmpSalary() + this.empWageBonus) * 0.1);
        else
            super.setEmpTax((super.getEmpSalary() + this.empWageBonus) * 0.12);
        
        super.setEmpNet(super.getEmpSalary() + this.empWageBonus - super.getEmpTax());
    }
    //--------------------------------------
    public double getEmpWageBonus() {
        return empWageBonus;
    }
    //--------------------------------------    
    @Override
    public void input(){
        super.input();
        
        System.out.print("> Nhập lương cơ bản: ");
        super.setEmpSalary(super.dInput());
        
        System.out.print("> Nhập lương trách nhiệm: ");
        setEmpWageBonus(super.dInput());
        
        setEmpTotal();
    }
    
    @Override
    public void output(int Type){
        if(Type == 161297){
            System.out.printf("%-15s%-25s%-25s%-20s%-17s%-15s\n", super.getEmpId(), super.getEmpName(), super.getEmpTitle(), String.format("%,.1f", super.getEmpSalary()), String.format("%,.1f", super.getEmpTax()), String.format("%,.1f", super.getEmpNet()));
            return;
        }
        
        System.out.printf("\u001B[34m%-15s%-25s%-25s%-20s%-17s%-15s%-15s\u001B[0m\n", "[Mã nhân viên]", "[Họ và tên]", "[Chức vụ]", "[Lương cơ bản]", "[Thưởng]", "[Thuế]", "[Tổng thu nhập]");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-25s%-25s%-20s%-17s%-15s%-15s\n", getEmpId(), getEmpName(), getEmpTitle(), String.format("%,.1f", super.getEmpSalary()), String.format("%,.1f", getEmpWageBonus()), String.format("%,.1f", super.getEmpTax()), String.format("%,.1f", super.getEmpNet()));
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    }
    
    @Override
    public void editSalary(){
        System.out.print("> Nhập lại lương cơ bản: ");
        super.setEmpSalary(super.dInput());
        
        System.out.print("> Nhập lại lương trách nhiệm: ");
        setEmpWageBonus(super.dInput());
        
        setEmpTotal();
    }
}   

