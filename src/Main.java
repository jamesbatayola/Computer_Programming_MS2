import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    // Fields
    public static String employee_hourly_rate;
    public static String employee[];

    public static void main(String[] args) {


    }

    // This method refreshed the field's data
    public static void refreshData() {
        employee_hourly_rate = "";
        employee = new String[0];
    }

    public static String getEmployeeDetails(String employee_id) {

        String file = System.getProperty("user.dir") + "/src/Employee_Details.csv";

        BufferedReader reader = null;
        String line = "";
        String employee_found = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while( (line = reader.readLine()) != null) {
                String repl = line.replaceAll(",(?!(([^\"]*\"){2})*[^\"]*$)", ";x;");
                String[] row = repl.split(",");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}