Hotel Management System - Java Swing
Project Overview
This is a simple Hotel Management System implemented in Java using Swing for the graphical user interface (GUI). The system allows hotel staff to manage room bookings, view room availability, and track customer details. The system can handle basic operations such as adding rooms, booking rooms, viewing all booked rooms, and viewing customer details.

Key Features:
Add Room: Allows adding room details such as room number, room type, and price.
View Rooms: Displays all rooms along with their current status (available or booked).
Book Room: Allows customers to book available rooms by entering their details.
View Booked Customers: Displays a list of customers who have booked rooms.
Room Availability: Each room can be marked as either available or booked.
Technologies Used:
Java: Core programming language used to implement the backend logic.
Java Swing: Used to create the GUI for the system.
Collections (HashMap and ArrayList): Used to store room and customer data.
Prerequisites
Before you begin, ensure you have met the following requirements:

Java JDK installed on your machine (version 8 or higher).
To check if Java is installed, run the command java -version in your terminal.
You can download Java JDK from Oracle's website.
A text editor or IDE such as IntelliJ IDEA, Eclipse, or NetBeans for writing and compiling the Java code.
Project Setup
Clone the Repository or Download the Java File:

If you are using version control like Git, clone the repository to your local machine:
bash
Copy code
git clone https://github.com/yourusername/hotel-management-system.git
Alternatively, you can simply download the Java file HotelManagement.java.
Compile the Java File:

Open the terminal (command prompt) and navigate to the folder where your HotelManagement.java file is saved.
Run the following command to compile the code:
bash
Copy code
javac HotelManagement.java
Run the Program:

Once compiled, you can run the program with the following command:
bash
Copy code
java HotelManagement
GUI Interface:

The program will launch a GUI window with three main sections:
Manage Rooms: Add and view rooms.
Booking: Book rooms for customers.
Customer Info: View a list of customers who have booked rooms.
Functionality
1. Manage Rooms Tab
Add Room:
You can add a new room by entering the room number, type (e.g., Single, Double), and price.
View Rooms:
Displays all rooms with their current availability (either "Available" or "Booked").
2. Booking Tab
Book Room:
Enter the customer's name and the room number they wish to book.
If the room is available, it will be booked and marked as "Booked".
3. Customer Info Tab
View Booked Customers:
This shows a list of customers who have booked rooms along with the room numbers they have reserved.
Code Structure
The project consists of three main classes:

1. HotelManagement.java
This is the main class containing the GUI and event handlers.
It uses JTabbedPane to create tabs for "Manage Rooms", "Booking", and "Customer Info".
It manages room data using a HashMap (rooms) and customer data using an ArrayList (customers).
2. Room.java
Represents a room in the hotel.
Contains properties like roomNumber, roomType, price, and availability.
Methods:
getRoomNumber(), getRoomType(), getPrice(), and isAvailable() to access room details.
setAvailable() to update the availability of the room.
3. Customer.java
Represents a customer who books a room.
Contains properties like name and room (the room booked by the customer).
Example Usage
Add Room:

Go to the Manage Rooms tab.
Click on the "Add Room" button and enter the room number, type, and price.
The room is added to the system and displayed in the "View Rooms" section.
Book Room:

Go to the Booking tab.
Enter the customer's name and select the room number to book.
If the room is available, it will be marked as "Booked" and the customer's details will be displayed in the Customer Info tab.
View Booked Customers:

Go to the Customer Info tab to see a list of all customers who have booked rooms.
Example Output (Console)
After running the program, you will see a GUI interface with the following options:

Manage Rooms: Add and view rooms.
Booking: Book rooms for customers.
Customer Info: View a list of customers and their booked rooms.
Sample output on the console for room booking:

yaml
Copy code
Room Number: 101, Type: Single, Price: 100.0, Availability: Available
Room Number: 102, Type: Double, Price: 150.0, Availability: Available
Room Number: 103, Type: Suite, Price: 200.0, Availability: Available
...
After booking a room:

yaml
Copy code
Room Number: 101, Type: Single, Price: 100.0, Availability: Booked
Customer Info:

yaml
Copy code
Customer: John Doe, Room Number: 101
Customer: Jane Smith, Room Number: 102
...
Troubleshooting
Error: Java not installed:
Ensure that you have installed Java correctly. Run java -version to check the version installed.
GUI Not Showing:
Ensure your environment supports Java Swing. If you're using an IDE, make sure the project is configured to support GUI libraries.
Contributing
If you would like to contribute to this project, feel free to fork the repository, make changes, and create a pull request. Please make sure to update the README file if necessary.

License
This project is licensed under the MIT License - see the LICENSE file for details.

Contact Information
For any issues or further queries, you can reach me at:

Email: youremail@example.com
GitHub: github.com/Lohith01-dev
