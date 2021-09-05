package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.GrupoAPI;
import me.viitor.configuração.cfGrupo;

public class TempGroupSetCommand implements CommandExecutor{
	
	private boolean CheckarNumero(String Numero){
		try {
			Integer.parseInt(Numero);
			return true;
		} catch(NumberFormatException e){
			return false;
		}
	}
	
	String erro = "§7(§4!§7) ";
	String sucesso = "§7(§2!§7) ";
	
	
	
	
	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {

		
		if(!(Sender instanceof Player)){
		if(Args.length == 0){
			Sender.sendMessage("§7Use: /TempGroupSet [Nick] [Grupo] [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		Player t = Bukkit.getPlayer(Args[0]);
		
		
		if(t == null){
			OfflinePlayer targetoff = Bukkit.getOfflinePlayer(Args[0]);
		if (Args.length == 1) {
			Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " [Grupo] [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		
		if(Args[1].equalsIgnoreCase("pro")){
		if (Args.length == 2) {
			Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[2])) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Dia = Integer.parseInt(Args[2]);
		if (Dia >= 31 || Dia <= 0) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		if (Args.length == 3) {
			Sender.sendMessage("§7Argumentos Insuficientes");
			Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[3])) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Mes = Integer.parseInt(Args[3]);
		if (Mes > 12 || Mes <= 0) {
			return true;
		}
		if (Args.length == 4) {
			Sender.sendMessage("Argumentos Insuficientes!");
			Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[4])) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Ano = Integer.parseInt(Args[4]);
		if (Ano < 2016) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números maior ou igual a 2016");
			return true;
		}
		if (Args.length == 5) {
			Sender.sendMessage("Argumentos Insuficientes!");
			Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[5])) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Horas = Integer.parseInt(Args[5]);
		if (Horas < 0 || Horas > 23) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números de  0 há 23");
			return true;
		}
		if (Args.length == 6) {
			Sender.sendMessage("Argumentos Insuficientes!");
			Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[6])) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Minutos = Integer.parseInt(Args[6]);
		if (Minutos <= 0 || Minutos > 59) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		if (Args.length == 7) {
			Sender.sendMessage("Argumentos Insuficientes!");
			Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[7])) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Segundos = Integer.parseInt(Args[7]);
		if (Segundos <= 0 || Segundos > 59) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		Sender.sendMessage(sucesso + "§7Você deu Vip §6(" + Args[1] + ") §7para o §6" + targetoff.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
			cfGrupo.setarGrupo(targetoff, "Pro");
			GrupoAPI.expirarOffline(targetoff, Dia, Mes, Ano, Horas, Minutos, Segundos);
			GrupoAPI.checarVipOffline(targetoff);
			return true;
		}
		else if(Args[1].equalsIgnoreCase("mvp")){
		if (Args.length == 2) {
			Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[2])) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Dia = Integer.parseInt(Args[2]);
		if (Dia >= 31 || Dia <= 0) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		if (Args.length == 3) {
			Sender.sendMessage("§7Argumentos Insuficientes");
			Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[3])) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Mes = Integer.parseInt(Args[3]);
		if (Mes > 12 || Mes <= 0) {
			return true;
		}
		if (Args.length == 4) {
			Sender.sendMessage("Argumentos Insuficientes!");
			Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[4])) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Ano = Integer.parseInt(Args[4]);
		if (Ano < 2016) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números maior ou igual a 2016");
			return true;
		}
		if (Args.length == 5) {
			Sender.sendMessage("Argumentos Insuficientes!");
			Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[5])) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Horas = Integer.parseInt(Args[5]);
		if (Horas < 0 || Horas > 23) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números de  0 há 23");
			return true;
		}
		if (Args.length == 6) {
			Sender.sendMessage("Argumentos Insuficientes!");
			Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[6])) {
		 	Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Minutos = Integer.parseInt(Args[6]);
		if (Minutos <= 0 || Minutos > 59) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		if (Args.length == 7) {
			Sender.sendMessage("Argumentos Insuficientes!");
			Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[7])) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Segundos = Integer.parseInt(Args[7]);
		if (Segundos <= 0 || Segundos > 59) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		Sender.sendMessage(sucesso + "§7Você deu Vip §6(" + Args[1] + ") §7para o §6" + targetoff.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
			cfGrupo.setarGrupo(targetoff, "Mvp");
			GrupoAPI.expirarOffline(targetoff, Dia, Mes, Ano, Horas, Minutos, Segundos);
			GrupoAPI.checarVipOffline(targetoff);
			return true;
		}
		if(Args[1].equalsIgnoreCase("light")){
		if (Args.length == 2) {
			Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[2])) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Dia = Integer.parseInt(Args[2]);
		if (Dia >= 31 || Dia <= 0) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		if (Args.length == 3) {
			Sender.sendMessage("§7Argumentos Insuficientes");
			Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[3])) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Mes = Integer.parseInt(Args[3]);
		if (Mes > 12 || Mes <= 0) {
			return true;
		}
		if (Args.length == 4) {
			Sender.sendMessage("Argumentos Insuficientes!");
			Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[4])) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Ano = Integer.parseInt(Args[4]);
		if (Ano < 2016) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números maior ou igual a 2016");
			return true;
		}
		if (Args.length == 5) {
			Sender.sendMessage("Argumentos Insuficientes!");
			Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[5])) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Horas = Integer.parseInt(Args[5]);
		if (Horas < 0 || Horas > 23) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números de  0 há 23");
			return true;
		}
		if (Args.length == 6) {
			Sender.sendMessage("Argumentos Insuficientes!");
			Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[6])) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Minutos = Integer.parseInt(Args[6]);
		if (Minutos <= 0 || Minutos > 59) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		if (Args.length == 7) {
			Sender.sendMessage("Argumentos Insuficientes!");
			Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[7])) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Segundos = Integer.parseInt(Args[7]);
		if (Segundos <= 0 || Segundos > 59) {
			Sender.sendMessage("§7Argumento Errado");
			Sender.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		Sender.sendMessage(sucesso + "§7Você deu Vip §6(" + Args[1] + ") §7para o  §6" +targetoff.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
			cfGrupo.setarGrupo(targetoff, "Light");
			GrupoAPI.expirarOffline(targetoff, Dia, Mes, Ano, Horas, Minutos, Segundos);
			GrupoAPI.checarVipOffline(targetoff);
			return true;
		}
		if(Args[1].equalsIgnoreCase("yt")){
			if (Args.length == 2) {
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[2])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Dia = Integer.parseInt(Args[2]);
			if (Dia >= 31 || Dia <= 0) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			if (Args.length == 3) {
				Sender.sendMessage("§7Argumentos Insuficientes");
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[3])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Mes = Integer.parseInt(Args[3]);
			if (Mes > 12 || Mes <= 0) {
				return true;
			}
			if (Args.length == 4) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[4])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Ano = Integer.parseInt(Args[4]);
			if (Ano < 2016) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números maior ou igual a 2016");
				return true;
			}
			if (Args.length == 5) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[5])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Horas = Integer.parseInt(Args[5]);
			if (Horas < 0 || Horas > 23) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  0 há 23");
				return true;
			}
			if (Args.length == 6) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[6])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Minutos = Integer.parseInt(Args[6]);
			if (Minutos <= 0 || Minutos > 59) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  1  há 59");
				return true;
			}
			if (Args.length == 7) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[7])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Segundos = Integer.parseInt(Args[7]);
			if (Segundos <= 0 || Segundos > 59) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  1  há 59");
				return true;
			}
			Sender.sendMessage(sucesso + "§7Você deu o grupo §6(" + Args[1] + ") §7para o §6" + targetoff.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
				cfGrupo.setarGrupo(targetoff, "Youtuber");
				GrupoAPI.expirarOffline(targetoff, Dia, Mes, Ano, Horas, Minutos, Segundos);
				GrupoAPI.checarVipOffline(targetoff);
				return true;
			}
		if(Args[1].equalsIgnoreCase("builder")){
			if (Args.length == 2) {
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[2])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Dia = Integer.parseInt(Args[2]);
			if (Dia >= 31 || Dia <= 0) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			if (Args.length == 3) {
				Sender.sendMessage("§7Argumentos Insuficientes");
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[3])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Mes = Integer.parseInt(Args[3]);
			if (Mes > 12 || Mes <= 0) {
				return true;
			}
			if (Args.length == 4) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[4])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Ano = Integer.parseInt(Args[4]);
			if (Ano < 2016) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números maior ou igual a 2016");
				return true;
			}
			if (Args.length == 5) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[5])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Horas = Integer.parseInt(Args[5]);
			if (Horas < 0 || Horas > 23) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  0 há 23");
				return true;
			}
			if (Args.length == 6) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[6])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Minutos = Integer.parseInt(Args[6]);
			if (Minutos <= 0 || Minutos > 59) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  1  há 59");
				return true;
			}
			if (Args.length == 7) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[7])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Segundos = Integer.parseInt(Args[7]);
			if (Segundos <= 0 || Segundos > 59) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  1  há 59");
				return true;
			}
			Sender.sendMessage(sucesso + "§7Você deu o grupo §6(" + Args[1] + ") §7para o §6" + targetoff.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
				cfGrupo.setarGrupo(targetoff, "Builder");
				GrupoAPI.expirarOffline(targetoff, Dia, Mes, Ano, Horas, Minutos, Segundos);
				GrupoAPI.checarVipOffline(targetoff);
				return true;
			}
		Sender.sendMessage("§7Você só pode usar os grupos §6§lPRO §7| §9§lMVP §7| §a§lLIGHT §7| §b§lYOUTUBER §7| §e§lBUILDER");
					}
				}
		if(!(Sender instanceof Player)){
			if(Args.length == 0){
				Sender.sendMessage("§7Use: /TempGroupSet [Nick] [Grupo] [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			Player t = Bukkit.getPlayer(Args[0]);
			
			if(t != null){
			if (Args.length == 1) {
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " [Grupo] [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			
			if(Args[1].equalsIgnoreCase("yt")){
			if (Args.length == 2) {
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[2])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Dia = Integer.parseInt(Args[2]);
			if (Dia >= 31 || Dia <= 0) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			if (Args.length == 3) {
				Sender.sendMessage("§7Argumentos Insuficientes");
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[3])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Mes = Integer.parseInt(Args[3]);
			if (Mes > 12 || Mes <= 0) {
				return true;
			}
			if (Args.length == 4) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[4])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Ano = Integer.parseInt(Args[4]);
			if (Ano < 2016) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números maior ou igual a 2016");
				return true;
			}
			if (Args.length == 5) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[5])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Horas = Integer.parseInt(Args[5]);
			if (Horas < 0 || Horas > 23) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  0 há 23");
				return true;
			}
			if (Args.length == 6) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[6])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Minutos = Integer.parseInt(Args[6]);
			if (Minutos <= 0 || Minutos > 59) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  1  há 59");
				return true;
			}
			if (Args.length == 7) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[7])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Segundos = Integer.parseInt(Args[7]);
			if (Segundos <= 0 || Segundos > 59) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  1  há 59");
				return true;
			}
			if(t != null || ((t instanceof Player))){
			Sender.sendMessage(sucesso + "§7Você deu o grupo §6(" + Args[1] + ") §7para o §6" + t.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
				t.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo temporario foi setado para (§6" + Args[1] + "§7). Ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
				cfGrupo.setarGrupo(t, "Youtuber");
				GrupoAPI.expirar(t, Dia, Mes, Ano, Horas, Minutos, Segundos);
				GrupoAPI.checarVip(t);
				return true;
			}
		}
			if(Args[1].equalsIgnoreCase("builder")){
			if (Args.length == 2) {
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[2])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Dia = Integer.parseInt(Args[2]);
			if (Dia >= 31 || Dia <= 0) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			if (Args.length == 3) {
				Sender.sendMessage("§7Argumentos Insuficientes");
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[3])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Mes = Integer.parseInt(Args[3]);
			if (Mes > 12 || Mes <= 0) {
				return true;
			}
			if (Args.length == 4) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[4])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Ano = Integer.parseInt(Args[4]);
			if (Ano < 2016) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números maior ou igual a 2016");
				return true;
			}
			if (Args.length == 5) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[5])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Horas = Integer.parseInt(Args[5]);
			if (Horas < 0 || Horas > 23) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  0 há 23");
				return true;
			}
			if (Args.length == 6) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[6])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Minutos = Integer.parseInt(Args[6]);
			if (Minutos <= 0 || Minutos > 59) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  1  há 59");
				return true;
			}
			if (Args.length == 7) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[7])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Segundos = Integer.parseInt(Args[7]);
			if (Segundos <= 0 || Segundos > 59) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  1  há 59");
				return true;
			}
			if(t != null || ((t instanceof Player))){
			Sender.sendMessage(sucesso + "§7Você deu o grupo §6(" + Args[1] + ") §7para o §6" + t.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
				t.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo temporario foi setado para (§6" + Args[1] + "§7). Ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
				cfGrupo.setarGrupo(t, "Builder");
				GrupoAPI.expirar(t, Dia, Mes, Ano, Horas, Minutos, Segundos);
				GrupoAPI.checarVip(t);
				return true;
			}
		}
			if(Args[1].equalsIgnoreCase("pro")){
			if (Args.length == 2) {
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[2])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Dia = Integer.parseInt(Args[2]);
			if (Dia >= 31 || Dia <= 0) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			if (Args.length == 3) {
				Sender.sendMessage("§7Argumentos Insuficientes");
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[3])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Mes = Integer.parseInt(Args[3]);
			if (Mes > 12 || Mes <= 0) {
				return true;
			}
			if (Args.length == 4) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[4])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Ano = Integer.parseInt(Args[4]);
			if (Ano < 2016) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números maior ou igual a 2016");
				return true;
			}
			if (Args.length == 5) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[5])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Horas = Integer.parseInt(Args[5]);
			if (Horas < 0 || Horas > 23) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  0 há 23");
				return true;
			}
			if (Args.length == 6) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[6])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Minutos = Integer.parseInt(Args[6]);
			if (Minutos <= 0 || Minutos > 59) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  1  há 59");
				return true;
			}
			if (Args.length == 7) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[7])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Segundos = Integer.parseInt(Args[7]);
			if (Segundos <= 0 || Segundos > 59) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  1  há 59");
				return true;
			}
			if(t != null || ((t instanceof Player))){
			Sender.sendMessage(sucesso + "§7Você deu Vip §6(" + Args[1] + ") §7para o §6" + t.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
				t.sendMessage("§6§lNew§f§lPvP §6» §7Você recebeu o VIP (§6" + Args[1] + "§7). Ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
				cfGrupo.setarGrupo(t, "Pro");
				GrupoAPI.expirar(t, Dia, Mes, Ano, Horas, Minutos, Segundos);
				GrupoAPI.checarVip(t);
				return true;
			}
		}
			else if(Args[1].equalsIgnoreCase("mvp")){
			if (Args.length == 2) {
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[2])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Dia = Integer.parseInt(Args[2]);
			if (Dia >= 31 || Dia <= 0) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			if (Args.length == 3) {
				Sender.sendMessage("§7Argumentos Insuficientes");
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[3])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Mes = Integer.parseInt(Args[3]);
			if (Mes > 12 || Mes <= 0) {
				return true;
			}
			if (Args.length == 4) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[4])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Ano = Integer.parseInt(Args[4]);
			if (Ano < 2016) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números maior ou igual a 2016");
				return true;
			}
			if (Args.length == 5) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[5])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Horas = Integer.parseInt(Args[5]);
			if (Horas < 0 || Horas > 23) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  0 há 23");
				return true;
			}
			if (Args.length == 6) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[6])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Minutos = Integer.parseInt(Args[6]);
			if (Minutos <= 0 || Minutos > 59) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  1  há 59");
				return true;
			}
			if (Args.length == 7) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[7])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Segundos = Integer.parseInt(Args[7]);
			if (Segundos <= 0 || Segundos > 59) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  1  há 59");
				return true;
			}
			Sender.sendMessage(sucesso + "§7Você deu Vip §6(" + Args[1] + ") §7para o §6" + t.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
				t.sendMessage("§6§lNew§f§lPvP §6» §7Você recebeu o VIP (§6" + Args[1] + "§7). Ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
				cfGrupo.setarGrupo(t, "Mvp");
				GrupoAPI.expirar(t, Dia, Mes, Ano, Horas, Minutos, Segundos);
				GrupoAPI.checarVip(t);
				return true;
			}
			if(Args[1].equalsIgnoreCase("light")){
			if (Args.length == 2) {
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[2])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Dia = Integer.parseInt(Args[2]);
			if (Dia >= 31 || Dia <= 0) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			if (Args.length == 3) {
				Sender.sendMessage("§7Argumentos Insuficientes");
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[3])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Mes = Integer.parseInt(Args[3]);
			if (Mes > 12 || Mes <= 0) {
				return true;
			}
			if (Args.length == 4) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[4])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Ano = Integer.parseInt(Args[4]);
			if (Ano < 2016) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números maior ou igual a 2016");
				return true;
			}
			if (Args.length == 5) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[5])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Horas = Integer.parseInt(Args[5]);
			if (Horas < 0 || Horas > 23) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  0 há 23");
				return true;
			}
			if (Args.length == 6) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[6])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Minutos = Integer.parseInt(Args[6]);
			if (Minutos <= 0 || Minutos > 59) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  1  há 59");
				return true;
			}
			if (Args.length == 7) {
				Sender.sendMessage("Argumentos Insuficientes!");
				Sender.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
				return true;
			}
			if (!CheckarNumero(Args[7])) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números!");
				return true;
			}
			Integer Segundos = Integer.parseInt(Args[7]);
			if (Segundos <= 0 || Segundos > 59) {
				Sender.sendMessage("§7Argumento Errado");
				Sender.sendMessage("§7Você só pode usar números de  1  há 59");
				return true;
			}
			Sender.sendMessage(sucesso + "§7Você deu Vip §6(" + Args[1] + ") §7para o  §6" + t.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
				cfGrupo.setarGrupo(t, "Light");
				GrupoAPI.expirar(t, Dia, Mes, Ano, Horas, Minutos, Segundos);
				GrupoAPI.checarVip(t);
				t.sendMessage("§6§lNew§f§lPvP §6» §7Você recebeu o VIP (§6" + Args[1] + "§7). Ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
				return true;
			}
			Sender.sendMessage("§7Você só pode usar os grupos §6§lPRO §7| §9§lMVP §7| §a§lLIGHT");
						}
					}
		
		Player p = (Player)Sender;
		
		if(Sender instanceof Player){
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
	
			///////////////////////////////////////////
		if(Sender instanceof Player){
		if(Args.length == 0){
			p.sendMessage("§7Use: /TempGroupSet [Nick] [Grupo] [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		Player target = Bukkit.getPlayer(Args[0]);
		
		if(target != null){
		if (Args.length == 1) {
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " [Grupo] [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if(Args[1].equalsIgnoreCase("builder")){
		if (Args.length == 2) {
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[2])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Dia = Integer.parseInt(Args[2]);
		if (Dia >= 31 || Dia <= 0) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		if (Args.length == 3) {
			p.sendMessage("§7Argumentos Insuficientes");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[3])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Mes = Integer.parseInt(Args[3]);
		if (Mes > 12 || Mes <= 0) {
			return true;
		}
		if (Args.length == 4) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[4])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Ano = Integer.parseInt(Args[4]);
		if (Ano < 2016) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números maior ou igual a 2016");
			return true;
		}
		if (Args.length == 5) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[5])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Horas = Integer.parseInt(Args[5]);
		if (Horas < 0 || Horas > 23) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  0 há 23");
			return true;
		}
		if (Args.length == 6) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[6])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Minutos = Integer.parseInt(Args[6]);
		if (Minutos <= 0 || Minutos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		if (Args.length == 7) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[7])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Segundos = Integer.parseInt(Args[7]);
		if (Segundos <= 0 || Segundos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		Player t = Bukkit.getPlayer(Args[0]);
		if(t == null){
			p.sendMessage("§7Player não online.");
			return true;
		}
			p.sendMessage("§7Você deu o grupo §6(" + Args[1] + ") §7para o §6" + t.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
			t.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo temporario foi setado para (§6" + Args[1] + "§7). Ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
			cfGrupo.setarGrupo(t, "Builder");
			GrupoAPI.expirar(t, Dia, Mes, Ano, Horas, Minutos, Segundos);
			GrupoAPI.checarVip(t);
			return true;
		}
		if(Args[1].equalsIgnoreCase("yt")){
		if (Args.length == 2) {
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[2])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Dia = Integer.parseInt(Args[2]);
		if (Dia >= 31 || Dia <= 0) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		if (Args.length == 3) {
			p.sendMessage("§7Argumentos Insuficientes");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[3])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Mes = Integer.parseInt(Args[3]);
		if (Mes > 12 || Mes <= 0) {
			return true;
		}
		if (Args.length == 4) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[4])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Ano = Integer.parseInt(Args[4]);
		if (Ano < 2016) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números maior ou igual a 2016");
			return true;
		}
		if (Args.length == 5) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[5])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Horas = Integer.parseInt(Args[5]);
		if (Horas < 0 || Horas > 23) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  0 há 23");
			return true;
		}
		if (Args.length == 6) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[6])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Minutos = Integer.parseInt(Args[6]);
		if (Minutos <= 0 || Minutos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		if (Args.length == 7) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[7])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Segundos = Integer.parseInt(Args[7]);
		if (Segundos <= 0 || Segundos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		Player t = Bukkit.getPlayer(Args[0]);
		if(t == null){
			p.sendMessage("§7Player não online.");
			return true;
		}
			p.sendMessage("§7Você deu o grupo §6(" + Args[1] + ") §7para o §6" + t.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
			t.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo temporario foi setado para (§6" + Args[1] + "§7). Ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
			cfGrupo.setarGrupo(t, "Youtuber");
			GrupoAPI.expirar(t, Dia, Mes, Ano, Horas, Minutos, Segundos);
			GrupoAPI.checarVip(t);
			return true;
		}
		if(Args[1].equalsIgnoreCase("pro")){
		if (Args.length == 2) {
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[2])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Dia = Integer.parseInt(Args[2]);
		if (Dia >= 31 || Dia <= 0) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		if (Args.length == 3) {
			p.sendMessage("§7Argumentos Insuficientes");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[3])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Mes = Integer.parseInt(Args[3]);
		if (Mes > 12 || Mes <= 0) {
			return true;
		}
		if (Args.length == 4) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[4])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Ano = Integer.parseInt(Args[4]);
		if (Ano < 2016) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números maior ou igual a 2016");
			return true;
		}
		if (Args.length == 5) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[5])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Horas = Integer.parseInt(Args[5]);
		if (Horas < 0 || Horas > 23) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  0 há 23");
			return true;
		}
		if (Args.length == 6) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[6])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Minutos = Integer.parseInt(Args[6]);
		if (Minutos <= 0 || Minutos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		if (Args.length == 7) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[7])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Segundos = Integer.parseInt(Args[7]);
		if (Segundos <= 0 || Segundos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		Player t = Bukkit.getPlayer(Args[0]);
		if(t == null){
			p.sendMessage("§7Player não online.");
			return true;
		}
			p.sendMessage("§7Você deu Vip §6(" + Args[1] + ") §7para o §6" + t.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
			t.sendMessage("§6§lNew§f§lPvP §6» §7Você recebeu o VIP (§6" + Args[1] + "§7). Ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
			cfGrupo.setarGrupo(t, "Pro");
			GrupoAPI.expirar(t, Dia, Mes, Ano, Horas, Minutos, Segundos);
			GrupoAPI.checarVip(t);
			return true;
		}
		else if(Args[1].equalsIgnoreCase("mvp")){
		if (Args.length == 2) {
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[2])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Dia = Integer.parseInt(Args[2]);
		if (Dia >= 31 || Dia <= 0) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		if (Args.length == 3) {
			p.sendMessage("§7Argumentos Insuficientes");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[3])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Mes = Integer.parseInt(Args[3]);
		if (Mes > 12 || Mes <= 0) {
			return true;
		}
		if (Args.length == 4) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[4])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Ano = Integer.parseInt(Args[4]);
		if (Ano < 2016) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números maior ou igual a 2016");
			return true;
		}
		if (Args.length == 5) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[5])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Horas = Integer.parseInt(Args[5]);
		if (Horas < 0 || Horas > 23) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  0 há 23");
			return true;
		}
		if (Args.length == 6) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[6])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Minutos = Integer.parseInt(Args[6]);
		if (Minutos <= 0 || Minutos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		if (Args.length == 7) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[7])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Segundos = Integer.parseInt(Args[7]);
		if (Segundos <= 0 || Segundos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		Player t = Bukkit.getPlayer(Args[0]);
		if(t == null){
			p.sendMessage("§7Player não online.");
			return true;
		}
			p.sendMessage(sucesso + "§7Você deu Vip §6(" + Args[1] + ") §7para o §6" + t.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
			t.sendMessage("§6§lNew§f§lPvP §6» §7Você recebeu o VIP (§6" + Args[1] + "§7). Ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
			cfGrupo.setarGrupo(t, "Mvp");
			GrupoAPI.expirar(t, Dia, Mes, Ano, Horas, Minutos, Segundos);
			GrupoAPI.checarVip(t);
			return true;
		}
		if(Args[1].equalsIgnoreCase("light")){
		if (Args.length == 2) {
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[2])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Dia = Integer.parseInt(Args[2]);
		if (Dia >= 31 || Dia <= 0) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		if (Args.length == 3) {
			p.sendMessage("§7Argumentos Insuficientes");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[3])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Mes = Integer.parseInt(Args[3]);
		if (Mes > 12 || Mes <= 0) {
			return true;
		}
		if (Args.length == 4) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[4])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Ano = Integer.parseInt(Args[4]);
		if (Ano < 2016) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números maior ou igual a 2016");
			return true;
		}
		if (Args.length == 5) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[5])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Horas = Integer.parseInt(Args[5]);
		if (Horas < 0 || Horas > 23) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  0 há 23");
			return true;
		}
		if (Args.length == 6) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[6])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Minutos = Integer.parseInt(Args[6]);
		if (Minutos <= 0 || Minutos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		if (Args.length == 7) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[7])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Segundos = Integer.parseInt(Args[7]);
		if (Segundos <= 0 || Segundos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		Player t = Bukkit.getPlayer(Args[0]);
		if(t == null){
			p.sendMessage("§7Player não online.");
			return true;
		}
			p.sendMessage("§7Você deu Vip §6(" + Args[1] + ") §7para o  §6" + t.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
			cfGrupo.setarGrupo(t, "Light");
			GrupoAPI.expirar(t, Dia, Mes, Ano, Horas, Minutos, Segundos);
			GrupoAPI.checarVip(t);
			t.sendMessage("§6§lNew§f§lPvP §6» §7Você recebeu o VIP (§6" + Args[1] + "§7). Ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
			return true;
		}
			p.sendMessage("§7Você só pode usar os grupos §6§lPRO §7| §9§lMVP §7| §a§lLIGHT");
					}
				}
		
		
		///////////////////////////////////////////
		
		
		
		if(Sender instanceof Player){
		if(Args.length == 0){
			p.sendMessage("§7Use: /TempGroupSet [Nick] [Grupo] [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		Player t = Bukkit.getPlayer(Args[0]);
		
		
		if(t == null){
			OfflinePlayer targetoff = Bukkit.getOfflinePlayer(Args[0]);
		if (Args.length == 1) {
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " [Grupo] [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if(Args[1].equalsIgnoreCase("yt")){
		if (Args.length == 2) {
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[2])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Dia = Integer.parseInt(Args[2]);
		if (Dia >= 31 || Dia <= 0) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		if (Args.length == 3) {
			p.sendMessage("§7Argumentos Insuficientes");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[3])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Mes = Integer.parseInt(Args[3]);
		if (Mes > 12 || Mes <= 0) {
			return true;
		}
		if (Args.length == 4) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[4])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Ano = Integer.parseInt(Args[4]);
		if (Ano < 2016) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números maior ou igual a 2016");
			return true;
		}
		if (Args.length == 5) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[5])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Horas = Integer.parseInt(Args[5]);
		if (Horas < 0 || Horas > 23) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  0 há 23");
			return true;
		}
		if (Args.length == 6) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[6])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Minutos = Integer.parseInt(Args[6]);
		if (Minutos <= 0 || Minutos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		if (Args.length == 7) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[7])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Segundos = Integer.parseInt(Args[7]);
		if (Segundos <= 0 || Segundos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
			p.sendMessage(sucesso + "§7Você deu o grupo §6(" + Args[1] + ") §7para o §6" + targetoff.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
			cfGrupo.setarGrupo(targetoff, "Youtuber");
			GrupoAPI.expirarOffline(targetoff, Dia, Mes, Ano, Horas, Minutos, Segundos);
			GrupoAPI.checarVipOffline(targetoff);
			return true;
		}
		if(Args[1].equalsIgnoreCase("builder")){
		if (Args.length == 2) {
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[2])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Dia = Integer.parseInt(Args[2]);
		if (Dia >= 31 || Dia <= 0) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		if (Args.length == 3) {
			p.sendMessage("§7Argumentos Insuficientes");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[3])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Mes = Integer.parseInt(Args[3]);
		if (Mes > 12 || Mes <= 0) {
			return true;
		}
		if (Args.length == 4) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[4])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Ano = Integer.parseInt(Args[4]);
		if (Ano < 2016) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números maior ou igual a 2016");
			return true;
		}
		if (Args.length == 5) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[5])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Horas = Integer.parseInt(Args[5]);
		if (Horas < 0 || Horas > 23) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  0 há 23");
			return true;
		}
		if (Args.length == 6) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[6])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Minutos = Integer.parseInt(Args[6]);
		if (Minutos <= 0 || Minutos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		if (Args.length == 7) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[7])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Segundos = Integer.parseInt(Args[7]);
		if (Segundos <= 0 || Segundos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
			p.sendMessage(sucesso + "§7Você deu o grupo §6(" + Args[1] + ") §7para o §6" + targetoff.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
			cfGrupo.setarGrupo(targetoff, "Builder");
			GrupoAPI.expirarOffline(targetoff, Dia, Mes, Ano, Horas, Minutos, Segundos);
			GrupoAPI.checarVipOffline(targetoff);
			return true;
		}
		if(Args[1].equalsIgnoreCase("pro")){
		if (Args.length == 2) {
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[2])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Dia = Integer.parseInt(Args[2]);
		if (Dia >= 31 || Dia <= 0) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		if (Args.length == 3) {
			p.sendMessage("§7Argumentos Insuficientes");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[3])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Mes = Integer.parseInt(Args[3]);
		if (Mes > 12 || Mes <= 0) {
			return true;
		}
		if (Args.length == 4) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[4])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Ano = Integer.parseInt(Args[4]);
		if (Ano < 2016) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números maior ou igual a 2016");
			return true;
		}
		if (Args.length == 5) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[5])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Horas = Integer.parseInt(Args[5]);
		if (Horas < 0 || Horas > 23) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  0 há 23");
			return true;
		}
		if (Args.length == 6) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[6])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Minutos = Integer.parseInt(Args[6]);
		if (Minutos <= 0 || Minutos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		if (Args.length == 7) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[7])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Segundos = Integer.parseInt(Args[7]);
		if (Segundos <= 0 || Segundos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
			p.sendMessage(sucesso + "§7Você deu Vip §6(" + Args[1] + ") §7para o §6" + targetoff.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
			cfGrupo.setarGrupo(targetoff, "Pro");
			GrupoAPI.expirarOffline(targetoff, Dia, Mes, Ano, Horas, Minutos, Segundos);
			GrupoAPI.checarVipOffline(targetoff);
			return true;
		}
		else if(Args[1].equalsIgnoreCase("mvp")){
		if (Args.length == 2) {
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[2])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Dia = Integer.parseInt(Args[2]);
		if (Dia >= 31 || Dia <= 0) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		if (Args.length == 3) {
			p.sendMessage("§7Argumentos Insuficientes");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[3])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Mes = Integer.parseInt(Args[3]);
		if (Mes > 12 || Mes <= 0) {
			return true;
		}
		if (Args.length == 4) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[4])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Ano = Integer.parseInt(Args[4]);
		if (Ano < 2016) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números maior ou igual a 2016");
			return true;
		}
		if (Args.length == 5) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[5])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Horas = Integer.parseInt(Args[5]);
		if (Horas < 0 || Horas > 23) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  0 há 23");
			return true;
		}
		if (Args.length == 6) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[6])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Minutos = Integer.parseInt(Args[6]);
		if (Minutos <= 0 || Minutos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		if (Args.length == 7) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[7])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Segundos = Integer.parseInt(Args[7]);
		if (Segundos <= 0 || Segundos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
			p.sendMessage(sucesso + "§7Você deu Vip §6(" + Args[1] + ") §7para o §6" + targetoff.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
			cfGrupo.setarGrupo(targetoff, "Mvp");
			GrupoAPI.expirarOffline(targetoff, Dia, Mes, Ano, Horas, Minutos, Segundos);
			GrupoAPI.checarVipOffline(targetoff);
			return true;
		}
		if(Args[1].equalsIgnoreCase("light")){
		if (Args.length == 2) {
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " [Dia] [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[2])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Dia = Integer.parseInt(Args[2]);
		if (Dia >= 31 || Dia <= 0) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		if (Args.length == 3) {
			p.sendMessage("§7Argumentos Insuficientes");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[2] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[3])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Mes = Integer.parseInt(Args[3]);
		if (Mes > 12 || Mes <= 0) {
			return true;
		}
		if (Args.length == 4) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet " + Args[0] + " " + Args[1] + " " + Args[3] + " [Mes] [Ano] [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[4])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Ano = Integer.parseInt(Args[4]);
		if (Ano < 2016) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números maior ou igual a 2016");
			return true;
		}
		if (Args.length == 5) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " [Hora] [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[5])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Horas = Integer.parseInt(Args[5]);
		if (Horas < 0 || Horas > 23) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  0 há 23");
			return true;
		}
		if (Args.length == 6) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " [Minuto] [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[6])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Minutos = Integer.parseInt(Args[6]);
		if (Minutos <= 0 || Minutos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
		if (Args.length == 7) {
			p.sendMessage("Argumentos Insuficientes!");
			p.sendMessage("§7Use: /TempGroupSet" + Args[0] + " " + Args[1] + " " + Args[2] + " " + Args[3] + " " + Args[4] + " " + Args[5] + " " + Args[6] + " [Segundo]");
			return true;
		}
		if (!CheckarNumero(Args[7])) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números!");
			return true;
		}
		Integer Segundos = Integer.parseInt(Args[7]);
		if (Segundos <= 0 || Segundos > 59) {
			p.sendMessage("§7Argumento Errado");
			p.sendMessage("§7Você só pode usar números de  1  há 59");
			return true;
		}
			p.sendMessage("§7Você deu Vip §6(" + Args[1] + ") §7para o  §6" +targetoff.getName() + " §7ele expira em §6" + Dia + "/" + Mes + "/" + Ano + " as " + Horas + ":" + Minutos + ":" + Segundos);
			cfGrupo.setarGrupo(targetoff, "Light");
			GrupoAPI.expirarOffline(targetoff, Dia, Mes, Ano, Horas, Minutos, Segundos);
			GrupoAPI.checarVipOffline(targetoff);
			return true;
		}
			p.sendMessage("§7Você só pode usar os grupos §6§lPRO §7| §9§lMVP §7| §a§lLIGHT");
					}
				}
		}
	return false;
	}
}
