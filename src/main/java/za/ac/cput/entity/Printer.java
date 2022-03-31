/**

 * This is a Printer.java class with entities and builder pattern.
 *Nondumiso Gaga (2204308543)
 * ADP Assignment1 term1 Group25
 * date:27/03/2022
 */

package za.ac.cput.entity;

public class Printer {
        private String printerCode;
        private String brandName;
        private String status;
        private int libraryId;

            //private constructor
            private Printer(Builder b){
            this.printerCode= b.printerCode;
            this.brandName= b.brandName;
            this.status=b.status;
            this.libraryId=b.libraryId;
        }
            //getters and setters

            public String getPrinterCode() {
            return printerCode;
        }

            public void setPrinterCode(String printerCode) {
            this.printerCode = printerCode;
        }

            public String getBrandName() {
            return brandName;
        }

            public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

            public String getStatus() {
            return status;
        }

            public void setStatus(String status) {
            this.status = status;
        }

            public int getLibraryId() {
            return libraryId;
        }
            public void setLibraryId(int libraryId) {
            this.libraryId = libraryId;
        }
            @Override
            public String toString() {
            return "Printer{" +
                    "printerCode=" + printerCode +
                    ", brandName='" + brandName + '\'' +
                    ", status='" + status + '\'' +
                    ", libraryId=" + libraryId +
                    '}';

        }
            //Builder class
            public static class Builder{
                private  String printerCode;
                private String brandName;
                private String status;
                private int libraryId;

                public Builder setPrinterCode(String printerCode) {
                    this.printerCode = printerCode;
                    return this;
                }

                public Builder setBrandName(String brandName) {
                    this.brandName = brandName;
                    return this;
                }

                public Builder setStatus(String status) {
                    this.status = status;
                    return this;
                }

                public Builder setLibraryId(int libraryId) {
                    this.libraryId = libraryId;
                    return this;
                }
                public Builder copy(Printer printer){
                    this.printerCode= printer.printerCode;
                    this.brandName = printer.brandName;
                    this.status =printer.status;
                    this.libraryId = printer.libraryId;
                    return this;
                }
                public Printer build(){
                    return new Printer(this);
                }
            }

        }




