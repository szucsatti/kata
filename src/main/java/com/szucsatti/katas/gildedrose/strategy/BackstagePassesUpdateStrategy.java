package com.szucsatti.katas.gildedrose.strategy;

import com.szucsatti.katas.gildedrose.Item;

public class BackstagePassesUpdateStrategy implements UpdateStrategy {

	@Override
	public void updateQuality(final Item item) {
		int quality = item.getQuality();
		int delta = qualityIncrease(item);
		item.setQuality(Math.min(quality + delta, 50));
		item.decreaseSellIn();
	}

	private int qualityIncrease(final Item item) {
		if (item.getSellIn() < 0)
			return item.getQuality() * -1;
		int count = 1;
		if (item.getSellIn() <= 10)
			count++;
		if (item.getSellIn() <= 5)
			count++;
		return count;
	}

}
