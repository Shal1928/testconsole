package others;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 *
 */
public class AES
{
    public static byte[] encrypt(final byte[] keyBytes, final byte[] ivBytes, final byte[] messageBytes)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
    {
        return AES.transform(Cipher.ENCRYPT_MODE, keyBytes, ivBytes, messageBytes);
    }

    public static byte[] decrypt(final byte[] keyBytes, final byte[] ivBytes, final byte[] messageBytes)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
    {
        return AES.transform(Cipher.DECRYPT_MODE, keyBytes, ivBytes, messageBytes);
    }

    private static byte[] transform(final int mode, final byte[] keyBytes, final byte[] ivBytes,
            final byte[] messageBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
    {
        final SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        final IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        cipher.init(mode, keySpec, ivSpec);

        return cipher.doFinal(messageBytes);
    }

//    @Test
//    public void main() {
//        try {
//            final String base64Key = "ABEiM0RVZneImaq7zN3u/w==";
//            final String base64Iv = "AAECAwQFBgcICQoLDA0ODw==";
//            final String base64Message = "SGVsbG8gd29ybGQh";
//
//            //            final byte[] keyBytes = DatatypeConverter.parseBase64Binary(base64Key);
//            //            final byte[] ivBytes = DatatypeConverter.parseBase64Binary(base64Iv);
//            //            final byte[] messageBytes = DatatypeConverter.parseBase64Binary(base64Message);
//
//            final byte[] keyBytes = base64Key.getBytes();
//            final byte[] ivBytes = base64Iv.getBytes();
//            final byte[] messageBytes = base64Message.getBytes();
//
//            final byte[] encryptedBytes = AES.encrypt(keyBytes, ivBytes, messageBytes);
//            final byte[] decryptedBytes = AES.decrypt(keyBytes, ivBytes, encryptedBytes);
//
//            System.out.println("Message  : " + new String(messageBytes, "UTF-8"));
//            System.out.println("Encrypted: " + DatatypeConverter.printBase64Binary(encryptedBytes));
//            System.out.println("Decrypted: " + new String(decryptedBytes, "UTF-8"));
//        } catch (Throwable e) {
//            System.out.println(e);
//        }
//    }
}
