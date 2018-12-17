/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptionservice;

import java.io.Console;

/**
 *
 * @author aojinadu
 */
public class EncryptionService {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Console cnsl = null;
		String passTest;
		String passControl;
		String pass = "";
		String encType = "";
		System.out.println("----------Welcome to UBN DevOps Encryption Application------------");
		System.out.println();
		System.out.println("Type 1 or 2 to choose encryption type");
		System.out.println("1 - PBEncryptor");
		System.out.println("2 - EncodedEncryptor");
		try {
			cnsl = System.console();
			if (cnsl != null) {
				encType = cnsl.readLine("Encryption Algorithm: ");
				int enc = Integer.valueOf(encType);
				
				switch (enc) {
					case 1:
						System.out.println("-------PBEncryptor-------");
						System.out.println();
						try {
							PBEncrytor encryptor = new PBEncrytor();
							System.out.println("-------Support Password-------");
							passTest = new String(cnsl.readPassword("Enter Support Password Carefully: "));

							System.out.println("-------Control Password-------");
							passControl = new String(cnsl.readPassword("Enter Control Password Carefully: "));

							pass = passTest + passControl;

							//				System.out.println("Full Password is >>"+pass);
							String encrpt = encryptor.PBEncrypt(pass);
							System.out.println(encrpt);

							cnsl.readLine();
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 2:
						System.out.println("-------EncodedEncryptor-------");
						System.out.println();
						String key = "";
						try {
							key = cnsl.readLine("Supply ur  8 character key: ");
							Encryptor encryptor = new Encryptor(key);

							System.out.println("-------Support Password-------");
							passTest = new String(cnsl.readPassword("Enter Support Password Carefully: "));

							System.out.println("-------Control Password-------");
							passControl = new String(cnsl.readPassword("Enter Control Password Carefully: "));

							pass = passTest + passControl;

							//				System.out.println("Full Password is >>"+pass);
							String encrpt = encryptor.encryptStringEncoded(pass);
							System.out.println(encrpt);

							cnsl.readLine();
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					default:
						System.out.println("You can only choose 1 or 2, Kindly restart application");
						cnsl.readLine();
						break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
