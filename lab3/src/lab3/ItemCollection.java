package lab3;
import java.util.Objects;
public class ItemCollection {
	private Item[] items;

    public ItemCollection(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Integer i = 0; i < items.length; i++) {
            Item item = items[i];
            Boolean isAgedBrie = Objects.equals(item.name, "Aged Brie");
            Boolean isBackstagePass = Objects.equals(item.name, "Backstage passes to a TAFKAL80ETC concert");
            Boolean isSulfuras = Objects.equals(item.name, "Sulfuras, Hand of Ragnaros");

            if (!isAgedBrie && !isBackstagePass && !isSulfuras && item.quality > 0) {
                item.quality--;
            }

            if (isAgedBrie || isBackstagePass) {
                if (item.quality < 50) {
                    item.quality++;
                }
            }
            if (isBackstagePass) {
                if (item.sellIn < 11 && item.quality < 50) {
                    item.quality++;
                }
                if (item.sellIn < 6 && item.quality < 50) {
                    item.quality++;
                }
            }
            if (!isSulfuras) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                if (!isAgedBrie && !isBackstagePass && !isSulfuras && item.quality > 0) {
                    item.quality--;
                }

                if (isBackstagePass) {
                    item.quality = 0;
                }

                if (isAgedBrie && item.quality < 50) {
                    item.quality++;
                }
            }
        }
    }
}
