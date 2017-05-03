package com.szucsatti.katas.gildedrose;

import com.szucsatti.katas.gildedrose.factory.UpdateStrategyFactory;
import com.szucsatti.katas.gildedrose.strategy.UpdateStrategy;

class GildedRose {
	Item[] items;

	public GildedRose(final Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		UpdateStrategyFactory factory = new UpdateStrategyFactory();
		for (int i = 0; i < items.length; i++) {
			UpdateStrategy strategy = factory.createUpdateStrategy(items[i]);
			strategy.updateQuality(items[i]);
		}
	}

}