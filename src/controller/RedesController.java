package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() {
		super();
	}
	
	//Retornar o S0 que está na máquina
	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void callProcess(String process) { //chama o processo
		//tratamento de erros
		try {
			Runtime.getRuntime().exec(process);
		} catch (Exception e) {
			String msgErro = e.getMessage();
			if (msgErro.contains("740")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(process);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else {
				System.err.println(msgErro);
			}
		}
	}
	
	public void readProcess(String process) { //lê o que tem no processo
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream(); //pega o fluxo de bits que vem do processo
			InputStreamReader leitor = new InputStreamReader(fluxo); //transformar em string
			BufferedReader buffer = new BufferedReader(leitor); //armazeno em um buffer
			String linha = buffer.readLine(); //lê o buffer
			while (linha != null) { //lê o buffer enquanto tiver alguma coisa na linha
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
