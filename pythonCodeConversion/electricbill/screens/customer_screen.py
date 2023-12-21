from controllers.customer_db_control import CustomerDbControl
from models.customer import Customer


class CustomerScreen:
    def __init__(self, connection):
        self.connection = connection

    def handle_options(self):
        customer_choice = 0
        while customer_choice != 5:
            print("Customer Home")
            print("1. Add")
            print("2. View")
            print("3. Delete")
            print("4. Edit")
            print("5. Go back")
            customer_choice = int(input("Enter your choice: "))

            customer_db_control = CustomerDbControl(self.connection)

            if customer_choice == 1:
                customer_name = input("Enter customer name: ")
                customer_nickname = input("Enter customer nickname: ")
                customer_gender = input("Enter customer gender: ")
                customer_phone_number = input("Enter customer phone number: ")
                customer_address = input("Enter customer address: ")
                customer_email = input("Enter customer email: ")
                customer_sub_type = input("Enter customer subscription type (1. 24 hour, 2. only day): ")
                customer_sub_quantity = int(input("Enter customer Ampere number (in Number): "))
                new_customer = Customer(customer_name, customer_nickname, customer_gender, customer_phone_number,
                                        customer_address, customer_email, customer_sub_type, customer_sub_quantity, 0)
                customer_db_control.add_customer_to_database(new_customer)
                print("Customer added successfully!")

            elif customer_choice == 2:
                customer_db_control.view_customers_from_database()

            elif customer_choice == 3:
                delete_id = int(input("Enter customer ID to delete: "))
                customer_db_control.delete_customer_from_database(delete_id)

            elif customer_choice == 4:
                customer_db_control.get_user_input_and_update()

            elif customer_choice == 5:
                print("Going back to the main menu...")

            else:
                print("Invalid choice. Please enter a valid option.")
