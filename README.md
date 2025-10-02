<img width="863" height="969" alt="image" src="https://github.com/user-attachments/assets/1ae6479e-250a-48ea-b4a2-61eb812aafc6" />
# Exercise 1 – Design Patterns with Usecase

##  Behavioral Design Patterns

### 1. Observer Pattern  
**Use Case:**  A YouTube-like subscription system where users subscribe to channels and get notified when new content is uploaded.  

**Relation to Pattern:**  Observer pattern allows **subjects (channels)** to notify **observers (subscribers)** about state changes (new content).  

**Classes:**  
- `Content` – Represents the video or content uploaded to a channel.  
- `Subscriber` – Observer that receives notifications when new content is posted.  
- `User` – Represents a subscriber entity.  
- `Channel` – Subject interface that defines subscription management.  
- `YouTubeChannel` – Concrete subject, manages subscribers and notifies them about updates.  
- `YouTubeMain` – Main class to demonstrate the observer workflow.  


### 2. Strategy Pattern  
**Use Case:**  A flexible notification system (Email, SMS, WhatsApp, Push) that can be changed at runtime.  

**Relation to Pattern:**  Strategy pattern defines multiple algorithms (notification methods) and switches between them without altering client code.  

**Classes:**  
- `NotificationService` – Strategy interface for notification.  
- `EmailNotification` – Sends notifications via email.  
- `SMSNotification` – Sends notifications via SMS.  
- `WhatsAppNotification` – Sends notifications via WhatsApp.  
- `PushNotification` – Sends notifications via push alerts.  
- `NotificationClient` – Client that selects and executes a notification strategy.  
- `Main` – Main class to demonstrate the strategy pattern in action.  


## Structural Design Patterns  

### 1. Adapter Pattern  
**Use Case:**  Modernizing an old attendance system with a new fingerprint-based system while maintaining compatibility.  

**Relation to Pattern:**  Adapter pattern bridges the old system and the new system, allowing integration without modifying the old code.  

**Classes:**  
- `OldAttendanceSystem` – Represents the legacy attendance system.  
- `AttendanceSystem` – Adapter interface that defines new system operations.  
- `NewAttendanceSystem` – Adapter implementation bridging old and new systems.  
- `Student` – Represents a student whose attendance is tracked.  
- `Main` – Demonstrates the adapter pattern.


### 2. Proxy Pattern  
**Use Case:**  A secure banking service with logging and security checks before accessing real banking services (deposit, withdraw).  

**Relation to Pattern:**  Proxy pattern controls access to the real service by adding extra features (logging, security).  

**Classes:**  
- `UserBank` – Represents a user in the banking system.  
- `BankService` – Service interface for banking operations.  
- `RealBankService` – Actual banking service implementation.  
- `ProxyBankService` – Proxy that adds logging and security checks before accessing `RealBankService`.  
- `Main` – Demonstrates proxy functionality.  


## Creational Design Patterns  

### 1. Factory Pattern  
**Use Case:**  Creating different types of home appliances (Microwave, Refrigerator, Washing Machine) using a factory.  

**Relation to Pattern:**  Factory pattern provides an interface for creating objects, letting subclasses decide which appliance to create.  

**Classes:**  
- `HomeAppliance` – Abstract product representing appliances.  
- `Microwave` – Concrete product.  
- `Refrigerator` – Concrete product.  
- `WashingMachine` – Concrete product.  
- `HomeApplianceFactory` – Abstract factory for creating appliances.  
- `MicrowaveFactory` – Creates `Microwave` objects.  
- `RefrigeratorFactory` – Creates `Refrigerator` objects.  
- `WashingMachineFactory` – Creates `WashingMachine` objects.  
- `Client` – Requests appliances through factories.  
- `Main` – Demonstrates the factory pattern.  


### 2. Prototype Pattern  
**Use Case:**  Duplicating different types of documents (PPT, Report, Resume) efficiently without recreating from scratch.  

**Relation to Pattern:**  Prototype pattern allows cloning existing documents, useful when object creation is costly.  

