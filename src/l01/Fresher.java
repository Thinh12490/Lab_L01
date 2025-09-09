/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package l01;

import java.time.LocalDate;

/**
 * L01 - Create a Java console program to manage Candidates of company.
 * @author ThinhNDCE190865
 */
public class Fresher extends Candidate {

    private LocalDate graduationDate;
    private GraduationRank graduationRank;
    private String education;

    /**
     * enumeration contains the graduation rating of fresher
     */
    public enum GraduationRank {
        EXCELLENCE, GOOD, FAIR, POOR
    }

    /**
     * Constructor, use builder to initialize class properties
     *
     * @param builder is a class that supports initialization
     */
    public Fresher(Builder builder) {
        super(builder);
        this.education = builder.education;
        this.graduationDate = builder.graduationDate;
        this.graduationRank = builder.graduationRank;
        this.setCandidateType((byte) 1);
    }

    /**
     * Builder is a class that makes initialization clearer, better, and easier
     * to maintain
     */
    public static class Builder extends Candidate.Builder {

        private LocalDate graduationDate;
        private GraduationRank graduationRank;
        private String education;

        /**
         * graduationDate method, used to assign the builder's address property
         *
         * @param graduationDate is the attribute to assign
         * @return itself for continued use
         */
        public Builder graduationDate(LocalDate graduationDate) {
            this.graduationDate = graduationDate;
            return this;
        }

        /**
         * graduationRank method, used to assign the builder's address property
         *
         * @param graduationRank is the attribute to assign
         * @return itself for continued use
         */
        public Builder graduationRank(GraduationRank graduationRank) {
            this.graduationRank = graduationRank;
            return this;
        }

        /**
         * education method, used to assign the builder's address property
         *
         * @param education is the attribute to assign
         * @return itself for continued use
         */
        public Builder education(String education) {
            this.education = education;
            return this;
        }

        /**
         * build method, used to initialize objects of the main class
         *
         * @return objects of the main class
         */
        @Override
        public Fresher build() {
            return new Fresher(this);
        }
    }

    /**
     * getGraduationDate method, used to get the graduationDate attribute
     *
     * @return graduationDate attribute
     */
    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    /**
     * setGraduationDate method, used to set the graduationDate property of an
     * object
     *
     * @param graduationDate is attribute to set
     */
    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    /**
     * getGraduationRank method, used to get the graduationRank attribute
     *
     * @return graduationRank attribute
     */
    public GraduationRank getGraduationRank() {
        return graduationRank;
    }

    /**
     * setGraduationRank method, used to set the graduationRank property of an
     * object
     *
     * @param graduationRank is attribute to set
     */
    public void setGraduationRank(GraduationRank graduationRank) {
        this.graduationRank = graduationRank;
    }

    /**
     * getEducation method, used to get the education attribute
     *
     * @return education attribute
     */
    public String getEducation() {
        return education;
    }

    /**
     * setEducation method, used to set the education property of an object
     *
     * @param education is attribute to set
     */
    public void setEducation(String education) {
        this.education = education;
    }

}
