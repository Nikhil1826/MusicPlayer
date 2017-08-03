package com.fasttech.music;

/**
 * Created by dell on 7/17/2017.
 */

public class Albums {
    int icon;
    String albumname;

    public Albums() {
    }

    public Albums(int icon, String albumname) {
        this.icon = icon;
        this.albumname = albumname;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }
}
