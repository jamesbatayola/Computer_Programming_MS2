import java.io.*;
import java.util.Arrays;

public class Main {

    // Fields
    public static String employeeHourlyRate;
    public static String employee[];

    public static int WEEKS_IN_MONTH = 4;
    public static int DAYS_IN_WEEK = 7;

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
                // This will convert remove comma within each index
                String employeeData = line.replaceAll(",(?!(([^\"]*\"){2})*[^\"]*$)", ";x;");
                String[] employeeDataArray = employeeData.split(",");

                System.out.println(employeeData);
                System.out.println("Employee name : " + employeeDataArray[1]);
                System.out.println(employeeDataArray[13].replace(";x;", ",").replace("\"", ""));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return employeeSearched;
    }

    public static void defineDataType() {
        refreshData();
        System.out.println("Enter employee number : ");

        var inputReader = new BufferedReader(new InputStreamReader(System.in));

        try {

            String userInput = inputReader.readLine();
            String employeeDetail = getEmployeeDetails(userInput);

            if(!employeeDetail.equals("")) {
                String[] row = employeeDetail.split(", ");
                employee = row;
                employeeHourlyRate = row[18];
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}