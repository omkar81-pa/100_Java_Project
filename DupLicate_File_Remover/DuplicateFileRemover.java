package DupLicate_File_Remover;

import java.io.*;
import java.nio.file.*;
import java.security.*;
import java.util.*;


public class DuplicateFileRemover {
	 // Returns the hash string of the given file
	public static String hashFile(String fileName)throws IOException, NoSuchAlgorithmException{
		final int BLOCKSISE = 65536;
		MessageDigest digest = MessageDigest.getInstance("MD5");
		
		try(InputStream iStream = Files.newInputStream(Paths.get(fileName))){
			byte[] buffer = new byte[BLOCKSISE];
			int bytesRead;
			
			while((bytesRead = iStream.read(buffer)) != -1) {
				digest.update(buffer, 0, bytesRead);
			}
		}
		
		//Convert the hash bytes to a hex string
		StringBuilder hash = new StringBuilder();
		for(byte b : digest.digest()) {
			hash.append(String.format("%02x", b));
		}
		return hash.toString();
	}
	public static void main(String[] args) {
		//Map to store the hash and fileName
		Map<String, String> hashMap = new HashMap<String, String>();
		
		//List to store deleted files
		List<String> deletedFiles = new ArrayList<String>();
		
		try {
			//Get the list of all files in the current directory
			File[] fileList = new File(".").listFiles(File::isFile);
			
			if(fileList != null) {
				for(File file : fileList) {
					String key = hashFile(file.getAbsolutePath());
					
					//If key already exists, delete the file
					if(hashMap.containsKey(key)) {
						deletedFiles.add(file.getName());
						Files.delete(file.toPath());
					}else {
						hashMap.put(key, file.getName());
					}
				}
			}
			
			//Print the result
			if(!deletedFiles.isEmpty()) {
				System.out.println("Deleted files:");
				for(String deletedFile : deletedFiles) {
					System.out.println(deletedFile);
				}
			}else {
				System.out.println("No duplicate files found");
			}
		}catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}
