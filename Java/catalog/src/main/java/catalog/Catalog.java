package catalog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    protected List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem item) {
        this.catalogItems.add(item);
    }

    public double averagePageNumberOver(int pages) {
        int sum = 0;
        int count = 0;
        for (CatalogItem item : catalogItems) {
            if (item.hasPrintedFeature() && item.numberOfPagesAtOneItem() > pages) {
                sum += item.numberOfPagesAtOneItem();
                count++;
            }
        }
        return new BigDecimal(sum).divide(new BigDecimal(count)).doubleValue();
    }

    public void deleteItemByRegistrationNumber(String regNum) {
        CatalogItem deletItem = null;
        for (CatalogItem item : catalogItems) {
            if (item.getRegistrationNumber().equals(regNum)) {
                deletItem = item;
                break;
            }
        }
        catalogItems.remove(deletItem);
    }

    public List<CatalogItem> findByCriteria(SearchCriteria criteria) {
        List<CatalogItem> searchItem = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            for (Feature feature : catalogItem.getFeatures()) {
                if (criteria.hasContributor() && feature.getContributors().toString().contains(criteria.getContributor())) {
                    searchItem.add(catalogItem);
                } else if (criteria.hasTitle() && feature.getTitle().equals(criteria.getTitle())) {
                    searchItem.add(catalogItem);
                }


            }

        }

        return searchItem;

    }


    public int getAllPageNumber() {
        int sum = 0;
        for (CatalogItem item : catalogItems) {
            if (item.hasPrintedFeature()) {
                sum += item.numberOfPagesAtOneItem();
            }
        }
        return sum;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> itemsOut = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.hasAudioFeature()) {
                itemsOut.add(item);
            }
        }
        return itemsOut;
    }

    public int getFullLength() {
        int sum = 0;
        for (CatalogItem item : catalogItems) {
            if (item.hasAudioFeature()) {
                sum += item.fullLengthAtOneItem();
            }
        }

        return sum;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> itemsOut = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.hasPrintedFeature()) {
                itemsOut.add(item);
            }
        }
        return itemsOut;
    }
}