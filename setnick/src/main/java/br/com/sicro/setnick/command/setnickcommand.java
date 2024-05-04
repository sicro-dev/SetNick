package br.com.sicro.setnick.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class setnickcommand implements CommandExecutor {

    private List<String> nicksDisponiveis = new ArrayList<>(Arrays.asList("JoaoPedra", "Cristiano Ronaldo", "SicroLindo", "SicroLindoso", "Sicroeomelhor"));
    private List<String> nicksOriginais = new ArrayList<>(nicksDisponiveis);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Este comando só pode ser usado por jogadores.");
            return true;
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("nick")) {
            if (args.length == 1 && args[0].equalsIgnoreCase("random")) {
                if (nicksDisponiveis.isEmpty()) {
                    reiniciarNicksDisponiveis();
                }

                if (nicksDisponiveis.isEmpty()) {
                    player.sendMessage(ChatColor.RED + "Todos os nicks disponíveis já foram utilizados.");
                    return true;
                }

                String novoNick = escolherNickAleatorio();
                player.setDisplayName(novoNick);
                player.setPlayerListName(novoNick);
                player.sendMessage(ChatColor.GREEN + "Seu nick foi alterado para " + novoNick);
                return true;
            } else if (args.length != 1) {
                player.sendMessage(ChatColor.RED + "Uso correto: /nick [novo-nick]");
                return true;
            }

            String novoNick = args[0];
            player.setDisplayName(novoNick);
            player.setPlayerListName(novoNick);
            player.sendMessage(ChatColor.GREEN + "Seu nick foi alterado para " + novoNick);
            return true;
        }

        return false;
    }

    private String escolherNickAleatorio() {
        Random random = new Random();
        int index = random.nextInt(nicksDisponiveis.size());
        return nicksDisponiveis.remove(index);
    }

    private void reiniciarNicksDisponiveis() {
        nicksDisponiveis.clear();
        nicksDisponiveis.addAll(nicksOriginais);
    }
}
