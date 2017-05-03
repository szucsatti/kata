package com.szucsatti.kata.gildedrose.strategy

import org.junit.Test

import com.szucsatti.kata.gildedrose.Item
import com.szucsatti.kata.gildedrose.TestBase

class StandardUpdateStrategyTest extends TestBase {

	@Test
	public void "standard item decreases in quality before sell by date"(){
		def item = createStandardItem(2, FIVE)
		def classToTest = new StandardUpdateStrategy()
		classToTest.updateQuality(item)
		assert (FIVE - 1) == item.quality
		assert  1 == item.sellIn
	}


	@Test
	public void "standard item decreases twice as fast in quality after sell by date"(){
		def item = createStandardItem(-1, FIVE)
		def classToTest = new StandardUpdateStrategy()
		classToTest.updateQuality(item)
		assert (FIVE - 2) == item.quality
		assert -2 == item.sellIn
	}


	@Test
	public void "item quality is never negative"(){
		def item = createStandardItem(-1, ZERO)
		def classToTest = new StandardUpdateStrategy()
		classToTest.updateQuality(item)
		assert 0 == item.quality
		assert -2 == item.sellIn
	}


	private Item createStandardItem(int sellIn, int quality ){
		return new Item("Standard", sellIn, quality);
	}
}
