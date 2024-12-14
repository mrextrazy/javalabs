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

            if (!isAgedBrie && !isBackstagePass && !isSulfuras) {
                decreaseQuality(item);
            }

            if (isAgedBrie || isBackstagePass) {
                increaseQualityIfPossible(item);
            }
            if (isBackstagePass) {
                applyBackstagePassRules(item);
            }
            if (!isSulfuras) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                applyExpiredItemRules(item, isAgedBrie, isBackstagePass, isSulfuras);
            }
        }
    }

    private void increaseQualityIfPossible(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void applyBackstagePassRules(Item item) {
        if (item.sellIn < 11) {
            increaseQualityIfPossible(item);
        }
        if (item.sellIn < 6) {
            increaseQualityIfPossible(item);
        }
    }

    private void applyExpiredItemRules(Item item, Boolean isAgedBrie, Boolean isBackstagePass, Boolean isSulfuras) {
        if (!isAgedBrie && !isBackstagePass && !isSulfuras) {
            decreaseQuality(item);
        }

        if (isBackstagePass) {
            item.quality = 0;
        }

        if (isAgedBrie) {
            increaseQualityIfPossible(item);
        }
    }
}