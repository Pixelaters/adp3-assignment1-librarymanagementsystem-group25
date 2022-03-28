/* Library.java
Entity for Library
Author: Ethan George(218008430)
Date: 28 March 2022
*/

package za.ac.cput.entity;

public class Computer {


    private String computerId;
    private String computerBrand;
    private String computerStatus;


    public Computer(String computerId, String computerBrand, String computerStatus) {
        this.computerId = computerId;
        this.computerBrand = computerBrand;
        this.computerStatus = computerStatus;
    }

    public Computer(Computer computer) {
    }


    public String getComputerId() {
        return computerId;
    }

    public void setComputerId(String computerId) {
        this.computerId = computerId;
    }

    public String getComputerBrand() {
        return computerBrand;
    }

    public void setComputerBrand(String computerBrand) {
        this.computerBrand = computerBrand;
    }

    public String getComputerStatus() {
        return computerStatus;
    }

    public void setComputerStatus(String computerStatus) {
        this.computerStatus = computerStatus;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "computerId='" + computerId + '\'' +
                ", computerBrand='" + computerBrand + '\'' +
                ", computerStatus='" + computerStatus + '\'' +
                '}';
    }

    public static class ComputerBuilder{

        private String libraryId;
        private String libraryName;
        private String libraryLocation;
        private String libraryAddress;
    }





    public Computer build(){
        Computer computer = new Computer(  this);
        return computer;
    }

}

