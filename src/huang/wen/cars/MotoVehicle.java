package huang.wen.cars;

import javax.swing.*;

abstract public class MotoVehicle {
    private String vehicleId; //车牌号
    private String brand;       //汽车品牌
    private float rent;



    public String flag;  //用来判断指定汽车是否已租出或者用户是否成功租车
    public String date;

    public MotoVehicle(String vehicleId, String brand, float rent, String flag,String date) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.rent = rent;
        this.flag = flag;
        this.date=date;
    }
    public MotoVehicle(){
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
    //车牌
    public String getPlateNumber() {
        return vehicleId;
    }

    public void setPlateNumber(String plateNumber) {
        this.vehicleId = plateNumber;
    }

    //汽车品牌
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    //租金
    public float getPerRent() {
        return rent;
    }

    public void setPerRent(float rent) {
        this.rent = rent;
    }

    //添加车辆流程
    public void AddProcess(JFrame Administrator){

    }
    //租用时间
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public abstract void calRent(int days); //计算租金
    public void leaseOutFlow(){}  //租车流程
}
