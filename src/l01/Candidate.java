/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package l01;

/**
 * L01 - Create a Java console program to manage Candidates of company.
 * @author ThinhNDCE190865
 */
public class Candidate {
    private final String[] typeStrings = { "Experience", "Fresher", "Intern"};

    private String address;
    private short birthDate;
    private String candidateId;
    private byte candidateType;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;

    /**
     * Constructor, use builder to initialize class properties
     *
     * @param builder is a class that supports initialization
     */
    public Candidate(Builder builder) {
        // initialize each property of the class
        this.address = builder.address;
        this.birthDate = builder.birthDate;
        this.candidateId = builder.candidateId;
        this.candidateType = builder.candidateType;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phone = builder.phone;
    }

    /**
     * Builder is a class that makes initialization clearer, better, and easier
     * to maintain
     */
    public static class Builder {

        private String address;
        private short birthDate;
        private String candidateId;
        private byte candidateType;
        private String email;
        private String firstName;
        private String lastName;
        private String phone;

        /**
         * address method, used to assign the builder's address property
         *
         * @param address is the attribute to assign
         * @return itself for continued use
         */
        public Builder address(String address) {
            this.address = address;
            return this;
        }

        /**
         * birthDate method, used to assign the builder's address property
         *
         * @param birthDate is the attribute to assign
         * @return itself for continued use
         */
        public Builder birthDate(short birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        /**
         * candidateId method, used to assign the builder's address property
         *
         * @param candidateId is the attribute to assign
         * @return itself for continued use
         */
        public Builder candidateId(String candidateId) {
            this.candidateId = candidateId;
            return this;
        }

        /**
         * candidateType method, used to assign the builder's address property
         *
         * @param candidateType is the attribute to assign
         * @return itself for continued use
         */
        public Builder candidateType(byte candidateType) {
            this.candidateType = candidateType;
            return this;
        }

        /**
         * email method, used to assign the builder's address property
         *
         * @param email is the attribute to assign
         * @return itself for continued use
         */
        public Builder email(String email) {
            this.email = email;
            return this;
        }

        /**
         * firstName method, used to assign the builder's address property
         *
         * @param firstName is the attribute to assign
         * @return itself for continued use
         */
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        /**
         * lastName method, used to assign the builder's address property
         *
         * @param lastName is the attribute to assign
         * @return itself for continued use
         */
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        /**
         * phone method, used to assign the builder's address property
         *
         * @param phone is the attribute to assign
         * @return itself for continued use
         */
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        /**
         * build method, used to initialize objects of the main class
         *
         * @return objects of the main class
         */
        public Candidate build() {
            return new Candidate(this);
        }
    }

    /**
     * getCandidateId method, used to get the candidateId attribute
     *
     * @return candidateId attribute
     */
    public String getCandidateId() {
        return candidateId;
    }

    /**
     * getFirstName method, used to get the firstName attribute
     *
     * @return firstName attribute
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * getLastName method, used to get the lastName attribute
     *
     * @return lastName attribute
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * getBirthDate method, used to get the birthDate attribute
     *
     * @return birthDate attribute
     */
    public short getBirthDate() {
        return birthDate;
    }

    /**
     * getAddress method, used to get the address attribute
     *
     * @return address attribute
     */
    public String getAddress() {
        return address;
    }

    /**
     * getPhone method, used to get the phone attribute
     *
     * @return phone attribute
     */
    public String getPhone() {
        return phone;
    }

    /**
     * getEmail method, used to get the email attribute
     *
     * @return email attribute
     */
    public String getEmail() {
        return email;
    }

    /**
     * getCandidateType method, used to get the candidateType attribute
     *
     * @return candidateType attribute
     */
    public byte getCandidateType() {
        return candidateType;
    }

    /**
     * setCandidateId method, used to set the candidateId property of an object
     *
     * @param candidateId is attribute to set
     */
    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    /**
     * setFirstName method, used to set the firstName property of an object
     *
     * @param firstName is attribute to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * setLastName method, used to set the lastName property of an object
     *
     * @param lastName is attribute to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * setBirthDate method, used to set the birthDate property of an object
     *
     * @param birthDate is attribute to set
     */
    public void setBirthDate(short birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * setAddress method, used to set the address property of an object
     *
     * @param address is attribute to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * setPhone method, used to set the phone property of an object
     *
     * @param phone is attribute to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * setPsetEmailone method, used to set the email property of an object
     *
     * @param email is attribute to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * setCandidateType method, used to set the candidateType property of an
     * object
     *
     * @param candidateType is attribute to set
     */
    final public void setCandidateType(byte candidateType) {
        this.candidateType = candidateType;
    }

    /**
     * toString method, returns a string of object format information
     *
     * @return a format string information
     */
    @Override
    public String toString() {
        String typeString = (this.candidateType >= 0 
                && this.candidateType < this.typeStrings.length) 
                ? this.typeStrings[this.candidateType] : "Unknown";
        
        return String.format("|%-15s|%9s|%-20s|%10s|%-20s|%-15s|",
                 this.lastName + " " + this.firstName,
                 this.birthDate, this.address, this.phone, this.email, typeString);
    }
}
