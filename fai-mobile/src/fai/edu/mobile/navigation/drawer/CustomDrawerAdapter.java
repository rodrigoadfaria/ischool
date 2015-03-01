package fai.edu.mobile.navigation.drawer;

import java.util.ArrayList;
import java.util.List;

import fai.edu.mobile.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Classe utilizada no navigation drawer (menu lateral) como
 * um adapter para o ListView
 * 
 */
public class CustomDrawerAdapter extends ArrayAdapter<DrawerItem> {

	private Context mContext;
	private List<DrawerItem> mDrawerItemList;
	private int mLayoutResID;

	public CustomDrawerAdapter(Context context, int layoutResID, List<DrawerItem> listItems) {
		super(context, layoutResID, listItems);
		this.mContext = context;
		this.mDrawerItemList = listItems;
		this.mLayoutResID = layoutResID;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		DrawerItemHolder drawerHolder;
		View view = convertView;

		if (view == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			drawerHolder = new DrawerItemHolder();

			view = inflater.inflate(mLayoutResID, parent, false);
			drawerHolder.mItemName = (TextView) view.findViewById(R.id.drawer_item_name);
			drawerHolder.mSpinner = (Spinner) view.findViewById(R.id.drawer_spinner);
			drawerHolder.mTitle = (TextView) view.findViewById(R.id.drawerTitle);
			drawerHolder.mHeaderLayout = (LinearLayout) view.findViewById(R.id.header_layout);
			drawerHolder.mItemLayout = (LinearLayout) view.findViewById(R.id.item_layout);
			drawerHolder.mSpinnerLayout = (LinearLayout) view.findViewById(R.id.spinner_layout);

			view.setTag(drawerHolder);
		} else {
			drawerHolder = (DrawerItemHolder) view.getTag();
		}

		DrawerItem dItem = (DrawerItem) this.mDrawerItemList.get(position);
		if (dItem.isSpinner()) {
			drawerHolder.mHeaderLayout.setVisibility(LinearLayout.INVISIBLE);
			drawerHolder.mItemLayout.setVisibility(LinearLayout.INVISIBLE);
			drawerHolder.mSpinnerLayout.setVisibility(LinearLayout.VISIBLE);

			List<SpinnerItem> userList = new ArrayList<SpinnerItem>();
			userList.add(new SpinnerItem(R.drawable.user1, "Andy Rubin", "andy.rubin@android.com"));
			userList.add(new SpinnerItem(R.drawable.user2, "Bill Gates", "bill@gates.com"));

			CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(mContext, R.layout.custom_spinner_item, userList);
			drawerHolder.mSpinner.setAdapter(adapter);

			drawerHolder.mSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
				@Override
				public void onItemSelected(AdapterView<?> arg0,
						View arg1, int arg2, long arg3) {
					Toast.makeText(mContext, "User Changed",
							Toast.LENGTH_SHORT).show();
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// nothing to do here
				}
			});

		} else if (dItem.getTitle() != null) {
			// setVisibility serve para mostrar/esconder algum elemento na tela
			drawerHolder.mHeaderLayout.setVisibility(LinearLayout.VISIBLE);
			drawerHolder.mItemLayout.setVisibility(LinearLayout.INVISIBLE);
			drawerHolder.mSpinnerLayout.setVisibility(LinearLayout.INVISIBLE);
			drawerHolder.mTitle.setText(dItem.getTitle());
		} else {
			drawerHolder.mHeaderLayout.setVisibility(LinearLayout.INVISIBLE);
			drawerHolder.mSpinnerLayout.setVisibility(LinearLayout.INVISIBLE);
			drawerHolder.mItemLayout.setVisibility(LinearLayout.VISIBLE);

			drawerHolder.mItemName.setCompoundDrawablesWithIntrinsicBounds(
					view.getResources().getDrawable(dItem.getImgResID()), null, null, null);
			drawerHolder.mItemName.setText(dItem.getItemName());
		}

		return view;
	}

	/**
	 * Essa classe foi criada pois é uma indicação
	 * de padrão de projeto pelo Google para
	 * melhorar a performance na renderização de itens dentro de adapter
	 *
	 */
	private static class DrawerItemHolder {
		private TextView mItemName, mTitle;
		private LinearLayout mHeaderLayout, mItemLayout, mSpinnerLayout;
		private Spinner mSpinner;
	}
}