package com.szucsatti.katas.gildedrose.strategy

import org.junit.Test;

import com.szucsatti.katas.gildedrose.Item
import com.szucsatti.katas.gildedrose.TestBase

class StandardUpdateStrategyTest extends TestBase {

	@Test
	public void "standard item decreases in quality before sell by date"(){
		def item = createStandardItem(2, FIVE) 
		def classToTest = new StandardUpdateStrategy()
		classToTest.updateQuality(item)
		assert (FIVE - 1) == item.quality
	}
	
	
	@Test
	public void "standard item decreases twice as fast in quality after sell by date"(){
		def item = createStandardItem(-1, FIVE) 
		def classToTest = new StandardUpdateStrategy()
		classToTest.updateQuality(item)
		assert (FIVE - 2) == item.quality
	}
	
	
	@Test
	public void "item quality is never negative"(){
		def item = createStandardItem(-1, ZERO)
		def classToTest = new StandardUpdateStrategy()
		classToTest.updateQuality(item)
		assert 0 == item.quality
	}
	
	private Item createStandardItem(int sellIn, int quality ){
		return new Item("Standard", sellIn, quality);
	}
	
}
