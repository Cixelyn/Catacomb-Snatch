package com.mojang.mojam.gui;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

import com.mojang.mojam.MojamComponent;
import com.mojang.mojam.screen.Screen;
import com.mojang.mojam.screen.Art;

public class HostingWaitMenu extends GuiMenu {

	public String myIpLAN;
	public String myIpWAN;

	public HostingWaitMenu() {
		super();

		addButton(new Button(TitleMenu.CANCEL_JOIN_ID, "Cancel", 364, 335));

		searchIpLAN();
		searchIpWAN();
	}

	@Override
	public void render(Screen screen) {

		screen.clear(0);
		screen.blit(Art.emptyBackground, 0, 0);
		Font.draw(screen, MojamComponent.texts.waitingForClient(), 100, 100);

		Font.draw(screen, "Your LAN IP:" + myIpLAN, 100, 120);
		Font.draw(screen, "Your WAN IP:" + myIpWAN, 100, 120);

		super.render(screen);
	}

	@Override
	public void buttonPressed(ClickableComponent button) {
		// nothing.
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// nothing
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// nothing
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// nothing
	}

	public void searchIpWAN() {
		URL whatismyip;
		try {
			whatismyip = new URL("http://automation.whatismyip.com/n09230945.asp");
			BufferedReader in;
			try {
				in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
				myIpWAN = in.readLine();
			} catch (IOException e) {
				myIpWAN = "N/A";
			}
		} catch (MalformedURLException e) {
			myIpWAN = "N/A";
		}
	}

	public void searchIpLAN() {
		try {
			InetAddress thisIp = InetAddress.getLocalHost();
			myIpLAN = thisIp.getHostAddress();
		} catch (Exception e) {
			myIpLAN = "N/A";
		}
	}

}
