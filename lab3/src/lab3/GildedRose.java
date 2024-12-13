package lab3;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        	boolean isAgedBrie = items[i].name.equals("Aged Brie");
            boolean isBackstagePass = items[i].name.equals("Backstage passes to a TAFKAL80ETC concert");
            boolean isSulfuras = items[i].name.equals("Sulfuras, Hand of Ragnaros");
            if (!isAgedBrie && !isBackstagePass && !isSulfuras && items[i].quality > 0 ) {
                items[i].quality--;
            }

            if (isAgedBrie || isBackstagePass) {
                if (items[i].quality < 50) {
                    items[i].quality++;
                }
            }
            if (isBackstagePass) {
                if (items[i].sellIn < 11 && items[i].quality < 50) {
                    items[i].quality++;
                }
                if (items[i].sellIn < 6 && items[i].quality < 50) {
                    items[i].quality++;
                }
            }
            if (!isSulfuras) {
                items[i].sellIn--;
            }

            if (items[i].sellIn < 0) {
                if (!isAgedBrie && !isBackstagePass && !isSulfuras && items[i].quality > 0 ) {
                    items[i].quality--;
                }

                if (isBackstagePass) {
                    items[i].quality = 0;
                }

                if (isAgedBrie && items[i].quality < 50) {
                    items[i].quality++;
                }
            }
        }
    }
}
