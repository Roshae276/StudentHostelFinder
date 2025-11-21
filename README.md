# Student Hostel Finder

A Java Swing desktop application for finding and managing student hostels near coaching centers, developed using object-oriented programming principles. This project demonstrates real-world usage of Java OOP concepts combined with a clean, modern GUI.

## Features

- Browse a large list of hostels (40+ included) with details like name, address, contact, and rent for AC/non-AC rooms
- View accommodations within each hostel, including room type, rent, and notes
- Login and Signup system with student preparation type (JEE/NEET), coaching, and branch selection on Signup page
- Separate Owner and Student roles (Owner dashboard to manage accommodation issues)
- Students can report and verify accommodation issues
- Professional, responsive GUI with modern design, smooth scrolling, and clear layouts
- No external dependencies; images intentionally excluded for simplicity

## Technologies Used

- Java SE 11+
- Swing for GUI development
- Object-Oriented Programming (OOP) principles
- MVC design pattern concepts applied (separation of concerns)

## Installation & Running
clone the repository
git clone https://github.com/Roshae276/StudentHostelFinder.git
cd StudentHostelFinder



### Compile the project

> **Using Git Bash or Unix-style shell (recommended for Windows users):**

mkdir -p bin
find . -name "*.java" -print0 | xargs -0 javac -d bin



> **Using Windows CMD or PowerShell (if all files are in one directory):**

mkdir bin
javac -d bin *.java



### Run the application

java -cp bin Main

## Project Structure

- `Main.java` - Entry point that launches the login frame.
- `LoginFrame.java` - Login UI with username/password and navigation to Signup page.
- `SignupFrame.java` - Signup UI with exam type and coaching/branch selectors.
- `StudentDashboard.java` - Main student interface showing hostel listings.
- `OwnerDashboard.java` - Owner interface for managing reported issues.
- `DataStore.java` - Singleton class managing app data, including seeded hostels and accommodations.
- Model classes: `Hostel.java`, `Accommodation.java`, `Issue.java`, `Review.java`, `User.java`, `Student.java`, `Owner.java`.

## Contributing

Contributions are welcome! Feel free to:

- Report issues or bugs
- Suggest new features or improvements
- Fork the project, make changes, and create pull requests

## License

This project is provided under the MIT License. See the LICENSE file for details.

## Contact

For questions or help, contact Roshni Dodani.  
Project inspired by real-world use case — designed as a hands-on OOP learning project.

---

Thank you for checking out the Student Hostel Finder! 🌟
