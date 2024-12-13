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
            if (!isAgedBrie && !isBackstagePass) {
                if (items[i].quality > 0) {
                    if (!isSulfuras) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (isBackstagePass) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!isSulfuras) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!isAgedBrie) {
                    if (!isBackstagePass) {
                        if (items[i].quality > 0) {
                            if (!isSulfuras) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
