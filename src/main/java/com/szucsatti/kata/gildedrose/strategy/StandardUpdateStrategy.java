package com.szucsatti.kata.gildedrose.strategy;

import com.szucsatti.kata.gildedrose.Item;

public class StandardUpdateStrategy implements UpdateStrategy{

	@Override
	public void updateQuality(final Item item) {
		int actualQuality = item.getQuality();
		int qualityDecrease = item.getSellIn() >= 0 ? 1 : 2;
		item.setQuality(Math.max(actualQuality - qualityDecrease, 0));
		item.decreaseSellIn();
	}
}
