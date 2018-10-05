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
//	public static void done(String[] args) {
//		// TODO code application logic here
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		System.out.print("Supply ur  8 character key : ");
//		String key = null;
//
//		try {
//			key = reader.readLine();
//			Encryptor encryptor = new Encryptor(key);
//			System.out.println("key is >>" + key);
//			System.out.print("Supply engine password : ");
//			String pass = reader.readLine();
//			String encrpt = encryptor.encryptStringEncoded(pass);
//			System.out.println(encrpt);
//			System.out.println(pass);
//			reader.readLine();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
	public static void main(String[] args) {
		Console cnsl = null;
		String key = null;
		String passTest;
		String passControl;
		String pass = "";
		System.out.print("Supply ur  8 character key : ");

		try {
			cnsl = System.console();
			if (cnsl != null) {
				key = cnsl.readLine();
				Encryptor encryptor = new Encryptor(key);

				System.out.println("--------------Support Password--------------------");
				passTest = new String(cnsl.readPassword("Enter Support Password Carefully: "));
				
				System.out.println("--------------Control Password--------------------");
				passControl = new String(cnsl.readPassword("Enter Control Password Carefully: "));
				
				pass = passTest+passControl;
				
//				System.out.println("Full Password is >>"+pass);
				
				String encrpt = encryptor.encryptStringEncoded(pass);
				System.out.println(encrpt);

				cnsl.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
