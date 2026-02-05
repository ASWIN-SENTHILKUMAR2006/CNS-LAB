import java.util.*;

public class TranspositionCipher {
    
    // Row Transposition Cipher - Encrypt
    public static String rowEncrypt(String plaintext, int numColumns) {
        plaintext = plaintext.toUpperCase().replaceAll("\\s+", "");
        int numRows = (int) Math.ceil((double) plaintext.length() / numColumns);
        char[][] matrix = new char[numRows][numColumns];
        
        // Fill matrix row by row
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (index < plaintext.length()) {
                    matrix[i][j] = plaintext.charAt(index++);
                } else {
                    matrix[i][j] = 'X';
                }
            }
        }
        
        // Read column by column
        StringBuilder ciphertext = new StringBuilder();
        for (int j = 0; j < numColumns; j++) {
            for (int i = 0; i < numRows; i++) {
                ciphertext.append(matrix[i][j]);
            }
        }
        
        return ciphertext.toString();
    }
    
    // Row Transposition Cipher - Decrypt
    public static String rowDecrypt(String ciphertext, int numColumns) {
        int totalChars = ciphertext.length();
        int numRows = totalChars / numColumns;
        char[][] matrix = new char[numRows][numColumns];
        
        // Fill matrix column by column
        int index = 0;
        for (int j = 0; j < numColumns; j++) {
            for (int i = 0; i < numRows; i++) {
                matrix[i][j] = ciphertext.charAt(index++);
            }
        }
        
        // Read row by row
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                plaintext.append(matrix[i][j]);
            }
        }
        
        return plaintext.toString();
    }
    
    // Column Transposition Cipher - Encrypt
    public static String columnEncrypt(String plaintext, int numColumns) {
        plaintext = plaintext.toUpperCase().replaceAll("\\s+", "");
        int numRows = (int) Math.ceil((double) plaintext.length() / numColumns);
        char[][] matrix = new char[numRows][numColumns];
        
        // Fill matrix row by row
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (index < plaintext.length()) {
                    matrix[i][j] = plaintext.charAt(index++);
                } else {
                    matrix[i][j] = 'X';
                }
            }
        }
        
        // Read columns in order (0, 1, 2, ... numColumns-1)
        StringBuilder ciphertext = new StringBuilder();
        for (int j = 0; j < numColumns; j++) {
            for (int i = 0; i < numRows; i++) {
                ciphertext.append(matrix[i][j]);
            }
        }
        
        return ciphertext.toString();
    }
    
    // Column Transposition Cipher - Decrypt
    public static String columnDecrypt(String ciphertext, int numColumns) {
        int totalChars = ciphertext.length();
        int numRows = totalChars / numColumns;
        char[][] matrix = new char[numRows][numColumns];
        
        // Fill matrix column by column
        int index = 0;
        for (int j = 0; j < numColumns; j++) {
            for (int i = 0; i < numRows; i++) {
                matrix[i][j] = ciphertext.charAt(index++);
            }
        }
        
        // Read row by row
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                plaintext.append(matrix[i][j]);
            }
        }
        
        return plaintext.toString();
    }

    // System.out.println("\n=== COLUMN TRANSPOSITION CIPHER ===");
    //     String colEncrypted = columnEncrypt(message, numColumns);
    //     System.out.println("Encrypted text: " + colEncrypted);
        
    //     String colDecrypted = columnDecrypt(colEncrypted, numColumns);
    //     System.out.println("Decrypted text: " + colDecrypted);
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter message: ");
        String message = sc.nextLine();
        
        System.out.print("Enter number of columns: ");
        int numColumns = sc.nextInt();
        
       // System.out.println("\n=== ROW TRANSPOSITION CIPHER ===");
        String rowEncrypted = rowEncrypt(message, numColumns);
        System.out.println("Encrypted : " + rowEncrypted);
        
        String rowDecrypted = rowDecrypt(rowEncrypted, numColumns);
        System.out.println("Decrypted : " + rowDecrypted);
        
        
        
        sc.close();
    }
}