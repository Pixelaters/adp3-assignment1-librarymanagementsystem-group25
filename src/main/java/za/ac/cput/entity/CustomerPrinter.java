
/**
 * This is CustomerPrinter.java file.
 * Nondumiso Gaga (220430853)
 * ADP Assignment1 term1 Group 25
 * date:27/03/2022
 */

package za.ac.cput.entity;

    public class CustomerPrinter {

        private int customerId;
        private String printerCode;
        private String activity;

        private CustomerPrinter(Builder builder){
            this.customerId =builder.customerId;
            this.printerCode= builder.printerCode;
            this.activity= builder.activity;
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public String getPrinterCode() {
            return printerCode;
        }
        public void setPrinterCode(String printerCode) {
            this.printerCode = printerCode;
        }

        public String getActivity() {
            return activity;
        }
        public void setActivity(String activity) {
            this.activity = activity;
        }

        @Override
        public String toString() {
            return "CustomerPrinter{" +
                    "customerId=" + customerId +
                    ", printerCode='" + printerCode + '\'' +
                    ", activity='" + activity + '\'' +
                    '}';
        }
        public static class Builder {
            private int customerId;
            private String printerCode;
            private String activity;

            public Builder setCustomerId(int customerId) {
                this.customerId = customerId;
                return this;
            }

            public Builder setPrinterCode(String printerCode) {
                this.printerCode = printerCode;
                return this;
            }

            public Builder setActivity(String activity) {
                this.activity = activity;
                return this;
            }
            public Builder copy(CustomerPrinter custPrinter){
                this.customerId = custPrinter.customerId;
                this.printerCode = custPrinter.printerCode;
                this.activity = custPrinter.activity;
                return this;
            }

            public CustomerPrinter build(){
                return new CustomerPrinter(this);
            }

        }

    }


