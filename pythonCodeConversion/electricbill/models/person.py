class Person:
    nextId = 1

    def __init__(self, name, nickname, gender, phone_number, address, email):
        self.id = Person.nextId
        Person.nextId += 1
        self.name = name
        self.address = address
        self.nickname = nickname
        self.phoneNumber = phone_number
        self.email = email
        self.gender = gender

    def get_gender(self):
        return self.gender

    def set_gender(self, gender):
        self.gender = gender

    def get_address(self):
        return self.address

    def get_name(self):
        return self.name

    def get_phone_number(self):
        return self.phoneNumber

    def get_id(self):
        return self.id

    def get_email(self):
        return self.email

    def get_nickname(self):
        return self.nickname

    def set_address(self, address):
        self.address = address

    def set_name(self, name):
        self.name = name

    def set_phone_number(self, phone_number):
        self.phoneNumber = phone_number

    def set_email(self, email):
        self.email = email

    def set_nickname(self, nickname):
        self.nickname = nickname
