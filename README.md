
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
