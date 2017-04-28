package com.szucsatti.katas.gildedrose;

import org.junit.Test;

public class GildedRoseTest {

	final int ZERO = 0

	final int ONE = 1

	final int TWO = 2

	final int THREE = 3
	
	final int FOUR = 4

	final int FIVE = 5
	
	final int NINE = 9
	
	final int TEN = 10
	
	final int ELEVEN = 11

	final int MAX_QUALITY = 50


	@Test
	public void qualityDegradesBeforeSellByDate(){
		def items = [new Item("Basketball", 1, FIVE) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert (FIVE - 1) == classToTest.items[0].quality
		assert ZERO == classToTest.items[0].sellIn
	}


	@Test
	public void qualityDegradesAfterSellByDate(){
		def items = [ new Item("Basketball", -1, FIVE) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert (FIVE - 2) == classToTest.items[0].quality
	}


	@Test
	public void qualityIsNeverNegative(){
		def items = [ new Item("Basketball", -1, ONE) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert ZERO == classToTest.items[0].quality
	}

	@Test
	public void agedBrieQualityIncreases(){
		def items = [ new Item("Aged Brie", 4, ONE) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert TWO == classToTest.items[0].quality
	}

	@Test
	public void agedBrieDoubleQualityIncreaseAfterSellInDate (){
		def items = [ new Item("Aged Brie", ZERO, ONE) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert THREE == classToTest.items[0].quality
	}

	@Test
	public void maximumQualityIsFifty(){
		def items = [ new Item("Aged Brie", FOUR, MAX_QUALITY) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert MAX_QUALITY == classToTest.items[0].quality
	}
	
	@Test
	public void sulfurasNeverDecreasesInQuality(){
		def items = [ new Item("Sulfuras, Hand of Ragnaros", FOUR, TWO) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert TWO == classToTest.items[0].quality
	}
	
	@Test
	public void sulfurasNeverDecreasesInSellByDate(){
		def items = [ new Item("Sulfuras, Hand of Ragnaros", FOUR, TWO) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert FOUR == classToTest.items[0].sellIn
	}

	@Test
	public void backstagePassIncreasesInQualityBeforeSellByDate(){
		def items = [ new Item("Backstage passes to a TAFKAL80ETC concert", ELEVEN, TWO) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert THREE == classToTest.items[0].quality
	}
	
	@Test
	public void backstagePassDoubleIncreaseInQualityBeforeSellByDate(){
		def items = [ new Item("Backstage passes to a TAFKAL80ETC concert", TEN, TWO) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert FOUR == classToTest.items[0].quality
	}
	
	@Test
	public void backstagePassTripleIncreaseInQualityBeforeSellByDate(){
		def items = [ new Item("Backstage passes to a TAFKAL80ETC concert", FIVE, TWO) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert FIVE == classToTest.items[0].quality
	}
	
	@Test
	public void backstagePassQualityDropsAfterSellByDate(){
		def items = [ new Item("Backstage passes to a TAFKAL80ETC concert", ZERO, TWO) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert ZERO == classToTest.items[0].quality
	}
	
}
