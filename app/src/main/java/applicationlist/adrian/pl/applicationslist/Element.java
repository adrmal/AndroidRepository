package applicationlist.adrian.pl.applicationslist;

import android.graphics.drawable.Drawable;

public class Element {

    String name;
    double size;
    Drawable icon;

    public Element(String name, double size, Drawable icon) {
        this.name = name;
        this.size = size;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    public Drawable getIcon() {
        return icon;
    }

}
