package com.arckenver.nations.cmdexecutor.nationadmin;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import com.arckenver.nations.DataHandler;
import com.arckenver.nations.LanguageHandler;
import com.arckenver.nations.object.Nation;

public class NationadminExtraspawnExecutor implements CommandExecutor
{
	public CommandResult execute(CommandSource src, CommandContext ctx) throws CommandException
	{
		if (!ctx.<String>getOne("nation").isPresent() || !ctx.<String>getOne("give|take|set").isPresent() || !ctx.<String>getOne("amount").isPresent())
		{
			src.sendMessage(Text.of(TextColors.YELLOW, "/na extraspawn <give|take|set> <nation> <amount>"));
			return CommandResult.success();
		}
		String nationName = ctx.<String>getOne("nation").get();
		Integer amount = Integer.valueOf(ctx.<Integer>getOne("amount").get());
		String operation = ctx.<String>getOne("give|take|set").get();
		
		Nation nation = DataHandler.getNation(nationName);
		if (nation == null)
		{
			src.sendMessage(Text.of(TextColors.RED, LanguageHandler.ERROR_BADNATIONNAME));
			return CommandResult.success();
		}
		if (operation.equalsIgnoreCase("give"))
		{
			nation.addExtraSpawns(amount);
		}
		else if (operation.equalsIgnoreCase("take"))
		{
			nation.addExtraSpawns(amount);
		}
		else if (operation.equalsIgnoreCase("set"))
		{
			nation.addExtraSpawns(amount);
		}
		else
		{
			src.sendMessage(Text.of(TextColors.RED, LanguageHandler.ERROR_BADARG_GTS));
			return CommandResult.success();
		}
		DataHandler.saveNation(nation.getUUID());
		src.sendMessage(Text.of(TextColors.GREEN, LanguageHandler.SUCCESS_GENERAL));
		return CommandResult.success();
	}
}
