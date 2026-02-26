
import java.net.NetworkInterface;
import java.util.Collections;

public class Fingerprintutil {

    public static String generateFingerprint() {
        StringBuilder data = new StringBuilder();

        try {
            for (NetworkInterface ni :
                    Collections.list(NetworkInterface.getNetworkInterfaces())) {

                byte[] mac = ni.getHardwareAddress();
                if (mac != null) {
                    for (byte b : mac) {
                        data.append(String.format("%02X", b));
                    }
                }
            }
        } catch (Exception ignored) {}

        data.append(System.getProperty("os.name"));
        data.append(System.getProperty("os.arch"));
        data.append(System.getProperty("user.name"));

        return HashUtill.sha256(data.toString());
    }
    public static void main(String[] args) {
        
    }
}