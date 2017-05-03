package com.szucsatti.katas.gildedrose;

import org.junit.Test;

public class GildedRoseTest extends TestBase {


	@Test
	public void "quality degrades before sell by date"(){
		def items = [new Item("Basketball", 1, FIVE) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert (FIVE - 1) == classToTest.items[0].quality
		assert ZERO == classToTest.items[0].sellIn
	}


	@Test
	public void "quality degrades after sell by date passes"(){
		def items = [ new Item("Basketball", -1, FIVE) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert (FIVE - 2) == classToTest.items[0].quality
	}


	@Test
	public void "quality is never negative"(){
		def items = [ new Item("Basketball", -1, ONE) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert ZERO == classToTest.items[0].quality
	}

	@Test
	public void "aged brie's quality increases as time passes"(){
		def items = [ new Item("Aged Brie", 4, ONE) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert TWO == classToTest.items[0].quality
	}

	@Test
	public void "aged brie's quality quality increases by two afer sell by date passes" (){
		def items = [ new Item("Aged Brie", ZERO, ONE) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert THREE == classToTest.items[0].quality
	}

	@Test
	public void "maximum quality is fifty"(){
		def items = [ new Item("Aged Brie", FOUR, MAX_QUALITY) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert MAX_QUALITY == classToTest.items[0].quality
	}
	
	@Test
	public void "sulfuras's quality never decreases"(){
		def items = [ new Item("Sulfuras, Hand of Ragnaros", FOUR, TWO) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert TWO == classToTest.items[0].quality
	}
	
	@Test
	public void "sulfuras's sell by date never decreases"(){
		def items = [ new Item("Sulfuras, Hand of Ragnaros", FOUR, TWO) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert FOUR == classToTest.items[0].sellIn
	}

	@Test
	public void "backstage passes increases in quality before sell by date"(){
		def items = [ new Item("Backstage passes to a TAFKAL80ETC concert", ELEVEN, TWO) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert THREE == classToTest.items[0].quality
	}
	
	@Test
	public void "backstage pass's quality increases by two before sell by date"(){
		def items = [ new Item("Backstage passes to a TAFKAL80ETC concert", TEN, TWO) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert FOUR == classToTest.items[0].quality
	}
	
	@Test
	public void "backstage pass's quality increases by three before sell by date"(){
		def items = [ new Item("Backstage passes to a TAFKAL80ETC concert", FIVE, TWO) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert FIVE == classToTest.items[0].quality
	}
	
	@Test
	public void "backstage pass's quality drops after sell by date passes"(){
		def items = [ new Item("Backstage passes to a TAFKAL80ETC concert", ZERO, TWO) ] as Item[]
		def classToTest = new GildedRose(items)
		classToTest.updateQuality()
		assert ZERO == classToTest.items[0].quality
	}
	
}
