package view;

import controller.RedesController;
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		RedesController redeControl = new RedesController();
		String os = redeControl.os();
		
		//Fazendo o painel do JOptionPane
		String[] btns = {"IP", "Ping", "Sair"}; //botões da interface
		int opt = JOptionPane.showOptionDialog(
				null, 
				"Seu sistema operacional é o "+os+". O que deseja fazer agora?", //Mensagem 
				"Exercício de Processos 1", //Título
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.PLAIN_MESSAGE, 
				null, 
				btns,
				btns[0]);
		
		//Executa a ação de acordo com o SO
		if (opt == 0){ //exec IP
			if (os.contains("Windows")) {
				String process = "IPCONFIG";
				redeControl.readProcess(process);

				
			}else {
				String process = "IFCONFIG";
				redeControl.readProcess(process);
			}
		}
		else if (opt == 1) { //exec ping
			if (os.contains("Windows")) {
				String process = "PING -4 -n 10 www.google.com.br";
				redeControl.readProcess(process);
			}else {
				String process = "PING -4 -c 10 www.google.com.br";
				redeControl.readProcess(process);
			}
		}else {}
		
	}

}
