package fai.edu.mobile.navigation.drawer;

import java.util.List;

import fai.edu.mobile.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Classe utilizada no navigation drawer (menu lateral) como
 * um adapter que contém o spinner para os usuários
 * 
 */
public class CustomSpinnerAdapter extends ArrayAdapter<SpinnerItem> {

	private Context mContext;
	private int mLayoutResID;
	private List<SpinnerItem> mSpinnerData;

	public CustomSpinnerAdapter(Context ctx, int layoutResID, int textViewResId, List<SpinnerItem> spinnerDataList) {
		super(ctx, layoutResID, textViewResId, spinnerDataList);

		this.mContext = ctx;
		this.mLayoutResID = layoutResID;
		this.mSpinnerData = spinnerDataList;
	}

	public CustomSpinnerAdapter(Context cxt, int layoutResID, List<SpinnerItem> spinnerDataList) {
		super(cxt, layoutResID, spinnerDataList);

		this.mContext = cxt;
		this.mLayoutResID = layoutResID;
		this.mSpinnerData = spinnerDataList;
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		return getCustomView(position, convertView, parent);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return getCustomView(position, convertView, parent);
	}

	public View getCustomView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		SpinnerHolder holder;

		if (row == null) {
			LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
			row = inflater.inflate(mLayoutResID, parent, false);
			holder = new SpinnerHolder();

			holder.mUserImg=(ImageView)row.findViewById(R.id.left_img);
			holder.mName=(TextView)row.findViewById(R.id.text_main_name);
			holder.mEmail=(TextView)row.findViewById(R.id.sub_text_email);

			row.setTag(holder);
		} else {
			holder = (SpinnerHolder)row.getTag();
		}

		SpinnerItem spinnerItem = mSpinnerData.get(position);
		holder.mUserImg.setImageDrawable(row.getResources().getDrawable(spinnerItem.getDrawableResID()));
		holder.mName.setText(spinnerItem.getName());
		holder.mEmail.setText(spinnerItem.getEmail());

		return row;
	}

	/**
	 * Essa classe foi criada pois é uma indicação
	 * de padrão de projeto pelo Google para
	 * melhorar a performance na renderização de itens dentro de adapter
	 *
	 */
	private static class SpinnerHolder {
		private ImageView mUserImg;
		private TextView  mName, mEmail;
	}

}
