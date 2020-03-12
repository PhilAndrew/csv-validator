package csvvalidator;

import uk.gov.nationalarchives.csv.validator.api.java.CsvValidator;
import uk.gov.nationalarchives.csv.validator.api.java.FailMessage;
import uk.gov.nationalarchives.csv.validator.api.java.Substitution;
import uk.gov.nationalarchives.csv.validator.api.java.WarningMessage;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
    private void csvValidation() {
        Boolean failFast = false;
        List<Substitution> pathSubstitutions = new ArrayList<Substitution>();

        List<FailMessage> messages = CsvValidator.validate(
                "./data/csv/data.csv",
                "./data/csv/data-schema.csvs",
                failFast,
                pathSubstitutions,
                true, false);

        if(messages.isEmpty()) {
            System.out.println("Completed validation OK");
        } else {
            for(FailMessage message : messages) {
                if(message instanceof WarningMessage) {
                    System.out.println("[WARN] " + message.getMessage());
                } else {
                    System.out.println("[ERROR] " + message.getMessage());
                }
            }
        }
    }

    public static void main(String args[]) {
        MyTest test = new MyTest();
        test.csvValidation();
    }
}