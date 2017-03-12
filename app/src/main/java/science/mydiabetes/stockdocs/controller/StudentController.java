package science.mydiabetes.stockdocs.controller;

import java.util.ArrayList;
import java.util.List;

import science.mydiabetes.stockdocs.model.Student;

/**
 * Created by sky on 10.02.2017.
 */

public class StudentController {
    public static List<Student> generateStudentsList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("ACC Ltd.", "ACC", 1467.45f));
        students.add(new Student("Adani Ports & Special Economic Zone Ltd.", "ADANIPORTS", 304.15f));
        students.add(new Student("Ambuja Cements Ltd.", "AMBUJACEM", 238.95f));
        students.add(new Student("Asian Paints Ltd.", "ASIANPAINT", 991.5f));
        students.add(new Student("Aurobindo Pharma Ltd.", "AUROPHARMA", 686.05f));
        students.add(new Student("Axis Bank Ltd.", "AXISBANK", 504.35f));
        students.add(new Student("Bajaj Auto Ltd.", "BAJAJ-AUTO", 2799.25f));
        students.add(new Student("Bank of Baroda", "BANKBARODA", 169.3f));
        students.add(new Student("Bharat Heavy Electricals Ltd.", "BHEL", 154.6f));
        students.add(new Student("Bharat Petroleum Corporation Ltd.", "BPCL", 703.95f));
        students.add(new Student("Bharti Airtel Ltd.", "BHARTIARTL", 362.85f));
        students.add(new Student("Bharti Infratel", "INFRATEL", 295.6f));
        students.add(new Student("Bosch Ltd.", "BOSCHLTD", 21732.0f));
        students.add(new Student("Cipla Ltd.", "CIPLA", 593.1f));
        students.add(new Student("Coal India Ltd", "COALINDIA", 319.6f));
        students.add(new Student("Dr. Reddy's Laboratories Ltd.", "DRREDDY", 2894.05f));
        students.add(new Student("Eicher Motors Ltd.", "EICHERMOT", 25253.5f));
        students.add(new Student("GAIL (India) Ltd.", "GAIL", 524.0f));
        students.add(new Student("Grasim Industries Ltd.", "GRASIM", 1068.3f));
        students.add(new Student("HCL Technologies Ltd.", "HCLTECH", 851.3f));
        students.add(new Student("HDFC Bank Ltd.", "HDFCBANK", 1415.55f));
        students.add(new Student("Hero MotoCorp Ltd.", "HEROMOTOCO", 3125.8f));
        students.add(new Student("Hindalco Industries Ltd.", "HINDALCO", 182.45f));
        students.add(new Student("Hindustan Unilever Ltd.", "HINDUNILVR", 862.75f));
        students.add(new Student("Housing Development Finance Corporation Ltd.", "HDFC", 1412.45f));
        students.add(new Student("I T C Ltd.", "ITC", 263.15f));
        students.add(new Student("ICICI Bank Ltd.", "ICICIBANK", 284.8f));
        students.add(new Student("Idea Cellular Ltd.", "IDEA", 108.35f));
        students.add(new Student("IndusInd Bank Ltd.", "INDUSINDBK", 1331.2f));
        students.add(new Student("Infosys Ltd.", "INFY", 1013.6f));
        students.add(new Student("Kotak Mahindra Bank Ltd.", "KOTAKBANK", 797.9f));
        students.add(new Student("Larsen & Toubro Ltd.", "LT", 1483.3f));
        students.add(new Student("Lupin Ltd.", "LUPIN", 1471.0f));
        students.add(new Student("Mahindra & Mahindra Ltd.", "M&M", 1311.65f));
        students.add(new Student("Maruti Suzuki India Ltd.", "MARUTI", 6063.15f));
        students.add(new Student("NTPC Ltd.", "NTPC", 172.5f));
        students.add(new Student("Oil & Natural Gas Corporation Ltd.", "ONGC", 196.25f));
        students.add(new Student("Power Grid Corporation of India Ltd.", "POWERGRID", 206.15f));
        students.add(new Student("Reliance Industries Ltd.", "RELIANCE", 1088.2f));
        students.add(new Student("State Bank of India", "SBIN", 270.7f));
        students.add(new Student("Sun Pharmaceutical Industries Ltd.", "SUNPHARMA", 673.2f));
        students.add(new Student("Tata Consultancy Services Ltd.", "TCS", 2465.35f));
        students.add(new Student("Tata Motors (DVR)", "TATAMTRDVR", 279.1f));
        students.add(new Student("Tata Motors Ltd.", "TATAMOTORS", 458.65f));
        students.add(new Student("Tata Power Co. Ltd.", "TATAPOWER", 84.25f));
        students.add(new Student("Tata Steel Ltd.", "TATASTEEL", 490.95f));
        students.add(new Student("Tech Mahindra Ltd.", "TECHM", 507.9f));
        students.add(new Student("UltraTech Cement Ltd.", "ULTRACEMCO", 3769.35f));
        students.add(new Student("Wipro Ltd.", "WIPRO", 475.8f));
        students.add(new Student("Yes Bank Ltd.", "YESBANK", 1449.75f));
        students.add(new Student("Zee Entertainment Enterprises Ltd.", "ZEEL", 523.25f));

        return students;
    }
}
