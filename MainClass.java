package Main;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;
import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) throws LoginException, InterruptedException {

        String token = "MTA2NzE3ODk3NDc5MjM5NjkzMQ.G73-wG.p9cLUaq2fsxEPl50Zq95V6vJ0JsAJdqxx8_A_A";

        JDABuilder builder = JDABuilder.createDefault(token);

        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("GameX"));



        builder.setChunkingFilter(ChunkingFilter.ALL);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.enableIntents(Arrays.asList(GatewayIntent.values()));


        builder.addEventListeners(new Embedcreate());

        JDA Bot = builder.build();

        Bot.awaitReady().updateCommands()

                .addCommands(Commands.slash("embedcreate", "Erstelle dein eigenes Embed"))

                .queue();

        System.out.println("The Bot is online");

    }

}
