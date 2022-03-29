package za.ac.cput.entity;

/*
   Ziyaad Petersen (219083479)
   ADP3 - Assignment 1: Group 25
   Date: 28 March 2022
 */

public class Manager extends Staff {

    private String managerCode;
    private boolean availability;


    public Manager(ManagerBuilder b) {
        super(b);
        this.managerCode = b.managerCode;
        this.availability = b.availability;
    }

    public String getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(String managerCode) {
        this.managerCode = managerCode;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return super.toString() + "Manager{" +
                "managerCode='" + managerCode + '\'' +
                ", availability=" + availability +
                '}';
    }

    public static class ManagerBuilder extends Staff.StaffBuilder{
        private String managerCode;
        private boolean availability;

        public ManagerBuilder setManagerCode(String managerCode) {
            this.managerCode = managerCode;
            return this;
        }

        public ManagerBuilder setAvailability(boolean availability) {
            this.availability = availability;
            return this;
        }

        public ManagerBuilder copy(Manager m){
            this.managerCode = m.managerCode;
            this.availability = m.availability;
            return this;
        }

        public Manager build(){
            return new Manager(this);
        }
    }
}
