package fai.edu.mobile.navigation.drawer;

/**
 * Classe utilizada no navigation drawer (menu lateral) e 
 * representa um item do menu na lista.
 * 
 */
public class DrawerItem {

	private String mItemName;
	private int mImgResID;
	private String mTitle;
	private boolean isSpinner;

	public DrawerItem(String itemName, int imgResID) {
		mItemName = itemName;
		this.mImgResID = imgResID;
	}

	public DrawerItem(boolean isSpinner) {
		this(null, 0);
		this.isSpinner = isSpinner;
	}

	public DrawerItem(String title) {
		this(null, 0);
		this.mTitle = title;
	}

	public String getItemName() {
		return mItemName;
	}

	public void setItemName(String itemName) {
		mItemName = itemName;
	}

	public int getImgResID() {
		return mImgResID;
	}

	public void setImgResID(int imgResID) {
		this.mImgResID = imgResID;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String title) {
		this.mTitle = title;
	}

	public boolean isSpinner() {
		return isSpinner;
	}
}
