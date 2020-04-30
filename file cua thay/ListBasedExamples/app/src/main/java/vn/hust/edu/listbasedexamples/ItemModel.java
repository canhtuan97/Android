package vn.hust.edu.listbasedexamples;

public class ItemModel {
    String caption;
    int thumbnailResource;
    int imageResource;

    public ItemModel(String caption, int thumbnailResource, int imageResource) {
        this.caption = caption;
        this.thumbnailResource = thumbnailResource;
        this.imageResource = imageResource;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getThumbnailResource() {
        return thumbnailResource;
    }

    public void setThumbnailResource(int thumbnailResource) {
        this.thumbnailResource = thumbnailResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
