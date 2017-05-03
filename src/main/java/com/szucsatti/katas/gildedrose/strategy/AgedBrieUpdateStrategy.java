package com.szucsatti.katas.gildedrose.strategy;

import com.szucsatti.katas.gildedrose.Item;

public class AgedBrieUpdateStrategy implements UpdateStrategy{

	@Override
	public void updateQuality(final Item item) {
		int quality = item.getQuality();
		int qualityIncrease = item.getSellIn() < 0 ? 2 : 1;
		item.setQuality(Math.min(quality + qualityIncrease, 50));
		item.decreaseSellIn();
	}

}
