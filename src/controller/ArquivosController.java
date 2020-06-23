package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class ArquivosController implements IArquivosController {

	public ArquivosController() {
		super();

	}

	@Override
	public void readDir(String path) throws IOException {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {

			File[] files = dir.listFiles();
			for (File f : files) {
				if (f.isFile()) {
					System.out.println("      \t" + f.getName());
				} else {
					System.out.println("<DIR>\t" + f.getName());
				}
			}

		} else {
			throw new IOException("Diretório inválido");
		}

	}

	@Override
	public boolean createFile(String path, String name, String conteudo) throws IOException {
		File dir = new File(path);
		File arq = new File(path, name);

		if (dir.exists() && dir.isDirectory()) {
			boolean existe = arq.exists();

			
			FileWriter fileWriter = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(conteudo);
			print.flush();
			print.close();
			fileWriter.close();
			return true;

		} else {
			throw new IOException("Diretório inválido");
		}

	}


	@Override
	public String readFile(String path, String name) throws IOException {
		File arq = new File(path, name);
		StringBuilder texto = new StringBuilder();
		
		if(arq.exists() && arq.isFile()) {
			
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha !=null) {
				
				texto.append(linha);
				texto.append("\r\n");
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
			return texto.toString();
			
		}else {
			throw new IOException("Diretório inválido");
		}
		

	}

	@Override
	public void openFile(String path, String name) throws IOException {
		File arq = new File(path, name);
		
		if(arq.exists() && arq.isFile()) {
			
			Desktop desktop = Desktop.getDesktop();
			desktop.open(arq);
			
		}else {
			throw new IOException("Diretório inválido");
		}

	}

}
