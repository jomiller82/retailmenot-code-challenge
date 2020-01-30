package secondsolution;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.io.File;
import java.util.List;
import java.util.Map;

public class GetOpenSeatsForFamily {

    public static void main(String[] args) throws Exception {

        List<String> passengerList;

        DocumentContext passengerListContext = JsonPath.parse(getFileFromResourcesFolder("passengers.json"));
        Map<String, String> rows = passengerListContext.read("$.passengerList");

        for (Map.Entry<String, String> entry : rows.entrySet()) {
            final String currentRow = entry.getKey();
            int unreservedSeats = 0;
            int reservedSeats = 0;

            passengerList = passengerListContext.read(String.format("$.passengerList.%s[*]", currentRow));

            for (int i = 0; i < passengerList.size(); i++) {
                if (passengerList.get(i).equals("reserved")) reservedSeats++;
                else if (passengerList.get(i).equals("unreserved")) unreservedSeats++;
            }
            System.out.println(String.format("== %s" , currentRow));
            System.out.println(String.format("Number of unreserved seats: %d" , unreservedSeats));
            System.out.println(String.format("Number of reserved seats: %d \n" , reservedSeats));

            if (getFamilyStatus(unreservedSeats)) {
                System.out.println(String.format("Answer:  A family of four can sit on %s" , currentRow));
            }
        }
    }


    private static boolean getFamilyStatus (final int numberOfUnreservedSeats) {
        if (numberOfUnreservedSeats >= 4) return true;
        return false;
    }

    private static File getFileFromResourcesFolder (final String fileName) { return new File (GetOpenSeatsForFamily.class.getClassLoader().getResource(fileName).getFile()); }
}
