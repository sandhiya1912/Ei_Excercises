package exercise_1.Creational.Prototype;

import exercise_1.Creational.Prototype.DocumentTypes.*;
import exercise_1.Utils.TransientException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Document resume = new Resume("Basic Resume Template: Name: , Skills: , Projects: ");
        Document report = new Report("Basic Report Template: Author: , Title: , Introduction: , Purpose: , Results: ");
        Document ppt = new PPT("Basic PPT Template: Title: , Presented By: , Introduction: , Objective: , Results: ");

        DocumentClient resumeClient = new DocumentClient(resume);
        DocumentClient reportClient = new DocumentClient(report);
        DocumentClient pptClient = new DocumentClient(ppt);

        Scanner sc = new Scanner(System.in);
        boolean start = true;

        System.out.println("Prototype Document Creator started..");
        System.out.println("Available commands: edit, show, exit");

        while (start) {
            System.out.println("\nChoose the Document to create: RESUME / REPORT / PPT / EXIT");
            String documentChoice = sc.nextLine().trim().toUpperCase();

            try {
                Document clonedDoc = null;

                switch (documentChoice) {
                    case "RESUME":
                        clonedDoc = resumeClient.createDocument();
                        System.out.println("Cloned a new Resume document.");
                        DocumentService(clonedDoc, sc);
                        break;
                    case "REPORT":
                        clonedDoc = reportClient.createDocument();
                        System.out.println("Cloned a new Report document.");
                        DocumentService(clonedDoc, sc);
                        break;
                    case "PPT":
                        clonedDoc = pptClient.createDocument();
                        System.out.println("Cloned a new PPT document.");
                        DocumentService(clonedDoc, sc);
                        break;
                    case "EXIT":
                        start = false;
                        System.out.println("Exiting Prototype Demo.");
                        break;
                    default:
                        System.out.println("Invalid document choice. Please enter RESUME, REPORT, or PPT.");
                }
            } catch (TransientException te) {
                System.out.println("Transient error occurred: " + te.getMessage() + ". Please try again.");
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        sc.close();
    }


    public static void DocumentService(Document doc, Scanner sc) {
        boolean docSession = true;
        while (docSession) {
            System.out.println("\nEnter command for the document (edit/show/exit):");
            String service = sc.nextLine().trim().toLowerCase();

            try {
                switch (service) {
                    case "edit":
                        System.out.println("Enter the new content for the document:");
                        String newContent = sc.nextLine();
                        doc.edit(newContent);
                        System.out.println("Document edited successfully.");
                        break;
                    case "show":
                        doc.show();
                        break;
                    case "exit":
                        docSession = false;
                        System.out.println("Returning to document selection...");
                        break;
                    default:
                        System.out.println("Invalid command. Available: edit, show, exit");
                }
            } catch (TransientException te) {
                System.out.println("Transient error: " + te.getMessage() + ". Retry the operation.");
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}
