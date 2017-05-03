package com.szucsatti.kata.gildedrose.strategy

import org.junit.Test

import com.szucsatti.kata.gildedrose.Item
import com.szucsatti.kata.gildedrose.TestBase

class BackstagePassesUpdateStrategyTest extends TestBase{

	@Test
	public void "backstage pass's quality increases by one before sell by date"(){
		def item = createBackstagePassItem(ELEVEN, FIVE)
		def classToTest = new BackstagePassesUpdateStrategy()
		classToTest.updateQuality(item)
		assert (FIVE + 1) == item.quality
		assert  TEN == item.sellIn
	}


	@Test
	public void "backstage pass's quality increases by two before sell by date"(){
		def item = createBackstagePassItem(TEN, FIVE)
		def classToTest = new BackstagePassesUpdateStrategy()
		classToTest.updateQuality(item)
		assert (FIVE + 2) == item.quality
		assert  NINE == item.sellIn
	}


	@Test
	public void "backstage pass's quality increases by three before sell by date"(){
		def item = createBackstagePassItem(FIVE, FIVE)
		def classToTest = new BackstagePassesUpdateStrategy()
		classToTest.updateQuality(item)
		assert (FIVE + 3) == item.quality
		assert  FOUR == item.sellIn
	}

	@Test
	public void "backstage pass's quality drops after sell by date passes"(){
		def item = createBackstagePassItem(-1, FIVE)
		def classToTest = new BackstagePassesUpdateStrategy()
		classToTest.updateQuality(item)
		assert 0 == item.quality
		assert  -2 == item.sellIn
	}

	@Test
	public void "backstage pass's quality drops on sell by date passes"(){
		def item = createBackstagePassItem(0, FIVE)
		def classToTest = new BackstagePassesUpdateStrategy()
		classToTest.updateQuality(item)
		assert 0 == item.quality
		assert  -1 == item.sellIn
	}


	private Item createBackstagePassItem(int sellIn, int quality){
		return new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
	}
}