**Classes:**  
- `Document` – Abstract prototype defining clone behavior.  
- `PPT` – Concrete prototype for PowerPoint files.  
- `Report` – Concrete prototype for reports.  
- `Resume` – Concrete prototype for resumes.  
- `DocumentClient` – Client that clones documents.  
- `Main` – Demonstrates prototype cloning.  


## Utils  
Utility classes used throughout the project:  
- `AppLogger` – Singleton logger for consistent logging.  
- `TransientError` – Represents temporary system errors.  
- `TransientException` – Custom exception for transient error handling.   

---

# Smart Home System

## Application Overview

The **Smart Home System** is a **console-based mini-project** that simulates the control of smart devices such as **Lights, Thermostats, and Door Locks** through a central hub. The system supports dynamic device creation, event-driven notifications, schedule and trigger automations, and secure access control.

---

## Features

- **Device Management**:       Add, remove, and control devices (Door, Light, Thermostat) with status updates.  
- **Dynamic Device Creation**: Uses the Factory pattern to instantiate device types dynamically without hardcoding.  
- **Event Notifications**:     Observer pattern enables real-time alerts on device state changes (e.g., door opened).  
- **Access Control**:          Proxy pattern enforces admin/guest permissions for secure interactions.  
- **Scheduling**:              Set timed automations for devices, like turning lights on/off at specific hours.  
- **Triggers**:                Event-based rules, such as activating lights when motion is detected via door sensor.  
- **Logging System**:          Comprehensive event logging to `smarthome.log` for tracking actions and errors.  
- **Error Handling**:          Custom exceptions for transient issues, ensuring graceful recovery.  
- **User Authentication**:     Simple admin/guest modes with role-based functionality.

---

## Functionality

### Admin Functions
- Full access: Add, remove, configure devices, schedules, triggers, and monitor all logs.  
- System status: View hub status, schedules, triggers, and export logs.

### Guest User Functions
- Read-only access: View device statuses, schedules, and triggers.  
- Limited interactions: No ability to add devices, modify schedules, or access logs.

---

## Design Patterns Used

### Factory Pattern
Abstracts device creation, allowing the system to produce different device types (Door, Light, Thermostat) dynamically.  
**Classes**: `DeviceFactory`, `DeviceFactories`.

### Proxy Pattern
Controls access to the Smart Home Hub, authenticating users and checking permissions before delegating requests.  
**Classes**: `SmartHomeProxy`, `SmartHomeHub`.

### Observer Pattern
Notifies registered observers of device state changes, enabling reactive behaviors like alerts or automation.  
**Classes**: `Observer`, `ObserverDevice`.

---

## Utilities

- **Logging**: `AppLogger` captures system events, errors, and user actions in `smarthome.log`.  
- **Exceptions**: `TransientException` handles temporary failures with retry logic.  
- **Smart Home Log File**: Records entries like `"Device 'Light1' toggled ON at 2025-10-02 14:30:00"`.

---

## Working of Smart Home System

### Add a Device
![Add Device Screenshot](screenshots/add_device.png](https://github.com/user-attachments/assets/5ead977f-6ef6-4e7d-af28-c7772a505539" )

### Remove a Device
![Remove Device Screenshot](screenshots/control_device.png)

### Turn On a Device
![Turn On Device Screenshot](screenshots/control_device.png)

### Turn Off a Device
![Turn Off Device Screenshot](screenshots/control_device.png)

### Configure a Device
![Configure Device Screenshot](screenshots/control_device.png)

### Set Schedule
![Set Schedule Screenshot](screenshots/manage_schedules.png)

### Add Trigger
![Add Trigger Screenshot](screenshots/set_triggers.png)

### Show Status
![Show Status Screenshot](screenshots/set_triggers.png)

### Show Schedules
![Show Schedules Screenshot](screenshots/set_triggers.png)

### Show Triggers
![Show Triggers Screenshot](screenshots/set_triggers.png)

### Guest Mode
![Guest Mode Screenshot](screenshots/set_triggers.png)

---

## Setup & Configuration

1. **Clone the repository**:  
   ```bash
   git clone https://github.com/yourusername/smart-home-system.git
   cd smart-home-system

