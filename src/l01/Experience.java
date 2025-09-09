/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package l01;

/**
 * L01 - Create a Java console program to manage Candidates of company.
 * @author ThinhNDCE190865
 */
public class Experience extends Candidate {

    private byte expInYear;
    private String proSkill;

    /**
     * Constructor, use builder to initialize class properties
     *
     * @param builder is a class that supports initialization
     */
    public Experience(Builder builder) {
        super(builder);
        this.expInYear = builder.expInYear;
        this.proSkill = builder.proSkill;
        this.setCandidateType((byte) 0);
    }

    /**
     * Builder is a class that makes initialization clearer, better, and easier
     * to maintain
     */
    public static class Builder extends Candidate.Builder {

        private byte expInYear;
        private String proSkill;

        /**
         * expInYear method, used to assign the builder's address property
         *
         * @param expInYear is the attribute to assign
         * @return itself for continued use
         */
        public Builder expInYear(byte expInYear) {
            this.expInYear = expInYear;
            return this;
        }

        /**
         * proSkill method, used to assign the builder's address property
         *
         * @param proSkill is the attribute to assign
         * @return itself for continued use
         */
        public Builder proSkill(String proSkill) {
            this.proSkill = proSkill;
            return this;
        }

        /**
         * build method, used to initialize objects of the main class
         *
         * @return objects of the main class
         */
        @Override
        public Experience build() {
            return new Experience(this);
        }
    }

    /**
     * getExpInYear method, used to get the expInYear attribute
     *
     * @return expInYear attribute
     */
    public byte getExpInYear() {
        return expInYear;
    }

    /**
     * setExpInYear method, used to set the expInYear property of an object
     *
     * @param expInYear is attribute to set
     */
    public void setExpInYear(byte expInYear) {
        this.expInYear = expInYear;
    }

    /**
     * getProSkill method, used to get the proSkill attribute
     *
     * @return proSkill attribute
     */
    public String getProSkill() {
        return proSkill;
    }

    /**
     * setProSkill method, used to set the proSkill property of an object
     *
     * @param proSkill is attribute to set
     */
    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

}
