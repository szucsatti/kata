package com.szucsatti.kata.gildedrose;

import com.szucsatti.kata.gildedrose.factory.UpdateStrategyFactory;
import com.szucsatti.kata.gildedrose.strategy.UpdateStrategy;

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