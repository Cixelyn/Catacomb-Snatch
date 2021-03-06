package com.mojang.mojam.gui;

import java.awt.event.KeyEvent;

import com.mojang.mojam.MojamComponent;
import com.mojang.mojam.screen.Screen;
import com.mojang.mojam.screen.Art;

public class JoinGameMenu extends GuiMenu {

	private Button joinButton;

	public JoinGameMenu() {
		super();

		joinButton = (Button) addButton(new Button(TitleMenu.PERFORM_JOIN_ID, "Join", 100, 180));
		addButton(new Button(TitleMenu.CANCEL_JOIN_ID, "Cancel", 250, 180));
	}

	@Override
	public void render(Screen screen) {

		screen.clear(0);
		screen.blit(Art.emptyBackground, 0, 0);
		Font.draw(screen, MojamComponent.texts.enterIP(), 100, 100);
		Font.draw(screen, TitleMenu.ip + "-", 100, 120);

		super.render(screen);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_ENTER && TitleMenu.ip.length() > 0) {
			joinButton.postClick();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent e) {

		if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE && TitleMenu.ip.length() > 0) {
			TitleMenu.ip = TitleMenu.ip.substring(0, TitleMenu.ip.length() - 1);
		} else if (Font.letters.indexOf(Character.toUpperCase(e.getKeyChar())) >= 0) {
			TitleMenu.ip += e.getKeyChar();
		}
	}

	@Override
	public void buttonPressed(ClickableComponent button) {
		// nothing
	}

}
