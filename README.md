# Exercise 1 – Design Patterns with Usecase

##  Behavioral Design Patterns

### 1. Observer Pattern  - Youtube Channel
**Use Case:**   A YouTube-like subscription system where users subscribe to channels and get notified when new content is uploaded.  

**Relation to Pattern:**   Observer pattern allows **subjects (channels)** to notify **observers (subscribers)** about state changes (new content).  

**Classes:**  
- `Content` – Represents the video, shorts, photo uploaded to a channel.  
- `Subscriber` – Observer that receives notifications when new content is uploaded.  
- `User` – Represents a subscriber entity.  
- `Channel` – Youtube channel interface that defines subscription management.  
- `YouTubeChannel` – Concrete youtube channel, manages subscribers and notifies them about updates.  
- `YouTubeMain` – Main class to demonstrate the observer pattern.  


### 2. Strategy Pattern  - Notification System
**Use Case:**   A flexible notification system (Email, SMS, WhatsApp, Push) that can be changed at runtime.  

**Relation to Pattern:**   Strategy pattern defines multiple notification methods and switches between them without altering client code.  

**Classes:**  
- `NotificationService` – Strategy interface for notification.  
- `EmailNotification` – Sends notifications via email.  
- `SMSNotification` – Sends notifications via SMS.  
- `WhatsAppNotification` – Sends notifications via WhatsApp.  
- `PushNotification` – Sends notifications via push alerts for specification.
- `NotificationClient` – Client that selects and executes a notification strategy.  
- `Main` – Main class to implements the strategy pattern.


## Creational Design Patterns  

### 1. Factory Pattern - Home Appliance Factory.
**Use Case:**   Creating different types of home appliances (Microwave, Refrigerator, Washing Machine) using a HomeAppliance factory.  

**Relation to Pattern:**   Factory pattern provides an interface for creating objects, promotes loose coupling by letting subclasses decide which appliance to create.

**Classes:**  
- `HomeAppliance` – Abstract product representing appliances.  
- `Microwave` – Concrete product microwave oven. 
- `Refrigerator` – Concrete product refrigerator. 
- `WashingMachine` – Concrete product washing machine.
- `HomeApplianceFactory` – Abstract factory for creating appliances.  
- `MicrowaveFactory` –  class that creates microwave ovens.  
- `RefrigeratorFactory` – class that creates refrigerators.
- `WashingMachineFactory` – Concrete class that creates washing machines.  
- `Client` – Requests appliances through factories (promotes loose coupling).
- `Main` – Main method that implements the factory pattern for Home Appliance. 


### 2. Prototype Pattern  - Document Creator and Editor
**Use Case:**   Duplicating and reusing different types of documents (PPT, Report, Resume) efficiently without recreating from scratch.  

**Relation to Pattern:**   Prototype pattern allows cloning existing documents, useful when object creation is costly.  

**Classes:**  
- `Document` – Abstract prototype defining clone behavior and structure for documents.
- `PPT` – Concrete prototype for PowerPoint files.  
- `Report` – Concrete prototype for reports.  
- `Resume` – Concrete prototype for resumes.  
- `DocumentClient` – Client that clones documents and enable options such as edit, show documents. 
- `Main` – Main method that implements prototype cloning and reusing.


## Structural Design Patterns  

### 1. Adapter Pattern  - FingerPrint Based Attendance System.
**Use Case:**   Modernizing an old attendance system with a new fingerprint-based system while maintaining compatibility.  

**Relation to Pattern:**   Adapter pattern bridges the old system and the new system, allowing integration without modifying the old code.

**Classes:**  
- `OldAttendanceSystem` – Represents the legacy attendance system.  
- `AttendanceSystem` – Adapter interface that defines new system operations.  
- `NewAttendanceSystem` – Adapter implementation bridging old and new systems that uses fingerprint based attendance. 
- `Student` – Represents a student whose attendance is tracked.  
- `Main` – Main method that implements the adapter pattern.


### 2. Proxy Pattern  -  Banking Application
**Use Case:**   A secure banking service with logging and security checks before accessing real banking services (deposit, withdraw).  

**Relation to Pattern:**   Proxy pattern controls access to the real service by adding extra features (logging, authentication).  

