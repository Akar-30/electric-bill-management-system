from models.person import Person


class Employee(Person):
    def __init__(self, name, nickname, gender, phone_number, address, email, salary, employee_type):
        super().__init__(name, nickname, gender, phone_number, address, email)
        self.salary = salary
        self.employeeType = employee_type

    # Getters and Setters for Employee properties
    def get_salary(self):
        return self.salary

    def set_salary(self, salary):
        self.salary = salary

    def get_employee_type(self):
        return self.employeeType

    # Override methods from the Person class
    def get_gender(self):
        return super().get_gender()

    def set_gender(self, gender):
        super().set_gender(gender)

    def get_id(self):
        return super().get_id()

    def get_address(self):
        return super().get_address()

    def get_email(self):
        return super().get_email()

    def get_name(self):
        return super().get_name()

    def get_nickname(self):
        return super().get_nickname()

    def get_phone_number(self):
        return super().get_phone_number()

    def set_address(self, address):
        super().set_address(address)

    def set_email(self, email):
        super().set_email(email)

    def set_name(self, name):
        super().set_name(name)

    def set_nickname(self, nickname):
        super().set_nickname(nickname)

    def set_phone_number(self, phone_number):
        super().set_phone_number(phone_number)
