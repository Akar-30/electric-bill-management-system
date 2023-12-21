from controllers.mysql_connection import MySQLConnector
from screens.customer_screen import CustomerScreen
from screens.employee_screen import EmployeeScreen
from screens.report_screen import Report


class MainScreen:
    def mainScreen(self):
        db_connection = None
        try:
            connector = MySQLConnector()
            db_connection = connector.get_connection()

            customer_control = CustomerScreen(db_connection)
            employee_control = EmployeeScreen(db_connection)
            report = Report(db_connection)

            choice = None
            while choice != 4:
                print("WELCOME TO MAIN SCREEN")
                print("1. Employee Screen")
                print("2. Customer Screen")
                print("3. Reports")
                print("4. Quit")
                choice = int(input("Enter your choice: "))

                if choice == 1:
                    employee_control.handle_options()
                elif choice == 2:
                    customer_control.handle_options()
                elif choice == 3:
                    report.generate_report()
                elif choice == 4:
                    print("Exiting MAIN SCREEN. Goodbye!")
                else:
                    print("Invalid choice. Please enter a valid option.")

            connector.close_connection()
        finally:
            if db_connection is not None:
                try:
                    db_connection.close()
                except Exception as e:
                    print(e)