**Classes:**  
- `UserBank` – Represents a user details(Id, name, pin, balance) in the banking system. 
- `BankService` – Service interface for banking operations(deposit, withdraw).
- `RealBankService` – Actual banking service implementation.  
- `ProxyBankService` – Proxy that adds logging and security checks before accessing `RealBankService`.  
- `Main` – Main method implements proxy functionality.


## Utils  
Utility classes used throughout the project:  
- `AppLogger` – Singleton logger for consistent logging.  
- `TransientError` – Represents temporary system errors.  
- `TransientException` – Custom exception for transient error handling.
- `Z_Command_to_Run` - Here I given commands to execute the above design patterns, you can use this command to compile and run the code.

---

# Exercise 2 - Smart Home System (Mini Project) 

## Application Overview

The **Smart Home System** is a **console-based mini-project** that simulates the control of smart devices such as **Lights, Thermostats, and Door Locks** through a central hub. The system supports dynamic device creation, event-driven notifications, schedule and trigger automations, and secure access control.


## Features

| Feature               | Description |
|-----------------------|-------------|
| **Device Management** | Add, remove, and control devices (Door, Light, Thermostat) with status updates. |
| **Dynamic Device Creation** | Uses the Factory pattern to add/remove device types dynamically at runtime. |
| **Access Control**    | Proxy pattern enforces admin/guest permissions for secure interactions. |
| **Scheduling**        | Set timed automations for devices, like turning lights on/off at specific hours. |
| **Triggers**          | Event-based rules, such as turning off the lights when the temperature is beyond the threshold. |
| **Event Notifications** | Observer pattern enables real-time alerts to observers on device state changes. |
| **Logging System**    | Comprehensive event logging to `smarthome.log` for tracking actions and errors. |
| **Error Handling**    | Default and Custom exceptions for device-not-found errors, transient issues with recovery attempts. |
| **User Authentication** | Simple admin/guest modes with role-based functionality. |


## Design Patterns Used

### Factory Pattern
**Purpose:** Abstracts device creation, allowing the system to produce different device types (Door, Light, Thermostat) dynamically.  
**Classes**: `DeviceFactory`, `DeviceFactories` 

### Proxy Pattern
**Purpose:**  Controls access to the Smart Home Hub, authenticating users and checking permissions before delegating requests.  
**Classes**: `SmartHomeProxy`, `SmartHomeHub`

### Observer Pattern
**Purpose:**  Notifies registered observers of publisher device state changes, enabling reactive behaviors like alerts or automation.
**Classes**: `Observer`, `ObserverDevice`

### Singleton Pattern (Implicit functionality)
**Purpose:**  A singleton application logger for tracking device actions, errors, and system events and storing them in a log file.
**Classes**: `AppLoger`, Log file: `smarthome.log`

### Classes & Responsibilities

- `Device.java` – Base class for all smart devices, defining common properties and actions.  
- `Door.java` – Represents a smart door with locked/unlocked functionality.  
- `Light.java` – Represents a smart light with on/off and brightness controls.  
- `Thermostat` – Represents a smart thermostat with temperature controls.  
- `DeviceFactory` - Interface for device factory.
- `DeviceFactories` - Concrete factory for creating devices (Light, Thermostat, Door).
- `Schedules` – Represents scheduled tasks for devices automations.  
- `Triggers` – Represents event-based rules to automate device actions.  
- `SmartHomeProxy` - Proxy Class that ensure the admin has full access and guest user has read-only access.
- `SmartHomeHub` - A central Hub that implements all the functionalites for Smart Home System.
- `Main.java` – Entry point to run and demonstrate the Smart Home System.  
- `Observer` - Interface for observer devices.
- `ObserverDevice` - Class that implements Observer Operations (addObservers, removeObservers, notifyObservers).
- `SmartHomeProxy` – Proxy class controlling user access and permissions to the hub.  
- `TransientError` – Represents temporary system errors that may require retries.  
- `TransientException` – Custom exception to handle transient errors gracefully.  
- `AppLogger` – Singleton logger for tracking device actions, errors, and system events.  

## Utilities

- **Logging**: `AppLogger` captures system events, errors, and user actions in `smarthome.log`.  
- **Exceptions**: `TransientException` handles temporary failures with retry logic.  
- **Smart Home Log File**: Records entries like `"Device 'Light1' toggled ON at 2025-10-02 14:30:00"`.


## Working of Smart Home System

### Admin Functions
- Full access: Add, remove, configure devices, schedules, triggers, and monitor all logs.  
- System status: View hub status, schedules, triggers, and export logs.

