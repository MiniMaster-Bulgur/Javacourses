package edu.hw2;

public class Task2 {

    private Task2() {
    }

    public static class Rectangle {
        private final int width;
        private final int height;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public int getArea() {
            return width * height;
        }

        public Rectangle setWidth(int width) {
            return new Rectangle(width, this.height);
        }

        public Rectangle setHeight(int height) {
            return new Rectangle(this.width, height);
        }
    }

    public static class Square extends Rectangle {
        public Square(int side) {
            super(side, side);
        }

        @Override
        public Rectangle setWidth(int width) {
            return new Square(width);
        }

        @Override
        public Rectangle setHeight(int height) {
            return new Square(height);
        }
    }
}

