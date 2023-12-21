import decimal


class Report:
    def __init__(self, connection):
        self.connection = connection

    def generate_report(self):
        self.show_customer_report()
        self.show_employee_report()
        self.show_financial_report()

    def show_customer_report(self):
        total_customers = 0
        total_ampere = 0
        total_day_only = 0
        total_day_ampere = 0
        total_revenue = 0

        sql = "SELECT COUNT(*) AS total_customers, SUM(ampere) AS total_ampere, " \
              "SUM(CASE WHEN subscriptionType = 'Day-only' THEN 1 ELSE 0 END) AS total_day_only, " \
              "SUM(CASE WHEN subscriptionType = 'Day-only' THEN ampere ELSE 0 END) AS total_day_ampere, " \
              "SUM(CASE WHEN subscriptionType = '24-Hours' THEN 1 ELSE 0 END) AS total_24_hour, " \
              "SUM(CASE WHEN subscriptionType = '24-Hours' THEN ampere ELSE 0 END) AS total_24_hour_ampere, " \
              "SUM(CASE WHEN subscriptionType = '24-Hours' THEN ampere*10000 ELSE ampere*5000 END) AS total_revenue " \
              "FROM customer"

        try:
            with self.connection.cursor(dictionary=True) as cursor:
                cursor.execute(sql)
                result = cursor.fetchone()
                if result:
                    total_customers = result['total_customers']
                    total_ampere = result['total_ampere']
                    total_day_only = result['total_day_only']
                    total_day_ampere = result['total_day_ampere']
                    total_revenue = result['total_revenue']

            print("Customer Report:")
            print("Total Customers:", total_customers)
            print("Total Ampere:", total_ampere)
            print("Total Day Only:", total_day_only)
            print("Total Day Only Ampere:", total_day_ampere)
            print("Total 24 Hour:", (total_customers - total_day_only))
            print("Total 24 Hour Ampere:", (total_ampere - total_day_ampere))
            print("Total Revenue:", total_revenue, "IQD\n")

        except Exception as e:
            print(e)

    def show_employee_report(self):
        total_employees = 0
        total_part_time = 0
        total_full_time = 0
        total_salary = 0

        sql = "SELECT COUNT(*) AS total_employees, " \
              "SUM(CASE WHEN type = 'Part-time' THEN 1 ELSE 0 END) AS total_part_time, " \
              "SUM(CASE WHEN type = 'Full-time' THEN 1 ELSE 0 END) AS total_full_time, " \
              "SUM(salary) AS total_salary " \
              "FROM Employee"

        try:
            with self.connection.cursor(dictionary=True) as cursor:
                cursor.execute(sql)
                result = cursor.fetchone()
                if result:
                    total_employees = result['total_employees']
                    total_part_time = result['total_part_time']
                    total_full_time = result['total_full_time']
                    total_salary = result['total_salary']

            print("Employee Report:")
            print("Total Employees:", total_employees)
            print("Total Part-time Employees:", total_part_time)
            print("Total Full-time Employees:", total_full_time)
            print("Total Salary:", total_salary, "IQD\n")

        except Exception as e:
            print(e)

    def show_financial_report(self):
        total_customer_revenue = 0
        total_employee_salary = 0

        # Calculate total customer revenue from the database
        customer_revenue_query = "SELECT SUM(CASE WHEN subscriptionType = '24-Hours' THEN ampere * 10000 ELSE ampere " \
                                 "* 5000 END) AS total_revenue FROM customer"
        try:
            with self.connection.cursor(dictionary=True) as cursor:
                cursor.execute(customer_revenue_query)
                result = cursor.fetchone()
                if result:
                    total_customer_revenue = result['total_revenue']

        except Exception as e:
            print(e)

        # Calculate total employee salary from the database
        employee_salary_query = "SELECT SUM(salary) AS total_salary FROM Employee"
        try:
            with self.connection.cursor(dictionary=True) as cursor:
                cursor.execute(employee_salary_query)
                result = cursor.fetchone()
                if result:
                    total_employee_salary = result['total_salary']

        except Exception as e:
            print(e)

        total_employee_salary = decimal.Decimal(str(total_employee_salary))

        difference = total_customer_revenue - total_employee_salary

        print("Financial Report:")
        print("Total Customer Revenue:", total_customer_revenue, "IQD")
        print("Total Employee Salary:", total_employee_salary, "IQD")
        print("Difference (Revenue - Salary):", difference, "IQD")