### Guest User Functions
- Read-only access: View device statuses, schedules, and triggers.  
- Limited interactions: No ability to add devices, modify schedules, or access logs.

### Add a Device
<img width="300" height="310" alt="Image" src="https://github.com/user-attachments/assets/12c07798-d855-4c49-ba92-6f4c9d49bab2" /> 
<br></br>
<img width="401" height="220" alt="Image" src="https://github.com/user-attachments/assets/41909b51-8e11-4757-b1c1-28c628a172e7" />
<br></br>
<img width="401" height="200" alt="Image" src="https://github.com/user-attachments/assets/37312c04-ff7e-4a2c-b2f3-0877cc03d8c2" />

### Turn On a Device
<img width="340" height="190" alt="Image" src="https://github.com/user-attachments/assets/36624261-d6fd-4549-ad9b-5a7109d19945" />

### Turn Off a Device
<img width="325" height="193" alt="Image" src="https://github.com/user-attachments/assets/f7a89e3c-ae89-4e9d-b534-2899371b53cd" />

### Configure a Device
<img width="450" height="240" alt="Image" src="https://github.com/user-attachments/assets/b945b24c-1567-45bd-a0e5-2416747e7632" />

### Set Schedule
<img width="401" height="200" alt="Image" src="https://github.com/user-attachments/assets/f1ca8870-7277-4957-8011-3a90a0a543dd" />

### Add Trigger
<img width="450" height="260" alt="Image" src="https://github.com/user-attachments/assets/406f2d7a-afca-405f-b303-bf5f315eeb73" />

### Remove a Device
<img width="320" height="194" alt="Image" src="https://github.com/user-attachments/assets/32959835-4c0f-42b0-bc42-082e8020b06e" />

### Show Status
<img width="350" height="200" alt="Image" src="https://github.com/user-attachments/assets/e8239321-755c-4f8f-a52d-db13d68c76b9" />

### Show Schedules
<img width="350" height="180" alt="Image" src="https://github.com/user-attachments/assets/9192f4d9-fe43-4b8d-aa19-10b4f6882f75" />

### Show Triggers
<img width="401" height="170" alt="Image" src="https://github.com/user-attachments/assets/c6f7020f-4d97-48da-bc1e-51adf95fb334" />

### Guest Mode
<img width="401" height="350" alt="Image" src="https://github.com/user-attachments/assets/0785c256-d479-4af8-a444-504d80a2c068" />

### Error Handling (Actual errors and Transient Errors)
<img width="400" height="190" alt="Image" src="https://github.com/user-attachments/assets/ac63d4f4-82e7-47cf-9a73-eb85da10eb32" />
<br></br>
<img width="350" height="200" alt="Image" src="https://github.com/user-attachments/assets/b60aad79-b373-45ae-afb5-cc3dcf278402" />
<br></br>
<img width="450" height="300" alt="Image" src="https://github.com/user-attachments/assets/4b4b0da4-112e-4df6-a68f-1edecabaedc0" />

### Log File (smarthome.log)
<img width="520" height="339" alt="Image" src="https://github.com/user-attachments/assets/3970326b-1cfa-441b-af2d-0565035919cd" />


## Setup & Configuration

1. **Clone the repository**:  
   ```bash
   git clone https://github.com/sandhiya1912/Ei_Project.git
   cd Ei_Project

2. **Compile**
   Ensure JDK 17+ is installed.
   The below command compiles all the dependendcies required for Main.java.
   ```bash
   javac -d exercise_2\bin -sourcepath . exercise_2\SmartHomeSystem\Main\Main.java

4. **Run the Application**
   ```bash
   java -cp exercise_2\bin exercise_2.SmartHomeSystem.Main.Main

## Tech Stack Used

| Category                       | Tools / Technologies |
|--------------------------------|--------------------|
| **Programming Language**        | Java (JDK 17+) |
| **Design Patterns**             | Factory, Proxy, Observer |
| **Build & Execution**           | Native `javac` and `java` commands |
| **Logging**                     | Custom file-based logging system (`AppLogger`) |
| **Version Control & Collaboration** | Git and GitHub |


## Contact

- **Email:** sandhiyapomman@gmail.com
- **GitHub:** [github.com/sandhiyapomman](https://github.com/sandhiya1912/Sandhiya-Pomman)

Thanking you for reviewing and using this project!

