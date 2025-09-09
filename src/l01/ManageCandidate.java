/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package l01;

import java.util.ArrayList;
import java.util.HashMap;
import ThinhLib.MyLib;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * L01 - Create a Java console program to manage Candidates of company.
 *
 * @author ThinhNDCE190865
 */
public class ManageCandidate {

    private final HashMap<Byte, ArrayList<Candidate>> candidateMap;
    // Use HashSet to store ids already in the database, for O(1) access
    private final HashSet<String> candidateIds = new HashSet<>();

    private final byte MIN_AGE_OF_EXPERIENCE = 23;
    private final byte MIN_AGE_OF_FRESHER = 22;
    private final byte MIN_AGE_OF_INTERN = 18;

    /**
     * Constructor, initialize the database of 3 candidateTypes of candidate
     */
    public ManageCandidate() {
        candidateMap = new HashMap<>();
        candidateMap.put((byte) 0, new ArrayList<>());
        candidateMap.put((byte) 1, new ArrayList<>());
        candidateMap.put((byte) 2, new ArrayList<>());
    }

    /**
     * isValidAge method, check if the year of birth is valid
     *
     * @param birthDate is the year of birth to check
     * @param candidateType is the type of candidate to check
     *
     * @return true if valid, false if not valid
     */
    public boolean isValidAge(short birthDate, byte candidateType) {
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - birthDate;

        if (birthDate < 1900 || birthDate > currentYear) {
            return false;
        }

        int minAge;
        switch (candidateType) {
            case 0:
                minAge = MIN_AGE_OF_EXPERIENCE;
                break;
            case 1:
                minAge = MIN_AGE_OF_FRESHER;
                break;
            case 2:
                minAge = MIN_AGE_OF_INTERN;
                break;
            default:
                throw new IllegalArgumentException("Invalid candidate type.");
        }

        return age >= minAge;
    }

