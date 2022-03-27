package beans;

public class User {
    private int userID;
    private String firstName;
    private String surname;
    private String email;
    private int phoneNo;
    private String gender;
    private String address;
    private String password;
    private String profilePhoto;
    
    public User(int userID, String firstName, String surname, String email, int phoneNo, String gender, String address, String password, String profilePhoto){
        this.userID = userID;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.address = address;
        this.password = password;
        this.profilePhoto = profilePhoto;
    }
    
    public User(String firstName, String surname, String email, int phoneNo, String gender, String address, String password, String profilePhoto){
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.address = address;
        this.password = password;
        this.profilePhoto = profilePhoto;
    }

    public User() {

    }

    public User(int userID, String firstName, String surname, String email, int phoneNo, String gender, String address, String profilePhoto) {
        this.userID = userID;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.address = address;
        this.profilePhoto = profilePhoto;
    }
    
    

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }  
}
