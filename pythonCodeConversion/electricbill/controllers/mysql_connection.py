import mysql.connector


class MySQLConnector:
    def __init__(self):
        try:
            self.connection = mysql.connector.connect(
                host='localhost',
                user='root',
                password='1234',
                database='oop'
            )
            if self.connection.is_connected():
                print("Connected to the database!")
        except mysql.connector.Error as e:
            print("Error connecting to MySQL database:", e)

    def get_connection(self):
        return self.connection

    def close_connection(self):
        if self.connection.is_connected():
            self.connection.close()
            print("Connection closed.")
