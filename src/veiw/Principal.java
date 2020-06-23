package veiw;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {

		IArquivosController arqCont = new ArquivosController();

		String path = "txt/";
		String name = "relatorio.txt";
		String newName = "relatorio.csv";

		try {
			if (arqCont.createFile(path, newName, arqCont.readFile(path, name))) {

				JOptionPane.showMessageDialog(null, "Arquivo Gravado com Sucesso", "Arquivo gravado",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao Gravar o Arquivo", "Erro ao Gravar",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
