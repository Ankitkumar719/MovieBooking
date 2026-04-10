# MovieBooking

A Java Swing-based movie ticket booking application.

## Project Structure

- `src/Cinema/`
  - `AdminLoginPage.java` - Admin login interface and access control.
  - `DashBoard.java` - Main dashboard for managing movie sessions and bookings.
  - `DBconnection.java` - Database connection utility.
  - `LoginPage.java` - User login screen.
  - `LoginProfile.java` - User profile and session management.
  - `MovieInfo.java` - Movie details and information display.
  - `MovieShowtimesUI.java` - Showtimes selection interface.
  - `PaymentPageUI.java` - Payment processing screen.
  - `RegistationPage.java` - Registration form for new users.
  - `SeatLayoutManager.java` - Seat selection and layout logic.
  - `TicketGeneratorUI.java` - Ticket generation and printing screen.

- `bin/` - Compiled application classes.
- `Image/` - Project images and assets used by the UI.

## Description

This application provides a graphical interface for users to log in, view movie details, choose showtimes, select seats, and complete ticket purchases. Admin users can manage movie sessions and monitor bookings.

## Requirements

- Java Development Kit (JDK) 8 or later

## Running the Project

1. Compile the Java source files in `src/Cinema/`.
2. Run the main application class from the compiled output.

Example command line (from the project root):

```sh
javac -d bin src/Cinema/*.java
java -cp bin Cinema.LoginPage
```

> If the project uses a database, make sure the database connection settings in `src/Cinema/DBconnection.java` are configured correctly before running.

## Notes

- The exact entry point may vary depending on the implementation. `LoginPage` is a likely starting class for the GUI.
- Place any required images from `Image/` into the working directory so the UI can load them.
