package com.szucsatti.kata.gildedrose;

public class Item {

	private String name;

	private int sellIn;

	private int quality;

	public Item(String name, int sellIn, int quality) {
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
	}


	public String getName() {
		return name;
	}


	public int getSellIn() {
		return sellIn;
	}

	public void decreaseSellIn(){
		this.sellIn--;
	}


	public int getQuality() {
		return quality;
	}

	public void increaseQuality(){
		this.quality++;
	}

	public void decreaseQuality(){
		this.quality--;
	}

	public void resetQuality(){
		this.quality = 0;
	}


	@Override
	public String toString() {
		return this.name + ", " + this.sellIn + ", " + this.quality;
	}


	public void setQuality(int quality) {
		this.quality = quality;
	}
}