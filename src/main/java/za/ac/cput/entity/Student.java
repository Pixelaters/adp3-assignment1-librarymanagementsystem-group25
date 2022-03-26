package za.ac.cput.entity;
/*
  Breyton Ernstzen (217203027)
  Date: 26 March 2022
 */
public class Student extends Customer{
    private long studentNumber;
    private String course;
    private boolean highSchool;
    private boolean university;

    //private constructor
    private Student(Builder b){
        super(b);
        this.studentNumber = b.studentNumber;
        this.course = b.course;
        this.highSchool = b.highSchool;
        this.university = b.university;

    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public boolean isHighSchool() {
        return highSchool;
    }

    public void setHighSchool(boolean highSchool) {
        this.highSchool = highSchool;
    }

    public boolean isUniversity() {
        return university;
    }

    public void setUniversity(boolean university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return super.toString() +
                "studentNumber= " + studentNumber +
                ", course='" + course + '\'' +
                ", highSchool=" + highSchool +
                ", university=" + university +
                '}';
    }

    public static class Builder extends Customer.Builder {
        private long studentNumber;
        private String course;
        private boolean highSchool;
        private boolean university;

        public Builder setStudentNumber(long studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }

        public Builder setCourse(String course) {
            this.course = course;
            return this;
        }

        public Builder setHighSchool(boolean highSchool) {
            this.highSchool = highSchool;
            return this;
        }

        public Builder setUniversity(boolean university) {
            this.university = university;
            return this;
        }

        public Builder copy(Student s){
            this.studentNumber = s.studentNumber;
            this.course = s.course;
            this.highSchool = s.highSchool;
            this.university = s.university;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }
}
