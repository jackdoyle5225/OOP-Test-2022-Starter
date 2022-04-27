package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();
	public int n = 0;

	public void keyPressed()
	{		
		if (keyCode == LEFT) {
			if(n == 0) {
				n = nematodes.size() - 1;
			}
			n--;
		}
		if (keyCode == RIGHT) {
			if(n == nematodes.size() - 1) {
				n = 0;
			}
			n++;
		}
	}


	public void settings()
	{
		size(800, 800);
		loadNematodes();
		printNematodes();
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();				
	}
	

	public void loadNematodes() {
		Table table = loadTable("nematodes.csv", "header" );

		for(TableRow row:table.rows()) {
			
			Nematode nematode = new Nematode(row);
			nematodes.add(nematode);
		}
	}

	public void printNematodes() {
		for(Nematode n:nematodes) {
			System.out.println(n);
		}
	}

	public void displayNematodes(int n) {

		stroke(255);
		strokeWeight(1);
		noFill();
		//draw body of nematode
		if(nematodes.get(n).getLength() > 1) {
			for(int i = 0; i <= nematodes.get(n).getLength();i++) {
				float x = width/2;
				float y;
				if(i==0) {
					y=100;
				}else {
					y = i * 50;
				}
				circle(x,y,50);
			}
		} else {
			circle(0,0,50);
		}

		String name = nematodes.get(n).getName();
		textSize(50);
		fill(255);
		text(name,200,600);

	}

	public void draw() {
		background(0);
		displayNematodes(n);
		
	}
}
