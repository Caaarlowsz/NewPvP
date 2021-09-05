package me.viitor.auth;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.configuração.cfGrupo;

public class AuthCommands implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("login")) {
			if(!Auth.checarRegistro(p)) {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Voce ainda nao esta registrado");
			}
			if(Auth.login.contains(p)) {
				if(args.length == 1) {
					String senha = args[0];
					if(senha.equalsIgnoreCase(Auth.pegarSenha(p))) {
						p.sendMessage("§6§lNash§f§lPvP §6» §7Voce se logou com sucesso");
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
						Auth.login.remove(p);
						Auth.login.remove(p);
						Auth.login.remove(p);
					} else {
						p.sendMessage("§6§lNash§f§lPvP §6» §7Senha incorreta");
					}
				}
			} else {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Voce ja esta logado");
			}
		}
		if(cmd.getName().equalsIgnoreCase("register")) {
			if(Auth.login.contains(p)) {
				if(Auth.checarRegistro(p)) {
					p.sendMessage("§6§lNash§f§lPvP §6» §7Voce ja esta registrado");
				}
				if(args.length == 0) {
					p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize /register <SuaSenha>");
				}
				if(args.length == 1) {
					String senha = args[0];
					Auth.registrar(p, senha);
					p.sendMessage("§6§lNash§f§lPvP §6» §7Voce se registrou com sucesso");
					Auth.login.remove(p);
					Auth.login.remove(p);
					Auth.login.remove(p);
				}
				if(args.length >= 2) {
					p.sendMessage("§6§lNash§f§lPvP §6» §7Voce so pode utilizar uma senha");
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("changepassword")) {
			if(!Auth.login.contains(p)) {
				if(args.length == 0) {
					p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize /changepassword <SenhaAntiga> <SenhaNova>");
				}
				if(args.length == 1) {
					p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize /changepassword <SenhaAntiga> <SenhaNova>");
				}
				if(args.length == 2) {
					String senhaantiga = args[0];
					String senhanova = args[1];
					if(!senhaantiga.equalsIgnoreCase(Auth.pegarSenha(p))) {
						p.sendMessage("§6§lNash§f§lPvP §6» §7A senha antiga e invalida");
					} else {
						p.sendMessage("§6§lNash§f§lPvP §6» §7Sua senha foi alterada com sucesso");
						Auth.kAuth.set("Jogadores." + p.getName() + ".Senha", senhanova);
						Auth.save();
					}
				}
			} else {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Voce precisa estar logado para executar este comando");
			}
		}
		if(cmd.getName().equalsIgnoreCase("setpassword")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")) {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize /setpassword <Jogador> <Senha>");
				return true;
			}
			if(args.length == 1) {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize /setpassword <Jogador> <Senha>");
				return true;
			}
			if(args.length == 2) {
				Player k = Bukkit.getPlayer(args[0]);
				if(Auth.login.contains(p)) {
					if(Auth.checarRegistro(p)) {
						p.sendMessage("§6§lNash§f§lPvP §6» §7Voce precisa estar logado para executar este comando");
					}
					if(!Auth.checarRegistro(p)) {
						p.sendMessage("§6§lNash§f§lPvP §6» §7Voce precisa estar registrado para executar este comando");
					}
				}
				if(k == null) {
					String senha = args[1];
					if(Auth.kAuth.get("Jogadores." + args[0]) == null) {
						p.sendMessage("§6§lNash§f§lPvP §6» §7Este jogador nunca se registrou no servidor");
					}
					if(Auth.kAuth.get("Jogadores." + args[0]) != null) {
						Auth.kAuth.set("Jogadores." + args[0] + ".Senha", senha);
					}
				}
				if(k != null) {
					if(Auth.login.contains(k)) {
						if(Auth.checarRegistro(k)) {
							p.sendMessage("§6§lNash§f§lPvP §6» §7O jogador citado nao se encontra logado");
						}
						if(!Auth.checarRegistro(k)) {
							p.sendMessage("§6§lNash§f§lPvP §6» §7O jogador citado nao se encontra registrado");
						}
					} else {
						String senha = args[1];
						Auth.kAuth.set("Jogadores." + k.getName() + ".Senha", senha);
						Auth.save();
						p.sendMessage("§6§lNash§f§lPvP §6» §7Voce alterou a senha do jogador §6" + k.getName() + " §7com sucesso");
					}
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("unregister")) {
			if(args.length == 0) {
				if(Auth.login.contains(p)) {
					if(Auth.checarRegistro(p)) {
						p.sendMessage("§6§lNash§f§lPvP §6» §7Voce precisa estar logado para executar este comando");
					}
					if(!Auth.checarRegistro(p)) {
						p.sendMessage("§6§lNash§f§lPvP §6» §7Voce precisa estar registrado para executar este comando");
					}
				} else {
					Auth.kAuth.set("Jogadores." + p.getName(), null);
					Auth.save();
					p.kickPlayer("§cVoce foi §c§ndesregistrado§c." + "\n" + "§cRelogue e registre-se novamente");
				}
			}
			if(args.length == 1) {
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Admin")) {
					Player k = Bukkit.getPlayer(args[0]);
					if(Auth.login.contains(p)) {
						if(Auth.checarRegistro(p)) {
							p.sendMessage("§6§lNash§f§lPvP §6» §7Voce precisa estar logado para executar este comando");
						}
						if(!Auth.checarRegistro(p)) {
							p.sendMessage("§6§lNash§f§lPvP §6» §7Voce precisa estar registrado para executar este comando");
						}
					}
					if(Auth.login.contains(k)) {
						if(Auth.checarRegistro(k)) {
							p.sendMessage("§6§lNash§f§lPvP §6» §7O jogador citado nao esta logado");
						}
						if(!Auth.checarRegistro(k)) {
							p.sendMessage("§6§lNash§f§lPvP §6» §7O jogador citado nao esta registrado");
						}
					} else {
						if(k == null) {
							if(Auth.kAuth.get("Jogadores." + args[0]) == null) {
								p.sendMessage("§6§lNash§f§lPvP §6» §7O jogador citado nunca se registrou no servidor");
							}
							if(Auth.kAuth.get("Jogadores." + args[0]) != null) {
								double l = Auth.kAuth.getDouble("Jogadores registrados");
								Auth.kAuth.set("Jogadores registrados", l - Double.valueOf(1.0D));
								Auth.kAuth.set("Jogadores." + args[0], null);
								Auth.save();
								p.sendMessage("§6§lNash§f§lPvP §6» §7Jogador desregistrado com sucesso");
							}
						}
						if(k != null) {
							double l = Auth.kAuth.getDouble("Jogadores registrados");
							Auth.kAuth.set("Jogadores registrados", l - Double.valueOf(1.0D));
							Auth.kAuth.set("Jogadores" + k.getName(), null);
							Auth.save();
							p.sendMessage("§6§lNash§f§lPvP §6» §7Jogador desregistrado com sucesso");
							k.kickPlayer("§cVoce foi §c§ndesregistrado§c." + "\n" + "§cRelogue e registre-se novamente");
						}
					}
				} else {
					p.sendMessage("§6§lNash§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando");
				}
			}
		}
		return false;
	}
}
