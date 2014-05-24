package com.senac.estruturas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.senac.mvc.view.CompactView;

public class ReadWriteFile {

	public static void reader(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String line = "";
		while (true) {
			if (line != null) {
				System.out.println(line);
			} else
				break;
			line = buffRead.readLine();
		}
		buffRead.close();
	}

	public static void recorder(String path, String name,String Telephone,int valida) throws IOException {

		CompactView compactView = new CompactView();
		FileWriter file = new FileWriter(path,true);
		PrintWriter recordsFile = new PrintWriter(file);
		recordsFile.printf(" Lista Telefônica  %n");
		compactView.printContato(name, Telephone);
		recordsFile.printf("%n" + "---------------------" +  "%n");
		file.close();
		System.out
		.printf("Contato Salvo com sucesso! No arquivo Contatos.txt \n");
	}
	
	
}
