package guru.haun.hackery.client.render;

import org.lwjgl.opengl.GL11;

import guru.haun.hackery.HackeryMod;
import guru.haun.hackery.client.HacKeyBinds;
import cpw.mods.fml.client.GuiScrollingList;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenLongRunningTask;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiWinGame;

public class BSODRenderer extends Gui {
	public static boolean active = false;
	private boolean laststate;
	private boolean oldguistate;
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onRenderGameOverlayEvent(RenderGameOverlayEvent e){
		if(laststate == active){
			if(active){
				Minecraft.getMinecraft().currentScreen = GuiWinGame;
			}else{
				
			}
			laststate = active;
		}
		if(active){
			int x = e.resolution.getScaledWidth();
			int y = e.resolution.getScaledHeight();
			int xc = x >> 1;
			int yc = y >> 1;
			int w = 256;
			int h = 256;
			int xi = w >> 1;
			int yi = h >> 1;
			ResourceLocation res = new ResourceLocation("hackery:bsods/Sad Notch.png");
			this.drawRect(0, 0, x, y, 0xFF000000);
			GL11.glColor4f(1F, 1F, 1F, 1F);
			Minecraft.getMinecraft().renderEngine.bindTexture(res);
			this.drawTexturedModalRect(xc-xi, yc-yi, 0, 0, w, h);
		}
	}
	
}