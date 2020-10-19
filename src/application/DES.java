package application;

public class DES {

    public static byte[] toHexByteArray(String self) {
        byte[] bytes = new byte[self.length() / 2];
        for (int i = 0; i < bytes.length; ++i) {
            bytes[i] = ((byte) Integer.parseInt(self.substring(i * 2, i * 2 + 2), 16));
        }
        return bytes;
    }

   public static void printHexBytes(byte[] self, String label) {
        System.out.printf("%s: ", label);
        for (byte b : self) {
            int bb = (b >= 0) ? ((int) b) : b + 256;
            String ts = Integer.toString(bb, 16);
            if (ts.length() < 2) {
                ts = "0" + ts;
            }
            System.out.print(ts);
        }
    }
}
