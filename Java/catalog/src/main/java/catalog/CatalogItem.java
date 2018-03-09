package catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem implements Feature {
    private List<Feature> features = new ArrayList<>();
    private int price;
    private String registrationNumber;

    //CONSTRUCTOR
    public CatalogItem(String registrationNumber, int price, Feature... features) {
        for (Feature i : features) {
            this.features.add(i);
        }
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    //GETTERS
    public List<Feature> getFeatures() {
        return features;
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String getTitle() {
        return null;
    }

    //METHODES
    public int fullLengthAtOneItem() {
        int sum = 0;
        for (Feature item : features) {
            if (item instanceof AudioFeatures) {
                sum += ((AudioFeatures) item).getLength();
            }
        }
        return sum;
    }

    public int numberOfPagesAtOneItem() {
        int sum = 0;
        for (Feature item : features) {
            if (item instanceof PrintedFeatures) {
                sum += ((PrintedFeatures) item).getNumberOfPages();
            }
        }
        return sum;
    }

    public List<String> getContributors() {
        List<String> outList = new ArrayList<>();
        for (Feature item : features) {
            outList.addAll(item.getContributors());
        }
        return outList;
    }

    public List<String> getTitles() {
        List<String> outList = new ArrayList<>();
        for (Feature item : features) {
            outList.add(item.getTitle());
        }
        return outList;
    }

    public boolean hasAudioFeature() {
        for (Feature item : features) {
            if (item instanceof AudioFeatures) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPrintedFeature() {
        for (Feature item : features) {
            if (item instanceof PrintedFeatures) {
                return true;
            }
        }
        return false;
    }
}
