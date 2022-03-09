public class March3_Example_Table {
    public static void main(String[] args) {
        int field1 = 30;
        int field2 = 30;

        header(field1, "Dog Years", field2, "Human Years");
        for(int dogAge = 0; dogAge <= 5; dogAge++){
            tableRow(true, field1, dogAge + " Years", field2, (dogAge * 7) + " Years");
            separatorRow(field1, field2);
        }
    }
    public static void header(int field1, String title1, int field2, String title2){
        separatorRow(field1, field2);
        tableRow(true, field1, title1, field2, title2);
        separatorRow(field1, field2);
    }
    public static void tableRow(Boolean leftAligned, int field1, String value1, int field2, String value2){
        String alignment = (leftAligned == true) ? "-" : "";
        System.out.printf("| %" + alignment + field1 + "s | %" + alignment + field2 + "s |\n", value1, value2  );
    }
    public static void separatorRow(int field1, int field2) {
        field1 = field1 + 1;
        field2 = field2 + 1;
        System.out.print("+");
        for(int i = field1; i >= 0; i--){
            System.out.print("-");
        }
        System.out.print("+");
        for(int i = field2; i >= 0; i--){
            System.out.print("-");
        }
        System.out.println("+");
    }
}
