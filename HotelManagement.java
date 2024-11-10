import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class HotelManagement {
    private static JFrame frame;
    private static JTabbedPane tabbedPane;

    // Data structures to hold room and customer information
    private static Map<Integer, Room> rooms = new HashMap<>();
    private static List<Customer> customers = new ArrayList<>();

    // Entry point for the application
    public static void main(String[] args) {
        frame = new JFrame("Hotel Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null); // Center the frame on screen

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Manage Rooms", createRoomManagementPanel());
        tabbedPane.addTab("Booking", createBookingPanel());
        tabbedPane.addTab("Customer Info", createCustomerInfoPanel());

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    // Panel to manage room information
    private static JPanel createRoomManagementPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextArea roomDetailsArea = new JTextArea(10, 40);
        roomDetailsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(roomDetailsArea);

        JButton viewRoomsButton = new JButton("View Rooms");
        viewRoomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roomDetailsArea.setText("");
                for (Room room : rooms.values()) {
                    roomDetailsArea.append(room + "\n");
                }
            }
        });

        JButton addRoomButton = new JButton("Add Room");
        addRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField roomNumberField = new JTextField(5);
                JTextField roomTypeField = new JTextField(10);
                JTextField priceField = new JTextField(5);

                JPanel inputPanel = new JPanel();
                inputPanel.add(new JLabel("Room Number:"));
                inputPanel.add(roomNumberField);
                inputPanel.add(new JLabel("Room Type:"));
                inputPanel.add(roomTypeField);
                inputPanel.add(new JLabel("Price:"));
                inputPanel.add(priceField);

                int option = JOptionPane.showConfirmDialog(null, inputPanel, "Enter Room Details", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    int roomNumber = Integer.parseInt(roomNumberField.getText());
                    String roomType = roomTypeField.getText();
                    double price = Double.parseDouble(priceField.getText());
                    rooms.put(roomNumber, new Room(roomNumber, roomType, price));
                    JOptionPane.showMessageDialog(null, "Room added successfully!");
                }
            }
        });

        panel.add(viewRoomsButton);
        panel.add(addRoomButton);
        panel.add(scrollPane);

        return panel;
    }

    // Panel to manage customer booking
    private static JPanel createBookingPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextArea bookingDetailsArea = new JTextArea(10, 40);
        bookingDetailsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(bookingDetailsArea);

        JTextField customerNameField = new JTextField(20);
        JTextField roomNumberField = new JTextField(5);

        JButton bookRoomButton = new JButton("Book Room");
        bookRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerName = customerNameField.getText();
                int roomNumber = Integer.parseInt(roomNumberField.getText());

                if (rooms.containsKey(roomNumber)) {
                    Room room = rooms.get(roomNumber);
                    if (room.isAvailable()) {
                        room.setAvailable(false);
                        customers.add(new Customer(customerName, room));
                        JOptionPane.showMessageDialog(null, "Room booked successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Room is already booked.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid room number.");
                }
            }
        });

        panel.add(new JLabel("Customer Name:"));
        panel.add(customerNameField);
        panel.add(new JLabel("Room Number:"));
        panel.add(roomNumberField);
        panel.add(bookRoomButton);
        panel.add(scrollPane);

        return panel;
    }

    // Panel to view customer booking information
    private static JPanel createCustomerInfoPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextArea customerDetailsArea = new JTextArea(10, 40);
        customerDetailsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(customerDetailsArea);

        JButton viewCustomersButton = new JButton("View Booked Customers");
        viewCustomersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerDetailsArea.setText("");
                for (Customer customer : customers) {
                    customerDetailsArea.append(customer + "\n");
                }
            }
        });

        panel.add(viewCustomersButton);
        panel.add(scrollPane);

        return panel;
    }
}

// Room class to represent each room
class Room {
    private int roomNumber;
    private String roomType;
    private double price;
    private boolean available;

    public Room(int roomNumber, String roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.available = true;
    }

    // Getter methods for private fields
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Type: " + roomType + ", Price: " + price + ", Availability: " + (available ? "Available" : "Booked");
    }
}

// Customer class to represent a customer booking a room
class Customer {
    private String name;
    private Room room;

    public Customer(String name, Room room) {
        this.name = name;
        this.room = room;
    }

    @Override
    public String toString() {
        return "Customer: " + name + ", Room Number: " + room.getRoomNumber();
    }
}
