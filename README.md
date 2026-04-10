# 🎬 MovieBooking System

A **Java Swing-based Movie Ticket Booking Application** that provides a complete GUI solution for users to browse movies, select seats, and book tickets — along with admin controls for managing the system.

---

## ✨ Features

### 👤 User Side
- 🔐 User registration & login
- 🎥 Browse movie details
- 🕒 View showtimes
- 💺 Interactive seat selection
- 💳 Ticket booking & payment
- 🎟️ Ticket generation

### 🛠️ Admin Side
- 🔑 Admin login
- 📊 Dashboard for managing shows
- 🎬 Add/update movie sessions
- 📈 Monitor bookings

---

## 📁 Project Structure

```
src/Cinema/
│
├── AdminLoginPage.java      # Admin authentication
├── DashBoard.java           # Admin control panel
├── DBconnection.java        # Database connectivity
├── LoginPage.java           # User login screen (entry point)
├── LoginProfile.java        # User session/profile
├── MovieInfo.java           # Movie details display
├── MovieShowtimesUI.java    # Showtimes selection
├── PaymentPageUI.java       # Payment interface
├── RegistationPage.java     # User registration
├── SeatLayoutManager.java   # Seat selection logic
└── TicketGeneratorUI.java   # Ticket generation

bin/                         # Compiled classes
Image/                       # UI assets (images)
```

---

## 🖥️ Tech Stack

- **Java (JDK 8+)**
- **Java Swing (GUI)**
- **JDBC (Database Connectivity)**

---

## 🚀 Getting Started

### 1️⃣ Compile the Project

```bash
javac -d bin src/Cinema/*.java
```

### 2️⃣ Run the Application

```bash
java -cp bin Cinema.LoginPage
```

---

## ⚙️ Configuration

Before running:

- ✔️ Ensure **JDK 8 or later** is installed  
- ✔️ Configure database settings in:
  src/Cinema/DBconnection.java
- ✔️ Place all images from the `Image/` folder in the working directory

---

## 📌 Notes

- The main entry point is typically:
  Cinema.LoginPage
- Make sure your database is running and accessible before launching the app.
- UI may depend on external assets (images), so missing files can affect display.

---

## 💡 Future Improvements

- Online payment gateway integration  
- Responsive UI redesign  
- Movie search & filtering  
- Booking history for users  
- Email/SMS ticket confirmation  

---

## 🤝 Contributing

Feel free to fork this repository and submit pull requests to improve functionality or UI.

---

## 📜 License

This project is open-source and available under the **MIT License**.
