/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package l01;

/**
 * L01 - Create a Java console program to manage Candidates of company.
 * @author ThinhNDCE190865
 */
public class Intern extends Candidate {

    private String majors;
    private byte semester;
    private String universityName;

    /**
     * Constructor, use builder to initialize class properties
     *
     * @param builder is a class that supports initialization
     */
    public Intern(Builder builder) {
        super(builder);
        this.majors = builder.majors;
        this.semester = builder.semester;
        this.universityName = builder.universityName;
        this.setCandidateType((byte) 2);
    }

    /**
     * Builder is a class that makes initialization clearer, better, and easier
     * to maintain
     */
    public static class Builder extends Candidate.Builder {

        private String majors;
        private byte semester;
        private String universityName;

        /**
         * majors method, used to assign the builder's address property
         *
         * @param majors is the attribute to assign
         * @return itself for continued use
         */
        public Builder majors(String majors) {
            this.majors = majors;
            return this;
        }

        /**
         * semester method, used to assign the builder's address property
         *
         * @param semester is the attribute to assign
         * @return itself for continued use
         */
        public Builder semester(byte semester) {
            this.semester = semester;
            return this;
        }

        /**
         * universityName method, used to assign the builder's address property
         *
         * @param universityName is the attribute to assign
         * @return itself for continued use
         */
        public Builder universityName(String universityName) {
            this.universityName = universityName;
            return this;
        }

        /**
         * build method, used to initialize objects of the main class
         *
         * @return objects of the main class
         */
        @Override
        public Intern build() {
            return new Intern(this);
        }
    }

    /**
     * getMajors method, used to get the majors attribute
     *
     * @return majors attribute
     */
    public String getMajors() {
        return majors;
    }

    /**
     * setMajors method, used to set the majors property of an object
     *
     * @param majors is attribute to set
     */
    public void setMajors(String majors) {
        this.majors = majors;
    }

    /**
     * getSemester method, used to get the semester attribute
     *
     * @return semester attribute
     */
    public byte getSemester() {
        return semester;
    }

    /**
     * setSemester method, used to set the semester property of an object
     *
     * @param semester is attribute to set
     */
    public void setSemester(byte semester) {
        this.semester = semester;
    }

    /**
     * getUniversityName method, used to get the universityName attribute
     *
     * @return universityName attribute
     */
    public String getUniversityName() {
        return universityName;
    }

    /**
     * setUniversityName method, used to set the universityName property of an
     * object
     *
     * @param universityName is attribute to set
     */
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

}
