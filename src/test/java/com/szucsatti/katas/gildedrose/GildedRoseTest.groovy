package com.szucsatti.katas.gildedrose;

import org.junit.Test;

public class GildedRoseTest {

	static final int ZERO = 0

	static final int ONE = 1

	static final int TWO = 2

	static final int THREE = 3

	static final int FIVE = 5

	static final int MAX_QUALITY = 50


	@Test
	public void testQualityDegradeBeforeSellByDate(){
		def items = [new Item("Basketball", 1, FIVE) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert (FIVE - 1) == classToTest.items[0].quality
		assert ZERO == classToTest.items[0].sellIn
	}


	@Test
	public void qualityDegradeAfterSellByDate(){
		def items = [ new Item("Basketball", -1, FIVE) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert (FIVE - 2) == classToTest.items[0].quality
	}


	@Test
	public void qualityNeverNegative(){
		def items = [ new Item("Basketball", -1, ONE) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert ZERO == classToTest.items[0].quality
	}

	@Test
	public void agedBrieQualityIncrease(){
		def items = [ new Item("Aged Brie", 4, ONE) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert TWO == classToTest.items[0].quality
	}

	@Test
	public void agedBrieDoubleQualityIncreaseAfterSellInDate(){
		def items = [ new Item("Aged Brie",0, ONE) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert THREE == classToTest.items[0].quality
	}

	@Test
	public void maxQualityIsFifty(){
		def items = [ new Item("Aged Brie", 4, MAX_QUALITY) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert MAX_QUALITY == classToTest.items[0].quality
	}


}
