import mysql.connector


class CustomerDbControl:
    def __init__(self, connection):
        self.connection = connection

    def add_customer_to_database(self, customer):
        sql = "INSERT INTO customer (fName, nickname, gender, phoneNumber, address, email, subscriptionType, ampere, " \
              "status, balance) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)"
        values = (
            customer.get_name(),
            customer.get_nickname(),
            customer.get_gender(),
            customer.get_phone_number(),
            customer.get_address(),
            customer.get_email(),
            customer.get_subscription_type(),
            customer.get_subscription_quantity(),
            customer.get_status(),
            customer.get_balance()
        )

        try:
            cursor = self.connection.cursor()
            cursor.execute(sql, values)
            self.connection.commit()
            print("Customer added successfully to the database!")
        except mysql.connector.Error as e:
            print("Error adding customer to the database:", e)
        finally:
            cursor.close()

    @staticmethod
    def display_table(data):
        num_columns = len(data)
        num_rows = (num_columns + 1) // 2

        for i in range(num_rows):
            row = data[i::num_rows]
            print("".join(f"{val:<20}" for val in row))

    def view_customers_from_database(self):
        sql = "SELECT idcustomer, fName, nickname, phoneNumber, subscriptionType, ampere, status, balance FROM customer"

        try:
            cursor = self.connection.cursor()
            cursor.execute(sql)
            result = cursor.fetchall()

            if not result:
                print("No customers found in the database.")
            else:
                print("Customers in the database:")
                headers = ["ID", "Name", "Phone Number", "Type", "Ampere", "Status", "Balance"]
                self.display_table(headers)

                for row in result:
                    customer_id, first_name, nickname, phone_number, subscription_type, ampere, status, balance = row
                    full_name = f"{first_name} {nickname}"
                    row_data = [
                        str(customer_id),
                        full_name,
                        phone_number,
                        subscription_type,
                        str(ampere),
                        status,
                        str(balance)
                    ]
                    self.display_table(row_data)
        except mysql.connector.Error as e:
            print("Error viewing customers from the database:", e)
        finally:
            cursor.close()

    def delete_customer_from_database(self, customer_id):
        sql = "DELETE FROM customer WHERE idcustomer = %s"
        try:
            cursor = self.connection.cursor()
            cursor.execute(sql, (customer_id,))
            self.connection.commit()
            if cursor.rowcount > 0:
                print(f"Customer with ID {customer_id} deleted successfully.")
            else:
                print(f"No customer found with ID {customer_id}. No deletion performed.")
        except mysql.connector.Error as e:
            print("Error deleting customer from the database:", e)
        finally:
            cursor.close()

    def update_customer_info(self, customer_id, column_name, new_value):
        sql = f"UPDATE customer SET {column_name} = %s WHERE idcustomer = %s"
        try:
            cursor = self.connection.cursor()
            cursor.execute(sql, (new_value, customer_id))
            self.connection.commit()
            if cursor.rowcount > 0:
                print(f"Customer with ID {customer_id} updated successfully.")
            else:
                print(f"No customer found with ID {customer_id}. No update performed.")
        except mysql.connector.Error as e:
            print("Error updating customer info:", e)
        finally:
            cursor.close()

    @staticmethod
    def display_column_table():
        column_names = [
            "Name", "Nickname", "Gender", "Phone Number",
            "Address", "Email", "Subscription Type",
            "Ampere", "Status", "Balance"
        ]

        print("Column Index | Column Name")
        print("-------------|-------------")
        for i, column_name in enumerate(column_names, start=1):
            print(f"{i:<12} | {column_name}")

    def get_user_input_and_update(self):
        self.display_column_table()

        customer_id = int(input("\nEnter customer ID: "))
        column_index = int(input("Enter column index to update: "))
        new_value = input("Enter new value: ")

        column_name = self.get_column_name(column_index)
        self.update_customer_info(customer_id, column_name, new_value)

    @staticmethod
    def get_column_name(index):
        column_names = [
            "fName", "nickname", "gender", "phoneNumber",
            "address", "email", "subscriptionType",
            "ampere", "status", "balance"
        ]
        if 0 < index <= len(column_names):
            return column_names[index - 1]
        return ""

