package androidx.appcompat.view.menu;

public interface MenuView {

    public interface a {
        MenuItemImpl getItemData();

        void initialize(MenuItemImpl menuItemImpl, int i);
    }

    void initialize(MenuBuilder menuBuilder);
}
