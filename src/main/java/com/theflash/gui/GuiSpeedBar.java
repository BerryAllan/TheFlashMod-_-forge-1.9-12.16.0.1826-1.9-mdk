package com.theflash.gui;

import com.theflash.handlers.SpeedForceHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class GuiSpeedBar extends Gui
{
	private Minecraft mc = Minecraft.getMinecraft();
	
	public GuiSpeedBar()
	{
		super();
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL) public void onRenderExperienceBar(
			RenderGameOverlayEvent.Post event)
	{
		if (SpeedForceHandler.isFlash || SpeedForceHandler.isFutureFlash)
		{
			ScaledResolution res = new ScaledResolution(mc);
			int x = res.getScaledWidth() / 2 - 91;

			this.mc.mcProfiler.startSection("jumpBar");
			this.mc.getTextureManager().bindTexture(Gui.icons);
			float f = mc.thePlayer.getHorseJumpPower();
			int i = 182;
			int j = (int) (f * (float) (i + 1));
			int k = res.getScaledHeight() - 32 + 3;
			this.drawTexturedModalRect(x, k, 0, 84, i, 5);

			if (j > 0)
			{
				this.drawTexturedModalRect(x, k, 0, 89, j, 5);
			}

			this.mc.mcProfiler.endSection();
		}
	}
}
