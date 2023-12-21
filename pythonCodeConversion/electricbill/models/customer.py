import random

from models.person import Person


class Customer(Person):
    def __init__(self, name, nickname, gender, phone_number, address, email, subscription_type, ampere, balance):
        super().__init__(name, nickname, gender, phone_number, address, email)
        self.subscriptionQuantity = ampere
        self.subscriptionType = subscription_type
        self.balance = balance
        random_boolean = random.choice([True, False])
        self.status = "Payed" if random_boolean else "Not Payed"

    def get_balance(self):
        return self.balance

    def get_subscription_type(self):
        return self.subscriptionType

    def get_status(self):
        return self.status

    def get_subscription_quantity(self):
        return self.subscriptionQuantity

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
