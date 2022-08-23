package encapsulation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea() {
        double surfaceArea = 2 * ((length * width) + (length * height) + (width * height));
        return surfaceArea;
    }

    public double calculateLateralSurfaceArea() {
        double lateralSurfaceArea = 2 * height * (length + width);
        return lateralSurfaceArea;
    }

    public double calculateVolume() {
        double volume = length * height * width;
        return volume;
    }

    @Override
    public String toString() {
        String str = System.out.printf("Surface Area - %.2f\nLateral Surface Area - %.2f\nVolume - %.2f\n",
                calculateSurfaceArea(),calculateLateralSurfaceArea(),calculateVolume()).toString();
        return str;
    }
}
