package za.ac.cput.entity;

public class Adult extends Customer{
    private boolean isPensioner;
    private boolean isEmployed;
    private String jobDescription;

    public Adult(Builder b){
        super(b);
        this.isPensioner = b.isPensioner;
        this.isEmployed = b.isEmployed;
        this.jobDescription = b.jobDescription;
    }

    public boolean isPensioner() {
        return isPensioner;
    }

    public void setPensioner(boolean pensioner) {
        isPensioner = pensioner;
    }

    public boolean isEmployed() {
        return isEmployed;
    }

    public void setEmployed(boolean employed) {
        isEmployed = employed;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    @Override
    public String toString() {
        super.toString();
        return "Adult{" +
                "isPensioner=" + isPensioner +
                ", isEmployed=" + isEmployed +
                ", jobDescription='" + jobDescription + '\'' +
                '}';
    }

    public static class Builder extends Customer.Builder {
        private boolean isPensioner;
        private boolean isEmployed;
        private String jobDescription;

        public Builder setPensioner(boolean pensioner) {
            isPensioner = pensioner;
            return this;
        }

        public Builder setEmployed(boolean employed) {
            isEmployed = employed;
            return this;
        }

        public Builder setJobDescription(String jobDescription) {
            this.jobDescription = jobDescription;
            return this;
        }

        public Builder copy(Adult a){
            this.isPensioner = a.isPensioner;
            this.isEmployed = a.isEmployed;
            this.jobDescription = a.jobDescription;
            return this;
        }

        public Adult build(){
            return new Adult(this);
        }
    }
}
