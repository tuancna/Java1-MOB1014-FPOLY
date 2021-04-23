package com.poly;

public class Saleman extends Employee {
    private double empSale, empBonus;
    //--------------------------------------
    public Saleman(){
        super();
    }
    
    public Saleman(int Type){
        super.setEmpTitle(Type);
    }
    
    public Saleman(String empId, String empName, double empSalary, double empSale){
        super.setEmpId(empId);
        super.setEmpName(empName);
        super.setEmpTitle(3);
        super.setEmpSalary(empSalary);
        this.empSale = empSale;
        this.empBonus = this.empSale * 0.05;
        
        if((super.getEmpSalary() + this.empBonus) < 9000000)
            super.setEmpTax(0);
        else if((super.getEmpSalary() + this.empBonus) < 15000000)
            super.setEmpTax((super.getEmpSalary() + this.empBonus) * 0.1);
        else
            super.setEmpTax((super.getEmpSalary() + this.empBonus) * 0.12);
        
        super.setEmpNet(super.getEmpSalary() + this.empBonus - super.getEmpTax());
    }
    //--------------------------------------
    public void setEmpSale(double empSale) {
        this.empSale = empSale;
    }
    
    public void setEmpTotal(){
        this.empBonus = this.empSale * 0.05;
        
        if((super.getEmpSalary() + this.empBonus) < 9000000)
            super.setEmpTax(0);
        else if((super.getEmpSalary() + this.empBonus) < 15000000)
            super.setEmpTax((super.getEmpSalary() + this.empBonus) * 0.1);
        else
            super.setEmpTax((super.getEmpSalary() + this.empBonus) * 0.12);
        
        super.setEmpNet(super.getEmpSalary() + this.empBonus - super.getEmpTax());
    }
    //--------------------------------------
    public double getEmpSale() {
        return empSale;
    }

    public double getEmpBonus() {
        return empBonus;
    }
    //--------------------------------------    
    @Override
    public void input(){
        super.input();
        
        System.out.print("> Nhập lương cơ bản: ");
        setEmpSalary(super.dInput());
        
        System.out.print("> Nhập doanh số bán hàng: ");
        setEmpSale(super.dInput());
        
        setEmpTotal();
    }
    
    @Override
    public void editSalary(){
        System.out.print("> Nhập lại lương cơ bản: ");
        setEmpSalary(super.dInput());
        
        System.out.print("> Nhập lại doanh số bán hàng: ");
        setEmpSale(super.dInput());
        
        setEmpTotal();
    }
    
    @Override
    public void output(int Type){
        if(Type == 161297){
            System.out.printf("%-15s%-25s%-25s%-20s%-17s%-15s\n", super.getEmpId(), super.getEmpName(), super.getEmpTitle(), String.format("%,.1f", super.getEmpSalary()), String.format("%,.1f", super.getEmpTax()), String.format("%,.1f", super.getEmpNet()));
            return;
        }

        System.out.printf("\u001B[34m%-15s%-25s%-25s%-20s%-17s%-17s%-15s%-15s\u001B[0m\n", "[Mã nhân viên]", "[Họ và tên]", "[Chức vụ]", "[Lương cơ bản]", "[Doanh số]", "[Thưởng]", "[Thuế]", "[Tổng thu nhập]");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-25s%-25s%-20s%-17s%-17s%-15s%-15s\n", getEmpId(), getEmpName(), getEmpTitle(), String.format("%,.1f", super.getEmpSalary()), String.format("%,.1f", getEmpSale()), String.format("%,.1f", getEmpBonus()), String.format("%,.1f", super.getEmpTax()), String.format("%,.1f", super.getEmpNet()));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
