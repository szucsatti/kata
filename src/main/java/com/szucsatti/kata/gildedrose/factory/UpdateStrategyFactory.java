package com.szucsatti.kata.gildedrose.factory;

import com.szucsatti.kata.gildedrose.Item;
import com.szucsatti.kata.gildedrose.strategy.AgedBrieUpdateStrategy;
import com.szucsatti.kata.gildedrose.strategy.BackstagePassesUpdateStrategy;
import com.szucsatti.kata.gildedrose.strategy.StandardUpdateStrategy;
import com.szucsatti.kata.gildedrose.strategy.SulfurasUpdateStrategy;
import com.szucsatti.kata.gildedrose.strategy.UpdateStrategy;

public class UpdateStrategyFactory {

	public UpdateStrategy createUpdateStrategy(final Item item) {
		switch (item.getName()) {
		case "Aged Brie":
			return new AgedBrieUpdateStrategy();
		case "Sulfuras, Hand of Ragnaros":
			return new SulfurasUpdateStrategy();
		case "Backstage passes to a TAFKAL80ETC concert":
			return new BackstagePassesUpdateStrategy();
		default:
			return new StandardUpdateStrategy();
		}
	}

}
