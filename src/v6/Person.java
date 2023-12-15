package v6;

public class Person {
    private static int nextId=1;
    final int id;
    private  String name;
    private  String nickname;
    private  String phoneNumber;
    private  String address;
    private String email;
    private String gender;

    public Person(String name,
      String nickname,
      String gender,
      String phoneNumber,
      String address,
      String email) {

        this.id=nextId++;
        this.name=name;
        this.address=address;
        this.nickname=nickname;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.gender=gender;

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

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
