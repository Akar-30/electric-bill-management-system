package v2;

import java.util.UUID;

public class Person {

    UUID uniqueId = UUID.randomUUID();

    private final String id=uniqueId.toString();
    private  String name;
    private  String nickname;
    private  String phoneNumber;
    private  String address;
    private String email;



}

