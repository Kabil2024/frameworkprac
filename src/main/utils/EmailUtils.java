package utils;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.DefaultAuthenticator;
import java.io.File;

public class EmailUtils {

    public static void sendEmailWithReport(String reportPath) {
        try {
            // Set up email
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName("smtp.gmail.com");  // Use your SMTP server
            email.setSmtpPort(465);  // Use the correct port (465 for SSL, 587 for TLS)
            email.setAuthenticator(new DefaultAuthenticator("gopibaratnadar00@gmail.com", "mdpx igms lxfc kfoj"));
            email.setSSLOnConnect(true);

            // Email details
            email.setFrom("gopibaratnadar00@gmail.com");
            email.setSubject("Test Automation Report");
            email.setMsg("Please find the attached test execution report.");
            email.addTo("kowshik.kunapareddy@gmail.com");
            email.addTo("gopinadar01@gmail.com");
            email.addTo("kabilarasan44@gmail.com");
            email.addTo("gokularun20030603@gmail.com");// Change to recipient's email

            // Attach report
            File reportFile = new File(reportPath);
            if (reportFile.exists()) {
                email.attach(reportFile);
            } else {
                System.out.println("Report file not found: " + reportPath);
            }

            // Send email
            email.send();
            System.out.println("Email sent successfully with test report!");
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
