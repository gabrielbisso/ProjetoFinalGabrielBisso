package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import modelo.Login;


public class LoginDAO {
	File Arquivo;

	public LoginDAO()
	{
		Arquivo = new File("ProjetoFinalGabrielBisso/senhas.txt");
	}
	
	public boolean autentica(Login Login)
	{
		boolean verificador = false;
		
		try {
			FileReader LeitorDoArquivo = new FileReader(Arquivo);
			BufferedReader br = new BufferedReader(LeitorDoArquivo);
			
			String linha = null;
			String[] campos = new String[2];
			
			try {
				while((linha = br.readLine())!=null)
				{
					campos = linha.split("#");
					if(campos[0].equals(Login.getUsuario()))
					{
						if(campos[1].equals(Login.getSenha()))
						{
							verificador = true;
							break;
						}
					}
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return verificador;
	}
}
