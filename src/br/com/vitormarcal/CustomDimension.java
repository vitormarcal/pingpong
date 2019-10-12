package br.com.vitormarcal;

public final class CustomDimension {
    private final int width;
    private final int height;
    private final int scale;

    private CustomDimension(int width, int height) {
        this.width = width;
        this.height = height;
        this.scale = 1;
    }

    private CustomDimension(int width, int height, int scale) {
        this.width = width;
        this.height = height;
        this.scale = scale;
    }

    public static CustomDimension of(int width, int height) {
        return new CustomDimension(width, height);
    }

    static CustomDimension of(int width, int height, int scale) {
        if (scale <= 0) {
            scale = 1;
        }
        return new CustomDimension(width, height, scale);
    }

    public CustomDimension withWitdth(int width) {
        return new CustomDimension(width, height, scale);
    }

    public CustomDimension withHeight(int height) {
        return new CustomDimension(width, height, scale);
    }

    public int getHeight() {
        return height;
    }

    int getScaleHeight() {
        return height * scale;
    }

    public int getWidth() {
        return width;
    }

    int getScaleWidth() {
        return width * scale;
    }

    @Override
    public String toString() {
        return width + "x" + height;
    }
}
