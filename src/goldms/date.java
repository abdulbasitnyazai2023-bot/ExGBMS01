import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;

public class date {

    public static String getUniqueId() {
        try {
            // ترکیب سریال مادربورد و پردازنده
            String rawId = getWindowsIdentifier("wmic baseboard get serialnumber")+getWindowsIdentifier("wmic cpu get processorid");
           
            // تبدیل به هش SHA-256 برای داشتن یک کد استاندارد و غیرقابل بازگشت
            MessageDigest salt = MessageDigest.getInstance("SHA-256");
            salt.update(rawId.getBytes("UTF-8"));
            byte[] digest = salt.digest();
           
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString().substring(0, 16).toUpperCase(); // بازگرداندن 16 کاراکتر اول
           
        } catch (Exception e) {
            return "FALLBACK_ID_12345"; // در صورت خطا یک کد پیش‌فرض
        }
    }

    private static String getWindowsIdentifier(String command) throws Exception {
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        reader.readLine(); // خط اول معمولاً تیتر است
        String line = reader.readLine();
        process.waitFor();
        return (line != null) ? line.trim() : "";
    }

    public static void main(String[] args) {
        System.out.println("Hardware ID این سیستم: " + getUniqueId());
    }
}