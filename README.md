# Remote Method Invocation (RMI) Project

This project demonstrates the implementation of a distributed object system using Remote Method Invocation (RMI). It consists of two main parts:

1. **Part 1:** A distributed calendar server with event management using built-in RMI functionality.  
2. **Part 2:** A custom RMI middleware designed and implemented without relying on external RMI libraries.

---

## **Project Overview**  
The goal of this project is to help developers understand the core principles of distributed object systems by working with both standard and custom implementations of RMI. The application is implemented in **Java**, though it can be adapted to other languages like Python or C#.

---

## **Part 1: Calendar Server using Standard RMI**  
In the first part, we design and implement a **calendar server** where multiple clients can perform the following actions:  
- Add events (with properties such as name, type, date, time, length, description, and location).  
- Remove events.  
- Retrieve events by specific criteria (name, type, date, or location).  
- Get all events for a given month and year.  

The calendar server exposes its remote methods using standard RMI interfaces and enables multiple clients to connect and interact concurrently.

### **Key Features**  
- Multi-client access with concurrent event management.  
- Dynamic binding between clients and the server.  
- Remote method calls that abstract the underlying communication.

---

## **Part 2: Custom RMI Middleware**  
In the second part, we implement a simplified version of RMI middleware **without using any external RMI libraries**. The custom solution is designed to provide:  
- Remote method invocation that appears local to the developer.  
- Dynamic binding of client and server objects.  
- Support for primitive data types (integer, boolean, char, String, and double).  
- Optional support for object-based arguments and return types.

This part involves implementing key RMI components, such as:  
- Stub and skeleton classes.  
- Network communication between clients and servers.  
- Object serialization and method invocation handling.

### **Key Features**  
- Custom implementation of dynamic object binding.  
- Handling of multiple clients connecting to the same remote object.  
- Inheritance to enforce method signatures on both client and server sides.

---

## **Design Considerations**  
- **Consistency:** Inheritance is used to ensure that client and server implement the same interface.  
- **Good Programming Practices:** The code is designed for maintainability, with clear interfaces and modularity.  
- **Scalability:** The custom RMI implementation allows for extending the support to more data types and complex objects if needed.

---

## **Project Structure**  
```
├── Part1/                   # Implementation of Part 1 (Calendar with standard RMI)
│   ├── CalendarServer.java  
│   ├── Client.java  
│   ├── CalendarInterface.java  
│   └── ...  
├── Part2/                   # Implementation of Part 2 (Custom RMI Middleware)  
│   ├── RMIServer.java  
│   ├── RMIClient.java  
│   ├── Stub.java  
│   ├── Skeleton.java  
│   ├── RemoteInterface.java  
│   └── ...  
├── README.md                # Project documentation  
├── report.pdf               # Detailed project report with class diagrams  
└── videos/                  # Demonstration videos for both parts  
```

---

## **Requirements**  
- **Java Development Kit (JDK)** (version 8 or higher recommended)  
- **Optional:** Python or C# if adapting to other languages  

---

## **How to Run the Project**

### **Part 1: Standard RMI Calendar Server**  
1. Navigate to the `Part1/` directory.  
2. Compile the server and client code using:  
    ```bash  
    javac *.java  
    ```  
3. Start the RMI registry:  
    ```bash  
    rmiregistry &  
    ```  
4. Run the server:  
    ```bash  
    java CalendarServer  
    ```  
5. In a separate terminal, run the client:  
    ```bash  
    java Client  
    ```  

### **Part 2: Custom RMI Middleware**  
1. Navigate to the `Part2/` directory.  
2. Compile the server and client code:  
    ```bash  
    javac *.java  
    ```  
3. Run the server:  
    ```bash  
    java RMIServer  
    ```  
4. In a separate terminal, run the client:  
    ```bash  
    java RMIClient  
    ```

---

## **Project Deliverables**  
- **Part 1:** Calendar server implemented using standard RMI mechanisms.  
- **Part 2:** Custom RMI middleware with remote object interaction.  
- **Report:** A detailed PDF explaining the implementation and evaluation.  
- **Demonstration videos:** Two short videos showing the functionality of each part.

---

## **Evaluation**  
- The custom RMI implementation demonstrates how remote method calls can be abstracted as local method calls.  
- The project highlights strengths in modularity and extensibility but acknowledges limitations in handling complex object types in Part 2.  
- Suggestions for future improvements include better support for object serialization and optimized network handling.
