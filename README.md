📘 Exercise 1 – Design Patterns in Java

This repository demonstrates the implementation of various Design Patterns in Java, categorized into Behavioral, Structural, and Creational patterns.
Each pattern includes a real-world inspired use case and the classes involved.

🔹 Behavioral Design Patterns
1. Observer Pattern

Use Case: A YouTube-like subscription system where users subscribe to channels and get notified when new content is uploaded.

Classes:

Content: Represents the video or content uploaded to a channel.

Subscriber: Observer that receives notifications when new content is posted.

User: Represents a subscriber entity.

Channel: Subject interface that defines subscription management.

YouTubeChannel: Concrete subject, manages subscribers and notifies them about updates.

YouTubeMain: Main class to demonstrate the observer workflow.

2. Strategy Pattern

Use Case: A flexible notification system (Email, SMS, WhatsApp, Push) that can be changed at runtime.

Classes:

NotificationService: Strategy interface for notification.c 71nmm

EmailNotification: Sends notifications via email.

SMSNotification: Sends notifications via SMS.

WhatsAppNotification: Sends notifications via WhatsApp.

PushNotification: Sends notifications via push alerts.

NotificationClient: Client that selects and executes a notification strategy.

Main: Main class to demonstrate the strategy pattern in action.

🔹 Structural Design Patterns
1. Adapter Pattern

Use Case: Modernizing an old attendance system while keeping compatibility with the new system.

Classes:

oldAttendanceSystem: Represents the legacy attendance system.

AttendanceSystem: Adapter interface that defines new system operations.

NewAttendanceSystem: Adapter implementation that bridges old and new systems.

Student: Represents a student whose attendance is tracked.

Main: Main class to demonstrate the adapter pattern.

2. Proxy Pattern

Use Case: A secure banking service with logging and security checks before accessing real banking services.

Classes:

UserBank: Represents a user in the banking system.

BankService: Service interface for banking operations.

RealBankService: Actual banking service implementation.

ProxyBankService: Proxy that adds logging and security checks before accessing RealBankService.

Main: Main class to demonstrate proxy functionality.

🔹 Creational Design Patterns
1. Factory Pattern

Use Case: Creating different types of home appliances (Microwave, Refrigerator, Washing Machine) without exposing creation logic.

Classes:

HomeAppliance: Abstract product representing appliances.

Microwave: Concrete product for microwave.

Refrigerator: Concrete product for refrigerator.

WashingMachine: Concrete product for washing machine.

HomeApplianceFactory: Abstract factory for creating appliances.

MicrowaveFactory: Creates Microwave objects.

RefridgeratorFactory: Creates Refrigerator objects.

WashineMachineFactory: Creates WashingMachine objects.

Client: Requests appliances through factories.

Main: Main class to demonstrate the factory pattern.

2. Prototype Pattern

Use Case: Duplicating different types of documents (PPT, Report, Resume) efficiently without creating them from scratch.

Classes:

Document: Abstract prototype defining clone behavior.

PPT: Concrete prototype for PowerPoint files.

Report: Concrete prototype for reports.

Resume: Concrete prototype for resumes.

DocumentClient: Client that clones documents.

Main: Main class to demonstrate prototype cloning.

🔹 Utils (Shared Utilities in Exercise 1)

These utility classes are used throughout the project to provide logging and error handling:

AppLogger: Singleton logger used across all patterns for consistent logging.

TransientError: Represents temporary errors in the system.

TransientException: Custom exception class for transient error handling.
