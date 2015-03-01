package fai.edu.mobile.fragment;

import fai.edu.mobile.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentBase extends Fragment {

	private TextView tvItemName;

	public static final String IMAGE_RESOURCE_ID = "iconResourceID";
	public static final String ITEM_NAME = "itemName";

	/**
	 * Fragment básico que tem apenas um ImageView e um TextView
	 * apenas como ilustração.
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_layout_base, container, false);

		tvItemName = (TextView) view.findViewById(R.id.frag_base_text);
		tvItemName.setText(getArguments().getString(ITEM_NAME));
		tvItemName.setCompoundDrawablesWithIntrinsicBounds(
				view.getResources().getDrawable(getArguments().getInt(IMAGE_RESOURCE_ID)), null, null, null);
		
		return view;
	}

}
