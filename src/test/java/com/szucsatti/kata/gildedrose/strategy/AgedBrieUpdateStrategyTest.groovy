package com.szucsatti.kata.gildedrose.strategy

import org.junit.Test

import com.szucsatti.kata.gildedrose.Item
import com.szucsatti.kata.gildedrose.TestBase

class AgedBrieUpdateStrategyTest extends TestBase{

	@Test
	public void "aged brie increases in quality before sell by date"(){
		def item = createAgedBrieItem(2, FIVE)
		def classToTest = new AgedBrieUpdateStrategy()
		classToTest.updateQuality(item)
		assert (FIVE + 1) == item.quality
		assert  1 == item.sellIn
	}

	@Test
	public void "maximum quality is fifty"(){
		def item = createAgedBrieItem(2, MAX_QUALITY)
		def classToTest = new AgedBrieUpdateStrategy()
		classToTest.updateQuality(item)
		assert MAX_QUALITY == item.quality
		assert  1 == item.sellIn
	}

	@Test
	public void "aged brie quality increases by two after sell by date"(){
		def item = createAgedBrieItem(-1, NINE)
		def classToTest = new AgedBrieUpdateStrategy()
		classToTest.updateQuality(item)
		assert ELEVEN == item.quality
		assert  -2 == item.sellIn
	}

	@Test
	public void "aged brie quality increases by two on sell by date"(){
		def item = createAgedBrieItem(0, NINE)
		def classToTest = new AgedBrieUpdateStrategy()
		classToTest.updateQuality(item)
		assert ELEVEN == item.quality
		assert  -1 == item.sellIn
	}


	private Item createAgedBrieItem(int sellIn, int quality){
		return new Item("Aged Brie", sellIn, quality);
	}
}
