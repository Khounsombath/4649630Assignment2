#  S4649630Assignment2 – Course Dashboard App

This Android application is developed as part of the MAP Assignment 2 project.  
The app demonstrates key Android development principles including **Dependency Injection (Hilt)**, **API integration using Retrofit**, and **RecyclerView-based UI** for displaying course information.

---

##  Features

- **Login Screen** – Simple authentication interface.
- **Dashboard Screen** – Displays a list of university courses dynamically.
- **Detail Screen** – Shows detailed course information including instructor, credits, and description.
- **API Integration** – Fetches real course data from a RESTful API (`https://nit3213api.onrender.com/dashboard/courses`).
- **Hilt Dependency Injection** – Implements clean architecture and modularity.
- **Offline Demo Mode** – Loads sample data if API is unavailable.

---

##  Technical Implementation

| Component | Purpose |
|------------|----------|
| `Hilt` | Used for dependency injection (`AppModule.kt`, `S4649630Assignment2App.kt`) |
| `Retrofit & OkHttp` | Handles API requests and responses |
| `RecyclerView` | Displays dynamic course list |
| `Navigation Component` | Manages navigation between Login → Dashboard → Details |
| `JUnit` | Used for unit testing the API service (`DashboardApiTest.kt`) |

---

## ⚙️ How to Build and Run

###  1. Clone the Repository
```bash
git clone https://github.com/khounsombath/S4649630Assignment2.git
cd S4649630Assignment2