    /**
     * inputCandidateDetails method, used for entering data and returning the
     * candidate object
     *
     * @param candidateType is the candidateType of candidate
     * @param checkFunc is a parameter that checks which method is in use
     * @return a candidate object after input
     * @throws java.lang.Exception
     */
    public Candidate inputCandidateDetails(byte candidateType, String checkFunc) throws Exception {
        if (checkFunc.equalsIgnoreCase("update") && candidateMap.get(candidateType).isEmpty()) {
            throw new Exception("Database of candidateType is empty so this function cannot be used");
        }

        System.out.println();

        /*
        Check each entered information and re-enter it 
        if it does not meet the format of the information
         */
        String candidateId;
        do {
            System.out.print("Enter Candidate ID: ");
            candidateId = MyLib.sc.nextLine().trim();
            if (candidateId == null || candidateId.isEmpty()) {
                System.out.println("Id cannot be empty. Please enter again");
                candidateId = null;
            } else {
                if (checkFunc.equalsIgnoreCase("add")) {
                    if (candidateIds.contains(candidateId)) {
                        System.out.println("Id is duplicated. Please enter again.");
                        candidateId = null;
                    }
                } else if (checkFunc.equalsIgnoreCase("update")) {
                    if (!candidateIds.contains(candidateId)) {
                        System.out.println("Id does not exist. Please enter again.");
                        candidateId = null;
                    }
                } else {
                    System.exit(190865);
                }
            }
        } while (candidateId == null);

        String firstName;
        do {
            System.out.print("Enter First Name: ");
            firstName = MyLib.sc.nextLine().trim();
            if (checkFunc.equalsIgnoreCase("add")) {
                if (!firstName.matches("^[a-zA-Z ]+$")) {
                    System.out.println("Invalid input. Please enter a valid first name without numbers or special characters.");
                    firstName = null;
                }
            } else if (checkFunc.equalsIgnoreCase("update")) {
                if (!firstName.isEmpty() && !firstName.matches("^[a-zA-Z ]+$")) {
                    System.out.println("Invalid input. Please enter a valid first name without numbers or special characters.");
                    firstName = null;
                }
            } else {
                System.exit(190865);
            }
        } while (firstName == null);

        String lastName;
        do {
            System.out.print("Enter Last Name: ");
            lastName = MyLib.sc.nextLine().trim();
            if (checkFunc.equalsIgnoreCase("add")) {
                if (!lastName.matches("^[a-zA-Z ]+$")) {
                    System.out.println("Invalid input. Please enter a valid last name without numbers or special characters.");
                    lastName = null;
                }
            } else if (checkFunc.equalsIgnoreCase("update")) {
                if (!lastName.isEmpty() && !lastName.matches("^[a-zA-Z ]+$")) {
                    System.out.println("Invalid input. Please enter a valid last name without numbers or special characters.");
                    lastName = null;
                }
            } else {
                System.exit(190865);
            }
        } while (lastName == null);

        short birthDate = -1;
        String inputBirthDate;
        do {
            System.out.print("Enter Year Of Birth (1900-" + LocalDate.now().getYear() + "): ");
            inputBirthDate = MyLib.sc.nextLine().trim();
            if (checkFunc.equalsIgnoreCase("add")) {
                try {
                    birthDate = Short.parseShort(inputBirthDate);
                    if (!this.isValidAge(birthDate, candidateType)) {
                        System.out.println("Invalid age. Please fill in the age suitable for candidate type");
                        inputBirthDate = null;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number");
                    inputBirthDate = null;
                }
            } else if (checkFunc.equalsIgnoreCase("update")) {
                try {
                    if (!inputBirthDate.isEmpty()) {
                        birthDate = Short.parseShort(inputBirthDate);
                        if (!this.isValidAge(birthDate, candidateType)) {
                            System.out.println("Invalid age. Please fill in the age suitable for candidate type");
                            inputBirthDate = null;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number");
                    inputBirthDate = null;
                }
            } else {
                System.exit(190865);
            }
        } while (inputBirthDate == null);

        String address;
        do {
            System.out.print("Enter Address: ");
            address = MyLib.sc.nextLine().trim();
            if (checkFunc.equalsIgnoreCase("add")) {
                if (!address.matches("^(?!\\d+$)([\\p{L}0-9]|[\\p{L}0-9]"
                        + "[\\p{L}0-9\\/\\-\\,\\.\\s]*[\\p{L}0-9])$")) {
                    System.out.println("Invalid input, Please enter a valid address without special characters.");
                    address = null;
                }
            } else if (checkFunc.equalsIgnoreCase("update")) {
                if (!address.isEmpty() && !address.matches("^(?!\\d+$)([\\p{L}0-9]|[\\p{L}0-9]"
                        + "[\\p{L}0-9\\/\\-\\,\\.\\s]*[\\p{L}0-9])$")) {
                    System.out.println("Invalid input, Please enter a valid address without special characters.");
                    address = null;
                }
            } else {
                System.exit(190865);
            }
        } while (address == null);

        String phone;
        do {
            System.out.print("Enter Phone: ");
            phone = MyLib.sc.nextLine().trim();
            if (checkFunc.equalsIgnoreCase("add")) {
                if (!phone.matches("^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|"
                        + "(7[06-9])|(8[1-689])|(9[0-46-9]))"
                        + "(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$")) {
                    System.out.println("Invalid input, Please enter a valid phone");
                    phone = null;
                }
            } else if (checkFunc.equalsIgnoreCase("update")) {
                if (!phone.isEmpty() && !phone.matches("^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|"
                        + "(7[06-9])|(8[1-689])|(9[0-46-9]))"
                        + "(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$")) {
                    System.out.println("Invalid input, Please enter a valid phone");
                    phone = null;
                }
            } else {
                System.exit(190865);
            }
        } while (phone == null);

        String email;
        do {
            System.out.print("Enter Email: ");
            email = MyLib.sc.nextLine().trim();
            if (checkFunc.equalsIgnoreCase("add")) {
                if (!MyLib.isValidEmailAddress(email)) {
                    System.out.println("Invalid input, Please enter a valid email");
                    email = null;
                }
            } else if (checkFunc.equalsIgnoreCase("update")) {
                if (!email.isEmpty() && !MyLib.isValidEmailAddress(email)) {
                    System.out.println("Invalid input, Please enter a valid email");
                    email = null;
                }
            } else {
                System.exit(190865);
            }
        } while (email == null);

        /*
        Check which sub-object it belongs to and continue entering and 
        checking the individual properties of that sub-object
         */
        Candidate existingCandidate = null;
        if (checkFunc.equalsIgnoreCase("update")) {
            final String candidateIdToCheck = candidateId;
            existingCandidate = candidateMap.get(candidateType).stream()
                    .filter(c -> c.getCandidateId().equals(candidateIdToCheck))
                    .findFirst().get();
        }
        int currentYear = LocalDate.now().getYear();
        switch (candidateType) {
            case 0:
                byte expInYear = -1;
                String inputExp;
                do {
                    System.out.print("Enter Years of Experience: ");
                    inputExp = MyLib.sc.nextLine().trim();
                    if (checkFunc.equalsIgnoreCase("add")) {
                        try {
                            expInYear = Byte.parseByte(inputExp);
                            if (expInYear > (currentYear - birthDate) - MIN_AGE_OF_FRESHER) {
                                System.out.println("You must be at least 22 years old to start having experience");
                                inputExp = null;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number between 0 and 100.");
                            inputExp = null;
                        }
                    } else if (checkFunc.equalsIgnoreCase("update")) {
                        try {
                            if (!inputExp.isEmpty()) {
                                expInYear = Byte.parseByte(inputExp);
                                if (existingCandidate != null) {
                                    if (expInYear > (currentYear - existingCandidate.getBirthDate()) - MIN_AGE_OF_FRESHER) {
                                        System.out.println("You must be at least 22 years old to start having experience");
                                        inputExp = null;
                                    }
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number between 0 and 100.");
                            inputExp = null;
                        }
                    } else {
                        System.exit(190865);
                    }
                } while (inputExp == null);

                String proSkill;
                do {
                    System.out.print("Enter Professional Skill: ");
                    proSkill = MyLib.sc.nextLine().trim();
                    if (checkFunc.equalsIgnoreCase("add")) {
                        if (!proSkill.matches("^(?!\\p{N}+$)[ \\p{L}\\p{N}#.-]{2,50}$")) {
                            System.out.println("Invalid input. Please enter a valid professional skill without starting with numbers.");
                            proSkill = null;
                        }
                    } else if (checkFunc.equalsIgnoreCase("update")) {
                        if (!proSkill.isEmpty() && !proSkill.matches("^(?!\\p{N}+$)[ \\p{L}\\p{N}#.-]{2,50}$")) {
                            System.out.println("Invalid input. Please enter a valid professional skill without starting with numbers.");
                            proSkill = null;
                        }
                    } else {
                        System.exit(190865);
                    }
                } while (proSkill == null);

                return new Experience.Builder()
                        .expInYear(expInYear)
                        .proSkill(proSkill)
                        .address(address)
                        .birthDate(birthDate)
                        .candidateId(candidateId)
                        .candidateType(candidateType)
                        .email(email)
                        .firstName(firstName)
                        .lastName(lastName)
                        .phone(phone)
                        .build();

            case 1:
                LocalDate graduationDate = null;
                String inputDate;
                do {
                    System.out.print("Enter Graduation Date (YYYY-MM-DD): ");
                    inputDate = MyLib.sc.nextLine().trim();
                    if (checkFunc.equalsIgnoreCase("add")) {
                        try {
                            graduationDate = LocalDate.parse(inputDate);
                            int graduationYear = graduationDate.getYear();
                            if (graduationYear < birthDate + MIN_AGE_OF_FRESHER) {
                                System.out.println("You must be at least 22 years old to graduate");
                                inputDate = null;
                            } else if (graduationYear > currentYear) {
                                System.out.println("Invalid graduated time. Currently it is " + currentYear);
                                inputDate = null;
                            }
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                            inputDate = null;
                        }
                    } else if (checkFunc.equalsIgnoreCase("update")) {
                        if (!inputDate.isEmpty()) {
                            try {
                                graduationDate = LocalDate.parse(inputDate);
                                if (graduationDate != null) {
                                    int graduationYear = graduationDate.getYear();
                                    if (existingCandidate != null) {
                                        if (graduationYear < existingCandidate.getBirthDate() + MIN_AGE_OF_FRESHER) {
                                            System.out.println("You must be at least 22 years old to graduate");
                                            inputDate = null;
                                        } else if (graduationYear > currentYear) {
                                            System.out.println("Invalid graduated time. Currently it is " + currentYear);
                                            inputDate = null;
                                        }

                                        ((Fresher) existingCandidate).setGraduationDate(graduationDate);
                                    }
                                }
                            } catch (DateTimeParseException e) {
                                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                                inputDate = null;
                            }
                        }
                    } else {
                        System.exit(190865);
                    }
                } while (inputDate == null);

                System.out.println("Select Graduation Rank:");
                for (Fresher.GraduationRank rank : Fresher.GraduationRank.values()) {
                    System.out.println(rank.ordinal() + 1 + ". " + rank);
                }

                Fresher.GraduationRank graduationRank = null;
                String inputRank;
                do {
                    System.out.print("Enter Graduation Rank (1-4): ");
                    inputRank = MyLib.sc.nextLine().trim();
                    if (checkFunc.equalsIgnoreCase("add")) {
                        try {
                            int rankValue = Integer.parseInt(inputRank);
                            if (rankValue >= 1 && rankValue <= 4) {
                                graduationRank = Fresher.GraduationRank.values()[rankValue - 1];
                            } else {
                                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                                inputRank = null;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number");
                            inputRank = null;
                        }
                    } else if (checkFunc.equalsIgnoreCase("update")) {
                        try {
                            if (!inputRank.isEmpty()) {
                                int rankValue = Integer.parseInt(inputRank);
                                if (rankValue >= 1 && rankValue <= 4) {
                                    graduationRank = Fresher.GraduationRank.values()[rankValue - 1];
                                } else {
                                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                                    inputRank = null;
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number");
                            inputRank = null;
                        }
                    } else {
                        System.exit(190865);
                    }
                } while (inputRank == null);

                String education;
                do {
                    System.out.print("Enter Education: ");
                    education = MyLib.sc.nextLine().trim();
                    if (checkFunc.equalsIgnoreCase("add")) {
                        if (!education.matches("^[a-zA-Z ]+$")) {
                            System.out.println("Invalid input, Please enter a valid education");
                            education = null;
                        }
                    } else if (checkFunc.equalsIgnoreCase("update")) {
                        if (!education.isEmpty() && !education.matches("^[a-zA-Z ]+$")) {
                            System.out.println("Invalid input, Please enter a valid education");
                            education = null;
                        }
                    } else {
                        System.exit(190865);
                    }
                } while (education == null);

                return new Fresher.Builder()
                        .education(education)
                        .graduationDate(graduationDate)
                        .graduationRank(graduationRank)
                        .address(address)
                        .birthDate(birthDate)
                        .candidateId(candidateId)
                        .candidateType(candidateType)
                        .email(email)
                        .firstName(firstName)
                        .lastName(lastName)
                        .phone(phone)
                        .build();

            case 2:
                String majors;
                do {
                    System.out.print("Enter Majors: ");
                    majors = MyLib.sc.nextLine().trim();
                    if (checkFunc.equalsIgnoreCase("add")) {
                        if (!majors.matches("^[a-zA-Z ]+$")) {
                            System.out.println("Invalid input, Please enter a valid major");
                            majors = null;
                        }
                    } else if (checkFunc.equalsIgnoreCase("update")) {
                        if (!majors.isEmpty() && !majors.matches("^[a-zA-Z ]+$")) {
                            System.out.println("Invalid input, Please enter a valid major");
                            majors = null;
                        }
                    } else {
                        System.exit(190865);
                    }
                } while (majors == null);

                byte semester = -1;
                String inputSemester;
                do {
                    System.out.print("Enter Semester: ");
                    inputSemester = MyLib.sc.nextLine().trim();
                    if (checkFunc.equalsIgnoreCase("add")) {
                        try {
                            semester = Byte.parseByte(inputSemester);
                            if (semester < 0 || semester > 100) {
                                System.out.println("Invalid input. Please enter a number between 0 and 100.");
                                inputSemester = null;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number");
                        }
                    } else if (checkFunc.equalsIgnoreCase("update")) {
                        try {
                            if (!inputSemester.isEmpty()) {
                                semester = Byte.parseByte(inputSemester);
                                if (semester < 0 || semester > 100) {
                                    System.out.println("Invalid input. Please enter a number between 0 and 100.");
                                    inputSemester = null;
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number");
                        }
                    } else {
                        System.exit(190865);
                    }
                } while (inputSemester == null);

                String universityName;
                do {
                    System.out.print("Enter University Name: ");
                    universityName = MyLib.sc.nextLine().trim();
                    if (checkFunc.equalsIgnoreCase("add")) {
                        if (!universityName.matches("^[a-zA-Z0-9 ]+$")) {
                            System.out.println("Invalid input, Please enter a valid university name");
                            universityName = null;
                        }
                    } else if (checkFunc.equalsIgnoreCase("update")) {
                        if (!universityName.isEmpty() && !universityName.matches("^[a-zA-Z0-9 ]+$")) {
                            System.out.println("Invalid input, Please enter a valid university name");
                            universityName = null;
                        }
                    } else {
                        System.exit(190865);
                    }
                } while (universityName == null);

                return new Intern.Builder()
                        .majors(majors)
                        .semester(semester)
                        .universityName(universityName)
                        .address(address)
                        .birthDate(birthDate)
                        .candidateId(candidateId)
                        .candidateType(candidateType)
                        .email(email)
                        .firstName(firstName)
                        .lastName(lastName)
                        .phone(phone)
                        .build();

            default:
                throw new IllegalArgumentException("Invalid candidate candidateType.");
        }
    }

    /**
     * checkDatabaseOfCandidate method, check if the database is null
     *
     * @throws Exception with error message
     */
    public void checkDatabaseOfCandidate() throws Exception {
        if (this.candidateMap == null) {
            throw new Exception("Database does not exist");
        }
    }

    /**
     * addCandidate method, used to add candidate objects to the database
     *
     * @param candidateType is the candidateType of the candidate object
     * @return true if the add is successful
     * @throws Exception with error message
     */
    public boolean addCandidate(byte candidateType) throws Exception {
        this.checkDatabaseOfCandidate();

        Candidate candidate = this.inputCandidateDetails(candidateType, "add");

        candidateMap.get(candidateType).add(candidate);
        candidateIds.add(candidate.getCandidateId());
        return true;
    }

    /**
     * updateCandidate method, used to update candidate objects in the database
     *
     * @param candidateType is the candidateType of the candidate object
     * @return true if the add is successful
     * @throws Exception with error message
     */
    public boolean updateCandidate(byte candidateType) throws Exception {
        this.checkDatabaseOfCandidate();

        Candidate candidate = this.inputCandidateDetails(candidateType, "update");

        final String candidateIdToCheck = candidate.getCandidateId();

        /*
                Get an existing object in the database, 
                check if the data the user enters is not empty, 
                then update that candidate object.
         */
        Candidate existingCandidate = candidateMap.get(candidateType).stream()
                .filter(c -> c.getCandidateId().equals(candidateIdToCheck))
                .findFirst().get();

        if (!candidate.getAddress().isEmpty()) {
            existingCandidate.setAddress(candidate.getAddress());
        }

        if (candidate.getBirthDate() != -1) {
            existingCandidate.setBirthDate(candidate.getBirthDate());
        }

        if (!candidate.getEmail().isEmpty()) {
            existingCandidate.setEmail(candidate.getEmail());
        }

        if (!candidate.getFirstName().isEmpty()) {
            existingCandidate.setFirstName(candidate.getFirstName());
        }

        if (!candidate.getLastName().isEmpty()) {
            existingCandidate.setLastName(candidate.getLastName());
        }

        if (!candidate.getPhone().isEmpty()) {
            existingCandidate.setPhone(candidate.getPhone());
        }

        /*
                Check the individual properties of each candidateType of candidate object
         */
        switch (candidate) {
            case Experience exp -> {
                if (exp.getExpInYear() != -1) {
                    ((Experience) existingCandidate).setExpInYear(exp.getExpInYear());
                }

                if (!exp.getProSkill().isEmpty()) {
                    ((Experience) existingCandidate).setProSkill(exp.getProSkill());
                }
            }
            case Fresher fresher -> {
                if (fresher.getGraduationDate() != null) {
                    ((Fresher) existingCandidate).setGraduationDate(fresher.getGraduationDate());
                }

                if (fresher.getGraduationRank() != null) {
                    ((Fresher) existingCandidate).setGraduationRank(fresher.getGraduationRank());
                }

                if (!fresher.getEducation().isEmpty()) {
                    ((Fresher) existingCandidate).setEducation(fresher.getEducation());
                }
            }
            case Intern intern -> {
                if (!intern.getMajors().isEmpty()) {
                    ((Intern) existingCandidate).setMajors(intern.getMajors());
                }

                if (intern.getSemester() != -1) {
                    ((Intern) existingCandidate).setSemester(intern.getSemester());
                }

                if (!intern.getUniversityName().isEmpty()) {
                    ((Intern) existingCandidate).setUniversityName(intern.getUniversityName());
                }
            }
            default -> {
            }
        }

        return true;
    }

    /**
     * deleteCandidate method, used to delete candidate objects in the database
     *
     * @param candidateType is the candidateType of the candidate object
     * @return true if the add is successful
     * @throws Exception with error message
     */
    public boolean deleteCandidate(byte candidateType) throws Exception {
        this.checkDatabaseOfCandidate();
        if (candidateMap.get(candidateType).isEmpty()) {
            throw new Exception("Database of candidateType is empty so this function cannot be used");
        }

        System.out.println();
        System.out.print("Enter candidate id: ");
        String candidateId = MyLib.sc.nextLine().trim();

        if (!candidateIds.contains(candidateId)) {
            throw new IllegalArgumentException("Id does not exist. Please enter again.");
        }

        candidateMap.get(candidateType).removeIf(candidate -> candidate.getCandidateId().equals(candidateId));
        return true;
    }

    /**
     * searchCandidate method, used to print a table of candidate candidateTypes
     * and search for objects
     *
     * @throws Exception with error message
     */
    public void searchCandidate() throws Exception {
        this.checkDatabaseOfCandidate();
        System.out.println();

        System.out.println("List of candidate:");

        System.out.println("===========EXPERIENCE CANDIDATE===========");
        candidateMap.get((byte) 0)
                .forEach(candidate
                        -> System.out.println(candidate.getLastName() + " " + candidate.getFirstName()));

        System.out.println("===========FRESHER CANDIDATE===========");
        candidateMap.get((byte) 1)
                .forEach(candidate
                        -> System.out.println(candidate.getLastName() + " " + candidate.getFirstName()));

        System.out.println("===========INTERN CANDIDATE===========");
        candidateMap.get((byte) 2)
                .forEach(candidate
                        -> System.out.println(candidate.getLastName() + " " + candidate.getFirstName()));

        System.out.println();

        String[] inputForSearch = new String[1];
        do {
            System.out.print("Input Candidate name (First name or Last name): ");
            inputForSearch[0] = MyLib.sc.nextLine().trim().toLowerCase();
            if (inputForSearch[0].isEmpty()) {
                System.out.println("Invalid. Input cannot be empty. Please re-enter your information");
            } else if (!inputForSearch[0].matches("^[a-zA-Z ]+$")) {
                System.out.println("Invalid input. Please enter a valid name without numbers or special characters.");
            }
        } while (inputForSearch[0].isEmpty() || !inputForSearch[0].matches("^[a-zA-Z ]+$"));

        byte candidateType;
        do {
            candidateType = MyLib.getPositiveByteContain0("Input candidateType of candidate: ");
            if (candidateType > 2) {
                System.out.println("Type of candidate is not valid. Please enter candidateType from 0-2");
            }
        } while (candidateType > 2);

        System.out.println();

        if (candidateMap.get(candidateType).isEmpty()) {
            throw new Exception("Database of candidateType is empty so this function cannot be used");
        }

        /*
        Print out the list of candidates found based on the information entered by the user
         */
        System.out.println("The candidates found:");
        System.out.println("+-----+---------------+---------+--------------------+----------+--------------------+---------------+");
        System.out.printf("|%-5s|%-15s|%-9s|%-20s|%-10s|%-20s|%-15s|\n",
                "No.", "Fullname", "Birthdate", "Address", "Phone", "Email", "Type");
        System.out.println("+-----+---------------+---------+--------------------+----------+--------------------+---------------+");

        AtomicInteger numberOrder = new AtomicInteger(1);
        candidateMap.get(candidateType).stream()
                .filter(candidate -> candidate.getFirstName().toLowerCase().contains(inputForSearch[0])
                || candidate.getLastName().toLowerCase().contains(inputForSearch[0]))
                .forEach(candidate -> System.out.printf("|%5s%s\n", numberOrder.getAndIncrement(), candidate));

        System.out.println("+-----+---------------+---------+--------------------+----------+--------------------+---------------+");
    }

    /**
     * manageCandidates method, the menu manages adding, updating and deleting
     * candidate objects by candidateType
     *
     * @param candidateType is the candidateType of the candidate object
     */
    public void manageCandidates(byte candidateType) {
        byte subChoice = -1;

        do {
            try {
                System.out.println();
                System.out.println("1. Add Candidate");
                System.out.println("2. Update Candidate");
                System.out.println("3. Delete Candidate");
                System.out.println("4. Back to Main Menu");

                do {
                    subChoice = MyLib.getPositiveByte("Please choose: ");
                    if (subChoice > 4) {
                        System.out.println("Invalid choose. Please enter again the number between 1 and 4");
                    }
                } while (subChoice > 4);

                switch (subChoice) {
                    case 1:
                        if (this.addCandidate(candidateType)) {
                            System.out.println("Add successfully");
                        }
                        break;
                    case 2:
                        if (this.updateCandidate(candidateType)) {
                            System.out.println("Update successfully");
                        }
                        break;
                    case 3:
                        if (this.deleteCandidate(candidateType)) {
                            System.out.println("Delete successfully");
                        }
                        break;
                    case 4:
                        System.out.println("Returning to main menu...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (subChoice != 4);
    }
}
