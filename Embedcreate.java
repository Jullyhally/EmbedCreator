package Main;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;

import java.util.Collection;

public class Embedcreate extends ListenerAdapter {

    private EmbedBuilder mainembed = new EmbedBuilder();
    private StringSelectMenu mainSelectMen = StringSelectMenu.create("embedcreate")
            .setPlaceholder("Erstelle dein Embed")
            .addOption("Title", "title")
            .addOption("Description", "description")
            .addOption("addField", "addField")
            .addOption("Thumbnail", "thumbnail")
            .addOption("Banner", "banner")
            .addOption("Footer", "footer")
            .addOption("send-Embed", "send-embed")
            .build();



    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("embedcreate")) {


            mainembed.setTitle("**Dieses Embed wird duch das Selectmenu bearbeitet.**\n**Um es abzuschicken klicke auf send-Embed!**");
            mainembed.setColor(0x00B9FF);



            event.replyEmbeds(mainembed.build()).addActionRow(mainSelectMen).queue();


        }

    }

    public void onStringSelectInteraction(StringSelectInteractionEvent event) {

        if (event.getSelectMenu().getId().equals("embedcreate")) {
            for (String s : event.getValues()) {
                switch (s) {

                    case "title":


                        TextInput Title = TextInput.create("title", "Titel", TextInputStyle.SHORT)
                                .setPlaceholder("Schreibe den Title vom Embed")
                                .setMinLength(0)
                                .setMaxLength(50)
                                .build();

                        Modal titlemodal = Modal.create("titlemodal", "Titlemodal")
                                .addActionRows(ActionRow.of(Title))
                                .build();

                        event.replyModal(titlemodal).queue();

                        break;

                    case "description":


                        TextInput Description = TextInput.create("description", "Description", TextInputStyle.PARAGRAPH)
                                .setPlaceholder("Schreibe die Description vom Embed")
                                .setMinLength(0)
                                .setMaxLength(2000)
                                .build();

                        Modal ModalDescription = Modal.create("descriptionmodal", "Description")
                                .addActionRows(ActionRow.of(Description))
                                .build();

                        event.replyModal(ModalDescription).queue();

                        break;


                    case "addField":

                        TextInput AddFieldTitle = TextInput.create("addFieldTitle", "addFieldTitle", TextInputStyle.SHORT)
                                .setPlaceholder("Schreibe den Title vom Field")
                                .setMinLength(0)
                                .setMaxLength(50)
                                .build();


                        TextInput AddField = TextInput.create("addField", "addField", TextInputStyle.PARAGRAPH)
                                .setPlaceholder("Schreibe den Text vom Field")
                                .setMinLength(0)
                                .setMaxLength(2000)
                                .build();



                        Modal ModaladdField = Modal.create("addFieldmodal", "addField")
                                .addActionRows(ActionRow.of(AddFieldTitle), ActionRow.of(AddField))
                                .build();

                        event.replyModal(ModaladdField).queue();

                        break;

                    case "thumbnail":

                        TextInput Thumbnail = TextInput.create("thumbnailmodal", "Thumbnail", TextInputStyle.PARAGRAPH)
                                .setPlaceholder("Schreibe den Link vom Thumbnail")
                                .setMinLength(0)
                                .setMaxLength(200)
                                .build();

                        Modal ThumbnailModal = Modal.create("ThumbnailModal", "Thumbnail")
                                .addActionRows(ActionRow.of(Thumbnail))
                                .build();

                        event.replyModal(ThumbnailModal).queue();

                        break;

                    case "banner":

                        TextInput Image = TextInput.create("imagemodal", "banner", TextInputStyle.PARAGRAPH)
                                .setPlaceholder("Schreibe den Link vom Banner")
                                .setMinLength(0)
                                .setMaxLength(200)
                                .build();

                        Modal ImageModal = Modal.create("ImageModal", "banner")
                                .addActionRows(ActionRow.of(Image))
                                .build();

                        event.replyModal(ImageModal).queue();

                        break;

                    case "footer":

                        TextInput footer = TextInput.create("footer", "Footer", TextInputStyle.PARAGRAPH)
                                .setPlaceholder("Schreibe den Text vom Footer")
                                .setMinLength(0)
                                .setMaxLength(200)
                                .build();

                        TextInput footericon = TextInput.create("footericon", "Footer-Icon", TextInputStyle.PARAGRAPH)
                                .setPlaceholder("Schreibe den Link vom Footer-Icon")
                                .setMinLength(0)
                                .setMaxLength(200)
                                .build();


                        Modal FooterModal = Modal.create("footericonModal", "Footer-Icon")
                                .addActionRows(ActionRow.of(footer),ActionRow.of(footericon))
                                .build();

                        event.replyModal(FooterModal).queue();

                        break;


                    case "send-embed":


                        TextInput TextchannelID = TextInput.create("Send-Embed", "send-Embed", TextInputStyle.SHORT)
                                .setPlaceholder("ID des Text-Channels")
                                .setMinLength(18)
                                .setMaxLength(19)
                                .build();

                        Modal ModalSendEmbed = Modal.create("SendEmbedmodal", "send-embed")
                                .addActionRows(ActionRow.of(TextchannelID))
                                .build();

                        event.replyModal(ModalSendEmbed).queue();

                        break;
                        




                }
            }
        }
    }
    public void onModalInteraction(ModalInteractionEvent event) {
        if (event.getModalId().equals("titlemodal")) {
            String Title = event.getValue("title").getAsString();


            event.editMessageEmbeds(mainembed.setTitle(Title).build()).queue();


        }
        if (event.getModalId().equals("descriptionmodal")) {
            String Description = event.getValue("description").getAsString();


            event.editMessageEmbeds(mainembed.setDescription(Description).build()).queue();


        }

        if (event.getModalId().equals("addFieldmodal")) {
            String AddFieldTitle = event.getValue("addFieldTitle").getAsString();
            String AddField = event.getValue("addField").getAsString();


            event.editMessageEmbeds(mainembed.addField(AddFieldTitle, AddField, false).build()).queue();

        }

        if (event.getModalId().equals("ThumbnailModal")) {
            String Thumbnail = event.getValue("thumbnailmodal").getAsString();


            event.editMessageEmbeds(mainembed.setThumbnail(Thumbnail).build()).queue();

        }
        if (event.getModalId().equals("ImageModal")) {
            String Image = event.getValue("imagemodal").getAsString();


            event.editMessageEmbeds(mainembed.setImage(Image).build()).queue();

        }

        if (event.getModalId().equals("footericonModal")) {
            String footer = event.getValue("footer").getAsString();
            String footericon = event.getValue("footericon").getAsString();



            event.editMessageEmbeds(mainembed.setFooter(footer,footericon).build()).queue();

        }

        if (event.getModalId().equals("SendEmbedmodal")) {
            String SendEmbed = event.getValue("Send-Embed").getAsString();

           TextChannel channelID = event.getGuild().getTextChannelById(SendEmbed);

           channelID.sendMessageEmbeds(mainembed.build()).queue();
           event.deferEdit().queue();



        }
    }
}



