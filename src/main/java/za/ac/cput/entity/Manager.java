package za.ac.cput.entity;
import za.ac.cput.entity.Staff;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Manager extends Staff {

    private String managerCode;
    private Boolean availability;


    public Manager(Builder b) {
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

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return super.toString() + "Manager{" +
                "managerCode='" + managerCode + '\'' +
                ", availability=" + availability +
                '}';
    }

    public static class Builder extends Staff.Builder{
        private String managerCode;
        private Boolean availability;

        public Builder setManagerCode(String managerCode) {
            this.managerCode = managerCode;
            return this;
        }

        public Builder setAvailability(Boolean availability) {
            this.availability = availability;
            return this;
        }

        public Builder copy(Manager m){
            this.managerCode = m.managerCode;
            this.availability = m.availability;
            return this;
        }

        public Manager build(){
            return new Manager(this);
        }
    }
}
