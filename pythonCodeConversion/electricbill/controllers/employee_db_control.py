import mysql.connector


class EmployeeDbControl:
    def __init__(self, connection):
        self.connection = connection

    def add_employee_to_database(self, employee):
        sql = "INSERT INTO employee (fName, nickname, gender, phoneNumber, address, email, type, salary) VALUES (%s, " \
              "%s, %s, %s, %s, %s, %s, %s)"

        try:
            cursor = self.connection.cursor()
            cursor.execute(sql, (employee.get_name(), employee.get_nickname(), employee.get_gender(),
                                 employee.get_phone_number(), employee.get_address(), employee.get_email(),
                                 employee.get_employee_type(), employee.get_salary()))
            self.connection.commit()
            print("Employee added successfully to the database!")
        except mysql.connector.Error as e:
            print("Error adding employee to the database:", e)
        finally:
            cursor.close()

    @staticmethod
    def display_table(data):
        num_columns = len(data)
        num_rows = (num_columns + 1) // 2

        for i in range(num_rows):
            for j in range(2):
                index = i + j * num_rows
                if index < num_columns:
                    print(f"{data[index]:<20}", end="")
            print()

    def view_employees_from_database(self):
        sql = "SELECT idEmployee, fName, nickname, phoneNumber, type, salary FROM employee"

        try:
            cursor = self.connection.cursor()
            cursor.execute(sql)
            result = cursor.fetchall()

            if not result:
                print("No Employees found in the database.")
            else:
                print("Employees in the database:")
                headers = ["ID", "Name", "Phone Number", "Employee Type", "Salary"]
                self.display_table(headers)

                for row in result:
                    employee_id, first_name, last_name, phone_number, employee_type, salary = row
                    display_name = f"{first_name} {last_name}"

                    row_data = [str(employee_id), display_name, phone_number, employee_type, str(salary)]
                    self.display_table(row_data)
        except mysql.connector.Error as e:
            print("Error viewing employees from the database:", e)
        finally:
            cursor.close()

    def delete_employee_from_database(self, employee_id):
        sql = "DELETE FROM employee WHERE idEmployee = %s"

        try:
            cursor = self.connection.cursor()
            cursor.execute(sql, (employee_id,))
            self.connection.commit()
            if cursor.rowcount > 0:
                print(f"Employee with ID {employee_id} deleted successfully.")
            else:
                print(f"No Employee found with ID {employee_id}. No deletion performed.")
        except mysql.connector.Error as e:
            print("Error deleting employee from the database:", e)
        finally:
            cursor.close()

    def update_employee_info(self, employee_id, column_name, new_value):
        sql = f"UPDATE employee SET {column_name} = %s WHERE idEmployee = %s"

        try:
            cursor = self.connection.cursor()
            cursor.execute(sql, (new_value, employee_id))
            self.connection.commit()
            if cursor.rowcount > 0:
                print(f"Employee with ID {employee_id} updated successfully.")
            else:
                print(f"No Employee found with ID {employee_id}. No update performed.")
        except mysql.connector.Error as e:
            print("Error updating employee info:", e)
        finally:
            cursor.close()

    @staticmethod
    def display_column_table():
        column_names = [
            "Name", "Nickname", "Gender", "Phone Number",
            "Address", "Email", "Employee Type",
            "Salary"
        ]

        print("Column Index | Column Name")
        print("-------------|-------------")
        for i, column_name in enumerate(column_names, start=1):
            print(f"{i:<12} | {column_name}")

    def get_user_input_and_update(self):
        self.display_column_table()

        employee_id = int(input("\nEnter Employee ID: "))
        column_index = int(input("Enter column index to update: "))
        new_value = input("Enter new value: ")

        column_name = self.get_column_name(column_index)
        self.update_employee_info(employee_id, column_name, new_value)

    @staticmethod
    def get_column_name(index):
        column_names = [
            "fName", "nickname", "gender", "phoneNumber",
            "address", "email", "type",
            "salary"
        ]
        if 0 < index <= len(column_names):
            return column_names[index - 1]
        return ""
