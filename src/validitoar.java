package utils;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class validitoar {

    // فقط عدد
    public static void allowOnlyNumbers(JTextField field) {
        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

    // فقط حروف (بدون عدد)
    public static void allowOnlyText(JTextField field) {
        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

    // چک خالی بودن
    public static boolean isEmpty(JTextField field, String message) {
        if (field.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, message);
            field.requestFocus();
            return true;
        }
        return false;
    }

    // چک فقط عدد بودن هنگام ذخیره
    public static boolean isNumeric(String value) {
        return value.matches("\\d+");
    }

    // چک نداشتن عدد در رشته
    public static boolean hasNumber(String value) {
        return value.matches(".*\\d.*");
    }
    // فقط عدد + محدودیت طول

    public static void allowOnlyNumbersWithLimit(JTextField field, int maxLength) {
        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                // اگر عدد نباشد رد شود
                if (!Character.isDigit(c)) {
                    e.consume();
                    return;
                }

                // اگر به حد مجاز رسید دیگر اجازه نده
                if (field.getText().length() >= maxLength) {
                    e.consume();
                }
            }
        });

    }
public static boolean isValidAfghanNumber(JTextField field) {

    String number = normalizeAfghanNumber(field.getText());

    if (number == null || !number.matches("\\d{10}")) {
        JOptionPane.showMessageDialog(null, "شماره باید دقیقاً 10 رقم باشد!");
        field.requestFocus();
        return false;
    }

    if (!(number.startsWith("078") ||
          number.startsWith("077") ||
          number.startsWith("076") ||
          number.startsWith("073") ||
          number.startsWith("079") ||
          number.startsWith("074"))) {

        JOptionPane.showMessageDialog(null,
                "پیش شماره معتبر نیست!\n078, 077, 076, 073, 079, 074");
        field.requestFocus();
        return false;
    }

    // اگر درست بود مقدار اصلاح شده را داخل تکسفیلد بگذار
    field.setText(number);

    return true;
}
    // نرمال سازی شماره افغانستان
public static String normalizeAfghanNumber(String input) {

    if (input == null) return null;

    // حذف سپیس و - 
    String number = input.replaceAll("[\\s-]", "");

    // اگر با +93 شروع شود
    if (number.startsWith("+93")) {
        number = "0" + number.substring(3);
    }

    // اگر با 0093 شروع شود
    if (number.startsWith("0093")) {
        number = "0" + number.substring(4);
    }

    return number;
}

public static boolean isPhoneDuplicate(Connection conn, String phone) {

    try {
        String sql = "SELECT COUNT(*) FROM Customers WHERE Phone=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, phone);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            if (rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "این شماره قبلاً ثبت شده است!");
                return true;
            }
        }

        rs.close();
        ps.close();

    } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "این شماره قبلاً ثبت شده است!");
    }

    return false;
}

 

}
