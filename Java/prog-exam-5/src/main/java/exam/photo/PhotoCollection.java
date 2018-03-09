package exam.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {
    private List<Photo> photos = new ArrayList<>();


    public List<Photo> getPhotos() {
        return photos;
    }

    public void addPhoto(String... names) {
        for (String name : names) {
            photos.add(new Photo(name));
        }
    }

    public int numberOfStars() {
        int result = 0;
        for (Photo photo : photos) {
            if (photo.getQuality().equals(Quality.ONE_STAR)) {
                result++;
            } else if (photo.getQuality().equals(Quality.TWO_STAR)) {
                result = result + 2;
            }
        }
        return result;
    }

    public void starPhoto(String name, Quality quality) {
        boolean isSearchSuccess = false;
        for (Photo photo : photos) {
            if (photo.getName().equals(name)) {
                photo.setQuality(quality);
                isSearchSuccess = true;
                break;
            }
        }
        if (!isSearchSuccess) {
            throw new PhotoNotFoundException();
        }
    }


}
