package applicationlist.adrian.pl.applicationslist;

import android.graphics.drawable.Drawable;

public class Element {

    private String name;
    private double size;
    private Drawable icon;

    public Element(String name, Drawable icon) {
        this.name = name;
        this.icon = icon;
    }

    public Element(String name, Drawable icon, double size) {
        this(name, icon);
        this.icon = icon;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public Drawable getIcon() {
        return icon;
    }

    public double getSize() {
        return size;
    }

}
