from controllers.employee_db_control import EmployeeDbControl
from models.employee import Employee


class EmployeeScreen:
    def __init__(self, connection):
        self.connection = connection

    def handle_options(self):
        employee_choice = 0
        while employee_choice != 5:
            print("Employee Home")
            print("1. Add")
            print("2. View")
            print("3. Delete")
            print("4. Edit")
            print("5. Go back")
            employee_choice = int(input("Enter your choice: "))

            employee_db_control = EmployeeDbControl(self.connection)

            if employee_choice == 1:
                emp_name = input("Enter employee name: ")
                emp_nickname = input("Enter employee nickname: ")
                emp_gender = input("Enter employee gender: ")
                emp_phone_number = input("Enter employee phone number: ")
                emp_address = input("Enter employee address: ")
                emp_email = input("Enter employee email: ")
                emp_type = input("Enter employee type (Full-time, Part-time): ")
                emp_salary = float(input("Enter employee salary (in IQD): "))

                new_employee = Employee(emp_name, emp_nickname, emp_gender, emp_phone_number, emp_address, emp_email,
                                        emp_salary, emp_type)
                employee_db_control.add_employee_to_database(new_employee)
                print("Employee added successfully!")

            elif employee_choice == 2:
                employee_db_control.view_employees_from_database()

            elif employee_choice == 3:
                delete_id = int(input("Enter Employee ID to delete: "))
                employee_db_control.delete_employee_from_database(delete_id)

            elif employee_choice == 4:
                employee_db_control.get_user_input_and_update()

            elif employee_choice == 5:
                print("Going back to the main menu...")

            else:
                print("Invalid choice. Please enter a valid option.")
