// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.input.Mouse;

// Referenced classes of package net.minecraft.src:
//			GuiScreen, StringTranslate, GameSettings, GuiSmallButton, 
//			GuiButton, KeyBinding

// Thanks to North101 and ScrollableControls for the codes
public class GuiControls extends GuiScreen
{
	private GuiScreen parentScreen;
	protected String screenTitle;
	private GameSettings options;
	private GuiListControls guiListControls;

	public GuiControls(GuiScreen guiscreen, GameSettings gamesettings)
	{
		screenTitle = "Controls";
		parentScreen = guiscreen;
		options = gamesettings;
	}

	private int func_20080_j()
	{
		return width / 2 - 155;
	}

	public void initGui()
	{
		StringTranslate stringtranslate = StringTranslate.getInstance();

		guiListControls = new GuiListControls(parentScreen.mc, this, options);

		controlList.add(new GuiButton(-200, width / 2 - 100, height / 6 + 168, stringtranslate.translateKey("gui.done")));
		screenTitle = stringtranslate.translateKey("controls.title");
	}

	protected void actionPerformed(GuiButton guibutton){
		if(guibutton.id == -200){
			mc.displayGuiScreen(parentScreen);
		}
	}

	protected void mouseClicked(int mouseX, int mouseY, int button) {
		guiListControls.mouseClicked(mouseX, mouseY, button);
		super.mouseClicked(mouseX, mouseY, button);
	}

	protected void mouseMovedOrUp(int mouseX, int mouseY, int button) {
		guiListControls.mouseMovedOrUp(mouseX, mouseY, button);
		super.mouseMovedOrUp(mouseX, mouseY, button);
	}

	protected void keyTyped(char key, int keyId) {
		guiListControls.keyTyped(key, keyId);
		super.keyTyped(key, keyId);
	}

	public void handleMouseInput() {
        int amount = Mouse.getEventDWheel();
        if(amount != 0) {
        	guiListControls.mouseScrolled(amount);
        }
		super.handleMouseInput();
	}

	public void drawScreen(int i, int j, float f){
		drawDefaultBackground();
		guiListControls.drawScreen(i, j, f);
		drawCenteredString(fontRenderer, screenTitle, width / 2, 20, 0xffffff);

        super.drawScreen(i, j, f);

	}
}