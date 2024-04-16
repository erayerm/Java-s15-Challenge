package com.workintech.aaaaaaaaaaaaaaaaa;

public class BookCounts {
    private int totalInLibrary;
    private int totalAvailable;

    public BookCounts(int totalInLibrary, int totalAvailable) {
        this.totalInLibrary = totalInLibrary;
        this.totalAvailable = totalAvailable;
    }

    public void setTotalInLibrary(int totalInLibrary) {
        this.totalInLibrary = totalInLibrary;
    }

    public void setTotalAvailable(int totalAvailable) {
        this.totalAvailable = totalAvailable;
    }

    public int getTotalInLibrary() {
        return totalInLibrary;
    }

    public int getTotalAvailable() {
        return totalAvailable;
    }

    @Override
    public String toString() {
        return "BookCounts{" +
                "totalInLibrary=" + totalInLibrary +
                ", totalAvailable=" + totalAvailable +
                '}';
    }
}
