import java.io.*;
import java.util.Arrays;

public class Main {

    // Fields
    public static String employeeHourlyRate;
    public static String employee[];

    public static void main(String[] args) {
        System.out.println(getEmployeeDetails("1"));
    }

    // This method refreshed the field's data
    public static void refreshData() {
        employeeHourlyRate = "";
        employee = new String[0];
    }

    // This method fetch the employee details
    public static String getEmployeeDetails(String id) {

        // locate the path of csv file
        String file = System.getProperty("user.dir") + "/src/employee_details.csv";

        BufferedReader reader = null;
        String line = "";
        String employeeSearched = "";

        try {
            reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null) {
                String repl = line.replaceAll(",(?!(([^\"]*\"){2})*[^\"]*$)", ";x;");
                String[] row = repl.split(",");
                System.out.println(Arrays.toString(row));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return employeeSearched;
    }
}