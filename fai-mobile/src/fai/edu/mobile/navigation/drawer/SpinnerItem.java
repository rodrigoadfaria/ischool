package fai.edu.mobile.navigation.drawer;

/**
 * Classe utilizada no navigation drawer (menu lateral) e 
 * representa um "Combo Box"
 * 
 */
public class SpinnerItem {

	private int mDrawableResID;
	private String mName;
	private String mEmail;

	public SpinnerItem(int drawableResID, String name, String email) {
		super();
		this.mDrawableResID = drawableResID;
		this.mName = name;
		this.mEmail = email;
	}

	public int getDrawableResID() {
		return mDrawableResID;
	}

	public void setDrawableResID(int mDrawableResID) {
		this.mDrawableResID = mDrawableResID;
	}

	public String getName() {
		return mName;
	}

	public void setName(String mName) {
		this.mName = mName;
	}

	public String getEmail() {
		return mEmail;
	}

	public void setEmail(String mEmail) {
		this.mEmail = mEmail;
	}
}
